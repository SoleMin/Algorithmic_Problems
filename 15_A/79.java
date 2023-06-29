import java.io.*;
import java.util.*;


public class CottageVillage
{
	Scanner in;
	PrintWriter out;
	
	CottageVillage()
	{
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
	}
	
	public void finalize()
	{
		out.flush();
		in.close();
		out.close();
	}
	
	int ans(House a, House b, int t)
	{
		int diff = b.cordl - a.cordr;
		
		if(diff < t) return 0;
		if(diff == t) return 1;
		return 2;
	}
	
	void solve()
	{
		int
			n = in.nextInt(),
			t = in.nextInt() * 2;
		House[] hs = new House[n];
		
		for(int i = 0; i < n; ++i)
		{
			int
				c = in.nextInt(),
				l = in.nextInt();
			hs[i] = new House(2 * c - l, 2 * c + l);
		}
		
		Arrays.sort(hs);
		
		//atleast 2 possible configs
		int co = 2;
		for(int i = 0; i < n - 1; ++i)
			co += ans(hs[i], hs[i + 1], t);
		
		out.println(co);
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		CottageVillage t = new CottageVillage();
		t.solve();
		t.finalize();
	}
}

class House implements Comparable<House>
{
	public int cordl, cordr;
	
	public House(int c, int l)
	{
		cordl = c;
		cordr = l;
	}
	
	@Override
	public int compareTo(House h)
	{
		return cordl - h.cordl;
	}
}

