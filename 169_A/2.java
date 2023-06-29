import java.util.*;
import java.io.*;

public class Chores
{
	public static void main(String args[])throws IOException 
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader  br = new BufferedReader(isr);
		String[] line = br.readLine().split("\\W");

		int n = Integer.parseInt(line[0]);
		int a = Integer.parseInt(line[1]);
		int b = Integer.parseInt(line[2]);

		int[] num = new int[n];
		line = br.readLine().split("\\W");

		for(int i=0;i<n;i++) num[i] = Integer.parseInt(line[i]);

		Arrays.sort(num);
		
		System.out.println(num[b]-num[b-1]);
	}	
}
		

