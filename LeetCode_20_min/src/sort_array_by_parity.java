import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class sort_array_by_parity {
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

    public int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length-1;

        while(left <= right) {
            if (A[left] %2 != 0 && A[right] % 2 == 0) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }else if (A[left] % 2 == 0) {
                left++;
            } else if (A[right] %2 == 1) {
                right--;
            }
        }

        return A;
    }

    public static void main(String[] args) throws Exception {
        new sort_array_by_parity().run();
    }


}