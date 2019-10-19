import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-04-29 

public class C_1150 {
    InputStream is;
    BufferedReader bufferedReader;
    PrintWriter out;
    String INPUT = "";


    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};


    void solve() {
        int n = ni();
        int in[] = new int[n];

        int o = 0;
        int t = 0;
        for (int i = 0; i < n; ++i) {
            in[i] = ni();
            if (in[i] == 1) o++;
            else t++;
        }


        int prime[] = findPrimeNumbers(2*(n+1));

        int sum = 1;

        int counter = 0;

        int fA[] = new int[n];
        int sA[] = new int[n];

        for (int i = 0; i < o; ++i) {
            fA[i] = 1;
        }

        for (int i = o; i < o+t; ++i) {
            fA[i] = 2;
        }

        if (o > 0) {
            sA[0] = 1;
            for (int i = 1; i <= t; ++i) {
                sA[i] = 2;
            }

            for (int i = t+1; i < o+t; ++i) {
                sA[i] = 1;
            }
        } else {
            for (int i = 0; i < t; ++i ){
                sA[i] = 2;
            }
        }


        int pF = 0;
        int sumF = 0;
        int sumS = 0;
        int pS = 0;
        for (int i = 0; i < n; ++i) {
            sumF+=fA[i];
            if (isPrime(sumF)) {
                pF++;
            }
            sumS+=sA[i];
            if (isPrime(sumS)) {
                pS++;
            }
        }

        if (pF > pS) {
            for (int i = 0; i < n; ++i) {
                out.print(fA[i] + " ");
            }
        } else {
            for (int i = 0; i < n; ++i) {
                out.print(sA[i] + " ");
            }
        }
    }

    static boolean isPrime(int n)
    {
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        // This is checked so
        // that we can skip
        // middle five numbers
        // in below loop
        if (n % 2 == 0 ||
                n % 3 == 0)
            return false;

        for (int i = 5;
             i * i <= n; i = i + 6)
            if (n % i == 0 ||
                    n % (i + 2) == 0)
                return false;

        return true;
    }

    private int[] findPrimeNumbers(int N) {
        int ans[] = new int[4000000];
        int counter = 0;
        for (int i = 2; i <= N; i++)
        {
            if (isPrime(i)) {
                ans[counter] = i;
                counter++;
            }

        }
        return ans;
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
        new C_1150().run();
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