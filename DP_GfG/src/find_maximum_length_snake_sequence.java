import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class find_maximum_length_snake_sequence {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    int[][] result;

    void solve() {
        int [][] mat = {
            {9, 6, 5, 2},
            {8, 7, 6, 5},
            {7, 3, 1, 6},
            {1, 1, 1, 7},
        };
        result = new int[mat.length][mat.length];
        int ans = 0;
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat.length; ++j) {
                if (result[i][j] == 0) {
                    result[i][j] = 1 + dfsHelper(mat, i, j);
                }
                out.print(result[i][j] + " ");
                ans = Math.max(ans, result[i][j]);
            }
            out.println();
        }
        out.println(ans);
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    private int dfsHelper(int[][] mat, int x, int y) {
        int sum1 = 0, sum2 = 0;
        if (x+1 < mat.length && Math.abs(mat[x][y] - mat[x+1][y]) == 1) {
            if (result[x+1][y] == 0) {
                result[x+1][y] = 1 + dfsHelper(mat, x+1, y);
            }
            sum1+= result[x+1][y];
        }
        if (y+1 < mat.length && Math.abs(mat[x][y] - mat[x][y+1]) == 1) {
            if (result[x][y+1] == 0) {
                result[x][y+1] = 1 + dfsHelper(mat, x, y+1);
            }
            sum2+= result[x][y+1];
        }
        return Math.max(sum1, sum2);
    }

    public static void main(String[] args) throws Exception {
        new find_maximum_length_snake_sequence().run();
    }


}