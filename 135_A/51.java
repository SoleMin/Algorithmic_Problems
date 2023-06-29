import java.io.*;
import java.util.*;

/*
 * Raudel Ravelo Suarez
 * Problem: 
 */

public class C 
{
	Scanner sc;
	BufferedReader in;
	PrintStream out;
	StringTokenizer tok;
	
	public C() throws NumberFormatException, IOException
	{
		//sc = new Scanner(System.in);
		//sc = new Scanner(new FileReader("in.txt"));
		in = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new FileReader("in.txt"));
		out = System.out;
		run();
	}
	void run() throws NumberFormatException, IOException
	{
		//Add your code here
		int[] array;
		int n = nextInt();
		array = new int[n];
		int max = 0;
		int pos = 0;
		for(int i = 0; i <n; i++)
		{
			int l = nextInt();
			if(l > max)
			{
				pos = i;
				max = l;
			}
			array[i] = l;
		}
		if(max == 1)array[pos] = 2;
		else array [pos] = 1;
		Arrays.sort(array);
		out.print(array[0]);
		for(int i = 1; i < n; i++)
			out.print(" " + array[i]);
		out.println();
	}
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		new C();
	}
	String nextToken() throws IOException
	{
		if(tok ==null || !tok.hasMoreTokens()) tok = new StringTokenizer(in.readLine());
		return tok.nextToken();
	}
	int nextInt() throws NumberFormatException, IOException
	{
		return Integer.parseInt(nextToken());
	}
	long nextLong() throws NumberFormatException, IOException
	{
		return Long.parseLong(nextToken());
	}
	double nextDouble() throws NumberFormatException, IOException
	{
		return Double.parseDouble(nextToken());
	}
}
