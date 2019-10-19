import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class partition_array_for_maximum_sum {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3);
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new partition_array_for_maximum_sum().run();
    }

    public int maxSumAfterPartitioning(int[] A, int K) {
        int dp[] = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            int max = 0;
            for (int j = 1; j<=K && i-j+1 >=0; ++j) {
                max = Math.max(max, A[i-j+1]);
                dp[i] = Math.max(dp[i],
                        (i-j >= 0 ? dp[i-j] : 0) + max * j);
            }
        }
        return dp[A.length-1];

    }


}