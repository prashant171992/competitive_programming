import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class fair_candy_swap {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new fair_candy_swap().run();
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int maxA = 0;
        int maxB = 0;
        int sumA = 0;
        int sumB = 0;
        Map<Integer,Boolean>mapA = new HashMap<>();
        Map<Integer,Boolean>mapB = new HashMap<>();

        for (int i : A) {
            sumA+=i;
            maxA = Math.max(maxA,i);
            mapA.put(i, true);
        }
        for (int i : B) {
            sumB+=i;
            maxB = Math.max(maxB,i);
            mapB.put(i,true);
        }

        int x, y;
        int ans[] = new int[2];

        if (sumA >= sumB) {
            int temp = (sumA-sumB)/2;
            for (int i : B) {
                if ((temp+i) <= maxA && mapA.get(temp+i) != null){
                    ans[0] = temp+i;
                    ans[1] = i;
                    return ans;
                }
            }
        } else {
            int temp = (sumB-sumA)/2;
            for (int i : A) {
                if ((temp+i) <= maxB && mapB.get(temp+i) != null){
                    ans[0] = i;
                    ans[1] = i+temp;
                    return ans;
                }
            }
        }
        return ans;
    }


}