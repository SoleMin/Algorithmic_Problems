import java.io.*;
import java.util.*;

public class Main implements Runnable {
    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer st;
    
    private void eat(String line)
    {
        st = new StringTokenizer(line);
    }
    
    private String next() throws IOException
    {
        while(!st.hasMoreTokens()) {
            String line = in.readLine();
            if(line == null)
                return null;
            eat(line);
        }
        return st.nextToken();
    }
    
    private int nextInt() throws IOException
    {
        return Integer.parseInt(next());
    }
    
    public void run()
    {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));
            eat("");
            
            go();
            
            out.close();
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
    
    public static void main(String[] args)
    {
        new Thread(new Main()).start();
    }
    
    public void go() throws IOException
    {
        int n = nextInt(), t = nextInt();
        int[] x = new int[n], a = new int[n];
        for(int i = 0; i < n; ++i) {
            x[i] = nextInt();
            a[i] = nextInt();
        }
        out.println(new Algo().solve(n, t, x, a));
    }
}

final class Algo {
    public int solve(int n, int t, final int[] x, final int[] a)
    {
        Integer[] order = new Integer[n];
        for(int i = 0; i < n; ++i)
            order[i] = i;
        Arrays.sort(order, new Comparator<Integer>() {
            public int compare(Integer a, Integer b)
            {
                return x[a] - x[b];
            }
        });
        int result = 2;
        for(int i = 0; i + 1 < n; ++i) {
            int u = order[i], v = order[i + 1];
            int dist = 2 * (x[v] - x[u]) - (a[v] + a[u]);
            if(dist > 2 * t)
                result += 2;
            else if(dist == 2 * t)
                ++result;
        }
        return result;
    }
}
