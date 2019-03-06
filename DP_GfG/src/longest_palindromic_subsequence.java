import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 


// https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/

public class longest_palindromic_subsequence {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(calcLongestPalindromicSubsequence("GEEKSFORGEEKS"));
    }

    private int calcLongestPalindromicSubsequence(String s) {
        int [][] L = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); ++i) {
            L[i][i] = 1;
        }

        for (int gap = 2; gap <= s.length(); ++gap) {
            for (int i = 0; i < s.length() - gap + 1; ++i) {
                int j = i + gap - 1;
                if (s.charAt(i) == s.charAt(j) && gap == 2) {
                    L[i][j] = 2;
                } else if (s.charAt(i) == s.charAt(j)) {
                    L[i][j] = 2 + L[i+1][j-1];
                } else {
                    L[i][j] = Math.max(L[i+1][j], L[i][j-1]);
                }
            }
        }
        return L[0][s.length()-1];
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new longest_palindromic_subsequence().run();
    }


}