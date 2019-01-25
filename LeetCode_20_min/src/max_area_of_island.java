import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class max_area_of_island {
    InputStream is;
    BufferedReader bufferedReader;
    PrintWriter out;
    String INPUT = "";


    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};


    void solve() {
        int input[][] = {{1,1, 1}, {1,0, 0}};
        out.println(maxAreaOfIsland(input));
    }

    class Node {
        int x, y, val;
    }

    public int maxAreaOfIsland(int[][] grid) {
        boolean visit[][] = new boolean[grid.length][grid[0].length];

        int ans = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    ans = Math.max(ans, dfs(grid, visit, i, j));
                }
            }
        }

        return ans;
    }

    int dfs(int[][] grid, boolean [][] visit, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0 || visit[i][j]) {
            return 0;
        }
        int ans = 1;
        visit[i][j] = true;
        for (int k = 0; k < 4; ++k){
            int x = i + row[k];
            int y = j + column[k];
            ans+= dfs(grid, visit, x, y);
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
        new max_area_of_island().run();
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