import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class leaf_similar_trees {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new leaf_similar_trees().run();
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == root2 && root1 == null) {
            return true;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root1);
        s2.push(root2);

        while(!s1.empty() && !s2.empty()) {
            if (dfsHelper(s1) != dfsHelper(s2)) {
                return false;
            }
        }

        return s1.empty() && s2.empty();

    }

    private int dfsHelper(Stack<TreeNode> s) {
        while(true) {
            TreeNode treeNode = s.pop();
            if (treeNode.right != null) s.push(treeNode.right);
            if (treeNode.left != null) s.push(treeNode.left);
            if (treeNode.left == null && treeNode.right == null) return treeNode.val;
        }
    }
}