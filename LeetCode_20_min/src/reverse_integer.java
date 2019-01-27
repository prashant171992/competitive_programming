import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class reverse_integer {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(reverse(123));
    }

    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x/=10;
        }
        result = x < 0 ? (-1) * result : result;
        if (result < Integer.MIN_VALUE || result >= (Integer.MAX_VALUE - 1)) {
            return 0;
        } else {
            return (int)result;
        }
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new reverse_integer().run();
    }


}