package com.chargepoint.csms.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AuthRequest {

    private UUID stationUuid;
    private DriverIdentifier driverIdentifier;


}
