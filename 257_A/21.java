import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n=in.nextInt();
        int m=in.nextInt();
        int k=in.nextInt();
        Integer []cap=new Integer[n];
        for(int i=0;i<n;i++) {
            cap[i]=in.nextInt();
        }
        Arrays.sort(cap, Collections.reverseOrder());
        int count=0;

        while(k<m && count<cap.length) {
            k+=(cap[count]-1);
            ++count;
        }
        if(k>=m) {
            out.println(count);
        } else {
            out.println(-1);
        }
    }
}

class InputReader {
    StringTokenizer st;
    BufferedReader in;
    public InputReader(InputStream ins)
    {
        in = new BufferedReader(new InputStreamReader(ins));
    }

    public String nextToken()
    {
        while(st==null || !st.hasMoreTokens())
        {
            try {
                st=new StringTokenizer(in.readLine());
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        return st.nextToken();
    }
    public int nextInt()
    {

        return Integer.parseInt(nextToken());
    }

    }

