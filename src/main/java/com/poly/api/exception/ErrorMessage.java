package com.poly.api.exception;

import lombok.Data;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Data
public class ErrorMessage {
    private int statusCode;
    private String message;

    public ErrorMessage() {
    }

    public ErrorMessage(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
