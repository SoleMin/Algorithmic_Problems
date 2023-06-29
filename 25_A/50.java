/**
 * Created by IntelliJ IDEA.
 * User: dev_il
 * Date: 03.08.2010
 * Time: 0:59:04
 * To change this template use File | Settings | File Templates.
 */


import java.io.*;

import static java.lang.Math.*;

import java.util.*;

public class IQTest implements Runnable {
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok;

    public static void main(String[] args) {
        new Thread(new IQTest()).start();
    }

    void solve() throws IOException {
        int n = nextInt();
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            int k = nextInt();
            if (k % 2 == 0) l1.add(i + 1);
            else l2.add(i + 1);
        }
        if (l1.size() == 1)
            out.println(l1.get(0));
        else out.println(l2.get(0));
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            // in = new BufferedReader(new FileReader(new File("input.txt")));
            out = new PrintWriter(System.out);
            // out = new PrintWriter(new File("output.txt"));
            solve();
            out.flush();
            out.close();
            in.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    String nextLine() throws IOException {
        tok = null;
        return in.readLine();
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

}
