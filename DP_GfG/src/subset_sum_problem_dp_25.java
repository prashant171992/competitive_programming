import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class subset_sum_problem_dp_25 {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(isSubsetSumPresent(new int[]{3, 34, 4, 12, 5, 2}, 9));
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new subset_sum_problem_dp_25().run();
    }

    private boolean isSubsetSumPresent(int [] S, int sum) {

        boolean subset[][] = new boolean[S.length+1][sum+1];

        for (int i = 0; i < S.length; ++i) {
            subset[i][0] = true;
        }

        for (int i = 1; i <= sum; ++i) {
            subset[0][i] = false;
        }

        for (int i = 1; i <= S.length; ++i) {
            for (int j = 1; j <= sum; ++j) {
                subset[i][j] = subset[i-1][j];
                if (j >= S[i-1]) {
                    subset[i][j] |= subset[i-1][j - S[i-1]];
                }
            }
        }
        return subset[S.length][sum];
    }


}