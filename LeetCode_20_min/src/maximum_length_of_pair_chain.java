import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class maximum_length_of_pair_chain {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        int[][] input = {{3,4}, {2,3}, {1,2}};
        out.println(findLongestChain(input));
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new maximum_length_of_pair_chain().run();
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(ints -> ints[1]));

        int ans = 0;

        for (int i = 0; i < pairs.length; ++i) {
            int last = pairs[i][1];
            int temp = 1;
            for (int j = i+1; j < pairs.length; ++j) {
                if (pairs[j][0] > last) {
                    last = pairs[j][1];
                    temp++;
                }
            }
            ans = Math.max(temp, ans);
        }
        return ans;
    }


}