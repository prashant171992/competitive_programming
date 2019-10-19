package Round1C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-05-04 

public class Solution {
    InputStream is;
    BufferedReader bufferedReader;
    PrintWriter out;
    String INPUT = "";


    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};


    void solve() {
        int t = ni();
        for (int i = 0; i < t; ++i) {
            int sc = ni();
            String[] strings = new String[sc];
            int maxL = 0;
            for (int j = 0; j < sc; ++j) {
                strings[j] = ns();
                maxL = Math.max(maxL, strings[j].length());
            }

           char chA [] = new char[]{'P', 'R', 'S'};
            Map<Character, Character> map = new HashMap<>();
            map.put('R', 'P');
            map.put('S', 'R');
            map.put('P', 'S');

            StringBuilder ans = new StringBuilder("");
            boolean[] sO = new boolean[sc];
            char lll[] = new char[sc];
            boolean ansCC = false;

            for (int j = 0; j < 500; ++j) {
                int []flag = new int[3];
                for (int l = 0; l < 3; ++l) {
                    for (int k = 0; k < sc; ++k) {

                        if (sO[k]) {
                            flag[l]+=2;
                            continue;
                        }

                        char test;
                        if (j >= strings[k].length()) {
                            int temp = j % strings[k].length();
                            test = strings[k].charAt(temp);
                        } else {
                            test = strings[k].charAt(j);
                        }
                        if (chA[l] == test) {
                            flag[l]++;
                        } else if (chA[l] == map.get(test)) {
                            flag[l]+=2;
                        } else {
                            flag[l] -= 10000;
                        }
                    }

                }

                if (flag[0] < 0 && flag[1] < 0 && flag[2] < 0) {
                    break;
                } else {
                    if (flag[0] > 0 && flag[0] > flag[1] && flag[0] > flag[2]) {
                        ans.append(chA[0]);

                        for (int k = 0; k < sc; ++k) {
                            char test;
                            if (j >= strings[k].length()) {
                                int temp = j % strings[k].length();
                                test = strings[k].charAt(temp);
                            } else {
                                test = strings[k].charAt(j);
                            }
                            if (chA[0] == map.get(test)) {
                                sO[k] = true;
                            }
                        }




                    } else if (flag[1] > 0 && flag[1] > flag[0] && flag[1] > flag[2]) {
                        ans.append(chA[1]);

                        for (int k = 0; k < sc; ++k) {
                            char test;
                            if (j >= strings[k].length()) {
                                int temp = j % strings[k].length();
                                test = strings[k].charAt(temp);
                            } else {
                                test = strings[k].charAt(j);
                            }
                            if (chA[1] == map.get(test)) {
                                sO[k] = true;
                            }
                        }

                    } else if (flag[2] > 0 && flag[2] > flag[0] && flag[2] > flag[1]) {
                        ans.append(chA[2]);

                        for (int k = 0; k < sc; ++k) {
                            char test;
                            if (j >= strings[k].length()) {
                                int temp = j % strings[k].length();
                                test = strings[k].charAt(temp);
                            } else {
                                test = strings[k].charAt(j);
                            }
                            if (chA[2] == map.get(test)) {
                                sO[k] = true;
                            }
                        }


                    }
                    Arrays.sort(flag);
                    if (flag[2] == 2 * sc) {printF(i, ans.toString());ansCC = true; break;}
                }
            }
            if (!ansCC)
            printF(i, "IMPOSSIBLE");
        }
    }



    private void printF(int t, String s) {
        out.println("Case #" + (t+1) + ": " + s);
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
        new Solution().run();
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