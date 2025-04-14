package org.example.ZohoLevel_2;

import java.util.Arrays;

class ValidateAnIPAddress {

    public  static boolean isValid(String s) {
        String arr[] = s.split("\\.");
        if (arr.length != 4) return false;
        for (String s1 : arr) {
            int len = s1.length();
            if (len == 0 || len > 3) {
                return false;
            }
            for (char c : s1.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            int num = Integer.parseInt(s1);
            if (num < 0 || num > 255 || (s1.length() > 1 && s1.charAt(0) == '0')) {
                return false;
            }

        }
        return  true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("0.0.0.255"));
    }
}