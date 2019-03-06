import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class knapsack_problem_dp_10 {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};


    // 0-1 Knapsack Problem bottom up approach


    void solve() {
        out.println(solveKnapsack(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50));
    }

    private int solveKnapsack(int[] val, int [] wt, int C) {

        int dp[][] = new int[val.length][C+1];

        for (int i = 0; i < val.length; ++i) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= C; ++i) {
            if (i >= wt[0]) {
                dp[0][i] = val[0];
            }
        }

        for (int i = 1; i < val.length; ++i) {
            for (int j = 1; j <= C; ++j) {
                dp[i][j] = dp[i-1][j];
                if (wt[i] <= j) {
                    dp[i][j] = Math.max(dp[i][j], val[i] + dp[i-1][j-wt[i]]);
                }
            }
        }

        return dp[val.length-1][C];
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new knapsack_problem_dp_10().run();
    }


}