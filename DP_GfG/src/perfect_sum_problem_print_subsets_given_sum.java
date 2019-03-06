import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class perfect_sum_problem_print_subsets_given_sum {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    boolean dp[][];


    void solve() {
        printAllSubsetWithSum(new int[]{1,2,3,4}, 5);
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new perfect_sum_problem_print_subsets_given_sum().run();
    }

    void printList(ArrayList<Integer> list) {
        list.forEach(i -> out.print(i + " "));
        out.println();
    }

    void printHelper(int[] array, int sum, int index, ArrayList<Integer> list) {
        if (index == 0 && sum != 0 && dp[index][sum]) {
            list.add(array[index]);
            printList(list);
            list.clear();
            return;
        }

        if (index == 0 && sum == 0) {
            printList(list);
            list.clear();
            return;
        }

        if (dp[index-1][sum]) {
            printHelper(array, sum, index-1, list);
        }

        if (sum >= array[index]) {
            if (dp[index-1][sum-array[index]]) {
                list.add(array[index]);
                printHelper(array, sum-array[index], index-1, list);
            }
        }
    }

    void printAllSubsetWithSum(int [] array, int sum) {
        dp = new boolean[array.length][sum+1];
        for (int i = 0; i < array.length; ++i) {
            dp[i][0] = true;
        }

        if (array[0] <= sum)
            dp[0][array[0]] = true;

        for (int i = 1; i < array.length; ++i) {
            for (int j = 0; j <= sum; ++j) {
                dp[i][j] = j >= array[i] ? dp[i-1][j] || dp[i-1][j - array[i]] : dp[i-1][j];
            }
        }

        if (!dp[array.length-1][sum]) {
            return;
        }

        printHelper(array, sum, array.length-1, new ArrayList<>());
    }

}