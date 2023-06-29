import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer tokenizer=null;
	
	public static void main(String[] args) throws IOException
	{
		new Main().execute();
	}
	
	void debug(Object...os)
	{
		System.out.println(Arrays.deepToString(os));
	}
	
	int ni() throws IOException
	{
		return Integer.parseInt(ns());
	}
	
	long nl() throws IOException 
	{
		return Long.parseLong(ns());
	}
	
	double nd() throws IOException 
	{
		return Double.parseDouble(ns());
	}
		
	String ns() throws IOException 
	{
		while (tokenizer == null || !tokenizer.hasMoreTokens()) 
			tokenizer = new StringTokenizer(br.readLine());
		return tokenizer.nextToken();
	}
	
	String nline() throws IOException
	{
		tokenizer=null;
		return br.readLine();
	}
		
	
	//Main Code starts Here
	int totalCases, testNum;	
	int k,n;
	
	void execute() throws IOException
	{
		totalCases = 1;
		for(testNum = 1; testNum <= totalCases; testNum++)
		{
			input();
			solve();
		}
	}

	void solve()
	{
		int a = arr[k-1].a;
		int b = arr[k-1].b;
		//debug(a,b);
		int count = 0;
		for(int i = 0;i<n;i++)
		{
			if(arr[i].a == a && arr[i].b == b)
				count++;
		}
		System.out.println(count);
	}
	
	void printarr(int [] a,int b)
	{
		for(int i = 0;i<=b;i++)
		{
			if(i==0)
				System.out.print(a[i]);
			else
				System.out.print(" "+a[i]);
		}
		System.out.println();
	}
	
	class Pair implements Comparable<Pair>
{	
	int a,b;
	Pair(int _a,int _b)
	{
		a=_a;
		b=_b;
	}
	
	public int compareTo(Pair x)
	{
		if(a == x.a) return b-x.b;
		return -(a-x.a);
	}
		
	public boolean equals(Pair x)
	{
		return a==x.a && b==x.b;
	}
}

	Pair[] arr;
	boolean input() throws IOException
	{
		n = ni();
		k = ni();
		arr = new Pair[n];
		for(int i = 0 ;i<n;i++)
		{
			Pair p =new Pair(ni(),ni());
			arr[i]  = p;
		}
		Arrays.sort(arr);
		//debug(arr);
		return true;
	}
}