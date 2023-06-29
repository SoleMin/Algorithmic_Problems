import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main 
{
	static ArrayList<Integer> Unique(ArrayList<Integer> x)
	{
		TreeSet<Integer> tmp=new TreeSet<Integer>();
		tmp.addAll(x);
		x.clear();
		x.addAll(tmp);
		return x;
	}
	public static void main(String[] args) 
	{
		InputReader in = new InputReader();
//		Scanner in=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while(in.hasNext())
		{
			long n=in.nextLong();
			out.println("25");
		}
		out.close();
	}
}

class node
{
	ArrayList<Integer> v=new ArrayList<Integer>();
	node(){}
	void push(Integer a)
	{
		v.add(a);
	}
}

class InputReader 
{
	BufferedReader buf;
	StringTokenizer tok;
	InputReader() 
	{
		buf = new BufferedReader(new InputStreamReader(System.in));
	}

	boolean hasNext() 
	{
		while (tok == null || !tok.hasMoreElements()) 
		{
			try 
			{
				tok = new StringTokenizer(buf.readLine());
			} 
			catch (Exception e) 
			{
				return false;
			}
		}
		return true;
	}

	String next() 
	{
		if (hasNext())
			return tok.nextToken();
		return null;
	}

	int nextInt() 
	{
		return Integer.parseInt(next());
	}

	long nextLong() 
	{
		return Long.parseLong(next());
	}

	double nextDouble() 
	{
		return Double.parseDouble(next());
	}

	BigInteger nextBigInteger() 
	{
		return new BigInteger(next());
	}

	BigDecimal nextBigDecimal() 
	{
		return new BigDecimal(next());
	}
}