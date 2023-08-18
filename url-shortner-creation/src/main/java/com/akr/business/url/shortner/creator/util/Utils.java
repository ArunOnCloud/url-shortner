package com.akr.business.url.shortner.creator.util;


import java.util.Random;

public class Utils {

    private static Random random = new Random();
    private static long BOUND= 10000000000L;
    public static String getShortKey(){
        Long num = random.nextLong(BOUND);
        return fromDecimalToOtherBase(62,num);
    }
    private static final String baseDigits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private static String fromDecimalToOtherBase(long base, long decimalNumber) {
        String result = decimalNumber == 0 ? "0" : "";
        while (decimalNumber != 0) {
            long mod = decimalNumber % base;
            result = baseDigits.substring((int)mod, (int)mod + 1) + result;
            decimalNumber = decimalNumber / base;
        }
        return result;
    }
}
