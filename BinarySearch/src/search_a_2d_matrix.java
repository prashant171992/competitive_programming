import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class search_a_2d_matrix {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        int arr[][] = {{1}};
        out.println(searchMatrix(arr, 1));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) return false;

        int rowCounter = 0;

        while (rowCounter < matrix.length) {
            int l = 0;
            int r = matrix[rowCounter].length-1;
            if (r >= 0 && target >= matrix[rowCounter][l] && target <= matrix[rowCounter][r]) {
                while (l <= r) {
                    int mid = (l+r)/2;
                    if (matrix[rowCounter][l] == target || matrix[rowCounter][r] == target || matrix[rowCounter][mid] == target) {
                        return true;
                    }
                    if (matrix[rowCounter][mid] > target) {
                        r = mid-1;
                    } else {
                        l = mid+1;
                    }
                }
                return false;
            } else {
                rowCounter++;
            }
        }
        return false;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new search_a_2d_matrix().run();
    }


}