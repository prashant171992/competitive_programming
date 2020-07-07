import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class longest_substring_with_at_most_two_distinct_characters {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(lengthOfLongestSubstringTwoDistinct("abcabcabc"));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int counter = 0, begin = 0, end = 0, result = Integer.MIN_VALUE;

        while (end < s.length()) {
            if (map.get(s.charAt(end)) == null || map.get(s.charAt(end)) == 0) {
                counter++;
            }
            map.merge(s.charAt(end), 1, (v1,v2) -> v1+v2);
            while (counter > 2) {
                map.merge(s.charAt(begin), -1, (v1,v2) -> v1+v2);
                if (map.get(s.charAt(begin)) == 0) counter--;
                begin++;
            }
            end++;
            result = Math.max(result, end-begin);

        }
        return result;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new longest_substring_with_at_most_two_distinct_characters().run();
    }


}