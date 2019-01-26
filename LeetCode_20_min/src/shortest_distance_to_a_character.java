import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class shortest_distance_to_a_character {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    public int[] shortestToChar(String S, char C) {
        int lastSeen = 100004;
        int[] ans = new int[S.length()];
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i)==C) {
                lastSeen = i;
            }
            ans[i] = Math.abs(lastSeen - i);
        }

        lastSeen = 100004;

        for (int i = S.length()-1; i >= 0; --i) {
            if (S.charAt(i)==C) {
                lastSeen = i;
            }
            ans[i] = Math.min(ans[i], Math.abs(lastSeen - i));
        }

        return ans;

    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new shortest_distance_to_a_character().run();
    }


}