import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class three_sum_closest {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(threeSumClosest(new int[]{-1,1,2,-4}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; ++i) {
            int l = i+1;
            int r = nums.length-1;
            while (l < r ) {
                int sum = nums[l]+nums[r]+nums[i];
                if (sum < target) {
                    if (minDiff > target-sum) {
                        minDiff = target-sum;
                        ans = sum;
                    }
                    l++;
                } else if (sum > target) {
                    if (minDiff > sum-target) {
                        minDiff = sum-target;
                        ans = sum;
                    }
                    r--;
                } else {
                    return target;
                }
            }
        }
        return ans;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new three_sum_closest().run();
    }


}