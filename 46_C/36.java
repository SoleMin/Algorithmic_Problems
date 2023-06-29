import java.io.*;
import java.util.*;


public class HamstersAndTigers
{
	Scanner in;
	PrintWriter out;
	
	HamstersAndTigers()
	{
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
	}
	
	HamstersAndTigers(String i, String o) throws FileNotFoundException
	{
		in = new Scanner(new File(i));
		out = new PrintWriter(new File(o));
	}
	
	public void finalize()
	{
		out.flush();
		in.close();
		out.close();
	}
	
	void solve()
	{
		int i = 0,
			h = 0,
			n = in.nextInt();
		
		String buf = "";
		char[] ht = in.next().toCharArray();
		
		for(i = 0; i < n; ++i)
			if(ht[i] == 'H')
				++h;
		
		for(i = 0; i < h; ++i)
			buf += 'H';
		
		for(i = 0; i < n - h; ++i)
			buf += 'T';
		
		int diff = (1 << 28);
		for(i = 0; i < n; ++i)
		{
			int tmp = 0;
			
			for(int j = 0; j < n; ++j)
				if(buf.charAt(j) != ht[(i + j) % n])
					++tmp;
			
			diff = Math.min(tmp, diff);
		}
		
		out.println(diff / 2);
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		HamstersAndTigers t = new HamstersAndTigers();
		t.solve();
		t.finalize();
	}
}

