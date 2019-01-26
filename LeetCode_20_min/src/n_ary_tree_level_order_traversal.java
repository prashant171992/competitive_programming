import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class n_ary_tree_level_order_traversal {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
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

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new n_ary_tree_level_order_traversal().run();
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) return list;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Node> l = new ArrayList<>();
            List<Integer> li = new ArrayList<>();
            while(!queue.isEmpty()) {
                Node n = queue.poll();
                l.add(n);
                li.add(n.val);
            }
            for(Node n : l) {
                for (Node c : n.children) {
                    queue.add(c);
                }
            }
            list.add(li);
        }

        return list;

    }


}