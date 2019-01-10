import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class string_transform_book {
    InputStream is;
    BufferedReader bufferedReader;
    PrintWriter out;
    String INPUT = "";


    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    // See book page 379 for problem statement.

    class Graph {
        private List<String> stringList;
        private Map<String, List<String>> adj;


        Graph(List<String> strings) {
            this.stringList = strings;
            for (int i = 0; i < strings.size(); ++i) {
                for (int j = 0; j < strings.size(); ++j) {
                    if (i!=j) {
                        if (differByOneOrLessCharacter(strings.get(i), strings.get(j))) {
                            adj.merge(strings.get(i), Arrays.asList(strings.get(j)), (l1, l2) -> Stream.of(l1, l2).flatMap(Collection::stream).collect(Collectors.toList()));
                            adj.merge(strings.get(j), Arrays.asList(strings.get(i)), (l1, l2) -> Stream.of(l1, l2).flatMap(Collection::stream).collect(Collectors.toList()));
                        }
                    }
                }
            }
        }

        int findMinDistanceToTransform(String s, String d) {
            Map<String, Integer> distanceMap = new HashMap<>();
            stringList.forEach(string -> distanceMap.putIfAbsent(string, -1));
            Queue<String> queue = new LinkedList<>();
            queue.add(s);
            distanceMap.putIfAbsent(s, 0);
            while (!queue.isEmpty()) {
                String queueNode = queue.poll();
                int distance = distanceMap.get(queueNode);
                if (queueNode.equals(d)) {
                    return distance;
                }
                for (int i = 0 ; i < adj.get(queueNode).size(); ++i) {
                    String s1 = adj.get(queueNode).get(i);
                    if (distanceMap.get(s1) == -1) {
                        distanceMap.replace(s1, distance+1);
                        queue.add(s1);
                    }
                }
            }
            return distanceMap.get(d);
        }

        boolean differByOneOrLessCharacter(String a, String b) {
            int freq[] = new int[26];
            for (int i = 0; i < a.length(); ++i) {
                freq[a.charAt(i)-'a']++;
            }
            for (int i = 0; i < b.length(); ++i) {
                freq[b.charAt(i)-'a']--;
            }
            int count = 0;
            for (int i = 0; i < 26; ++i) {

                if (freq[i] != 0) {
                    count++;
                }
            }

            if (count > 1) {
                return false;
            }

            return true;

        }
    }

    void solve() {

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
        new string_transform_book().run();
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