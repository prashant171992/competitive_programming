import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class robot_return_to_origin {
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

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < moves.length(); ++i) {
            char c = moves.charAt(i);
            if (c == 'R') {
                x++;
            }
            if (c == 'L') {
                x--;
            }
            if (c == 'U') {
                y++;
            }
            if (c == 'D') {
                y--;
            }

        }

        return x == 0 && y==0;
    }

    public static void main(String[] args) throws Exception {
        new robot_return_to_origin().run();
    }


}