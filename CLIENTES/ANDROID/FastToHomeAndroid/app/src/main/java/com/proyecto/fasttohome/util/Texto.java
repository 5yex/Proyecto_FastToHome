package com.proyecto.fasttohome.util;

public class Texto {

    private static String genString(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

}
