import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Berland{
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		new Berland().run();
	}
	
	public void run() throws NumberFormatException, IOException
	{
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(file.readLine());
		long[] cutoff = new long[13];
		cutoff[0] = 0;
		for(int i = 1;i<=12;i++)
		{
			cutoff[i] = cutoff[i-1] + (long)(9*Math.pow(10,i-1))*i;
		}
		int dig = -1;
		for(int i = 0;i<12;i++)
		{
			if(cutoff[i]>=N)
			{
				dig = i;
				break;
			}
		}
		long sub = N - cutoff[dig-1]-1;
		long num = (sub)/dig;
		long number = (long)Math.pow(10,dig-1)+num;
		int pos = (int)(sub % dig);
		System.out.println((number+"").charAt(pos));
	}	
}
