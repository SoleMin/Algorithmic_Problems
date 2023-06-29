import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Lokesh Khandelwal aka (codeKNIGHT | phantom11)
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n=in.nextInt(),k=in.nextInt();
        int a[]=new int[n];
        int i;
        for(i=0;i<n;i++)
            a[i]=in.nextInt();
        HashSet<Integer> hs=new HashSet<Integer>();
        boolean status=false;
        int index=-1;
        for(i=0;i<n;i++)
        {
            
            hs.add(a[i]);
            if(hs.size()==k)
            {
                index=i;
                status=true;
                break;
            }
        }
        if(!status)
        {
            out.println(-1+" "+ -1);
            return;
        }
        HashSet<Integer> hash=new HashSet<Integer>();
        for(i=index;i>=0;i--)
        {

            hash.add(a[i]);
            if(hash.size()==k)
            {
                break;
            }
        }
        out.println((i+1)+" "+(index+1));
    }
}

class InputReader
{
    BufferedReader in;
    StringTokenizer tokenizer=null;

    public InputReader(InputStream inputStream)
    {
        in=new BufferedReader(new InputStreamReader(inputStream));
    }
    public String next()
    {
        try{
            while (tokenizer==null||!tokenizer.hasMoreTokens())
            {
                tokenizer=new StringTokenizer(in.readLine());
            }
            return tokenizer.nextToken();
        }
        catch (IOException e)
        {
            return null;
        }
    }
    public int nextInt()
    {
        return Integer.parseInt(next());
    }

}

