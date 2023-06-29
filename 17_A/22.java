import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    StreamTokenizer in;
    //BufferedReader in;
    PrintWriter out;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }
    int ni() throws IOException {
        in.nextToken(); return (int)in.nval;
    }
    void run() throws IOException {
        //in = new StreamTokenizer(new BufferedReader(new FileReader("input.txt")));
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        //out = new PrintWriter(new FileWriter("output.txt"));
        int cprime = 0;
        int[] prime = new int[1000];
        for(int i = 2; i < 1001; i++) {
            boolean f = false;
            for(int j = 2; j*j <= i; j++)
                if(i % j == 0) {
                    f = true; break;
                }
            if(!f) prime[cprime++] = i;
        }
        int n = ni(), k = ni();
        int last = 0;
        int count = 0;
        for(int i = 0; i < cprime && prime[i] <= n; i++) {
            for(int j = 0; j < cprime - 1; j++)
                if(prime[j] + prime[j + 1] + 1 == prime[i]) {
                    count++; break;
                }
                else if(prime[j] + prime[j + 1] + 1 > prime[i]) break;
        }
        if(count >= k) out.print("YES");
        else out.print("NO");
        out.flush();
    }
}