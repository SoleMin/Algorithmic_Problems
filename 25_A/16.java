import java.io.*;
import java.math.*;
import java.util.*;
import java.util.List;
import java.util.Queue;
import java.awt.*;
import static java.util.Arrays.fill;

public class Solution implements Runnable {

    private BufferedReader br = null;
    private PrintWriter pw = null;
    private StringTokenizer stk = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(new Solution()).run();
    }

    public void run() {
        /*
         * try { // br = new BufferedReader(new FileReader("input.txt")); pw =
         * new PrintWriter("output.txt"); } catch (FileNotFoundException e) {
         * e.printStackTrace(); }
         */
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new OutputStreamWriter(System.out));
        solver();
        pw.close();

    }

    private void nline() {
        try {
            if (!stk.hasMoreTokens())
                stk = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException("KaVaBUnGO!!!", e);
        }
    }

    private String nstr() {
        while (!stk.hasMoreTokens())
            nline();
        return stk.nextToken();
    }

    private int ni() {
        return Integer.valueOf(nstr());

    }

    private double nd() {
        return Double.valueOf(nstr());

    }

    String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
        }
        return null;
    }

    private void solver() {
        int n = ni();
        ArrayList<Integer> ar = new ArrayList<Integer>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            ar.add(ni() % 2);
            sum += ar.get(i);
        }
        int flag = 0;
        if(sum==1)flag = 1;
            for(int i =0;i<n;i++)if(ar.get(i)==flag)System.out.println(i+1);
        

    }

    void exit() {
        System.exit(0);
    }
}
