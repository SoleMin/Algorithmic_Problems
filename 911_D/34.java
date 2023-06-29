/**
 p * @author prakhar28
 *
 */
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.text.*;
import java.math.*;
import java.util.regex.*;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main{
	
	static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[200005]; // line length+1
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n' || c==' ') {
                	//buf[cnt++]=(byte)c;
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
	
	static class FastScanner {

	    private final BufferedReader bufferedReader;
	    private StringTokenizer stringTokenizer;

	    public FastScanner() {
	        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	    }

	    public String next() {
	        while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
	            try {
	                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
	            } catch (IOException e) {
	                throw new RuntimeException("Can't read next value", e);
	            }
	        }
	        return stringTokenizer.nextToken();
	    }

	    public int nextInt() {
	        return Integer.parseInt(next());
	    }

	    public long nextLong() {
	        return Long.parseLong(next());
	    }

	    public double nextDouble() {
	        return Double.parseDouble(next());
	    }

	    public String nextLine(){
	        String str = "";
	        try {
	            str = bufferedReader.readLine();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return str;
	    }
	}
	
	static void closeall() throws IOException{
		printWriter.close();
		sc.close();
		in.close();
	}
	static Scanner sc = new Scanner(System.in);
	static Reader in = new Reader();
	static FastScanner fastScanner = new FastScanner();
	static PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(System.out));
	static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
	static long INF = (long)(1e18);

	
	int V,E;
	ArrayList<Integer> adj[];
	HashMap<Integer,Integer> path;
	Main(){
	}
	Main(int v,int e){
		V=v;
		E=e;
		adj=new ArrayList[v];
		path = new HashMap<Integer,Integer>();
		for(int i=0;i<v;i++)
			adj[i] = new ArrayList<>();
	}
	void addEdge(int u,int v){
		adj[u].add(v);
		adj[v].add(u);
	}
	
	
	static long power(long a,long k)
	{
		long m = 1000000007;
	    long ans=1;
	    long tmp=a%m;
	    while(k>0)
	    {
	        if(k%2==1)
	        	ans=ans*tmp%m;
	        tmp=tmp*tmp%m;
	        k>>=1;
	    }
	    return ans;
	}
	
	static class Pair /*implements Comparable<Pair>*/{
		long F,S;
		Pair(long x,long y){
			F = x;
			S = y;
		}
		/*public int compareTo(Pair ob){
			return this.num-ob.num;
		}*/
		
	}
	static long gcd(long a,long b) {
		if(a<b) {
			long t = a;
			a = b;
			b = t;
		}
		long r = a%b;
		if(r==0)
			return b;
		return gcd(b,r);
	}
	
	static int lower_bound(int[] a,int low,int high,int val) {
		while(low!=high) {
			int mid = (low+high)/2;
			if(a[mid]<val)
				low=mid+1;
			else
				high=mid;
		}
		return low;
	}
	
	static int max(int a,int b) {
		return (int)Math.max(a, b);
	}
	static long max(long a,long b) {
		return (long)Math.max(a, b);
	}
	static int min(int a,int b) {
		if(a<b)
			return a;
		return b;
	}
	static long mod = 1000000007;
	
	public static void main(String args[])throws IOException{
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++)
			a[i] = in.nextInt();
		int inv = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(a[j]>a[i])
					inv++;
			}
		}
		inv%=2;
		int q = in.nextInt();
		for(int i=0;i<q;i++) {
			int l = in.nextInt();
			int r = in.nextInt();
			int num = r-l+1;
			inv=(inv+num*(num-1)/2)%2;
			if(inv==0)
				printWriter.println("even");
			else
				printWriter.println("odd");
		}
		closeall();
	}
} 