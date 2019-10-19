import java.io.PrintWriter;
import java.util.*;

// 2019-01-15 

public class tes1 {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    static int count = 0;
    static int finalAns = 0;

    static long countWays(int S[], int m, int n)
    {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[n+1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];

        return table[n];
    }

    void solve() {

        int goal = 30;
        int [] coins = new int [] {5, 10, 30};//, 60, 120, 240, 300};

        out.println(countWays(coins, coins.length, 30));

        // for formatting the string outputs
        Map<Integer, String> names = new HashMap<Integer, String>();
        names.put(5, "-5");
        names.put(10, "-10");
        names.put(30, "-30");
        names.put(60, "-60");
        names.put(120, "-120");
        names.put(240, "-240");
        names.put(300, "-300");

        // to keep track of the current amounts of each type of coin
        Map<String, Integer> curr = new HashMap<>();
        curr.put(names.get(5), 0);
        curr.put(names.get(10), 0);
        curr.put(names.get(30), 0);
        curr.put(names.get(60), 0);
        curr.put(names.get(120), 0);
        curr.put(names.get(240), 0);
        curr.put(names.get(300), 0);

        findCoins(goal, 0, coins, names, curr);
        //out.println(count);
        out.println(finalAns);
    }

    private static void findCoins(int left, int index, int [] coins, Map<Integer, String> names, Map<String, Integer> curr) {
        // not the last type of coin
        if (index < coins.length - 1) {
            // if we have not reached our goal value yet
            if (left > 0) {
                int coinAmount = coins[index];
                if (coinAmount <= left) {
                    // try all possible numbers of current coin given the amount
                    // that is left
                    for (int i = 0; i <= left / coinAmount; i++) {
                        curr.put(names.get(coinAmount), i);
                        findCoins(left - coinAmount * i, index + 1, coins, names, curr);
                    }
                    // reset the current coin amount to zero before recursing
                    curr.put(names.get(coinAmount), 0);
                }
                // case when there is a coin whose value is greater than the goal
                else {
                    findCoins(left, index + 1, coins, names, curr);
                }
            }
            // we've reached our goal, print out the current coin amounts
            else {
                printCurr(curr);
            }
        }
        // last type of coin
        else {
            // if we have not reached our goal value yet
            if (left > 0) {
                int coinAmount = coins[index];
                if (coinAmount <= left) {
                    // if the remainder of our goal is evenly divisble by our last
                    // coin value, we can make the goal amount
                    if (left % coinAmount == 0) {
                        // add last coin amount and print current values out
                        curr.put(names.get(coinAmount), left / coinAmount);
                        printCurr(curr);

                        // reset this coin amount to zero before recursing
                        curr.put(names.get(coinAmount), 0);
                    }
                }
            }
            // we've reached our goal, print out the current coin amounts
            else {
                printCurr(curr);
            }
        }
    }

    private static void printCurr(Map<String, Integer> curr) {
        Iterator<String> iter = curr.keySet().iterator();
        int sum = 0;
        //StringBuilder stringBuilder = new StringBuilder();
        Set<DummyClass> set = new HashSet<>();
        while (iter.hasNext()) {
            String denom = iter.next();
            sum+=curr.get(denom);
            if (curr.get(denom) != 0) {
                set.add(new DummyClass(denom, curr.get(denom)));
            }
            //stringBuilder.append(curr.get(denom)).append(" ").append(denom).append(" ");
        }

        if (sum%2==0) {
            //System.out.println(stringBuilder.toString());
            if (set.size() == 1) {
                finalAns+=1;
            } else {
                Set<Set<DummyClass>> powerSets = generatePowerSets(set);
                int finalSum = sum;
                powerSets
                        .forEach(set1 -> finalAns += calcAns(set1, finalSum /2, set.size()));
            }
        }

        count++;
    }


    static class DummyClass {
        DummyClass(String denom, Integer count) {
            this.denom = denom;
            this.count = count;
        }

        private String denom;
        private Integer count;
    }

    private static Set<Set<DummyClass>> generatePowerSets(Set<DummyClass> set) {
        List<DummyClass> list = new ArrayList<>(set);
        int n = list.size();

        Set<Set<DummyClass>> powerSet = new HashSet<>();

        for( long i = 0; i < (1 << n); i++) {
            Set<DummyClass> element = new HashSet<>();
            for( int j = 0; j < n; j++ )
                if( (i >> j) % 2 == 1 ) element.add(list.get(j));
            powerSet.add(element);
        }
        return powerSet;
    }

    private static long calcAns(Set<DummyClass> set, int sumOfElements, int numberOfElements) {
        int k = numberOfElements-1;
        final int[] tempSum = {0};
        set.forEach(i -> tempSum[0] = tempSum[0] + i.count + 1);
        int n = sumOfElements + k - tempSum[0];
        long tempAns = binomialCoeff(n, k);
        if (set.size()%2 == 0) return tempAns;
        else return (-1) * tempAns;
    }


    private static long binomialCoeff(int n, int k) {
        if (n < 0 || n == 0 || n < k) return 0;


        long res = 1;

        // Since C(n, k) = C(n, n-k)
        if ( k > n - k )
            k = n - k;

        // Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for (int i = 0; i < k; ++i)
        {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new tes1().run();
    }




}