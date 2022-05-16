package com.masudbappy.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {
    private Date timeStamp;
    private String message;
    private String details;

    public ExceptionResponse() {
    }

    public ExceptionResponse(Date timeStamp, String message, String details) {
        super();
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
