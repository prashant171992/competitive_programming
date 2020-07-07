import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class test_union_find {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    class Data {
        int id;
        String type;
        int groupId;
    }

    class Node {
        String data;
        int rank;
        Node parent;
    }

    Node findParent(Node n) {
        if (n.parent != n) {
            n.parent = findParent(n.parent);
        }
        return n.parent;
    }

    void unionNodes(Node a, Node b) {
        Node pa = findParent(a);
        Node pb = findParent(b);
        if (pa == pb) return;
        if (pa.rank > pb.rank) {
            pb.parent = pa;
        } else if (pb.rank > pa.rank) {
            pa.parent = pb;
        } else {
            pa.parent = pb;
            pb.rank++;
        }
    }



    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new test_union_find().run();
    }


}