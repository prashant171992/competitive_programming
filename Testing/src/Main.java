import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Enter string list size");
//        Scanner sc = new Scanner(System.in);
//        Integer stringListSize = sc.nextInt();
//        sc.nextLine();
//        Map<String, Integer> freqMap = new HashMap<>();
//        for (int i = 0; i < stringListSize; ++i) {
//            String input = sc.nextLine();
//            Integer freq = freqMap.get(input);
//            if (freq == null) {
//                freqMap.put(input, 1);
//            } else {
//                freqMap.put(input, freq + 1);
//            }
//        }
//        System.out.println("Frequency of unique words in the list : ");
//        for (String key : freqMap.keySet()) {
//            System.out.println(key + " " + String.valueOf(freqMap.get(key)));
//        }

        Node node = new Node(1);
        LinkedList linkedList = new LinkedList(node);
        linkedList.addNode(new Node(2));
        linkedList.addNode(new Node(3));
        linkedList.printLinkedList();
        lengthOfLongestSubstring("tmmzuxt");

        longestPalindrome("abacab");
    }

    public boolean isMatch(String s, String p) {
        return false;
    }


    public static String longestPalindrome(String s) {
        boolean table[][] = new boolean[s.length()][s.length()];

        int longestLength = 0;
        for (int i = 0; i < s.length(); ++i) {
            table[i][i] = true;
            longestLength = 1;
        }


        int startIndex = 0;

        // setting up the table for length 2
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) == s.charAt(i+1)) {
                table[i][i+1] = true;
                longestLength = 2;
                startIndex = i;
            }
        }

        for (int l = 3; l <= s.length(); ++l) {
            for (int i = 0; i+l <= s.length(); ++i) {
                if (table[i+1][i+l-2] && s.charAt(i) == s.charAt(i+l-1)) {
                    if (longestLength <= l) {
                        longestLength = l;
                        startIndex = i;
                        table[i][i+l-1] = true;
                    }
                }
            }
        }
        return s.substring(startIndex, startIndex+longestLength);
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int result = 0, j = 0;
        if (s.isEmpty()) return 0;
        for (int i = 0; i < s.length(); ++i) {
            Integer prevOccur = map.get(s.charAt(i));
            if (prevOccur == null) {
                map.put(s.charAt(i), i);
                j++;
            } else {
                result = Math.max(result, j);
                if (i - prevOccur <= j)
                j = i - map.get(s.charAt(i));
                else
                    j++;
                map.put(s.charAt(i), i);
            }
        }
        return Math.max(result, j);
    }
}



class LinkedList {
    Node headNode;

    LinkedList(Node node) {
        this.headNode = node;
    }

    void addNode(Node node) {
        Node iterNode = headNode;
        while (iterNode.nextNode != null) {
            iterNode = iterNode.nextNode;
        }
        iterNode.nextNode = node;
    }

    void removeNode(int value) {
        if (headNode.value == value) {
            headNode = headNode.nextNode;
            return;
        }

        Node iterNode = headNode;
        while (iterNode.nextNode != null) {
            if (iterNode.nextNode.value == value) {
                iterNode.nextNode = iterNode.nextNode.nextNode;
                break;
            }
            iterNode = iterNode.nextNode;
        }
    }

    void printLinkedList() {
        Node iterNode = headNode;
        while (iterNode != null) {
            System.out.print(iterNode.value + " -> ");
            iterNode = iterNode.nextNode;
        }
    }
}

class Node {
    int value;
    Node nextNode;

    Node(int value) {
        this.value = value;
        this.nextNode = null;
    }
}
