import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class delete_columns_to_make_sorted_iii {
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
        new delete_columns_to_make_sorted_iii().run();
    }

    public int minDeletionSize(String[] A) {

        int m = A.length, n = A[0].length(), res = n - 1, k;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < j; ++i) {
                for (k = 0; k < m; ++k) {
                    if (A[k].charAt(i) > A[k].charAt(j)) break;
                }
                if (k == m && dp[i] + 1 > dp[j])
                    dp[j] = dp[i] + 1;
            }
            res = Math.min(res, n - dp[j]);
        }
        return res;
    }

}