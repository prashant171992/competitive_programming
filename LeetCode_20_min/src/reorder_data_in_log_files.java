import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

// 2019-01-15 

public class reorder_data_in_log_files {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    public String[] reorderLogFiles(String[] logs) {
        String[] result = new String[logs.length];

        int letterLogsCount = 0;
        int digitLogsCount = 0;

        for (String str : logs) {
            String[] split = str.split("\\s+");
            if (split[1].charAt(0) >= '0' && split[1].charAt(0) <= '9') {
                digitLogsCount++;
            } else {
                letterLogsCount++;
            }
        }

        String[] tempStringArray = new String[letterLogsCount];
        int counter = 0;

        for (String str : logs) {
            String[] split = str.split("\\s+");
            if (split[1].charAt(0) >= '0' && split[1].charAt(0) <= '9') {
                result[letterLogsCount] = str;
                letterLogsCount++;
            } else {
                tempStringArray[counter] = str;
                counter++;
            }
        }

        Arrays.sort(tempStringArray, (o1, o2) -> {
            String w1 = o1.substring(o1.split("\\s+")[0].length());
            String w2 = o2.substring(o2.split("\\s+")[0].length());
            int compareResult = w1.compareTo(w2);
            if (compareResult == 0) {
                return o1.split("\\s+")[0].compareTo(o2.split("\\s+")[0]);
            }
            return compareResult;
        });

        if (counter - 1 + 1 >= 0) System.arraycopy(tempStringArray, 0, result, 0, counter - 1 + 1);

        return result;
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new reorder_data_in_log_files().run();
    }


}