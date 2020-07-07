import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class minimum_size_subarray_sum {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new minimum_size_subarray_sum().run();
    }

    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        while(right <= nums.length && left <= right) {
            if (sum < s) {
                if (right < nums.length)
                    sum+=nums[right];
                right++;
            } else {
                sum-=nums[left];
                left++;
            }
            if (sum >= s) {
                ans = Math.min(ans, right-left);
            }
        }

        return ans != Integer.MAX_VALUE ? ans : 0;
    }


}