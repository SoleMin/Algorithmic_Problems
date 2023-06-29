/* Shubhang Verma */
import java.io.*;
import java.math.*;
import java.util.*;
public class Main {

    public static void main(String[] args) 
    {	
        InputStream inputstream = System.in;
        OutputStream outputstream = System.out;
        InputReader in = new InputReader(inputstream);
        OutputWriter out = new OutputWriter(outputstream);
        mysolver mysol = new mysolver();
        mysol.solve(in, out);
        out.close();
    }
}
class node implements Comparable<node>{
	int count;
	long value;
	public int compareTo(node t)
	{
		if(this.value == t.value)
			return 0;
		else if(this.value < t.value)
			return -1;
		else
			return 1;
	}
}
class mysolver {
	public long mod = 1000000007;
	int M,N;
	boolean bpm(boolean bpGraph[][], int u, boolean seen[], int matchR[])
	{
	    for (int v = 0; v < N; v++)
	    {
	        if (bpGraph[u][v] && !seen[v])
	        {
	            seen[v] = true;
	            if (matchR[v] < 0 || bpm(bpGraph, matchR[v], seen, matchR))
	            {
	                matchR[v] = u;
	                return true;
	            }
	        }
	    }
	    return false;
	}

	int maxBPM(boolean bpGraph[][])
	{
	    int matchR[] = new int[N];
	    Arrays.fill(matchR,-1);
	    int result = 0;
	    for (int u = 0; u < M; u++)
	    {
	        boolean seen[] = new boolean[N];
	        if (bpm(bpGraph, u, seen, matchR))
	            result++;
	    }
	    return result;
	}
	
    public void solve(InputReader in,OutputWriter out)
    {
    	PrintWriter pout = new PrintWriter(new BufferedOutputStream(System.out));	
    	int n = in.readInt();
    	int m = in.readInt();
    	boolean eg[][] = new boolean[n][n];
    	for(int i=0;i<n;i++)
    	{
    		Arrays.fill(eg[i],false);
    	}
    	for(int i=0;i<m;i++)
    	{
    		int x = in.readInt()-1;
    		int y = in.readInt()-1;
    		eg[x][y] = true;
    	}
    	
    	int minimum = Integer.MAX_VALUE;
    	
    	for(int i=0;i<n;i++)
    	{

        	int ct = 0;
        	
    		int addedges =0;
    		if(eg[i][i] == false)
    		{
    			addedges++;
    		}
    		else
    		{
    			ct++;
    		}
    		
    		for(int j=0;j<n;j++)
    		{
    			if(j!=i && eg[i][j]==false)
    			{
    				addedges++;
    			}
    			else if(j!=i && eg[i][j] == true)
    			{
    				ct++;
    			}
    			if(j!=i && eg[j][i]==false)
    			{
    				addedges++;
    			}
    			else if(j!=i && eg[j][i] == true)
    			{
    				ct++;
    			}
    		}
    		//m - ct
    		
    		boolean row[] = new boolean[n];
    		boolean col[] = new boolean[n];
    		for(int j=0;j<n;j++)
    		{
    			row[j] = eg[i][j];
    			col[j] = eg[j][i];
    			eg[i][j] = false;
    			eg[j][i] = false;
    		}
    		
    		N = n;
    		M = n;
    		
//    		for(int I=0;I<n;I++)
//    		{
//    			for(int J=0;J<n;J++)
//    			{
//    				System.out.print(eg[I][J]+" ");
//    			}
//    			System.out.println();
//    		}
    		//System.out.println();
    		int matching = maxBPM(eg);
    		//System.out.println(matching);
    		addedges += n - 1 + m - ct - 2*matching;
    		minimum = Math.min(minimum,addedges);
    		for(int j=0;j<n;j++)
    		{
    			eg[i][j] = row[j];
    			eg[j][i] = col[j];
    		}
    		
    	}
    	
    	System.out.println(minimum);
    	
        pout.close();
    }
   
    
     
}
class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;
 
    public InputReader(InputStream stream) {
        this.stream = stream;
    }
    
    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }
 
    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }
 
    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return isWhitespace(c);
    }
 
    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    public String next() {
        return readString();
    }
 
    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}
 
class OutputWriter {
    private final PrintWriter writer;
 
    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }
 
    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }
 
    public void close() {
        writer.close();
    }
 
    public void printLine(int i) {
        writer.println(i);
    }
}
 
class IOUtils {
 
    public static void readIntArrays(InputReader in, int[]... arrays) {
        for (int i = 0; i < arrays[0].length; i++) {
            for (int j = 0; j < arrays.length; j++)
                arrays[j][i] = in.readInt();
        }
    }
 
    }
