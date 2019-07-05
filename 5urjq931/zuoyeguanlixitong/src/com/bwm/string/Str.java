package com.bwm.string;

import java.io.*;


public class Str {

 
    public String toChinese(String str) {
        if (str == null || str.length() < 1) {
            str = "";
        } else {
            try {
                str = (new String(str.getBytes("iso-8859-1"), "GB2312"));
            } catch (UnsupportedEncodingException e) {
                System.err.print(e.getMessage());
                e.printStackTrace();
                return str;
            }
        }
        return str;
    }

    public String dbEncode(String str) {
        if (str == null) {
            str = "";
        } else {
            try {
                str = str.replace('\'', (char) 1).trim();
            } catch (Exception e) {
                System.err.print(e.getMessage());
                e.printStackTrace();
                return str;
            }
        }
        return str;
    }
}
