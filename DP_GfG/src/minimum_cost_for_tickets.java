import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class minimum_cost_for_tickets {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    public int mincostTickets(int[] days, int[] costs) {

        Queue<Pair<Integer, Integer>> queue7 = new LinkedList<>();
        Queue<Pair<Integer, Integer>> queue30 = new LinkedList<>();

        int cost = 0;

        for (int d : days) {
            while(!queue7.isEmpty() && queue7.peek().getKey() + 7 <= d) queue7.poll();
            while(!queue30.isEmpty() && queue30.peek().getKey() + 30 <= d) queue30.poll();
            queue7.add(new Pair<>(d, cost + costs[1]));
            queue30.add(new Pair<>(d, cost + costs[2]));
            cost = Math.min(cost + costs[0], Math.min(
                    queue7.peek().getValue(), queue30.peek().getValue()));
        }
        return cost;


    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new minimum_cost_for_tickets().run();
    }


}