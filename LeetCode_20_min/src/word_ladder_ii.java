import java.io.PrintWriter;
import java.util.*;

// 2019-01-15 

public class word_ladder_ii {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();

        Set<String> set = new HashSet<>(wordList);

        boolean found = false;

        for (String s : wordList) {
            if (s.equals(endWord)) found = true;
        }

        if (!found) return new ArrayList<>();

        Map<String, Integer> nodeDistanceMap = new HashMap<>();
        Map<String, List<String>> neighboursMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        bfs(beginWord, endWord, set, nodeDistanceMap, neighboursMap);

        dfs(beginWord, endWord, nodeDistanceMap, neighboursMap, new ArrayList<>(), result);

        return result;

    }

    private void bfs(String beginWord, String dest, Set<String> set, Map<String, Integer> nodeDistanceMap, Map<String, List<String>> neighboursMap) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        nodeDistanceMap.put(beginWord, 0);
        for (String word : set) neighboursMap.put(word, new ArrayList<>());
        neighboursMap.put(beginWord, new ArrayList<>());

        while (!queue.isEmpty()) {

            int queueSize = queue.size();

            boolean foundEnd = false;

            for (int i = 0; i < queueSize; ++i) {
                String word = queue.poll();
                int currDistance = nodeDistanceMap.get(word);

                List<String> neighbours = getNeighbours(word, set);
                neighboursMap.get(word).addAll(neighbours);

                for (String neighbour : neighbours) {

                    if (!nodeDistanceMap.containsKey(neighbour)) {
                        nodeDistanceMap.put(neighbour, currDistance+1);

                        if (neighbour.equals(dest)) {
                            foundEnd = true;
                        } else {
                            queue.offer(neighbour);
                        }
                    }
                }
                if (foundEnd) break;
            }
        }
    }

    private void dfs(String beginWord, String dest, Map<String, Integer> nodeDistanceMap, Map<String, List<String>> neighboursMap, List<String> currSolution, List<List<String>> finalSolution) {
        currSolution.add(beginWord);
        if (beginWord.equals(dest)) {
            finalSolution.add(new ArrayList<>(currSolution));
        } else {
            for (String neighbour : neighboursMap.get(beginWord)) {
                if (nodeDistanceMap.get(neighbour) == nodeDistanceMap.get(beginWord) + 1) {
                    dfs(neighbour, dest, nodeDistanceMap, neighboursMap, currSolution, finalSolution);
                }
            }
        }

        currSolution.remove(currSolution.size()-1);

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
        new word_ladder_ii().run();
    }


}