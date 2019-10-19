import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class test {
    InputStream is;
    BufferedReader bufferedReader;
    PrintWriter out;
    String INPUT = "";


    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};



    Map<Pair<Pair<Double, Integer>, Integer>, Integer> map = new HashMap<Pair<Pair<Double, Integer>, Integer>, Integer>();

//    void solve() {
//        map.put(new Pair<>(0.5, 1), 1);
//        map.put(new Pair<>(1.0, 1) , 1);
//        map.put(new Pair<>(3.0, 1), 1);
//        map.put(new Pair<>(6.0, 1), 1);
//
//        double input = 10.0;
//
//        int ans = 0;
//
//        for (double i = 0.5; i <= input; i+=0.5) {
//            double sumSoFar = 0.0;
//            double restSum;
//
//            for (int j = 1; j <= (i/0.5)/2; ++j) {
//                sumSoFar+=0.5;
//                restSum = i-sumSoFar;
//                for (int k = 1; k <= j; ++k) {
//                    Integer sumSoFarBool = map.get(new Pair<>(sumSoFar, k));
//                    Integer restSumBool  = map.get(new Pair<>(restSum, k));
//                    if ((sumSoFarBool != null || canBeExpressedInK(map, k, sumSoFar) != null) && (restSumBool != null || canBeExpressedInK(map, k, restSum) != null)) {
//                        if (sumSoFar != restSum) {
//                            if (i == input) ans+=2;
//                            map.merge(new Pair<>(i, 2*k), 2, (a, b) -> a + b);
//                        }
//                        else {
//                            if (i == input) ans++;
//                            map.merge(new Pair<>(i, 2*k), 1, (a, b) -> a + b);
//                        }
//                    }
//                }
//            }
//            map.putIfAbsent(new Pair<>(i, (int) ((i / 0.5))), 1);
//        }
//
//        out.println(ans);
//
//    }




    private void solveMoreOptimized() {
        double[] denom = new double[]{0.5, 1.0, 3.0, 6.0, 12.0, 24.0, 30.0};
        out.println(recursive(denom, 10.0, 0));
    }

    int recursive(double[] denomination, double amount, int index) {
        if (amount == 0)
            return 1;
        else if (amount < 0 || denomination.length == index)
            return 0;
        else
        {
            int left = recursive(denomination, amount - denomination[index], index);
            int right = recursive(denomination, amount, index+1);
            return left + right;
        }
    }

    private void solveOptimized() {
        List<Double> list = Arrays.asList(0.5, 1.0, 3.0, 6.0, 12.0, 24.0, 30.0);
        Map<Pair<Double, Pair<Integer, Integer>> , Long> map = new HashMap<>();
        double mini = 0.5;
        double n = 240;
        for (int i = 0; i < list.size(); ++i) {
            map.put(new Pair<>(0.0, new Pair<>(0, i)), 1L);
        }

        for (int i = 0; i < list.size(); ++i) {
            for (int _i = 0; _i <= i; ++_i) {
                for (double _n = list.get(_i); _n <= n; _n+=0.5) {
                    for (int k = 1; k <= _n/mini; ++k) {
                        Long temp = map.get(new Pair<>(_n-list.get(_i), new Pair<>(k-1, _i)));
                        map.merge(new Pair<>(_n, new Pair<>(k, i)), temp == null ? 0 : temp, (a, b) -> a + b);
                    }
                }
            }
        }

        long result = 0;

        for(double a = 0.5; a < n; a+=0.5) {
            double b = n - a;
            for (int k = 1; k <= n / mini; ++k) {
                Long t1 = map.get(new Pair<>(a, new Pair<>(k, list.size()-1)));
                Long t2 = map.get(new Pair<>(b, new Pair<>(k, list.size()-1)));
                result+=  (t1 == null ? 0 : t1) * (t2 == null ? 0 : t2) ;
            }
        }

        out.println(result);

    }

    private Map<Pair<Pair<Double, Integer>, Integer>, Long> map1 = new HashMap<>();
    private List<Double> list1 = Arrays.asList(0.5, 1.0, 3.0, 6.0, 12.0, 24.0, 30.0);


    private void solveBest() {
        long total = 0;

        double n = 120.0;

        // 120
        // 240
        // 1200
        // 2400

        double mini = 0.5;


        for (double i = 0.5; i < n; i+=0.5) {
            for (int k = 1; k <= (Math.min(i, n-i))/mini; ++k) {
                Long cik = map1.get(new Pair<>(new Pair<>(i, k), 0));
                Long cnik = map1.get(new Pair<>(new Pair<>(n-i, k), 0));

                if (cik == null) {
                    map1.put(new Pair<>(new Pair<>(i, k), 0), compute(i, k, 0));
                    cik = map1.get(new Pair<>(new Pair<>(i, k), 0));
                }
                if (cnik == null) {
                    map1.put(new Pair<>(new Pair<>(n-i, k), 0), compute(n-i, k, 0));
                    cnik = map1.get(new Pair<>(new Pair<>(n-i, k), 0));
                }
                total = total + cik * cnik;
            }
        }

        out.println(total);
    }


    private Long compute(double n, int k, int index) {
        long total = 0;

        if (n == 0.0 && k == 0){
            return 1L;
        }

        if (n < 0 || k < 0 || (n > 0 && k < 1)) {
            return 0L;
        }

        Long tt = map1.get(new Pair<>(new Pair<>(n, k), index));

        if (tt != null) {
            return tt;
        }

        for (int i = index; i < list1.size(); ++i) {
            Long temp = map1.get(new Pair<>(new Pair<>(n - list1.get(i), k-1), i));
            if (temp == null) {
                temp = compute(n-list1.get(i), k - 1, i);
                map1.put(new Pair<>(new Pair<>(n - list1.get(i), k-1), i), temp);
            }
            total += temp;
        }
        return total;
    }


    private void solve() {

        solveOptimized();

        //solveMoreOptimized();
        //solveBest();

//        int total = 0;
//
//        double n = 240.0;
//
//        // 120
//        // 240
//        // 1200
//        // 2400
//
//        double mini = 0.5;
//
//        List<Double> list = Arrays.asList(0.5, 1.0, 3.0, 6.0, 12.0, 24.0, 30.0);
//
//        for (double i = 0.5; i < n; i+=0.5) {
//            for (int k = 1; k <= (Math.min(i, n-i))/mini; ++k) {
//                int cik = compute(i, k, list);
//                int cnik = compute(n-i, k, list);
//                total = total + cik * cnik;
//            }
//        }
//
//        out.println(total);

    }

    private int compute(double n, int k, List<Double> list) {
        int total = 0;

        if (n == 0.0 && k == 0){
            return 1;
        }

        if (n < 0 || k < 0 || (n > 0 && k < 1)) {
            return 0;
        }

        for (int i = 0; i < list.size(); ++i) {
            total += compute(n-list.get(i), k - 1, list.subList(i, list.size()));
        }
        return total;
    }

    private Integer canBeExpressedInK(Map<Pair<Double, Integer>, Integer> map, int k, double num) {
        double sum = 0.0;
        double restSum;
        for (int i = 1; i<(num/0.5); ++i) {
            sum+=0.5;
            restSum = num-sum;
            for (int j = 1; j < k; ++j) {
                Integer sumSoFarBool = map.get(new Pair<>(sum, j));
                Integer restSumSoFarBool = map.get(new Pair<>(restSum, k-j));
                if (sumSoFarBool != null && restSumSoFarBool != null ) {
                    map.put(new Pair<>(num, k), 1);
                    return 1;
                }
            }
        }
        return null;
    }

    private List<List<Integer>> getSubset(List<Integer> input) {
        List<List<Integer>> list = new ArrayList<>();
        Collections.sort(input);
        backtrack(list, new ArrayList<>(), 0, input);
        return list;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, int start, List<Integer> input) {

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
        new test().run();
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