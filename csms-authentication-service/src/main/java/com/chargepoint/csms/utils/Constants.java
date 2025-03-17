package com.chargepoint.csms.utils;

public class Constants {
    public enum AUTHORIZATION_STATUS {Accepted, Unknown, Invalid, Rejected}

    public static String TOPIC_RFID_AUTH_REQUESTS = "auth_requests";
    public static String TOPIC_RFID_AUTH_RESPONSES = "auth_requests";
}
