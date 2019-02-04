import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class gold_mine_problem {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        int gold[][]= { {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2} };

        out.println(gold_mine_calc(gold));
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    int gold_mine_calc(int [][] matrix) {

        int ans = 0;

        for (int j = 0; j < matrix[0].length; ++j) {
            for (int i = 0; i < matrix.length; ++i) {
                int f = 0, s = 0, t = 0;

                if (j + 1 < matrix[0].length) {
                    t = matrix[i][j+1];
                }

                if (i-1 >= 0 && j - 1 >= 0) {
                    f = matrix[i-1][j-1];
                }
                if (i+1 < matrix.length && j - 1  >= 0) {
                    s = matrix[i+1][j-1];
                }
                matrix[i][j] += Math.max(f, Math.max(s, t));
                ans = Math.max(ans, matrix[i][j]);
            }
        }
        return ans;

    }

    public static void main(String[] args) throws Exception {
        new gold_mine_problem().run();
    }


}