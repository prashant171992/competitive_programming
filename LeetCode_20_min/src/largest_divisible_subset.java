import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class largest_divisible_subset {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(largestDivisibleSubset(new int[]{4, 8, 10, 240}));
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new largest_divisible_subset().run();
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>subset = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            subset.add(new ArrayList<>());
        }

        for (int i = 0; i< nums.length; ++i) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0) {
                    if (temp.size() < subset.get(j).size()) {
                        temp = subset.get(j);
                    }
                }
            }
            subset.get(i).addAll(temp);
            subset.get(i).add(nums[i]);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            if (subset.get(i).size() > result.size()) {
                result = subset.get(i);
            }
        }
        return result;
    }

}