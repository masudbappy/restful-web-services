package com.masudbappy.restfulwebservices.constant;

public final class CommonApiConstants {
    /**
     * Constructor.
     */
    private CommonApiConstants() {
    }

    public static final String REQUEST_ID_FIELD = "requestId";
    public static final String KEY_EMAIL_SUBJECT_PATTERN = "[Spring STG]SYSTEM ERROR: Cabinet. ServerIP: %s. RequestId: %s";
    /**
     * email body pattern
     */
    public static final String KEY_EMAIL_BODY_PATTERN = "RootException: %s\nRootMessage: %s\nMessage: %s\nStack Trace: %s";
    public static final String EMPTY_STRING = "";
}
