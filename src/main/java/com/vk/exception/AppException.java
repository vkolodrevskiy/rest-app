package com.vk.exception;

/**
 * Application specific exception.
 *
 * @author vkolodrevskiy
 */
public class AppException extends RuntimeException {
    public AppException(String message) {
        super(message);
    }
}
