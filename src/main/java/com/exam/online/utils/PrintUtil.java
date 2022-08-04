package com.exam.online.utils;

public class PrintUtil {
    public static void sout(String... params) {
        for (int i = 0; i < params.length; i++) {
            if (i == 0) {
                System.out.println("[" + params[i] + ",");
            } else if (i == params.length - 1) {
                System.out.println(params[i] + "]");
            } else {
                System.out.println(params[i] + ",");
            }
        }
    }
}
