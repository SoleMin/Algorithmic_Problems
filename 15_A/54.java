import java.util.*;
import java.awt.*;

public class A
{
	static Comparator<Point> cmp = new Comparator<Point>()
	{
		public int compare(Point a, Point b)
		{
			if(a.x < b.x)
				return -1;
			else if(a.x > b.x)
				return 1;

			return 0;
		}
	};

	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);

		while(scan.hasNextInt())
		{

		int n = scan.nextInt();
		int k = scan.nextInt();

		Point[] a = new Point[n];

		for(int i=0;i < n;i++)
		{
			a[i] = new Point();
			a[i].x = scan.nextInt();
			a[i].y = scan.nextInt();
		}

		Arrays.sort(a, cmp);

		int rtn = 0;

		ArrayList<Double> ans = new ArrayList<Double>();

		for(int i=0;i < n;i++)
		{
			//Left
			double lb = a[i].x - (a[i].y / 2.0) - k;
			double pos = lb + (k/2.0);
			boolean good = true;

			for(int j=0;j < ans.size();j++)
				if(Math.abs(ans.get(j) - pos) < 0.0000001)
					good = false;


			if(good && (i == 0 || a[i-1].x + (a[i-1].y / 2.0) <= lb))
			{
				rtn++;
				ans.add(pos);
			}

			double rb = a[i].x + (a[i].y / 2.0) + k;
			pos = rb - (k/2.0);
			good = true;

			for(int j=0;j < ans.size();j++)
				if(Math.abs(ans.get(j) - pos) < 0.0000001)
					good = false;

			if(good && (i == n-1 || a[i+1].x - (a[i+1].y / 2.0) >= rb))
			{
				rtn++;
				ans.add(pos);
			}
		}

		System.out.println(rtn);
		}
	}
}