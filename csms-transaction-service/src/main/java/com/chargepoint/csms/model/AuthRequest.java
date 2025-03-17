package com.chargepoint.csms.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AuthRequest {

    /*@Serial
    private static final long serialVersionUID = -7094823242385243580L;*/
    private UUID stationUuid;
    private DriverIdentifier driverIdentifier;


}
