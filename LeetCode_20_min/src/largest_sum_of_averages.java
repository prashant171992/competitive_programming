import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

// 2019-01-15 

public class largest_sum_of_averages {
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
        new largest_sum_of_averages().run();
    }

    public double largestSumOfAverages(int[] A, int K) {
        int N = A.length;
        double[] P = new double[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + A[i];

        double[] dp = new double[N];
        for (int i = 0; i < N; ++i)
            dp[i] = (P[N] - P[i]) / (N - i);

        for (int k = 0; k < K-1; ++k)
            for (int i = 0; i < N; ++i)
                for (int j = i+1; j < N; ++j)
                    dp[i] = Math.max(dp[i], (P[j]-P[i]) / (j-i) + dp[j]);

        return dp[0];
    }

}