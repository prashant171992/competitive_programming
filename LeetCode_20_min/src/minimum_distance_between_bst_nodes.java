import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class minimum_distance_between_bst_nodes {
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
        new minimum_distance_between_bst_nodes().run();
    }

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int leftDiff = Integer.MAX_VALUE;
        int rightDiff = Integer.MAX_VALUE;

        if (root.left != null) {
            leftDiff = root.val - rightMost(root.left);
        }

        if (root.right != null) {
            rightDiff = leftMost(root.right) - root.val;
        }

        return Math.min(Math.min(leftDiff, rightDiff), Math.min(minDiffInBST(root.left), minDiffInBST(root.right)));
    }

    private int rightMost(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    private int leftMost(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}