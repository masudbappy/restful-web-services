package com.masudbappy.restfulwebservices.utils;

import com.masudbappy.restfulwebservices.constant.CommonApiConstants;
import org.springframework.web.servlet.function.ServerRequest;

public class CommonUtils {

    private CommonUtils() {
    }

    public static String getRequestId(ServerRequest request) {
        if (request.headers().header(CommonApiConstants.REQUEST_ID_FIELD).isEmpty()) {
            return "";
        }
        return request.headers().header(CommonApiConstants.REQUEST_ID_FIELD).get(0);
    }
}
