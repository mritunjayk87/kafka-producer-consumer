package com.chargepoint.csms.model;


import com.chargepoint.csms.utils.Constants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse extends DriverIdentifier {

    private Constants.AUTHORIZATION_STATUS authorizationStatus;


}
