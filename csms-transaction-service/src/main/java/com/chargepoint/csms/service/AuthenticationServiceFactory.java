package com.chargepoint.csms.service;

import com.chargepoint.csms.model.AuthRequest;
import com.chargepoint.csms.service.impl.RfIdAuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class AuthenticationServiceFactory {
    private final Map<String, AuthenticationService> authenticationServiceMap;

    public void getAuthenticationService(AuthRequest request) {
        authenticationServiceMap.get(RfIdAuthenticationServiceImpl.BEAN_ID).authenticate(request);
    }
}
