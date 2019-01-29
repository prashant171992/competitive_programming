import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class non_decreasing_array {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    public boolean checkPossibility(int[] nums) {
        int negCount = 0;
        for (int i = 1; i < nums.length && negCount <= 1; ++i) {
            if (nums[i] < nums[i-1]) {
                negCount++;
                if (i-2<0 || nums[i-2] <= nums[i]) {
                    nums[i-1] = nums[i];
                } else {
                    nums[i] = nums[i-1];
                }
            }
        }
        return negCount <= 1;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new non_decreasing_array().run();
    }


}