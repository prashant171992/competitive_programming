import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class unique_paths_iii {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(uniquePathsIII(new int[][]{{1,0,0,0}, {0, 0, 0, 0}, {0, 0, 2, -1}}));
    }

    int res = 0;
    int empty = 1;
    int dx=0, dy=0;

    public int uniquePathsIII(int[][] grid) {

        int sx = 0, sy= 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 0) {
                    empty++;
                } else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 2) {
                    dx = i;
                    dy = j;
                }
            }
        }

        dfsHelper(grid, sx, sy);
        return res;

    }

    public void dfsHelper(int [][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] < 0) {
            return;
        }

        if (x == dx && y == dy && empty == 0) {
            res++;
            return;
        }
        grid[x][y] = -2;
        empty--;
        dfsHelper(grid, x+1, y);
        dfsHelper(grid, x-1, y);
        dfsHelper(grid, x, y+1);
        dfsHelper(grid, x, y-1);
        grid[x][y] = 0;
        empty++;

    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new unique_paths_iii().run();
    }


}