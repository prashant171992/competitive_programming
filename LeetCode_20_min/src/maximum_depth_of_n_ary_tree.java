import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class maximum_depth_of_n_ary_tree {
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

    public static void main(String[] args) throws Exception {
        new maximum_depth_of_n_ary_tree().run();
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Solution {
        public int maxDepth(Node root) {
            if (root == null) return 0;
            int maxDepthChildren = 0;
            for (Node node : root.children) {
                maxDepthChildren = Math.max(maxDepth(node), maxDepthChildren);
            }
            return 1 + maxDepthChildren;
        }
    }


}