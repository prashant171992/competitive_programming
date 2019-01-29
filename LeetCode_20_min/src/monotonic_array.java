import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class monotonic_array {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) return true;
        int dir = 0;
        for (int i = 1; i < A.length; ++i) {
            if (A[i] > A[i-1] && (dir == 1 || dir == 0)) {
                dir = 1;
            } else if (A[i] < A[i-1] && (dir == -1 || dir == 0)) {
                dir = -1;
            } else if (A[i] == A[i-1]){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new monotonic_array().run();
    }


}