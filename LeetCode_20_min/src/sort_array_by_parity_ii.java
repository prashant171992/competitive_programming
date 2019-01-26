import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class sort_array_by_parity_ii {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(sortArrayByParityII(new int[]{4,2,5,7}));
    }

    public int[] sortArrayByParityII(int[] A) {
        int evenPointer = 0;
        int oddPointer = 1;
        while (evenPointer < A.length && oddPointer < A.length) {
            if (evenPointer< A.length && A[evenPointer] % 2 != 0) {
                if (oddPointer < A.length && A[oddPointer] % 2 == 0) {
                    int temp = A[evenPointer];
                    A[evenPointer] = A[oddPointer];
                    A[oddPointer] = temp;
                    evenPointer+=2;
                    oddPointer+=2;
                } else if (oddPointer < A.length) {
                    oddPointer+=2;
                }
            }
            else if (oddPointer < A.length && A[oddPointer] % 2 != 1) {
                if (evenPointer < A.length && A[evenPointer] % 2 == 1) {
                    int temp = A[evenPointer];
                    A[evenPointer] = A[oddPointer];
                    A[oddPointer] = temp;
                    evenPointer+=2;
                    oddPointer+=2;
                } else if (evenPointer < A.length) {
                    evenPointer+=2;
                }
            } else {
                evenPointer+=2;
                oddPointer+=2;
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
        new sort_array_by_parity_ii().run();
    }


}