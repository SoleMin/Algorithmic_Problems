
import java.io.*;
import java.util.*;

public class CottageVillage
{
	public Scanner in = new Scanner(System.in);
	public PrintStream out = System.out;

	public int n, t;
	public Pair[] v;
	
	public void main()
	{
		n = in.nextInt();
		t = in.nextInt();
		
		int i;
		v = new Pair[n];
		for(i=0;i<n;++i) v[i] = new Pair(in.nextInt() * 2, in.nextInt());
		
		Arrays.sort(v);
		
		int res = 2;
		for(i=0;i+1<n;++i)
		{
			if(v[i].x + v[i].y + 2*t == v[i+1].x - v[i+1].y) ++res;
			else if(v[i].x+v[i].y+2*t < v[i+1].x-v[i+1].y) res +=2;
		}
		
		out.println(res);
	}//end public void main()

	//int pair
	private class Pair implements Comparable<Pair>
	{
		public int x, y;
		public Pair(int xx, int yy) { x = xx; y = yy; }

		public int compareTo(Pair u)
		{
			if(x!=u.x) return x-u.x;
			return y-u.y;
		}

		public String toString() { return "(" + x + "," + y + ")"; }
	}
	
	public static void main(String[] args)
	{
		(new CottageVillage()).main();
	}
}