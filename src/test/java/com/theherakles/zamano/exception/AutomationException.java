package com.theherakles.zamano.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AutomationException extends RuntimeException {
    public AutomationException(String message) {
        super(message);
    }
}
