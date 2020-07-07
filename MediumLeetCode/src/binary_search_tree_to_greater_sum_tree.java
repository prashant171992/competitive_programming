import java.io.PrintWriter;

// 2019-11-06

public class binary_search_tree_to_greater_sum_tree {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {

        TreeNode fN = new TreeNode(4);
        TreeNode fLn = new TreeNode(1);
        TreeNode fLLn = new TreeNode(0);
        TreeNode fLRn = new TreeNode(2);
        TreeNode fLRRn = new TreeNode(3);
        TreeNode fRn = new TreeNode(6);
        TreeNode fRLn = new TreeNode(5);
        TreeNode fRRn = new TreeNode(7);
        TreeNode fRRRn = new TreeNode(8);

        fRRn.right = fRRRn;
        fRn.right = fRRn;
        fRn.left = fRLn;

        fLn.left = fLLn;
        fLn.right = fLRn;
        fLRn.right = fLRRn;

        fN.left = fLn;
        fN.right = fRn;

        out.println(bstToGst(fN).val);

    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new binary_search_tree_to_greater_sum_tree().run();
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    private int accumulatedVal = 0;
    private TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            root.right = bstToGst(root.right);
            root.val += accumulatedVal;
            accumulatedVal = root.val;
            root.left = bstToGst(root.left);
        }
        return root;
    }


}