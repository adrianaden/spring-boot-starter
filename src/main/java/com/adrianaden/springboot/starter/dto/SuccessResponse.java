package com.adrianaden.springboot.starter.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class SuccessResponse extends Response {

    private Object data;

    public SuccessResponse(Integer status, Long timeStamp, String message, Object data) {
        this.status = status;
        this.timeStamp = timeStamp;
        this.message = message;
        this.data = data;
    }

    /**
     * construct new body success response
     * <b>default</b>
     * - status = 200, OK
     * - timestamp = currentTimeMillis();
     *
     * @param message the body message
     * @param data    the response data
     * @return response body
     */
    public static SuccessResponse body(String message, Object data) {
        return body(HttpStatus.OK.value(), System.currentTimeMillis(), message, data);
    }

    /**
     * construct new body success response
     *
     * @param status    the response status
     * @param timeStamp the time stamp
     * @param message   the body message
     * @param data      the response data
     * @return response body
     */
    public static SuccessResponse body(Integer status, Long timeStamp, String message, Object data) {
        return new SuccessResponse(status, timeStamp, message, data);
    }
}
