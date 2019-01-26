import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

// 2019-01-15 

public class complex_number_multiplication {
    PrintWriter out;

    int row[] = {-1, 0, 1, 0};
    int column[] = {0, 1, 0, -1};

    void solve() {
        out.println(complexNumberMultiply("78+-76i","-86+72i"));
    }

    void run() {
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new complex_number_multiplication().run();
    }

    public String complexNumberMultiply(String a, String b) {
        int a1,b1,a2,b2;
        int r1, r2;
        a1 = getNumbersFromString(a)[0];
        a2 = getNumbersFromString(a)[1];
        b1 = getNumbersFromString(b)[0];
        b2 = getNumbersFromString(b)[1];

        int t1 = a1 * b1 + (-1) * (a2) * (b2);
        int t2 = a1 * b2 + a2 * b1;

        String result = "";
        result+= t1;
        result+= "+";
        result+= t2;
        result+="i";

        return result;


    }

    int[] getNumbersFromString(String s) {
        int[] ans = new int[2];
        int i = 0;
        String calc = "";
        if (s.charAt(0) == '-') {
            i++;
        }
        while(s.charAt(i) != '+') {
            calc+=s.charAt(i);
            i++;
        }

        calc = new StringBuffer(calc).reverse().toString();
        int placeVal = 0;

        for(Character c : calc.toCharArray()) {
            ans[0]+= ((c - '0') * Math.pow(10, placeVal));
            placeVal++;
        }

        if (s.charAt(0) == '-') {
            ans[0]*=-1;
        }

        i++;

        boolean flag = false;
        if (s.charAt(i) == '-') {
            flag = true;
            i++;
        }

        calc = "";
        while(s.charAt(i) != 'i') {
            calc+=s.charAt(i);
            i++;
        }

        calc = new StringBuffer(calc).reverse().toString();
        placeVal = 0;

        for(Character c : calc.toCharArray()) {
            ans[1]+= ((c - '0') * Math.pow(10, placeVal));
            placeVal++;
        }

        if (flag) {
            ans[1] *= -1;
        }

        return ans;
    }


}