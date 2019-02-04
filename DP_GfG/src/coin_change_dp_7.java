import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class coin_change_dp_7 {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(count_ways(new int[]{1, 2, 3}, 4));
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    int count_ways(int S[], int n) {
        int table[] = new int[n+1];
        Arrays.fill(table, 0);
        table[0] = 1;
        for (int i = 0; i < S.length; ++i) {
            for (int j = S[i]; j <= n; ++j) {
                table[j] += table[j - S[i]];
            }
        }
        return table[n];
    }

    public static void main(String[] args) throws Exception {
        new coin_change_dp_7().run();
    }


}