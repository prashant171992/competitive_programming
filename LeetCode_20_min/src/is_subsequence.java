import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class is_subsequence {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    public boolean isSubsequence(String s, String t) {
        int last = -1;
        for (int i = 0 ; i < s.length(); ++i) {
            boolean found = false;
            for (int j = last+1; j < t.length(); ++j) {
                if (s.charAt(i) == t.charAt(j)) {
                    found = true;
                    last = j;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new is_subsequence().run();
    }


}