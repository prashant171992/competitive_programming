import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class construct_binary_tree_from_postorder_and_inorder_traversal {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(buildTree(new int[]{3,2,1}, new int[]{3,2,1}));
    }

    public find_bottom_left_tree_value.TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
        return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private find_bottom_left_tree_value.TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe){
        if (ps>pe || is>ie) return null;
        find_bottom_left_tree_value.TreeNode root = new find_bottom_left_tree_value.TreeNode(postorder[pe]);
        int ri = 0;
        for (int i = is; i <= ie; ++i)
            if (inorder[i] == postorder[pe])
                ri = i;
        int leftlen =  ri-1-is, rightlen = ie-(ri+1);
        find_bottom_left_tree_value.TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+leftlen);
        find_bottom_left_tree_value.TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, pe-1-rightlen, pe-1);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new construct_binary_tree_from_postorder_and_inorder_traversal().run();
    }


}