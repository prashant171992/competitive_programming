import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class hackerrank_sample {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        canFinish(3, new int[][]{{0,1},{0,2},{1,2}});
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>adjMatrix[] = new ArrayList[numCourses];


        for (int i = 0; i < numCourses; ++i) {
            adjMatrix[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; ++i) {
            adjMatrix[prerequisites[i][1]].add(prerequisites[i][0]);
        }


        for (int i = 0; i < prerequisites.length; ++i) {
            boolean visited[] = new boolean[numCourses];
            visited[prerequisites[i][1]] = true;
            if (!dfs(visited, adjMatrix, prerequisites[i][1])) {
                return false;
            }
        }

        return true;

    }

    boolean dfs(boolean[] visited, List<Integer> adjMatrix[], int element) {
        boolean result = true;
        for (int i = 0; i < adjMatrix[element].size(); ++i) {
            if (visited[adjMatrix[element].get(i)]) {
                result = result && false;
            }
            visited[adjMatrix[element].get(i)] = true;
            result = result && dfs(visited, adjMatrix, adjMatrix[element].get(i));
        }
        return result;
    }



    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new hackerrank_sample().run();
    }

}