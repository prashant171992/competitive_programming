import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class longest_absolute_file_path {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new longest_absolute_file_path().run();
    }

    public int lengthLongestPath(String input) {
        String[] inputArray = input.split("\n");

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(inputArray[0].length());

        int maxLen = 0;

        for(int i = 0; i < inputArray.length; ++i) {
            int level = inputArray[i].lastIndexOf('\t') + 1;
            int prevLength = 0;
            while(level < stack.size()) stack.pop();
            if (stack.size() > 0) {
                prevLength = stack.peek() + 1;
            }
            int currLen = prevLength + (inputArray[i].length() - level);
            stack.push(currLen);
            if (inputArray[i].indexOf('.', 0) != -1) {
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }


}