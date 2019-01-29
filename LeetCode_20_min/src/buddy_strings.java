import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class buddy_strings {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(buddyStrings("ab", "ba"));
    }

    public boolean buddyStrings(String A, String B) {

        int ans = 0;

        if (A.equals(B)) {
            Set<Character> s = new HashSet<Character>();
            for (char c : A.toCharArray()) s.add(c);
            return s.size() < A.length();
        }

        if (A.isEmpty() || B.isEmpty()) {
            return false;
        }

        if (A.length() != B.length()) {
            return false;
        }


        int count = 0;
        char AfirstDiffChar='\0';
        char AsecondDiffChar='\0';
        char BfirstDiffChar='\0';
        char BsecondDiffChar='\0';
        for (int i = 0; i < A.length(); ++i) {
            if (A.charAt(i) == B.charAt(i)){
                continue;
            } else if (A.charAt(i) != B.charAt(i)) {
                if (count == 0) {
                    AfirstDiffChar = A.charAt(i);
                    BfirstDiffChar = B.charAt(i);
                    count++;
                } else if (count == 1) {
                    AsecondDiffChar = A.charAt(i);
                    BsecondDiffChar = B.charAt(i);
                    count++;
                } else {
                    return false;
                }
            }
        }

        return AfirstDiffChar == BsecondDiffChar && AsecondDiffChar == BfirstDiffChar;

    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
    }

    public static void main(String[] args) throws Exception {
        new buddy_strings().run();
    }


}