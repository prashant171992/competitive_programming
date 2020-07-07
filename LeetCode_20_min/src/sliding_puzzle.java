import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class sliding_puzzle {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {

        int[][] board = {{1,2,3}, {5, 4,0}};

        out.println(slidingPuzzle(board));
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new sliding_puzzle().run();
    }

    public int slidingPuzzle(int[][] board) {

        //updateVisitMap(board, map);

        return solve(board, new ArrayList<>(), 0);

    }

    private int solve(int[][] board, List<String> list, int count) {

        if (hasVisited(list, board)) {
            return Integer.MIN_VALUE;
        }
        if (canFinish(board)) return count;

        updateVisitMap(board, list);

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == 0) {

                    if (i == 0) {
                        int temp = board[i+1][j];
                        board[i][j] = temp;
                        board[i+1][j] = 0;
                        int ans = solve(board, list, count+1);
                        if (ans >= count) result = Math.min(ans, result);
                        board[i][j] = 0;
                        board[i+1][j] = temp;
                    }

                    if (i == 1) {
                        int temp = board[i-1][j];
                        board[i][j] = temp;
                        board[i-1][j] = 0;
                        int ans = solve(board, list, count+1);
                        if (ans >= count) result = Math.min(ans, result);
                        board[i][j] = 0;
                        board[i-1][j] = temp;
                    }

                    if (j-1>=0) {
                        int temp = board[i][j-1];
                        board[i][j] = temp;
                        board[i][j-1] = 0;
                        int ans = solve(board, list, count+1);
                        if (ans >= count) result = Math.min(ans, result);
                        board[i][j] = 0;
                        board[i][j-1] = temp;
                    }

                    if (j+1<board[i].length) {
                        int temp = board[i][j+1];
                        board[i][j] = temp;
                        board[i][j+1] = 0;
                        int ans = solve(board, list, count+1);
                        if (ans >= count) result = Math.min(ans, result);
                        board[i][j] = 0;
                        board[i][j+1] = temp;
                    }
                    break;
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;

    }

    private boolean hasVisited(List<String> list, int[][]board) {
        StringBuilder sb = getString(board);
        return list.contains(sb.toString());
    }

    private StringBuilder getString(int[][] board) {
        StringBuilder str = new StringBuilder();
        for (int[] ints : board) {
            for (int anInt : ints) {
                str.append(anInt).append(" ");
            }
        }
        return str;
    }

    private void updateVisitMap(int[][]board, List<String> list) {
        StringBuilder sb = getString(board);
        list.add(sb.toString());
    }

    private boolean canFinish(int[][] board) {
        return board[0][0] == 1
                && board[0][1] == 2
                && board[0][2] == 3
                && board[1][0] == 4
                && board[1][1] == 5
                && board[1][2] == 0;
    }


}