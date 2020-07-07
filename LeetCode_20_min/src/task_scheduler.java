import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class task_scheduler {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        char arr[] = {'A','A','B','B','C','C','D','D'};
        out.println(leastInterval(arr, 2));
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new task_scheduler().run();
    }

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(int i = 0; i < tasks.length; ++i) {
            freq[tasks[i]-'A']++;
        }

        if (n==0) return tasks.length;

        int ans = 0;
        Arrays.sort(freq);

        int i = 25;

        while(i>=0 && freq[i] == freq[25]) {
            i--;
        }

        return Math.max(tasks.length, freq[25] + n * (freq[25]-1) + 25-i-1);

    }

}