/*
 * Author Ayub Subhaniya
 * Institute DA-IICT
 */

import java.io.*;
import java.math.*;
import java.util.*;

public class A
{
	
	InputStream in;
	PrintWriter out;

	void solve() 
	{
		int n=ni();
		int a[]=na(n);
		int INV=0;
		for (int i=0;i<n;i++)
			for (int j=i+1;j<n;j++)
				if (a[i]>a[j])
					INV++;
		boolean even=INV%2==0;
		int q=ni();
		while (q-->0)
		{
			int l=ni();
			int r=ni();
			int len=r-l+1;
			len=(len-1)*(len)/2;
			if (len%2==1)
				even=!even;
			if (even)
				out.println("even");
			else
				out.println("odd");
		}
	}
	
	int MAX = (int)1e5;
	long factorial[];
	void findfactorial() 
	{
		factorial = new long[MAX + 1];
		factorial[0] = 1;
		for (int i = 1; i < MAX + 1; i++) 
		{
			factorial[i] = mul(i,factorial[i - 1]);
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
	
	int max(int a,int b)
	{
		if(a>b)
			return a;
		else
			return b;
	}
	
	int min(int a,int b)
	{
		if(a>b)
			return b;
		else 
			return a;
	}
	
	long max(long a,long b)
	{
		if(a>b)
			return a;
		else
			return b;
		
	}
	
	
	long min(long a,long b)
	{
		if(a>b)
			return b;
		else 
			return a;
		
	}
		
	void run() throws Exception 
	{
		String INPUT = "C:/Users/ayubs/Desktop/input.txt";
		in = oj ? System.in : new FileInputStream(INPUT);
		out = new PrintWriter(System.out);
		
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		tr(System.currentTimeMillis() - s + "ms");
		
	}
	public static void main(String[] args) throws Exception 
	{
		new A().run();
	}
	
	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;
	
	private int readByte() 
	{
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) 
		{
			ptrbuf = 0;
			try 
			{
				lenbuf = in.read(inbuf);
			}
			catch (IOException e) 
			{
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private boolean inSpaceChar(int c) 
	{
		return !(c >= 33 && c <= 126);
	}
	
	private int skip() 
	{
		int b;
		while ((b = readByte()) != -1 && inSpaceChar(b))
			;
		return b;
	}
	
	private double nd() 
	{
		return Double.parseDouble(ns());
	}
	
	private char nc() 
	{
		return (char) skip();
	}
	
	private String ns() 
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(inSpaceChar(b))) 
		{ // when nextLine, (inSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private char[] ns(int n) 
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(inSpaceChar(b))) 
		{
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private char[][] nm(int n, int m) 
	{
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
		return map;
	}
	
	private int[] na(int n) 
	{
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}
	
	private int ni() 
	{
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') 
		{
			minus = true;
			b = readByte();
		}
		
		while (true) 
		{
			if (b >= '0' && b <= '9') 
			{
				num = num * 10 + (b - '0');
			} 
			else 
			{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private long nl() 
	{
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') 
		{
			minus = true;
			b = readByte();
		}
		
		while (true) 
		{
			if (b >= '0' && b <= '9') 
			{
				num = num * 10 + (b - '0');
			}
			else 
			{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
	
	private void tr(Object... o) 
	{
		if (!oj)
			System.out.println(Arrays.deepToString(o));
	}
	
}