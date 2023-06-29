import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.io.IOException;
import java.io.BufferedReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class p3
{
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader()
		{
				br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next()
		{
				while (st == null || !st.hasMoreElements()) {
						try {
								st = new StringTokenizer(br.readLine());
						}
						catch (IOException e) {
								e.printStackTrace();
						}
				}
				return st.nextToken();
		}

		int nextInt() { return Integer.parseInt(next()); }

		byte nextByte() { return Byte.parseByte(next()); }

		short nextShort() { return Short.parseShort(next()); }

		long nextLong() { return Long.parseLong(next()); }

		double nextDouble()	{	return Double.parseDouble(next());	}

		String nextLine()
		{
				String str = "";
				try {
						str = br.readLine();
				}
				catch (IOException e) {
						e.printStackTrace();
				}
				return str;
		}
	}

	public static void main(String[] args)
	{
		FastReader fr=new FastReader();

		byte t=fr.nextByte();
		while(t-->0)
		{
			short n=fr.nextShort();
			short a[]=new short [n];
			for (short i=-1;++i<n;)
				a[i]=fr.nextShort();
			
			String s="1";
			System.out.println(s);

			for(short i=0;++i<n;)
			{
				if(a[i]==1)
				{
					s+=".1";
					System.out.println(s);
				}
				else if(a[i]==a[i-1]+1)
				{
					int c=s.lastIndexOf(".");
					s=s.substring(0,c+1)+a[i];
					System.out.println(s);
				}
				else
				{					
					for(;;)
					{
						s=s.substring(0,s.lastIndexOf("."));
						int c=s.lastIndexOf(".");

						int b=Integer.parseInt(s.substring(c+1,s.length()));
						if(b+1==a[i])
						{
							s=s.substring(0,c+1)+a[i];
							System.out.println(s);
							break;
						}
					}
				}
			}
		}
	}
}