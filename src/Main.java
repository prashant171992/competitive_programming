import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    InputStream is;
    BufferedReader bufferedReader;
    PrintWriter out;
    String INPUT = "";


    int row[] = { -1, 0, 1, 0 };
    int column[] = { 0, 1, 0, -1 };

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }

    public int findTargetSumWays(int[] nums, int S) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(0);
        queue.add(root);
        int counter = 0;
        while(!queue.isEmpty()) {
            int addCount = 0;
            List<TreeNode> list = new ArrayList<>();
            TreeNode node = queue.poll();
            node.left = new TreeNode(nums[counter]);
            node.right = new TreeNode((-1) * nums[counter]);
            list.add(node.left);
            list.add(node.right);
            while(!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                temp.left = new TreeNode(nums[counter]);
                temp.right = new TreeNode((-1) * nums[counter]);
                list.add(temp.left);
                list.add(temp.right);
            }

            for (int i = 0; i < list.size(); ++i) {
                if (list.get(i) != null)
                    queue.add(list.get(i));
            }
        }
        return calcSum(root, 0, S);
    }

    int calcSum(TreeNode treeNode, int sum, int target) {
        if (treeNode == null) {
            return 0;
        }
        else if (treeNode.left == null && treeNode.right == null) {
            if (treeNode.val + sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        else {
            return calcSum(treeNode.left, sum + treeNode.val, target) +
                    calcSum(treeNode.right, sum + treeNode.val, target);
        }
    }


    void solve() {

        out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

    void printList(ArrayList<Point> arrayList) {
        arrayList.stream().forEach( i -> System.out.println(i.x1 + " " + i.x2 + " " + i.y));
        System.out.println("----");
    }

    class Point {
        long x1;
        long x2;
        long y;
        Point(long a, long b, long c) {
            this.x1 = a;
            this.x2 = b;
            this.y = c;
        }

        public long getX1() {
            return x1;
        }

        public void setX1(long x1) {
            this.x1 = x1;
        }

        public long getX2() {
            return x2;
        }

        public void setX2(long x2) {
            this.x2 = x2;
        }

        public long getY() {
            return y;
        }

        public void setY(long y) {
            this.y = y;
        }
    }




    boolean isPrime(long n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    private BigInteger modulo(BigInteger a, BigInteger b, BigInteger c) {
        BigInteger t1 = a.mod(c);
        BigInteger t2 = b.mod(c);
        BigInteger t3 = t1.multiply(t2);
        return t3.mod(c);

//        BigInteger x= BigInteger.valueOf(1);
//        BigInteger y=a;
//        while(b.compareTo(BigInteger.valueOf(0)) > 0){
//            if(b.mod(BigInteger.valueOf(2)).equals( BigInteger.valueOf(1))){
//                x= x.multiply(y).mod(c);
//            }
//            y = y.multiply(y).mod(c); // squaring the base
//            b = b.divide(BigInteger.valueOf(2));
//        }
//        return x.mod(c);
    }




    void run() throws Exception {
        is =  System.in;

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
        new Main().run();
    }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
    private boolean isNewLineChar(int c) { return c == 10;}

    private double nd() { return Double.parseDouble(ns()); }
    private char nc() { return (char)skip(); }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private String nsTillNewLine() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isNewLineChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private String nsF() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while((isSpaceChar(b)) && b!=' '){ // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for(int i = 0;i < n;i++)map[i] = ns(m);
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = ni();
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }

        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl() {
        long num = 0;
        long b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }

        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
    private void tr(Object... o) { if(!oj)System.out.println(Arrays.deepToString(o)); }
}