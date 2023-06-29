import java.io.*;
import java.math.*;
import java.util.*;


public class Main {


	public static class pair implements Comparable<pair>
	{
		int a;
		int b;
		public pair(int pa, int pb)
		{
			a = pa; b= pb;
		}
		@Override
		public int compareTo(pair o) {
			if(this.a < o.a)
				return -1;
			if(this.a > o.a)
				return 1;
			return Integer.compare(o.b, this.b);
		}
	}


	//int n = Integer.parseInt(in.readLine());
	//int n = Integer.parseInt(spl[0]);
	//String[] spl = in.readLine().split(" ");
		
	public static void main (String[] args) throws Exception
	{	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] spl = in.readLine().split(" ");
		long l = Long.parseLong(spl[0]);
		long r = Long.parseLong(spl[1]);
		if(l+2 <= r && l%2==0)
		{
			System.out.println(l+" "+(l+1)+" "+(l+2));
		}
		else if(l+3<=r && (l+1)%2==0)
		{
			System.out.println((l+1)+" "+(l+2)+" "+(l+3));
		}
		else System.out.println(-1);
	}

}