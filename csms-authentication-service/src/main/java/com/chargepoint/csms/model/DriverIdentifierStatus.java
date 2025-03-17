package com.chargepoint.csms.model;

import com.chargepoint.csms.utils.Constants.AUTHORIZATION_STATUS;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverIdentifierStatus extends DriverIdentifier {
    
    private AUTHORIZATION_STATUS authorizationStatus;
}
