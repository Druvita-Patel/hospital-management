package org.example.exception;

public record ApiError(String timestamp,String status,String error,String message) {
}
