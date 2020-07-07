import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class backspace_string_compare {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(backspaceCompare("ab##", "c#d#"));
    }

    public boolean backspaceCompare(String S, String T) {
        int bS = S.length()-1;
        int bT = T.length()-1;

        while (bS >= 0 && bT >= 0) {
            char s = S.charAt(bS);
            char t = T.charAt(bT);
            if (s != '#' && t != '#') {
                if (s != t) {
                    return false;
                }
                bS--;
                bT--;
                continue;
            }

            if (s == '#') {
                int count = 0;
                for (int i = bS; i >= 0; --i) {
                    if (S.charAt(i) == '#') count++;
                    else count--;
                    if (count == 0) {
                        bS = i;
                        break;
                    }
                }
                bS--;
            }
            if (t == '#') {
                int count = 0;
                for (int i = bT; i >= 0; --i) {
                    if (T.charAt(i) == '#') count++;
                    else count--;
                    if (count == 0) {
                        bT = i;
                        break;
                    }
                }
                bT--;
            }
        }
        return bS < 0 && bT < 0;

    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new backspace_string_compare().run();
    }


}