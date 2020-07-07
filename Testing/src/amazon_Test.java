import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class amazon_Test {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(searchRange(new int[]{5,7,7,8,8,10}, 8));
    }

    public int[] searchRange(int[] nums, int target) {
        int pos = binarySearch(nums, 0, nums.length-1, target);
        if (pos == -1) return new int[] {-1,-1};
        if (pos+1 < nums.length && nums[pos+1] == target) {
            return new int[] {pos,pos+1};
        }
        if (pos-1 >=0 && nums[pos-1] == target) {
            return new int[] {pos-1,pos};
        }
        return new int[] {pos,pos};
    }

    private int binarySearch(int [] nums, int l, int r, int target) {
        if (l <= r && l >=0 && l < nums.length
                && r >= 0 && r < nums.length) {
            if (nums[l] == target) return l;
            if (nums[r] == target) return r;
            int mid = l + (r-l)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                return binarySearch(nums,mid+1, r, target);
            } else {
                return binarySearch(nums,l, mid-1, target);
            }
        }
        return -1;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new amazon_Test().run();
    }


}