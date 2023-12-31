package com.example.ae.security;

public class Constants {

    public static final String  AUTH_HEADER = "Authorization";
    public static final String JWT_SECRET = "t3pCSx2wx1ExbQ5z43XXB8my/KR24aon4EH/niU9iZi1I3S69rk1QhlMFFsTrZIY";
    public static final String SIGN_IN_URI_ENDING = "/auth/login";
    public static final long EXPIRATION_TIME = 36_000_000; // 10 hours
    public static final String BASIC_TOKEN_PREFIX = "Basic ";
    public static final String BEARER_TOKEN_PREFIX = "Bearer ";
}
