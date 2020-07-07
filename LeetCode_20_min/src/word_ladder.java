import java.io.PrintWriter;
import java.util.*;

// 2019-01-15 

public class word_ladder {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        boolean found = false;

        for (String s : wordList) {
            if (s.equals(endWord)) found = true;
        }

        if (!found) return 0;

        Map<String, Integer> nodeDistanceMap = new HashMap<>();
        Map<String, List<String>> neighboursMap = new HashMap<>();

        return bfs(beginWord, endWord, set, nodeDistanceMap, neighboursMap);

    }

    private int bfs(String beginWord, String dest, Set<String> set, Map<String, Integer> nodeDistanceMap, Map<String, List<String>> neighboursMap) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        nodeDistanceMap.put(beginWord, 1);
        for (String word : set) neighboursMap.put(word, new ArrayList<>());
        neighboursMap.put(beginWord, new ArrayList<>());

        while (!queue.isEmpty()) {

            int queueSize = queue.size();

            for (int i = 0; i < queueSize; ++i) {
                String word = queue.poll();
                int currDistance = nodeDistanceMap.get(word);

                List<String> neighbours = getNeighbours(word, set);
                neighboursMap.get(word).addAll(neighbours);

                for (String neighbour : neighbours) {

                    if (!nodeDistanceMap.containsKey(neighbour)) {
                        nodeDistanceMap.put(neighbour, currDistance+1);

                        if (neighbour.equals(dest)) {
                            return currDistance+1;
                        } else {
                            queue.offer(neighbour);
                        }
                    }
                }
            }
        }

        return 0;
    }

    private List<String> getNeighbours(String beginWord, Set<String> set) {
        char[] tempArray = beginWord.toCharArray();

        List<String> neighbours = new ArrayList<>();

        for (int k = 0; k < tempArray.length; ++k) {
            char originalChar = tempArray[k];
            for (char j = 'a'; j <= 'z'; ++j) {
                if (j != originalChar) {
                    tempArray[k] = j;
                    String newWord = String.valueOf(tempArray);
                    if (set.contains(newWord)) {
                        neighbours.add(newWord);
                    }
                }
            }
            tempArray[k] = originalChar;
        }
        return neighbours;
    }


    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new word_ladder().run();
    }


}