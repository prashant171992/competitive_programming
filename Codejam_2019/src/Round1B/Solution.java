package Round1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution {
    InputStream is;
    BufferedReader bufferedReader;
    PrintWriter out;
    String INPUT = "";


    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};


    void solve() {
        int t = ni();

        for (int j = 0; j < t; ++j) {




            int points = ni();
            int maxL = ni();

            int x[] = new int[points];
            int y[] = new int[points];
            char d[] = new char[points];
            int nx[] = new int[points];
            int ny[] = new int[points];

            for (int i = 0; i < points; ++i) {
                x[i] = ni();
                y[i] = ni();
                d[i] = nc();
                if (d[i] == 'N') {
                    nx[i] = x[i];
                    ny[i] = y[i] + 1;
                }
                if (d[i] == 'E') {
                    nx[i] = x[i] + 1;
                    ny[i] = y[i];
                }
                if (d[i] == 'W') {
                    nx[i] = x[i] - 1;
                    ny[i] = y[i];
                }
                if (d[i] == 'S') {
                    nx[i] = x[i];
                    ny[i] = y[i] - 1;
                }
            }

            int maxCover = 0;
            int ansx = 0;
            int ansy = 0;

            int tAx = ansx, tAy = ansy;

            for (int i = 0; i < points; ++i) {

                int ttt = ccalc(maxL, points, nx, ny, d, nx[i], ny[i]);
                if (ttt == maxCover) {
                    if (tAx > nx[i] || tAy > ny[i]) {
                        tAx = nx[i];
                        tAy = ny[i];
                    }
                    maxCover = ttt;
                } else if (ttt > maxCover) {
                    tAx = nx[i];
                    tAy = ny[i];
                    maxCover = ttt;
                }

//                ttt = ccalc(maxL, points, nx, ny, d, nx[i], ansy);
//
//                if (ttt == maxCover) {
//                    if (tAx > nx[i] || tAy > ansy) {
//                        tAx = nx[i];
//                        tAy = ansy;
//                    }
//                    maxCover = ttt;
//                } else if (ttt > maxCover) {
//                    tAx = nx[i];
//                    tAy = ansy;
//                    maxCover = ttt;
//                }
//
//                ttt = ccalc(maxL, points, nx, ny, d, ansx, ny[i]);
//
//                if (ttt == maxCover) {
//                    if (tAx > ansx || tAy > ny[i]) {
//                        tAx = ansx;
//                        tAy = ny[i];
//                    }
//                    maxCover = ttt;
//                } else if (ttt > maxCover) {
//                    tAx = ansx;
//                    tAy = ny[i];
//                    maxCover = ttt;
//                }

                ansx = tAx;
                ansy = tAy;

            }

            int fc = maxCover;
            int lx = ansx;
            int ly = ansy;

            while (fc == maxCover) {
                //fc = 0;
                fc = ccalc(maxL, points, nx, ny, d, ansx, ansy);
                if (ccalc(maxL, points, nx, ny, d, ansx-1, ansy) == fc) {
                    ansx--;
                }
                if (ccalc(maxL, points, nx, ny, d, ansx, ansy-1) == fc) {
                    ansy--;
                }

                fc = ccalc(maxL, points, nx, ny, d, ansx, ansy);

                if (ansx == lx && ansy == ly) {
                    break;
                }
                lx = ansx;
                ly = ansy;
            }

            out.println("Case #"+ (j+1) +": " + lx + " " + ly);
        }

    }

    private int ccalc(int maxL,int points, int nx[], int ny[], char d[], int p, int q) {
        int cc = 0;
        if (p >= 0 && p <= maxL && q >= 0 && q <= maxL) {
            for (int k = 0; k < points; ++k) {
                if (nx[k] >= 0 && nx[k] <= maxL && ny[k] >= 0 && ny[k] <= maxL) {
                    if (nx[k] == p && ny[k] == q) {
                        cc++;
                    } else if (nx[k] == p && ny[k] < q && (d[k] == 'E' || d[k] == 'W')) {
                        cc++;
                    } else if (nx[k] < p && ny[k] == q && (d[k] == 'S' || d[k] == 'N')) {
                        cc++;
                    }
                }

            }
        }
        return cc;
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
        new Round1B.Solution().run();
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
