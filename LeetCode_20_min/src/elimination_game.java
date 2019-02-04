import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class elimination_game {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int head = 1;
        int step = 1;
        while(remaining > 1) {
            if (remaining % 2 == 1 || left) {
                head = head + step;
            }
            step*=2;
            remaining/=2;
            left = !left;
        }

        return head;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new elimination_game().run();
    }


}