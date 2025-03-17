package com.chargepoint.csms.kafka;

import com.chargepoint.csms.model.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.chargepoint.csms.utils.Constants.TOPIC_AUTH_REQUESTS;

@Component
public class AuthRequestProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public AuthRequestProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendAuthRequest(AuthRequest request) {
        kafkaTemplate.send(TOPIC_AUTH_REQUESTS, "csms-auth-group", request);
    }
}
