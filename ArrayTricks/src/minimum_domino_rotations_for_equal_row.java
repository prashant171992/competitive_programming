import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class minimum_domino_rotations_for_equal_row {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        int[] A = {2,1,2,4,2,2};
        int[] B = {5,2,6,2,3,2};
        out.println(minDominoRotations(A, B));
    }

    public int minDominoRotations(int[] A, int[] B) {
        int ans = -1;
        for (int i = 1; i <= 6; ++i) {
            int countA = 0, countB = 0;
            int j;
            for (j = 0; j < A.length; ++j) {
                if (A[j] != i && B[j] != i) break;
                if (A[j] == i) countA++;
                if (B[j] == i) countB++;
            }
            if (j == A.length) {
                if (ans == -1) {
                    ans = A.length - Math.max(countA, countB);
                } else {
                    ans = Math.min(ans, A.length - Math.max(countA, countB));
                }
            }
        }

        return ans;

    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new minimum_domino_rotations_for_equal_row().run();
    }


}