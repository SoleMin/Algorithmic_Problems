//Implemented By Aman Kotiyal Date:-30-May-2021  Time:-7:54:28 pm
import java.io.*;
import java.util.*;

public class ques3
{
	public static void main(String[] args)throws Exception{ new ques3().run();} 
	long mod=1000000000+7;
	
	void solve() throws Exception
	{
		for(int ii=ni();ii>0;ii--)
		{
			int n=ni();
			//ArrayList<Integer> al=new ArrayList<Integer>();
			Stack<Integer> st=new Stack<Integer>();
			int x=ni();
			//al.add(1);
			st.add(1);
			out.println("1");
			for(int i=2;i<=n;i++)
			{
				 x=ni();
				 if(x==1)
				 {
					 st.add(1);
					 Stack<Integer> tep=(Stack<Integer>) st.clone();
					 display(tep);
					 continue;
				 }
				 int top=st.peek();
				 if(top+1==x)
				 {
					 st.pop();
					 st.add(x);
					 Stack<Integer> tep=(Stack<Integer>) st.clone();
					 display(tep);
					 continue;
				 }
				 while(true)
				 {
					 top=st.peek();
					 if(top+1==x)
					 {
						 st.pop();
						 st.add(x);
						 Stack<Integer> tep=(Stack<Integer>) st.clone();
						 display(tep);
						 break;
					 }
					 top=st.pop();
				 }
			}
		}
	}
	
	
	void display(Stack<Integer> st)
	{
		ArrayList<Integer> al = new ArrayList<>();
		while(st.size()!=0)
		{
			int tem=st.pop();
			al.add(tem);
		}
		Collections.reverse(al);
		for (int i = 0; i <al.size()-1; i++) {
			out.print(al.get(i)+".");
		}
		out.println(al.get(al.size()-1));
	}
	
	/*FAST INPUT OUTPUT & METHODS BELOW*/
	
	private byte[] buf=new byte[1024];
	private int index;
	private InputStream in;
	private int total;
	private SpaceCharFilter filter;
	PrintWriter out;
	
	int min(int... ar){int min=Integer.MAX_VALUE;for(int i:ar)min=Math.min(min, i);return min;}
	long min(long... ar){long min=Long.MAX_VALUE;for(long i:ar)min=Math.min(min, i);return min;}
	int max(int... ar) {int max=Integer.MIN_VALUE;for(int i:ar)max=Math.max(max, i);return max;}
	long max(long... ar) {long max=Long.MIN_VALUE;for(long i:ar)max=Math.max(max, i);return max;}
	void reverse(int a[]){for(int i=0;i<a.length>>1;i++){int tem=a[i];a[i]=a[a.length-1-i];a[a.length-1-i]=tem;}}
	void reverse(long a[]){for(int i=0;i<a.length>>1;i++){long tem=a[i];a[i]=a[a.length-1-i];a[a.length-1-i]=tem;}}
	String reverse(String s){StringBuilder sb=new StringBuilder(s);sb.reverse();return sb.toString();}
	
	void shuffle(int a[]) {
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=0;i<a.length;i++) 
			al.add(a[i]);
		
		Collections.sort(al);
		for(int i=0;i<a.length;i++) 
			a[i]=al.get(i);
	}
	long lcm(long a,long b)
	{
		return (a*b)/(gcd(a,b));
	}
	
	int gcd(int a, int b) 
	{ 
		if (a == 0) 
			return b; 
		return gcd(b%a, a); 
	} 
	long gcd(long a, long b) 
	{ 
		if (a == 0) 
			return b; 
		return gcd(b%a, a); 
	}
	/* for (1/a)%mod = ( a^(mod-2) )%mod  ----> use expo to calc -->(a^(mod-2)) */
	long expo(long p,long q)  /*  (p^q)%mod   */
	{
		long z = 1;
		while (q>0) {
			if (q%2 == 1) {
				z = (z * p)%mod;
			}
			p = (p*p)%mod;
			q >>= 1;
		}
		return z;
	}
	void run()throws Exception
	{
		in=System.in; out = new PrintWriter(System.out);
		solve();
		out.flush();
	}
	private int scan()throws IOException
	{
		if(total<0)
			throw new InputMismatchException();
		if(index>=total)
		{
			index=0;
			total=in.read(buf);
			if(total<=0)
				return -1;
		}
		return buf[index++];
	}
	private int ni() throws IOException 
	{
		int c = scan();
		while (isSpaceChar(c))
			c = scan();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = scan();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = scan();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
	private long nl() throws IOException 
	{
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = scan()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = scan();
		}
		
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = scan();
		}
	}
	private double nd() throws IOException{
		return Double.parseDouble(ns());
	}
	private String ns() throws IOException {
		int c = scan();
		while (isSpaceChar(c))
			c = scan();
		StringBuilder res = new StringBuilder();
		do {
			if (Character.isValidCodePoint(c))
				res.appendCodePoint(c);
			c = scan();
		} while (!isSpaceChar(c));
		return res.toString();
	}
	private String nss() throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}
	private char nc() throws IOException 
	{
		int c = scan();
		while (isSpaceChar(c))
			c = scan();
		return (char) c;
	}
	private boolean isWhiteSpace(int n)
	{
		if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
			return true;
		return false;
	}
	private boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return isWhiteSpace(c);
	}
	private interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}