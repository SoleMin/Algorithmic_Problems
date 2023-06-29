import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;


public class B
{
	BufferedReader in;
	PrintStream out;
	StringTokenizer tok;
	public B() throws NumberFormatException, IOException
	{
		in = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new FileReader("in.txt"));
		out = System.out;
		run();
	}
	void run() throws NumberFormatException, IOException
	{
		int n = nextInt();
		int k = nextInt();
		int[] num = new int[n];
		for(int i = 0; i < n; i++)
			num[i] = nextInt();
		int[] cant = new int[100001];
		int cnt = 0;
		int r = 0;
		for(; r < n; r++)
		{
			if(cant[num[r]]==0)cnt++;
			cant[num[r]]++;
			if(cnt==k) break;
		}
		if(cnt<k)
		{
			out.println("-1 -1");
			return;
		}
		int l = 0;
		for(; l < r; l++)
		{
			cant[num[l]]--;
			if(cant[num[l]]==0)cnt--;
			if(cnt<k) break;
		}
		out.println((l+1)+" "+(r+1));
	}
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		new B();
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
