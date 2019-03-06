import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class count_palindrome_sub_strings_string {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    private int countPS(char str[], int n)
    {
        // creat empty 2-D matrix that counts all palindrome
        // substring. dp[i][j] stores counts of palindromic
        // substrings in st[i..j]
        int dp[][] = new int[n][n];

        // P[i][j] = true if substring str[i..j] is palindrome,
        // else false
        boolean P[][] = new boolean[n][n];

        // palindrome of single lenght
        for (int i= 0; i< n; i++)
            P[i][i] = true;

        // palindrome of length 2
        for (int i=0; i<n-1; i++)
        {
            if (str[i] == str[i+1])
            {
                P[i][i+1] = true;
                dp[i][i+1] = 1 ;
            }
        }

        // Palindromes of length more then 2. This loop is similar
        // to Matrix Chain Multiplication. We start with a gap of
        // length 2 and fill DP table in a way that gap between
        // starting and ending indexes increases one by one by
        // outer loop.
        for (int gap=2 ; gap<n; gap++)
        {
            // Pick starting point for current gap
            for (int i=0; i<n-gap; i++)
            {
                // Set ending point
                int j = gap + i;

                // If current string is palindrome
                if (str[i] == str[j] && P[i+1][j-1] )
                    P[i][j] = true;

                // Add current palindrome substring ( + 1)
                // and rest palinrome substring (dp[i][j-1] + dp[i+1][j])
                // remove common palinrome substrings (- dp[i+1][j-1])
                if (P[i][j])
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1 - dp[i+1][j-1];
                else
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
            }
        }

        // return total palindromic substrings
        return dp[0][n-1];
    }

    public static void main(String[] args) throws Exception {
        new count_palindrome_sub_strings_string().run();
    }


}