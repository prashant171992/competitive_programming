import java.io.*;
import java.util.*;

/**
 * Created by prassingh on 2/26/17.
 */
public class Fibonacci {

    private int numA;
    private int numB;

    private Fibonacci(int num1, int num2) {
        this.numA = num1;
        this.numB = num2;
    }

    public static void main(String[] args) throws IOException {

        Reader.init(System.in);
        Print print = new Print();

        int n = Reader.nextInt();
        int m = Reader.nextInt();

        boolean ans = false;

        for (int i = 0 ; i < m ; ++i) {
            int p = Reader.nextInt();
            for (int j = 0 ; j < p ; ++j){
                int temp = Reader.nextInt();

            }
        }
        print.close();

    }

    private static int arrayToInt(ArrayList<Integer> input) {
        int ans = 0;
        for (Integer i: input) {
            ans = 10*ans + i;
        }
        return ans;
    }

    public int getNumA() {
        return numA;
    }

    public void setNumA(int numA) {
        this.numA = numA;
    }

    public int getNumB() {
        return numB;
    }

    public void setNumB(int numB) {
        this.numB = numB;
    }
}

class FibonacciComparator implements Comparator<Fibonacci> {

    @Override
    public int compare(Fibonacci o1, Fibonacci o2) {
        if (((o1.getNumA() - o1.getNumB()) > (o2.getNumA() - o2.getNumB()))) {
            return 1;
        } else if (((o1.getNumA() - o1.getNumB()) < (o2.getNumA() - o2.getNumB()))) {
            return -1;
        } else {
            return 0;
        }
    }
}


///** Class for buffered reading int and double values */
class Reader {
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while (! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }

    static String nextLine() throws IOException {
        String str = "";
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    static Integer[] nextIntegerArray(int n) throws IOException {
        Integer[] a = new Integer[n];
        for(int i = 0; i < n; i++) a[i] = nextInt();
        return a;
    }

    static int[] nextIntArray(int n) throws IOException {
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = nextInt();
        return a;
    }

    static char[] nextCharArray() throws IOException {
        return nextLine().toCharArray();
    }
}

class Print {

    private final BufferedWriter bw;
    Print() {
        this.bw=new BufferedWriter(new OutputStreamWriter(System.out));
    }
    void print(Object object)throws IOException {
        bw.append("").append(String.valueOf(object));
    }
    void println(Object object)throws IOException {
        print(object);
        bw.append("\n");
    }
    void close()throws IOException {
        bw.close();
    }
}