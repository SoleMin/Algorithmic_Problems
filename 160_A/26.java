

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
	int sum;
	int n;
	int arr[];

	void execute() throws IOException
	{
		totalCases = 1;
		for(testNum = 1; testNum <= totalCases; testNum++)
		{
			if(!input())
				break;
			solve();
		}
	}

	void solve() throws IOException
	{
		Arrays.sort(arr);
		int count = 0;
		int ans = 0;
		for(int i = n-1;i>=0;i--)
		{
			count+= arr[i];
			if(count>sum-count)
			{
				ans = n-i;
				break;
			}
		}
		System.out.println(ans);
	}
	

	boolean input() throws IOException
	{
		n = ni();
		sum = 0;
		arr = new int[n];
		for(int i = 0;i<n;i++)
		{
			arr[i] = ni();
			sum = sum+arr[i];
		}
		return true;
	}


}


