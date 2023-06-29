import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class A
{
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);

		System.out.println(rec(in.nextLong(), in.nextLong()));

	}

	private static long rec(long a, long b)
	{
		return b == 0 ? 0 : a/b + rec(b, a%b);
	}

}
