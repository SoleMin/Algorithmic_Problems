/*
 * Institute DA-IICT
 */

import java.io.*;
import java.math.*;
import java.util.*;

public class C
{
	
	InputStream in;
	PrintWriter out;
	
	void solve() 
	{
		int n=ni();
		long dp[]=new long[n+1];
		
		dp[0]=1;
		for (int i=0;i<n;)
		{
			i++;
			if (nc()=='f')
			{
				//boolean flag=i==1;
				i++;
				int k=1;
				while (nc()!='s')
				{
					i++;k++;
				}
				//long dp1[]=Arrays.copyOf(dp, n+1);
				for (int j=n-1;j>=0;j--)
				{
					dp[j]=add(dp[j],dp[j+1]);
				}
				
				for (int j=n;j>=k;j--)
				{
					dp[j]=dp[j-k];
				}
				for (int j=0;j<k;j++)
					dp[j]=0;
			}
			else
			{
				for (int j=n-1;j>=0;j--)
				{
					dp[j]=add(dp[j],dp[j+1]);
				}
			}
			//tr(dp);
		}
		long sum=0;
		for (int i=0;i<=n;i++)
			sum=add(sum,dp[i]);
		out.println(sum);
	}
	
	class LazyPropagation
		{
			long tree[];
			long lazy[];
			long A[];
			public LazyPropagation(int n,long arr[]) 
			{
				tree=new long[4*n];
				lazy=new long[4*n];
				A=arr;
				buildSum(1,1,n);
			}
			
			public LazyPropagation(int n) 
			{
				tree=new long[4*n];
				lazy=new long[4*n];
			}
			
			void buildSum(int node,int start,int end)
			{
				if (start==end)
				{
					tree[node]=A[start];
				}
				else
				{
					int mid=(start+end)>>1;
					buildSum(node*2, start, mid);
					buildSum(node*2+1, mid+1, end);
					tree[node]=tree[node*2]+tree[2*node+1];
				}
			}
			
			void updateRangeSum(int node, int start, int end,int l,int r,long val)
			{
				if (lazy[node]!=0)
				{
					tree[node]=add(tree[node],mul((end-start+1),lazy[node]));
					if (start!=end)
					{
						lazy[2*node]=add(lazy[2*node],lazy[node]);
						lazy[node*2+1]=add(lazy[2*node+1],lazy[node]);
					}
					lazy[node]=0;
				}
				if (start>end||start>r||end<l)
					return;
				
				if (start>=l&&end<=r)
				{
					tree[node]=add(tree[node],mul((end-start+1),val));
					if (start!=end)
					{
						lazy[2*node]=add(lazy[2*node],val);
						lazy[node*2+1]=add(lazy[2*node+1],val);
					}
					return;
				}
				int mid=(start+end)>>1;
				updateRangeSum(node*2, start, mid, l, r, val);
				updateRangeSum(node*2+1, mid+1, end, l, r, val);
				tree[node]=add(tree[node*2],tree[node*2+1]);
				
			}
			
			long queryRangeSum(int node,int start,int end,int l,int r)
			{
				if (start>r||end<l||start>end)
					return 0;
				if (lazy[node]!=0)
				{
					tree[node]=add(tree[node],mul((end-start+1),lazy[node]));
					if (start!=end)
					{
						lazy[2*node]=add(lazy[2*node],lazy[node]);
						lazy[node*2+1]=add(lazy[2*node+1],lazy[node]);
					}
					lazy[node]=0;
				}
				
				if (start>=l&&end<=r)
					return tree[node];
				
				int mid=(start+end)>>1;
				return add(queryRangeSum(node*2, start, mid, l, r),queryRangeSum(node*2+1, mid+1, end, l, r));
			}
		}
	
	long mod=(long)1e9+7;
	long add(long a,long b)
	{
		long x=(a+b);
		while(x>=mod) x-=mod;
		return x;
		
	}
	
	
	long sub(long a,long b)
	{
		long x=(a-b);
		while(x<0) x+=mod;
		return x;
		
	}
	
	
	long mul(long a,long b)
	{
		a%=mod;
		b%=mod;
		long x=(a*b);
		return x%mod;
		
	}
	
	void run() throws Exception {
		String INPUT = "C:/Users/ayubs/Desktop/input.txt";
		in = oj ? System.in : new FileInputStream(INPUT);
		out = new PrintWriter(System.out);
		
			long s = System.currentTimeMillis();
			solve();
			out.flush();
			tr(System.currentTimeMillis() - s + "ms");
	}
	public static void main(String[] args) throws Exception {
		new C().run();
	}
	
	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;
	
	private int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = in.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private boolean inSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}
	
	private int skip() {
		int b;
		while ((b = readByte()) != -1 && inSpaceChar(b))
			;
		return b;
	}
	
	private double nd() {
		return Double.parseDouble(ns());
	}
	
	private char nc() {
		return (char) skip();
	}
	
	private String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(inSpaceChar(b))) { // when nextLine, (inSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(inSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private char[][] nm(int n, int m) {
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
		return map;
	}
	
	private int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}
	
	private int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
	
	private void tr(Object... o) {
		if (!oj)
			System.out.println(Arrays.deepToString(o));
	}
	
}
