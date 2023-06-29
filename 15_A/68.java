import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Scanner;


public class A
{

	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int t=in.nextInt();
		pt[] P=new pt[n];
		for (int i=0; i<n; ++i)
			P[i]=new pt(in.nextInt(), in.nextInt());
		Arrays.sort(P);
		int res=2;
		for (int i=0; i+1<n; ++i)
		{
			double d=P[i+1].x-P[i].x-P[i+1].a/2.-P[i].a/2.;
			if (Math.abs(d-t) <= 1e-11)
				++res;
			else if (d>t)
				res+=2;
		}
		System.out.println(res);
	}

	
}

class pt implements Comparable<pt>
{
	int x,a;
	pt(int x, int a)
	{
		this.x=x;
		this.a=a;
	}
	
	public int compareTo(pt o)
	{
		return x-o.x;
	}
}