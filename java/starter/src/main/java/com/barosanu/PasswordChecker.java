package com.barosanu;

public class PasswordChecker {
    
    public boolean checkPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        if (password.length() > 20) {
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        if (!password.matches(".*\\d.*")) {  // numeric check
            return false;
        }

        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            return false;
        }

        return true;
    }

    public boolean checkPasswordAndThrowReason(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        if (password.length() > 20) {
            throw new IllegalArgumentException("Password must be at most 20 characters long");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter");
        }

        if (!password.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("Password must contain at least one lowercase letter");
        }

        if (!password.matches(".*\\d.*")) {  // numeric check
            throw new IllegalArgumentException("Password must contain at least one digit");
        }

        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|, .<>\\/?].*")) {
            throw new IllegalArgumentException("Password must contain at least one special character");
        }

        return true;
    }
}
