package com.example.demo.customerservices.customervalidator;

public class CustomerValidatorResult {
    private boolean isValid;
    private String reason;

    public CustomerValidatorResult(boolean isValid, String reason) {
        this.isValid = isValid;
        this.reason = reason;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
