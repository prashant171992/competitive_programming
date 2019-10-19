
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

// 2019-04-24 

public class D_1151 {
    InputStream is;
    BufferedReader bufferedReader;
    PrintWriter out;
    String INPUT = "";


    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};


    void solve() {
        int n = ni();

        long a[] = new long[n];
        long b[] = new long[n];
        long c[] = new long[n];

        long sum = 0;

        for (int i = 0; i < n; ++i) {
            a[i] = ni();
            b[i] = ni();
            c[i] = (a[i] - b[i]);
            sum+= (n*b[i] - a[i]);
        }

        Arrays.sort(c);
        for (int i = n-1; i >=0; --i) {
            sum+= (c[n-i-1] * (i+1));
        }
        out.println(sum);
    }

    private BigInteger modulo(BigInteger a, BigInteger b, BigInteger c) {
        BigInteger t1 = a.mod(c);
        BigInteger t2 = b.mod(c);
        BigInteger t3 = t1.multiply(t2);
        return t3.mod(c);
    }


    void run() throws Exception {
        is = System.in;

        //is = new BufferedInputStream(new FileInputStream("./input.txt"));

        out = new PrintWriter(System.out);

        //out = new PrintWriter(new BufferedWriter(new FileWriter("./output.txt")));

        long s = System.currentTimeMillis();
        solve();
        //inputThird();
        out.close();
        //tr(System.currentTimeMillis()-s+"ms");
    }

    public static void main(String[] args) throws Exception {
        new D_1151().run();
    }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
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

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
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

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private String nsTillNewLine() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isNewLineChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private String nsF() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while ((isSpaceChar(b)) && b != ' ') { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = ns(m);
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
        return a;
    }

    private int ni() {
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

    private long nl() {
        long num = 0;
        long b;
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

    private boolean oj = System.getProperty("ONLINE_JUDGE") != null;

    private void tr(Object... o) {
        if (!oj) System.out.println(Arrays.deepToString(o));
    }
}