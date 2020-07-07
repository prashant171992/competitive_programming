import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class longest_consecutive_sequence {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, true);
        }

        Map<Integer, Integer> childCount = new HashMap<>();
        int answer = 0;
        Map<Integer, Integer> parent = new HashMap<>();
        for (int i : nums) {
            Integer temp = find(i, map, parent);
            childCount.merge(temp, 1, (v1,v2) -> v1+v2);
            answer = Math.max(childCount.get(temp), answer);
        }
        return answer;
    }

    private Integer find(int i, Map<Integer, Boolean> map, Map<Integer, Integer> parentMap) {
        Integer parent = i-1;
        while (map.getOrDefault(parent, false)) {
            int temp = parent;
            if (parentMap.get(temp) != null) {
                parent = parentMap.get(temp);
            } else {
                parent = find(temp, map, parentMap);
                parentMap.put(temp, parent);
            }
        }
        parentMap.put(i, parent);
        return parent;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new longest_consecutive_sequence().run();
    }


}