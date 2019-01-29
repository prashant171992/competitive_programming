import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class flood_fill {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int col[] = {0, 1, 0, -1};

    void solve() {
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new flood_fill().run();
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int prevColor = image[sr][sc];
        if (prevColor == newColor) {
            return image;
        }
        image[sr][sc] = newColor;
        return floodFillHelper(image,sr,sc,newColor, prevColor);
    }

    private int[][] floodFillHelper(int[][] image, int sr, int sc, int newColor, int prevColor) {
        for (int i = 0; i < 4; ++i) {
            int x = sr + row[i];
            int y = sc + col[i];
            if (x >= 0 && y >= 0 && x < image.length && y < image[x].length && image[x][y] == prevColor) {
                image[x][y] = newColor;
                image = floodFillHelper(image, x, y, newColor, prevColor);
            }
        }
        return image;
    }

}