package com.chargepoint.csms.model;

import com.chargepoint.csms.utils.Constants.AUTHORIZATION_STATUS;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthorizationStatusResponse {

    private AUTHORIZATION_STATUS authorizationStatus;
}
