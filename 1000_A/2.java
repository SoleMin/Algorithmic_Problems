import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
 
public class temp
{
	
	void solve()
	{
		FastReader sc =new FastReader();
		int n = sc.nextInt();
		
		ArrayList<String> a[] = new ArrayList[5];
		
		for(int i=0;i<=4;i++)
			a[i] = new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			String s = sc.next();
			a[s.length()].add(s);
		}
		
		int ans = 0;
		
		for(int i=0;i<n;i++)
		{
			String s = sc.next();
			if(a[s.length()].contains(s))
				a[s.length()].remove(new String(s));
		}
		
		for(int i=1;i<=4;i++)
			ans+=a[i].size();
		
		System.out.println(ans);
	}
 
    public static void main(String[] args)
    {
        new temp().solve();
    }
	
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
} 