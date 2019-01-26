import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class unique_morse_code_words {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] array = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> result = new HashSet<>();

        for (String word : words) {
            String s = "";
            for (Character c : word.toCharArray()) {
                s += array[c-'a'];
            }
            result.add(s);
        }

        return result.size();
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new unique_morse_code_words().run();
    }


}