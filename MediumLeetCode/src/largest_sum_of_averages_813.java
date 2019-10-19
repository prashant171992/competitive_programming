import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class largest_sum_of_averages_813 {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    public double largestSumOfAverages(int[] A, int K) {

        if (A.length == 1) {
            return A[0];
        }

        double ans[][] = new double[A.length][K+1];

        double sum[] = new double[A.length];

        sum[0] = A[0];
        ans[0][1] = A[0];

        for (int i = 1; i < A.length; ++i) {
            sum[i] = sum[i-1] + A[i];
            ans[i][1] = sum[i]/(i+1);
        }


        for (int groups = 2; groups <= K; ++groups) {
            for (int i = 0; i < A.length; ++i) {
                double max = Double.MIN_VALUE;
                for (int j = 0; j < i; ++j) {
                    max = Math.max(max, ans[j][groups-1]+ (sum[i] - sum[j])/(i-j));
                }
                ans[i][groups] = max;
            }
        }

        return ans[A.length-1][K];

    }

    void solve() {

    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new largest_sum_of_averages_813().run();
    }


}