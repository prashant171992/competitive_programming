import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class merge_k_sorted_lists {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {

        ListNode[] listNodes = new ListNode[3];
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(5);
        l1.next = l11;
        l11.next = l12;

        listNodes[0] = l1;

        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;

        listNodes[1] = l2;


        ListNode l3 = new ListNode(2);
        ListNode l31 = new ListNode(6);
        l3.next = l31;

        listNodes[2] = l3;

        mergeSortedLists(listNodes);

    }

    ListNode mergeSortedLists(ListNode[] lists) {

        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode point = head;
        while(!queue.isEmpty()) {
            point.next = queue.poll();
            point = point.next;
            ListNode next = point.next;
            if (next != null) {
                queue.add(next);
            }
        }
        return head.next;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new merge_k_sorted_lists().run();
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }


}