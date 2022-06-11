package com.proyecto.fasttohome.util;

public class Texto {

    public static String genString(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
    public static String leftPad(String in, int len) {
        return new StringBuilder(in) //
                .append(genString(len - in.length() - 1)).toString();
    }

}
