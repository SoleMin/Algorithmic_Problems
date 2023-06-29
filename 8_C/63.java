
import java.io.*;
import java.util.*;

public class LookingForOrder
{
	public Scanner in = new Scanner(System.in);
	public PrintStream out = System.out;

	public int[] go;
	public int[][] cost;
	
	public int [] sol;
	public Pair[] how;
	public int n, lim;
	
	public Pair bag;
	public Pair[] obj;
	
	public void main()
	{		
		bag = new Pair(in.nextInt(), in.nextInt());
		
		n = in.nextInt();
		obj = new Pair[n];
		for(int i=0;i<n;++i) obj[i] = new Pair(in.nextInt(), in.nextInt());
		
		go = new int[n];
		cost = new int[n][n];
		for(int i=0;i<n;++i)
		{
			go[i] = squDist(bag, obj[i]);
			for(int j=0;j<n;++j) cost[i][j] = squDist(obj[i], obj[j]);
		}
		
		lim = (1<<n);
		
		sol = new int[lim];
		Arrays.fill(sol, -1);
		how = new Pair[lim];
		
		out.println(solve(lim-1));
		
		Pair T;
		int set = lim-1;
		
		out.print("0");
		while(set > 0)
		{
			solve(set);
			T = how[set];
			out.print(" "+(T.x+1));
			set = off(T.x, set);
			if(T.y >= 0) 
			{
				out.print(" " + (T.y+1));
				set = off(T.y, set);
			}
			out.print(" 0");
		}
		out.println();
	}//end public void main()

	public int oo = 987654321;
	
	public boolean in(int x, int set) { return ((1<<x) & set) != 0; }
	//Turn on bit x
	public int on(int x, int set) { return (set | (1<<x)); }
	//Turn off bit x
	public int off(int x, int set) { return (set ^ (set & (1<<x)) ); }
    
	
	public int solve(int set)
	{
		if(sol[set] >= 0) return sol[set];
		
		int ret;
		if(set == 0) ret = 0;
		else
		{
			ret = oo;
			
			int x, y, sub, c;
			for(x=0;x<n;++x) if(in(x, set)) break;
			
			sub = off(x, set);
			c =  go[x]+go[x]+solve(sub);
			
			if(c < ret)
			{
				how[set] = new Pair(x, -1);
				ret = c;
			}
			
			for(y=x+1;y<n;++y) if(in(y, set))
			{
				c = go[x]+cost[x][y]+go[y] + solve(off(y, sub));
				if(c < ret)
				{
					ret = c;
					how[set] = new Pair(x, y);
				}
			}
		}
		
		return sol[set] = ret;
	}
	
	public int squDist(int ax, int ay, int bx, int by)
	{
		int dx, dy;
		dx = ax - bx; 
		dy = ay - by;
		return dx*dx + dy*dy;
	}
	
	public int squDist(Pair p, Pair q)
	{
		return squDist(p.x, p.y, q.x, q.y);
	}
	
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
		(new LookingForOrder()).main();
	}
}