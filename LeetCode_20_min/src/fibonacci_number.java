import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

// 2019-01-15 

public class fibonacci_number {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new fibonacci_number().run();
    }

    public int fib(int N) {
        int fib[] = new int[N+2];
        fib[0] = 0;
        fib[1] = 1;
        IntStream.range(2, N+1).
                forEach(i -> fib[i] = fib[i-1] + fib[i-2]);
        return fib[N];
    }

}