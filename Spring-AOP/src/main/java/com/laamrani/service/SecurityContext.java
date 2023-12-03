package com.laamrani.service;

public class SecurityContext {
    private static String username = "";
    private static String password = "";
    private static String[] roles = new String[] {};
    public static void authenticate(String username, String password, String[] roles) {
        if (username.equals("root") && password.equals("1234")) {
            SecurityContext.username = username;
            SecurityContext.password = password;
            SecurityContext.roles = roles;
        }
        else {
            throw new RuntimeException("Authentication failed!");
        }
    }
    public static boolean hasRole(String role) {
        for (String r : roles) {
            if (r.equals(role)) {
                return true;
            }
        }
        return false;
    }
}
