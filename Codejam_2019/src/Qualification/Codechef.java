package Qualification;

import java.util.*;
import java.io.*;
public class Codechef {

    private static byte[] inbuf = new byte[1024];
    public static int lenbuf = 0;
    public static int ptrbuf = 0;
    static InputStream is;
    private static int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }
    private static boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private static int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    private boolean isNewLineChar(int c) {
        return c == 10;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    static private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private static int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
    public static void main(String[] args) {

        is = System.in;
        int t = ni(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = ni();
            String str = ns();
            StringBuilder newString = new StringBuilder(str);
            for(int j=0;j<str.length();j++){
                if(str.charAt(j) == 'E'){
                    newString.setCharAt(j,'S');
                }
                else{
                    newString.setCharAt(j,'E');
                }
            }
            System.out.println("Case #" +i+": " + newString.toString());
        }
    }
}