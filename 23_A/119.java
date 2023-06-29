import java.io.*;
import java.util.*;
import java.math.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.*;

public class Main {
    //StreamTokenizer in;
    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        //in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));

        String s = in.readLine();
        int n = s.length();
        for(int len = n; len > 0; len--) {
            for(int i = 0; i + len <= n; i++) {
                for(int j = 0; j + len <= n; j++)
                    if(i != j) {
                        boolean f = true;
                        for(int k = 0; k < len; k++)
                            if(s.charAt(i + k) != s.charAt(j + k)) {
                                f = false;
                                break;
                            }
                        if(f) {
                            out.println(len);
                            out.flush();
                            return;
                        }
                    }
            }
        }
        out.println(0);
        out.flush();
    }

    void solve() throws IOException {
        
    }
    
    //int ni() throws IOException { in.nextToken(); return (int) in.nval; }
}