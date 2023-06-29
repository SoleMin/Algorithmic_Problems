import java.util.*;

public class A
{
	public static void main(String args[])
	{
		boolean[] b = new boolean[11000];
		Arrays.fill(b, true);
		b[0] = b[1] = false;

		for(int i=2;i < b.length;i++)
		{
			if(!b[i])
				continue;

			for(int j=2;i*j<b.length;j++)
				b[i*j] = false;
		}

		int[] p = new int[11000];
		int pn = 0;

		for(int i=0;i < b.length;i++)
		{
			if(b[i])
				p[pn++] = i;
		}

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int k = scan.nextInt();

		int rtn = 0;

		
		for(int j=0;p[j] <= n;j++)
		{
			//Try to make sum
			for(int h=0;h <= j;h++)
			{
				if(p[h] + p[h+1] + 1 == p[j])
				{
					rtn++;
					break;
				}
			}
		}

		System.out.println(rtn >= k ? "YES" : "NO");
		

	}
}