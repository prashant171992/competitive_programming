import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class maximal_rectangle {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

//    void solve() {
//        out.println(maximalRectangle(new int[][]{""}));
//    }


//    public int maximalRectangle(char[][] matrix) {
//        int l = 0, r = 0, ans = 0;
//        while (l < matrix[0].length) {
//            r = l;
//            int tempSum[] = new int[matrix.length];
//            while (r < matrix[0].length) {
//                for (int i = 0; i < matrix.length; ++i) {
//                    if(matrix[i][r] == 0) {
//                        tempSum[i] = 0;
//                    } else {
//                        tempSum[i]+= matrix[i][r];
//                    }
//                }
//
//                int sum = tempSum[0];
//                ans = Math.max(ans, sum);
//
//                for (int i = 1; i < matrix.length; ++i) {
//                    if (tempSum[i] == tempSum[i-1]) {
//                        sum+=tempSum[i];
//                    } else {
//                        sum = tempSum[i];
//                    }
//                    ans = Math.max(ans, sum);
//                }
//
//                r++;
//            }
//            l++;
//
//        }
//        return ans;
//
//
//    }

    void run() {
        out = new PrintWriter(System.out);
        //solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new maximal_rectangle().run();
    }


}