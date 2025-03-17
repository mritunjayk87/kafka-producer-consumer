package com.chargepoint.csms.service.impl;

import com.chargepoint.csms.kafka.AuthRequestProducer;
import com.chargepoint.csms.kafka.AuthResponseConsumer;
import com.chargepoint.csms.model.AuthRequest;
import com.chargepoint.csms.model.AuthResponse;
import com.chargepoint.csms.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.chargepoint.csms.service.impl.RfIdAuthenticationServiceImpl.BEAN_ID;

@Service(value = BEAN_ID)
@Slf4j
public class RfIdAuthenticationServiceImpl implements AuthenticationService {
    public static final String BEAN_ID = "RfIdAuthenticationService";


    @Autowired
    private AuthRequestProducer authRequestProducer;
    @Autowired
    private AuthResponseConsumer authResponseConsumer;

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        if (authResponseConsumer.rfidRegistry.containsKey(request.getDriverIdentifier().getId())) {
            log.info("Unique RFID found in registry, returning cached response");
        } else {
            authRequestProducer.sendAuthRequest(request);
        }
        return authResponseConsumer.rfidRegistry.get(request.getDriverIdentifier().getId());
    }
}
