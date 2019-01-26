import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class n_repeated_element_in_size_2n_array {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    public int repeatedNTimes(int[] A) {

        for (int i = 0; i < A.length; ++i) {
            if (i+1 < A.length && A[i] == A[i+1]) {
                return A[i];
            }
            if (i+2 < A.length && A[i] == A[i+2]) {
                return A[i];
            }
        }
        return A[0];
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new n_repeated_element_in_size_2n_array().run();
    }


}