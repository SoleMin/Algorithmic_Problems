import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in/*new File("input.txt")*/);
		int n = sc.nextInt(), t = sc.nextInt(), x, a, kol = 2;
		ArrayList<Double> al = new ArrayList<Double>();
		for(int i=0;i<n;i++)
		{
			x = sc.nextInt();
			a = sc.nextInt();
			al.add(x - a/2.);
			al.add(x + a/2.);	
		}
		Collections.sort(al);
		double d0 = 0; int k = 0, kn = al.size();
		for(Double d: al)
		{
			if (k == 2)
			{
				if (d-d0>t) kol+=2; else
				if (d-d0==t) kol++;
				d0 = d;
				k = 1;		
			} else 
			{
				k++;
				d0 = d;
			}			
		} 
		System.out.print(kol);
	}
}