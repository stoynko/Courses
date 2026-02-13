package _09_Workshop.entities.user;

import _09_Workshop.common.SystemErrors;

public class UserValidator {

    public static void validateUsername(String username) {
        if (username == null
                || username.isBlank()
                || username.length() < 5
                || username.chars().noneMatch(Character::isDigit)
                || username.chars().noneMatch(Character::isLetter)) {
            throw new IllegalArgumentException(SystemErrors.INVALID_USERNAME);
        }
    }
    public static void validatePassword(String password) {
        if (password == null
                || password.isBlank()
                || password.length() < 6
                || !password.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(SystemErrors.INVALID_PASSWORD);
        }
    }
}
