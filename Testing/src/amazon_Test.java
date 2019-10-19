import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class amazon_Test {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        String tiles = "ABA";
        out.println(numTilePossibilities(tiles));
    }

    Set<String> set = new LinkedHashSet();
    boolean[] vis;
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        vis = new boolean[n];
        dfs(new StringBuilder(), tiles);
        set.stream().forEach(element-> out.println(element));
        return set.size();
    }
    void dfs(StringBuilder sb, String tiles){
        if(sb.length()>0) set.add(sb.toString());
        if(sb.length()>=tiles.length()) return;
        for(int i=0;i<tiles.length();i++){
            if(vis[i]) continue;
            vis[i] = true;
            int len = sb.length();
            dfs(sb.append(tiles.charAt(i)), tiles);
            sb.setLength(len);
            vis[i] = false;
        }
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new amazon_Test().run();
    }


}