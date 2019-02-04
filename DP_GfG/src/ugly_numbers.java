import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class ugly_numbers {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(getNthUglyNumber(150));
    }

    int getNthUglyNumber(int n) {
        int ugly[] = new int[n+1];
        int ugly_2 = 0;
        int ugly_3 = 0;
        int ugly_5 = 0;
        ugly[0] = 1;

        int ugly_number = 1;

        for (int i = 1; i < n; ++i) {

            ugly_number = Math.min(ugly[ugly_2] * 2, Math.min(ugly[ugly_3] * 3, ugly[ugly_5] * 5));
            ugly[i] = ugly_number;

            if (ugly_number == ugly[ugly_2] * 2) {
                ugly_2++;
            }
            if (ugly_number == ugly[ugly_3] * 3) {
                ugly_3++;
            }
            if (ugly_number == ugly[ugly_5] * 5) {
                ugly_5++;
            }
        }

        return ugly_number;

    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new ugly_numbers().run();
    }


}