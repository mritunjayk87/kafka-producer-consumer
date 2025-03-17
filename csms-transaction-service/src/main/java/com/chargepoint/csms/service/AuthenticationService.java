package com.chargepoint.csms.service;


import com.chargepoint.csms.model.AuthRequest;
import com.chargepoint.csms.model.AuthResponse;

public interface AuthenticationService {

    AuthResponse authenticate(AuthRequest request);
}