import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class maximum_length_of_repeated_subarray {
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
        new maximum_length_of_repeated_subarray().run();
    }

    public int findLength(int[] A, int[] B) {
        int ans[][] = new int[A.length+1][B.length+1];
        int result = 0;
        for (int i = 0; i <= A.length; ++i) {
            for (int j = 0; j <= B.length; ++j) {
                if (i == 0 || j == 0) {
                    ans[i][j] = 0;
                }
                else if (A[i-1] == B[j-1]) {
                    ans[i][j] = ans[i-1][j-1] + 1;
                    result = Math.max(ans[i][j], result);
                }
            }
        }
        return result;
    }


}