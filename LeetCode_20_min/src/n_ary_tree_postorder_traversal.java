import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class n_ary_tree_postorder_traversal {
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

    public List<Integer> postorder(Node root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node n = stack.pop();
            ans.add(n.val);
            for (int i = 0; i< n.children.size(); ++i) {
                stack.push(n.children.get(i));
            }
        }

        Collections.reverse(ans);
        return ans;

    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new n_ary_tree_postorder_traversal().run();
    }


}