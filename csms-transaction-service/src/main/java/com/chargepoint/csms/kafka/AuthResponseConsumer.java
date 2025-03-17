package com.chargepoint.csms.kafka;

import com.chargepoint.csms.model.AuthResponse;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AuthResponseConsumer {
    public Map<String, AuthResponse> rfidRegistry = new HashMap<>();

    @KafkaListener(topics = "auth_responses", groupId = "csms-auth-group", containerFactory = "authResKafkaListenerContainerFactory")
    public void processAuthRequest(AuthResponse response) {
        rfidRegistry.put(response.getId(), response);
    }
}
