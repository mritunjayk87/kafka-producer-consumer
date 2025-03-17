package com.chargepoint.csms.utils;

import com.chargepoint.csms.model.AuthRequest;

public class AuthRequestValidators {

    private AuthRequestValidators() {
    }

    public static void validate(AuthRequest request) {
        if (request.getDriverIdentifier() == null || request.getDriverIdentifier().getId() == null) {
            throw new IllegalArgumentException("Driver identifier is required");
        } else if (request.getDriverIdentifier().getId().length() < 20 || request.getDriverIdentifier().getId().length() > 80) {
            throw new IllegalArgumentException("Driver identifier is length must be between 20 and 80 characters");
        }
    }
}
