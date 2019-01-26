import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class unique_email_addresses {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> result = new HashSet<>();

        for (String s : emails) {
            String correctEmail = "";
            boolean toIgnore = false;
            boolean domainStart = false;
            for (Character c : s.toCharArray()) {
                if (domainStart) {
                    correctEmail += c;
                    continue;
                }
                if (toIgnore) {
                    if (c=='@') {
                        toIgnore = false;
                    }
                } else if (c == '+'){
                    toIgnore = true;
                } else if (c != '.') {
                    correctEmail += c;
                }
                if (c=='@') {
                    domainStart = true;
                }
            }
            result.add(correctEmail);
        }
        return result.size();

    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new unique_email_addresses().run();
    }


}