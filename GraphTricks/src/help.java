import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class help {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1,1,0,0));
        list.add(Arrays.asList(0,0,1,0));
        list.add(Arrays.asList(0,0,0,0));
        list.add(Arrays.asList(1,0,1,1));
        list.add(Arrays.asList(1,1,1,1));

        out.print(solve(5, 4, list));
    }

    int solve(int rows, int column, List<List<Integer>> grid) {

        int matrix[][] = transform(rows, column, grid);

        return countIslands(matrix, rows, column);

    }

    int[][] transform(int r, int c, List<List<Integer>> list) {
        int arr[][] = new int[r][c];
        for (int i = 0; i < list.size(); ++i) {
            for (int j = 0; j < list.get(i).size(); ++j) {
                arr[i][j] = list.get(i).get(j);
            }
        }
        return arr;
    }

    void DFS(int M[][], int row, int col, boolean visited[][], int ROW, int COL)
    {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int rowNbr[] = new int[] { -1, 0, 0, 1 };
        int colNbr[] = new int[] {  0, -1, 1, 0 };

        visited[row][col] = true;

        for (int k = 0; k < 4; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited, ROW, COL))
                DFS(M, row + rowNbr[k], col + colNbr[k], visited, ROW, COL);
    }

    private int countIslands(int M[][], int r, int c) {
        // Make a bool array to mark visited cells.
        boolean [][]visited = new boolean[r][c];

        // Initialize count as 0 and travese through the all cells
        // of given matrix
        int count = 0;
        for (int i = 0; i < r; ++i)
            for (int j = 0; j < c; ++j)
                if (M[i][j] == 1 && !visited[i][j]) // If a cell with
                { // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    DFS(M, i, j, visited, r, c);
                    ++count;
                }

        return count;
    }



    boolean isSafe(int M[][], int row, int col,
                   boolean visited[][], int ROW, int COL) {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]);
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new help().run();
    }


}