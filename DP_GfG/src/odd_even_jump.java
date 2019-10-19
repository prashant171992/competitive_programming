import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class odd_even_jump {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(oddEvenJumps(new int[]{2,3,1,1,4}));
    }

    public int oddEvenJumps(int[] A) {

        int result = 0;
        boolean dp[][] = new boolean[A.length][2];
        dp[A.length-1][0] = true;
        dp[A.length-1][1] = true;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(A[A.length-1], A.length-1);
        result = 1; // since last index already reached

        for (int i = A.length-2; i >= 0; i --) {
            // for odd jump
            Integer smallestGreaterThanCurrent = treeMap.ceilingKey(A[i]);
            dp[i][0] = smallestGreaterThanCurrent != null && dp[treeMap.get(smallestGreaterThanCurrent)][1];

            // for even jump
            Integer greatestNumberSmallerThanCurrent = treeMap.floorKey(A[i]);
            dp[i][1] = greatestNumberSmallerThanCurrent != null && dp[treeMap.get(greatestNumberSmallerThanCurrent)][0];

            result += dp[i][0] ? 1 : 0;
        }

        return result;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new odd_even_jump().run();
    }


}