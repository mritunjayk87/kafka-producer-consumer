package com.chargepoint.csms.kafka;

import com.chargepoint.csms.model.AuthRequest;
import com.chargepoint.csms.model.AuthResponse;
import com.chargepoint.csms.model.DriverIdentifier;
import com.chargepoint.csms.utils.Constants.AUTHORIZATION_STATUS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class AuthRequestConsumer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public AuthRequestConsumer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "auth_requests", groupId = "csms-auth-group", containerFactory = "authReqKafkaListenerContainerFactory")
    public void processAuthRequest(AuthRequest request) {
        AuthResponse response = new AuthResponse();
        AUTHORIZATION_STATUS status = validateRFID(request.getDriverIdentifier());
        response.setId(request.getDriverIdentifier().getId());
        response.setAuthorizationStatus(status);
        kafkaTemplate.send("auth_responses", "csms-auth-group", response);
    }

    private AUTHORIZATION_STATUS validateRFID(DriverIdentifier request) {
        // Simulate token validation (DB lookup, external service call, etc.)
        if (request.getId().startsWith("IN")) {
            return AUTHORIZATION_STATUS.Invalid;
        } else if (request.getId().startsWith("In")) {
            return AUTHORIZATION_STATUS.Accepted;
        } else if (request.getId().startsWith("Un")) {
            return AUTHORIZATION_STATUS.Unknown;
        } else if (request.getId().startsWith("Re")) {
            return AUTHORIZATION_STATUS.Rejected;
        } else {
            return AUTHORIZATION_STATUS.Invalid;
        }
    }
}
