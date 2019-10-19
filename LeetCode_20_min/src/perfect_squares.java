import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class perfect_squares {
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
        new perfect_squares().run();
    }

    public int numSquares(int n) {

        int leastSquareArray[] = new int[n+1];
        int size = 0;
        for (int i = 1; i <= n; ++i) {
            if (i * i > n) {
                break;
            }
            leastSquareArray[size] = i*i;
            size++;
        }

        int ans[] = new int[n+1];
        for (int i = 1; i <= n; ++i) ans[i] = Integer.MAX_VALUE;
        ans[0] = 0;

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < size; ++j) {
                if (leastSquareArray[j] <= i) {
                    int temp = ans[i-leastSquareArray[j]];
                    if (temp != Integer.MAX_VALUE &&
                            temp + 1 < ans[i]) {
                        ans[i] = 1 + temp;
                    }
                }
            }
        }
        return ans[n];

    }

}