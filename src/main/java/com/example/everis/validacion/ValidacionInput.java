package com.example.everis.validacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ValidacionInput {

    static boolean password(String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=(?:.*\\d){2})(?=(?:.*[A-Z]){1})(?=(?:.*[a-z]){1})\\S{8,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    static boolean email(String email) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}


