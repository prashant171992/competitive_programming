import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class minimum_moves_to_equal_array_elements {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    public int minMoves(int[] nums) {
        int minNumber = Integer.MAX_VALUE;
        int result = 0;
        for (int i : nums) minNumber = Math.min(i, minNumber);
        for (int i : nums) result+= i - minNumber;
        return result;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new minimum_moves_to_equal_array_elements().run();
    }



}