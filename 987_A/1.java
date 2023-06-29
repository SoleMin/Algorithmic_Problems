
import java.io.*;
import java.util.*;
public class Tempelate
{
    static PrintWriter out=new PrintWriter((System.out));
    public static void main(String args[])throws IOException
    {
        Reader sc=new Reader();
//        int t=sc.nextInt();
//        while(t-->0)
//        {
//            solve();
//        }
        solve();
	out.close();
    }

    public static void solve()
    {
       Reader sc = new Reader();
       HashMap<String,String> hm = new HashMap<>();
       hm.put("purple","Power");
       hm.put("green","Time");
       hm.put("blue","Space");
       hm.put("orange","Soul");
       hm.put("red","Reality");
       hm.put("yellow","Mind");
       int n =sc.nextInt();
       String[] st = new String[n];
       for(int i =0;i<n;i++)
       {
    	   st[i] = sc.next();
       }
       for(String i : st)
       {
    	   if(hm.containsKey(i))
    		   hm.remove(i);
       }
       System.out.println(hm.size());
       for (Map.Entry<String, String> set : hm.entrySet()) {
		    System.out.println(set.getValue());
		}
    }
    
    static class Reader 
    { 
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        public String next()
        {
            while(!st.hasMoreTokens())
            {
                try
                {
                    st=new StringTokenizer(br.readLine());
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        public int nextInt()
        {
            return Integer.parseInt(next());
        }
        public long nextLong()
        {
            return Long.parseLong(next());
        }
        public double nextDouble()
        {
            return Double.parseDouble(next());
        }
        public String nextLine()
        {
            try
            {
                return br.readLine();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
        public boolean hasNext()
        {
            String next=null;
            try
            {
                next=br.readLine();
            }
            catch(Exception e)
            {
            }
            if(next==null)
            {
                return false;
            }
            st=new StringTokenizer(next);
            return true;
        }
    } 
}