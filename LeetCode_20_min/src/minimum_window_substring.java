import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class minimum_window_substring {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(minWindow("ABXCBAC", "ABC"));
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

//    public String minWindow(String s, String t) {
//        Map<Character, Integer> tFreqMap = new HashMap<>();
//        Map<Character, Integer> sFreqMap = new HashMap<>();
//
//        for (Character ch : t.toCharArray()) {
//            tFreqMap.merge(ch, 1, (v1,v2) -> v1 + v2);
//        }
//
//        int front = 0;
//        int end = 0;
//
//        String result = "";
//
//        while (front < s.length() && end <= s.length()) {
//            if (foundAllElements(tFreqMap, sFreqMap)) {
//                String tempAns = s.substring(front, end);
//                if (result.length() == 0 || result.length() > tempAns.length()) {
//                    result = tempAns;
//                }
//                sFreqMap.merge(s.charAt(front), -1, (v1, v2) -> v1+v2);
//                front++;
//            } else if (end < s.length()) {
//                sFreqMap.merge(s.charAt(end), 1, (v1,v2) -> v1 + v2);
//                end++;
//            } else {
//                end++;
//            }
//        }
//
//        return result;
//    }

    private boolean foundAllElements(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        for (Character ch : m1.keySet()) {
            if (m2.get(ch) == null || m2.get(ch) < m1.get(ch)) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char e : t.toCharArray()) {
            freqMap.merge(e, 1, (v1, v2) -> v1+v2);
        }

        int counter = t.length();

        int begin = 0, end = 0, ans = Integer.MAX_VALUE;
        String result = "";

        while (end < s.length()) {

            Integer freq = freqMap.get(s.charAt(end));
            if (freq != null && freq > 0) {
                counter--;
            }

            freqMap.merge(s.charAt(end), -1, (v1, v2) -> v1+v2);

            end++;

            while (counter == 0) {
                if (ans > (end - begin)) {
                    ans = end - begin;
                    result = s.substring(begin, end);
                }
                freqMap.merge(s.charAt(begin), 1, (v1, v2) -> v1+v2);

                /*
                    this is for ensuring elements on t if they're removed from beginning we reset counter.
                    for elements which don't appear in t, the freqMap already has negative value and it won't affect the counter
                 */

                if (freqMap.get(s.charAt(begin)) > 0)
                    counter++;
                begin++;
            }
        }

        return result;

    }

    public static void main(String[] args) throws Exception {
        new minimum_window_substring().run();
    }


}