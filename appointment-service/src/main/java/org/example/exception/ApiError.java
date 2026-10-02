package org.example.exception;

import java.util.List;

public record ApiError(String timestamp,
                       String status,
                       String error,
                       List<String> message) {
}
