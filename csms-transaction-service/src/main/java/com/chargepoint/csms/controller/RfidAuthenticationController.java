package com.chargepoint.csms.controller;

import com.chargepoint.csms.model.AuthRequest;
import com.chargepoint.csms.model.AuthorizationStatusResponse;
import com.chargepoint.csms.service.AuthenticationServiceFactory;
import com.chargepoint.csms.utils.AuthRequestValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/csms/v1/auth")
public class RfidAuthenticationController {

    private final AuthenticationServiceFactory authenticationService;

    @Autowired
    public RfidAuthenticationController(AuthenticationServiceFactory authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate")
    public AuthorizationStatusResponse authenticate(@RequestBody AuthRequest authRequest) {
        AuthRequestValidators.validate(authRequest);
        authenticationService.getAuthenticationService(authRequest);
        return new AuthorizationStatusResponse();
    }
}
