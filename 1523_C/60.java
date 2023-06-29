import java.io.*;
import java.util.*;
 public class Main {
	public static void main(String[] args) throws Exception {
		FastIO io = new FastIO();
		int test=io.nextInt();
		while(test>0)
		{
		    int n=io.nextInt();
		    int arr[]=new int[n];
		    for(int i=0;i<n;i++)arr[i]=io.nextInt();
		    List<int[]> list=new ArrayList<>();
		    Stack<int[]> stk=new Stack<>();
		    int temp[]={1};
		    list.add(temp);
		    stk.push(temp);
		    for(int i=1;i<n;i++)
		    {
		        if(arr[i]==1)
		        {
		            int t[]=stk.peek();
		            int nt[]=new int[t.length+1];
		            for(int j=0;j<t.length;j++)nt[j]=t[j];
		            nt[nt.length-1]=arr[i];
		            stk.push(nt);
		            list.add(nt);
		            continue;
		        }
		        while(stk.size()>0)
		        {
		            int t[]=stk.peek();
		            if(t[t.length-1]+1==arr[i]){
		                int nt[]=new int[t.length];
		                for(int j=0;j<t.length-1;j++)nt[j]=t[j];
		                nt[t.length-1]=arr[i];
		                stk.pop();
		                stk.push(nt);
		                list.add(nt);
		                break;
		            }
		            else
		            {
		                stk.pop();
		            }
		        }
		    }
		    for(int i=0;i<list.size();i++)
		    {
		        StringBuilder sb=new StringBuilder();
		        sb.append(list.get(i)[0]);
		        for(int j=1;j<list.get(i).length;j++)
		        {
		            sb.append("."+list.get(i)[j]);
		        }
		        io.println(sb.toString());
		    }
		    test--;
		}
		io.close();
	}
}
 
 class FastIO extends PrintWriter {
	private InputStream stream;
	private byte[] buf = new byte[1<<16];
	private int curChar, numChars;
 
	// standard input
	public FastIO() { this(System.in,System.out); }
	public FastIO(InputStream i, OutputStream o) {
		super(o);
		stream = i;
	}
	// file input
	public FastIO(String i, String o) throws IOException {
		super(new FileWriter(o));
		stream = new FileInputStream(i);
	}
 
	// throws InputMismatchException() if previously detected end of file
	private int nextByte() {
		if (numChars == -1) throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars == -1) return -1; // end of file
		}
		return buf[curChar++];
	}
 
	public String nextLine() {
		int c; do { c = nextByte(); } while (c <= '\n');
		StringBuilder res = new StringBuilder();
		do { res.appendCodePoint(c); c = nextByte(); } while (c > '\n');
		return res.toString();
	}
 
	public String next() {
		int c; do { c = nextByte(); } while (c <= ' ');
		StringBuilder res = new StringBuilder();
		do { res.appendCodePoint(c); c = nextByte(); } while (c > ' ');
		return res.toString();
	}
 
	public int nextInt() { 
		int c; do { c = nextByte(); } while (c <= ' ');
		int sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res = 10*res+c-'0';
			c = nextByte();
		} while (c > ' ');
		return res * sgn;
	}
 
  public long nextLong() { 
		int c; do { c = nextByte(); } while (c <= ' ');
		long sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
		long res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res = 10*res+c-'0';
			c = nextByte();
		} while (c > ' ');
		return res * sgn;
	}
 
	public double nextDouble() { return Double.parseDouble(next()); }
}