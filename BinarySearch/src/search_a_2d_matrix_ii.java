import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class search_a_2d_matrix_ii {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {

        int [][] matrix = {{-1,3}};
        out.println(searchMatrix(matrix, 3));
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new search_a_2d_matrix_ii().run();
    }


    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) return false;

        int r = 0;
        int c = matrix[0].length-1;



        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) return true;
            if (target > matrix[r][c]) r++;
            else c--;
        }

        return false;
    }


}