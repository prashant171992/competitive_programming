import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.stream.IntStream;

public class best_time_to_buy_and_sell_stock_with_transaction_fee {
    InputStream is;
    BufferedReader bufferedReader;
    PrintWriter out;
    String INPUT = "";


    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};


    void solve() {
        int prices[] = new int[]{1, 3, 2, 8, 4, 9};
        //int prices[] = new int[]{10,1,20};
        out.println(maxProfit1(prices, 2));
    }

    private BigInteger modulo(BigInteger a, BigInteger b, BigInteger c) {
        BigInteger t1 = a.mod(c);
        BigInteger t2 = b.mod(c);
        BigInteger t3 = t1.multiply(t2);
        return t3.mod(c);
    }

    public int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = -prices[0];
        for (int i = 1; i < prices.length; ++i) {
            cash = Math.max(cash, prices[i] + hold - fee); // Either have previous day cash or earn more cash by selling stock
            hold = Math.max(hold, cash - prices[i]); // Either have stock as yesterday or buy new stock today
        }
        return cash;
    }

    public int maxProfit1(int[] prices, int fee) {
        int cash[] = new int[prices.length];
        int hold[] = new int[prices.length];
        String action[] = new String[prices.length];
        cash[0] = 0;
        hold[0] = -prices[0];
        for (int i = 1; i < prices.length; ++i) {
            cash[i] = Math.max(cash[i-1], prices[i] + hold[i-1] - fee); // Either have previous day cash or earn more cash by selling stock
            hold[i] = Math.max(hold[i-1], cash[i-1] - prices[i]); // Either have stock as yesterday or buy new stock today
        }
        if (cash[prices.length-1] == cash[prices.length-2]) {
            action[prices.length-1] = "No-action";
        } else {
            action[prices.length-1] = "Sell";
        }
        int lastBuy = Integer.MAX_VALUE;
        int lastSell = Integer.MAX_VALUE;
        for (int i = prices.length-2; i>0; --i) {
            if (action[i+1].equals("Sell")) {
                if (hold[i] > hold[i-1]) {
                    action[i] = "Buy";
                    lastBuy = Math.min(i, lastBuy);
                } else {
                    action[i] = "No-action";
                }
            } else if (action[i+1].equals("Buy")) {
                if (cash[i] > cash[i-1]) {
                    action[i] = "Sell";
                    lastSell = Math.min(i, lastSell);
                } else {
                    action[i] = "No-action";
                }
            } else {
                if (cash[i] > cash[i-1]) {
                    action[i] = "Sell";
                    lastSell = Math.min(i, lastSell);
                } else if (hold[i] > hold[i-1]) {
                    action[i] = "Buy";
                    lastBuy = Math.min(i, lastBuy);
                } else {
                    action[i] = "No-action";
                }
            }
        }
        if (lastBuy < lastSell) {
            action[0] = "No-action";
        } else {
            action[0] = "Buy";
        }
        IntStream.range(0, action.length)
                .forEach(i -> System.out.print(action[i] + " "));
        return cash[prices.length-1];
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
        new best_time_to_buy_and_sell_stock_with_transaction_fee().run();
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