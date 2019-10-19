import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class minimum_path_sum {
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
        new minimum_path_sum().run();
    }

    public int minPathSum(int[][] grid) {

        for (int i = 1; i < grid[0].length; ++i) {
            grid[0][i] += grid[0][i-1];
        }

        for (int i = 1; i < grid.length; ++i) {
            grid[i][0] += grid[i-1][0];
        }

        for (int i = 1; i < grid.length; ++i) {
            for (int j = 1; j < grid[i].length; ++j) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];

    }

}