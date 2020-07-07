import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class first_missing_positive {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = nums.length+1;
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            int temp = Math.abs(nums[i]);
            if (temp < nums.length) {
                temp--;
                if (nums[temp] > 0) {
                    nums[temp] *= -1;
                }
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] >= 0) return i+1;
        }

        return nums.length+1;

    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new first_missing_positive().run();
    }


}