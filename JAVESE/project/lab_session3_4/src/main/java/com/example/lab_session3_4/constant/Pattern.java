package com.example.lab_session3_4.constant;

public class Pattern {
    private Pattern(){}
    public static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
    public static final String PASSWORD_PATTERN = "^(?=.{4,}$).*";
    public static final String NO_DIGITS_PATTERN = "^[^0-9]*$";
}
