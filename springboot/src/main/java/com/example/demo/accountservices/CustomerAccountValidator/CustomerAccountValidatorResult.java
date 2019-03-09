package com.example.demo.accountservices.CustomerAccountValidator;

public class CustomerAccountValidatorResult {
    private boolean isValid;
    private String reason;

    public CustomerAccountValidatorResult(boolean isValid, String reason) {
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
