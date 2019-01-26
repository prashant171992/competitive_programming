import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class jewels_and_stones {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

    public int numJewelsInStones(String J, String S) {
        Map<Character, Boolean> map = new HashMap<>();
        for (Character c : J.toCharArray()) {
            map.put(c, Boolean.TRUE);
        }
        int result=0;
        for (Character c : S.toCharArray()) {
            if (map.get(c) == null || !map.get(c)) {
                continue;
            }
            result++;
        }

        return result;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new jewels_and_stones().run();
    }


}