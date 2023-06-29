import java.util.*;
import java.io.*;
import java.math.*;
 public class Q1 {

	static ArrayList<Integer> adj[],adj2[];
	static int color[],cc;
	static long mod=1000000007;
	static TreeSet<Integer> ts[];
	static boolean b[],visited[],possible,ans1,ans2;
	static Stack<Integer> s;
	static int totalnodes,colored,min,minc;
	static int c[];
	static long sum[];
	static HashMap<Integer,Integer> hm;
	public static void main(String[] args) throws IOException {
		
		//Scanner sc=new Scanner(System.in);
		in=new InputReader(System.in);
		out=new PrintWriter(System.out);
		String n1=in.readString();
		String s1=in.readString();
		long s=Long.parseLong(s1);
		long n=Long.parseLong(n1);
		
		long l=s-1;
		long r=n+1;
		HashSet<Long> hset=new HashSet<>();
		long last=-1;
		while(l<r)
		{
			long mid=(l+r)/2;
			long sum=0;
			if(hset.contains(mid))
				break;
			String d=String.valueOf(mid);
			for(int i=0;i<d.length();i++)
			{
				sum=sum+(d.charAt(i)-'0');
			}
			//debug(sum);
			hset.add(mid);
			
			if(mid-sum>=s)
			{
				last=mid;
				r=mid;
			}
			else
			{
				l=mid;
			}
		}
		if(last==-1)
			out.println("0");
		else
		{
			out.println(n-last+1);
		}
		out.close();
		}
	
	static InputReader in;
	static PrintWriter out;
 	static void dfs(int i,int parent)
	{
 		if(color[i]!=cc)
 			ans1= false;
 		for(int j:adj[i])
 		{
 			if(j!=parent)
 			{
 				dfs(j,i);
 			}
 		}
		
	}
	/*public static void seive(long n){
		b = new boolean[(int) (n+1)];
	Arrays.fill(b, true);
	
		for(int i = 2;i*i<=n;i++){
			if(b[i]){
				sum[i]=count[i];
			//	System.out.println(sum[i]+" wf");
				for(int p = 2*i;p<=n;p+=i){
					b[p] = false;
					sum[i]+=count[p];  
					//System.out.println(sum[i]);
				}
			}
		
		}
	}*/
	static class Pair implements Comparable<Pair> {
		int i;
		int j;
		int index;
		public Pair(){
			
		}
		public Pair(int u, int v,int index) {
			this.i = u;
			this.j= v;
			this.index=index;
		}
		public int compareTo(Pair other) {
			
			
				return this.i-other.i;
		}
		
		/*public String toString() {
			return "[u=" + u + ", v=" + v + "]";
		}*/
	}
	static class Node2{
		Node2 left = null;
		Node2 right = null;
		Node2 parent = null;
		int data;
	}
	
	//binaryStree
	static class BinarySearchTree{
		Node2 root = null;
		int height = 0;
		int max = 0;
		int cnt = 1;
		ArrayList<Integer> parent = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		public void insert(int x){
			Node2 n = new Node2();
			n.data = x;
			if(root==null){
				root = n;
			}
			else{
				Node2 temp = root,temp2 = null;
				while(temp!=null){
					temp2 = temp;
					if(x>temp.data) temp = temp.right;
					else temp = temp.left;
				}
				if(x>temp2.data) temp2.right = n;
				else temp2.left = n;
				n.parent = temp2;
				parent.add(temp2.data);
			}
		}
		public Node2 getSomething(int x, int y, Node2 n){
			if(n.data==x || n.data==y) return n;
			else if(n.data>x && n.data<y) return n;
			else if(n.data<x && n.data<y) return getSomething(x,y,n.right);
			else return getSomething(x,y,n.left);
		}
		public Node2 search(int x,Node2 n){
			if(x==n.data){
				max = Math.max(max, n.data);
				return n;
			}
			if(x>n.data){
				max = Math.max(max, n.data);
				return search(x,n.right);
			}
			else{
				max = Math.max(max, n.data);
				return search(x,n.left);
			}
		}
		public int getHeight(Node2 n){
			if(n==null) return 0;
			height = 1+ Math.max(getHeight(n.left), getHeight(n.right));
			return height;
		}
	}
public static void debug(Object... o) {
	System.out.println(Arrays.deepToString(o));
}

public static String rev(String s)
{
	StringBuilder sb=new StringBuilder(s);
	sb.reverse();
	return sb.toString();
}

static long lcm(long a, long b)
{
    return a * (b / gcd(a, b));
}

static long gcd(long a, long b)
{
    while (b > 0)
    {
        long temp = b;
        b = a % b; // % is remainder
        a = temp;
    }
    return a;
}

public static long max(long x, long y, long z){
		if(x>=y && x>=z) return x;
		if(y>=x && y>=z) return y;
		return z;
	}
	static int[] sieve(int n,int[] arr)
	{
	for(int i=2;i*i<=n;i++)
	{
		if(arr[i]==0)
		{
			for(int j=i*2;j<=n;j+=i)
				arr[j]=1;
		}
	}
	return arr;
	}




static class InputReader {

private final InputStream stream;
private final byte[] buf = new byte[8192];
private int curChar, snumChars;
private SpaceCharFilter filter;

public InputReader(InputStream stream) {
  this.stream = stream;
}

public int snext() {
  if (snumChars == -1)
    throw new InputMismatchException();
  if (curChar >= snumChars) {
    curChar = 0;
    try {
      snumChars = stream.read(buf);
    } catch (IOException e) {
      throw new InputMismatchException();
    }
    if (snumChars <= 0)
      return -1;
  }
  return buf[curChar++];
}

public int nextInt() {
  int c = snext();
  while (isSpaceChar(c)) {
    c = snext();
  }
  int sgn = 1;
  if (c == '-') {
    sgn = -1;
    c = snext();
  }
  int res = 0;
  do {
    if (c < '0' || c > '9')
      throw new InputMismatchException();
    res *= 10;
    res += c - '0';
    c = snext();
  } while (!isSpaceChar(c));
  return res * sgn;
}

public long nextLong() {
  int c = snext();
  while (isSpaceChar(c)) {
    c = snext();
  }
  int sgn = 1;
  if (c == '-') {
    sgn = -1;
    c = snext();
  }
  long res = 0;
  do {
    if (c < '0' || c > '9')
      throw new InputMismatchException();
    res *= 10;
    res += c - '0';
    c = snext();
  } while (!isSpaceChar(c));
  return res * sgn;
}

public int[] nextIntArray(int n) {
	 return nextIntArray(n, 0);
	    }
	    
public int[] nextIntArray(int n, int off) {
	 int[] arr = new int[n + off];
	   for (int i = 0; i < n; i++) {
	    arr[i + off] = nextInt();
	    }
	    return arr;
	    }
	    
public long[] nextLongArray(int n) {
return nextLongArray(n, 0);
	    }
        
	public long[] nextLongArray(int n, int off) {
	 long[] arr = new long[n + off];
	 for (int i = 0; i < n; i++) {
		  arr[i + off] = nextLong();
		 }
 return arr;
	}


public String readString() {
  int c = snext();
  while (isSpaceChar(c)) {
    c = snext();
  }
  StringBuilder res = new StringBuilder();
  do {
    res.appendCodePoint(c);
    c = snext();
  } while (!isSpaceChar(c));
  return res.toString();
}

public String nextLine() {
  int c = snext();
  while (isSpaceChar(c))
    c = snext();
  StringBuilder res = new StringBuilder();
  do {
    res.appendCodePoint(c);
    c = snext();
  } while (!isEndOfLine(c));
  return res.toString();
}

public boolean isSpaceChar(int c) {
  if (filter != null)
    return filter.isSpaceChar(c);
  return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
}

private boolean isEndOfLine(int c) {
  return c == '\n' || c == '\r' || c == -1;
}

public interface SpaceCharFilter {
  public boolean isSpaceChar(int ch);
}
}
	
}
