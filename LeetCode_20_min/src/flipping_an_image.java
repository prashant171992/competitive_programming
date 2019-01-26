import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class flipping_an_image {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int left = 0;
        int right = A[0].length - 1;

        while(left < right) {
            for (int i = 0; i < A.length; ++i) {
                int temp = A[i][left];
                A[i][left] = A[i][right];
                A[i][right] = temp;

                // now invert their values
                A[i][left] = Math.abs(A[i][left]-1);
                A[i][right] = Math.abs(A[i][right]-1);
            }
            left++;
            right--;
        }

        if (left == right) {
            // Inverting the central column
            for (int i = 0; i < A.length; ++i) {
                A[i][left] = Math.abs(A[i][left]-1);
            }
        }


        return A;
    }


    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new flipping_an_image().run();
    }


}