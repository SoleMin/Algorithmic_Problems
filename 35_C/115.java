

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FireAgain 
{

	public static void main(String[] args) throws IOException 
	{

	      FileInputStream in = null;
	      FileOutputStream out = null;
	
	      try 
	      {
	         in = new FileInputStream("input.txt");
	         out = new FileOutputStream("output.txt");
	         
		  		Scanner sc = new Scanner(in);

	      
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		int k = sc.nextInt();
		
		int[] xk = new int[k];
		int[] yk = new int[k];
		
		for(int i = 0; i < k; i++)
		{
			int y = sc.nextInt()-1;
			int x = sc.nextInt()-1;
			
			xk[i] = x;
			yk[i] = y;
		}

		int best = -1;
		int bestx = -1;
		int besty = -1;
		for(int x = 0; x < w; x++)
		{
			for(int y = 0; y < h; y++)
			{
				int cur = 99999;
				for(int f = 0; f < k; f++)
				{
					cur = Math.min(cur, Math.abs(xk[f] - x)+Math.abs(yk[f] - y));
				}
				
				if(cur > best)
				{
					best = cur;
					bestx = x;
					besty = y;
				}
			}
		}
		
//		System.out.println((besty+1) + " " + (bestx+1));
		String s = (besty+1) + " " + (bestx+1);

		out.write(s.getBytes());
		
	      }finally 
	      {
	         if (in != null) 
	         {
	            in.close();
	         }
	         if (out != null) 
	         {
	            out.close();
	         }
	      }		
	}

}
