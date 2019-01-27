import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class k_diff_pairs_in_an_array {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(findPairs(new int[]{1,1,1,2,1}, 1));
    }

    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int result = 0;
        if (k < 0) {
            return result;
        }
        for (int i : nums) {
            Integer val = map.get(i);
            if (val == null) {
                val = 0;
            }
            val++;
            map.put(i,val);
        }

        for (int i : nums) {
            if (k == 0) {
                if (map.get(i) != null && map.get(i) > 1) {
                    result++;
                }
                map.put(i, null);
                continue;
            }
            if (map.get(i) != null && map.get(i-k) != null) {
                result++;
            }
            if (map.get(i) != null && map.get(i+k) != null) {
                result++;
            }
            map.put(i, null);
        }

        return result;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new k_diff_pairs_in_an_array().run();
    }


}