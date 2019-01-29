import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class largest_perimeter_triangle {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int ans = 0;
        for (int i = A.length-1; i>=2; --i) {
            if (A[i-1] + A[i-2] > A[i]) {
                ans = A[i] + A[i-1] + A[i-2];
                break;
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
        new largest_perimeter_triangle().run();
    }


}