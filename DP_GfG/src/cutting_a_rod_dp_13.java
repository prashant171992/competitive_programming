import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class cutting_a_rod_dp_13 {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(calcBestPrice(new int[]{3, 5, 8, 9, 10, 17, 17, 20}));
    }

    private int calcBestPrice(int[] price) {

        int [] best_price = new int[price.length];

        best_price[0] = price[0];

        for (int i = 1; i < price.length; ++i) {
            best_price[i] = price[i];
            for (int j = 0; j < i; ++j) {
                best_price[i] = Math.max(best_price[i], best_price[j] + best_price[i-j-1]);
            }
        }

        return best_price[price.length-1];
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new cutting_a_rod_dp_13().run();
    }


}