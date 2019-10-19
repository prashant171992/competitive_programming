import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class testCodeWhilePractice {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {

        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);


        treeNode5.left = treeNode3;
        treeNode5.right = treeNode6;

        treeNode3.left = treeNode2;
        treeNode3.right = treeNode4;

        treeNode2.left = treeNode1;

        treeNode6.right = treeNode8;

        treeNode8.left = treeNode7;
        treeNode8.right = treeNode9;

        TreeNode treeNode = increasingBST(treeNode5);

        while (treeNode != null) {
            out.print(treeNode.val + " ");
            treeNode = treeNode.right;
        }
    }

    boolean visited[][];

    int dr[] = {0, 0, 1, -1};
    int dc[] = {1, -1, 0, 0};



    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new testCodeWhilePractice().run();
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode result;
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        if (root.left != null) {
            result = increasingBST(root.left);
            root.left = null;
            result.right = increasingBST(root);
        } else {
            result = root;
            result.right = increasingBST(root.right);
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int x) {
            val = x;
        }
    }

}