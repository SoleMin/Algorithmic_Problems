import java.io.*;
import java.util.*;

public class YoureGivenAString {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String str = f.readLine();
        int max = 0;
        for (int i = 0; i < str.length(); i++)
            for (int j = i+1; j <= str.length(); j++) {
                String s = str.substring(i,j);
                if (str.indexOf(s) >= 0 && str.substring(str.indexOf(s)+1).indexOf(s) >= 0)
                    max = Math.max(max, j-i);
            }
        System.out.println(max);
    }   
}