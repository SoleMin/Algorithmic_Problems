import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author abashkin
 */
public class Solution implements Runnable {

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    public void run() {
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            pw = new PrintWriter(new OutputStreamWriter(System.out));
            solve();
            pw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void solve() throws Exception {
        int n = nextInt();
        pw.print(n + n / 2);
    }

    private BufferedReader br;
    private PrintWriter pw;
    private StringTokenizer tok;

    private String next() throws Exception {
        while (tok == null || !tok.hasMoreElements()) tok = new StringTokenizer(br.readLine());
        return tok.nextToken();
    }

    private int nextInt() throws Exception {
        return Integer.parseInt(next());
    }



}