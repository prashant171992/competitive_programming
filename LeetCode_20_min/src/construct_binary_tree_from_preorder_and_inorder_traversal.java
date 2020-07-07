import java.io.PrintWriter;

// 2019-01-15 

public class construct_binary_tree_from_preorder_and_inorder_traversal {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }




    public find_bottom_left_tree_value.TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public find_bottom_left_tree_value.TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        find_bottom_left_tree_value.TreeNode root = new find_bottom_left_tree_value.TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new construct_binary_tree_from_preorder_and_inorder_traversal().run();
    }


}