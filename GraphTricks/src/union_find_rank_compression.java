import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-12 

public class union_find_rank_compression {
    InputStream is;
    BufferedReader bufferedReader;
    PrintWriter out;
    String INPUT = "";


    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    class Graph {
        int vertices, edges;
        List<Edge> edgeList;

        class Edge {
            int src, dest;

            Edge(int src, int dest) {
                this.src = src;
                this.dest = dest;
            }
        }

        class Subset {
            int parent;
            int rank;
        }

        Graph(int v, int e) {
            this.vertices = v;
            this.edges = e;
            this.edgeList = new ArrayList<>();
        }

        int findParent(Subset[] subsetList, int vertex) {
            if (subsetList[vertex].parent != vertex) {
                subsetList[vertex].parent = findParent(subsetList, subsetList[vertex].parent);
            }
            return subsetList[vertex].parent;
        }

        void union(Subset[] subsetList, int source, int dest) {
            int sourceRoot = findParent(subsetList, source);
            int destRoot = findParent(subsetList, dest);

            if (subsetList[sourceRoot].rank < subsetList[destRoot].rank) {
                subsetList[sourceRoot].parent = destRoot;
            } else if (subsetList[destRoot].rank < subsetList[sourceRoot].rank) {
                subsetList[destRoot].parent = sourceRoot;
            } else {
                subsetList[sourceRoot].parent = destRoot;
                subsetList[destRoot].rank++;
            }
        }

        boolean isCycle(Graph graph) {
            Subset[] subsetList = new Subset[graph.vertices];
            for (int i = 0; i < graph.vertices; ++i) {
                subsetList[i] = new Subset();
                subsetList[i].parent = i;
                subsetList[i].rank = 0;
            }

            for (int i = 0; i < edgeList.size(); ++i) {
                Edge edge = edgeList.get(i);
                int sourceRoot = findParent(subsetList, edge.src);
                int destRoot = findParent(subsetList, edge.dest);

                if (sourceRoot == destRoot) {
                    return true;
                }
                union(subsetList, edge.src, edge.dest);
            }
            return false;
        }
    }

    void solve() {

        Graph graph = new Graph(3, 3);
        graph.edgeList.add(graph.new Edge(0, 1));
        graph.edgeList.add(graph.new Edge(1, 2));
        graph.edgeList.add(graph.new Edge(0, 2));

        out.println(graph.isCycle(graph));
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
        new union_find_rank_compression().run();
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