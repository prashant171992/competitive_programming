import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class help_1 {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(0,1,1,0,1));
        list.add(Arrays.asList(0,1,0,1,0));
        list.add(Arrays.asList(0,0,0,0,1));
        list.add(Arrays.asList(0,1,0,0,0));

        out.print(solve(4, 5, list));
    }

    int solve(int rows, int columns, List<List<Integer>> grid) {
        int matrix[][] = transform(rows, columns, grid);
        int counter = 1;
        while (true) {
            sendFiles(counter, matrix);
            if (shouldBreak(matrix)) return counter;
            else counter++;
        }
    }

    boolean shouldBreak(int [][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) return false;
            }
        }
        return true;
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

    void sendFiles(int counter, int[][] matrix) {

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == counter) {
                    for (int k = 0; k < 4; ++k) {
                        int nr = i + row[k];
                        int nc = j + column[k];
                        if (nr >= 0 && nr < matrix.length && nc >=0 && nc < matrix[0].length && matrix[nr][nc] != counter) {
                            matrix[nr][nc] = counter+1;
                        }
                    }
                }
            }
        }

    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new help_1().run();
    }


}