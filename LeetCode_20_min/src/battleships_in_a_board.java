import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class battleships_in_a_board {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (i > 0 && board[i-1][j] == 'X') {
                    continue;
                }
                if (j > 0 && board[i][j-1] == 'X') {
                    continue;
                }
                count++;
            }
        }
        return count;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new battleships_in_a_board().run();
    }


}