import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class lemonade_change {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0, tenCount = 0, twentyCount = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveCount++;
            }
            if (bill == 10) {
                tenCount++;
                if (fiveCount < 1) {
                    return false;
                } else {
                    fiveCount--;
                }
            }
            if (bill == 20) {
                twentyCount++;
                if (tenCount >= 1 && fiveCount >= 1) {
                    tenCount--;
                    fiveCount--;
                } else if (fiveCount >= 3) {
                    fiveCount-=3;
                } else {
                    return false;
                }
            }
        }
        return fiveCount >= 0 && tenCount >= 0 && twentyCount >= 0;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new lemonade_change().run();
    }


}