import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.Map.Entry;
 
 
public class  cf2{
	static int x0;
	static int y0;
	static int x1;
	static int y1;
	static HashMap<Integer,HashSet<Integer>>allowed;
	static HashMap<Integer,HashMap<Integer,Integer>>cost;
	static int []dx= {-1,-1,-1,0,0,0,1,1,1};
	static int []dy= {-1,0,1,-1,0,1,-1,0,1};
	static int highbound=(int)1e9;
	static boolean valid(int i,int j) {
		if(i>=1 && i<=highbound && j>=1 && j<=highbound && allowed.containsKey(i) && allowed.get(i).contains(j))return true;
		return false;
	}
	static long ans;
	static class Triple implements Comparable<Triple>
	{
		int i,j,cost;
		Triple(int x, int y, int z){i = x; j = y; cost = z;}
		
		public int compareTo(Triple t) {
			return this.cost - t.cost;
		}
		public String toString() {
			return i+" "+j+" "+cost;
		}
		
	}
	public static int dijkstra()
	{
		PriorityQueue<Triple> q = new PriorityQueue<Triple>();
		q.add(new Triple(x0,y0,0));
		HashMap<Integer,Integer>z=new HashMap<Integer,Integer>();z.put(y0,0);
		cost.put(x0,z);
		while(!q.isEmpty())
		{	
			Triple cur = q.remove();
			//if(cur.i==x1 && cur.j==y1)continue;
			if(cur.cost > cost.getOrDefault(cur.i,new HashMap<Integer,Integer>()).getOrDefault(cur.j,1000000000))
				continue;
			for(int k = 0; k < 9; k++)
			{
				int x = cur.i + dx[k];
				int y = cur.j + dy[k];
				int c=cost.getOrDefault(x,new HashMap<Integer,Integer>()).getOrDefault(y,1000000000);
				if(valid(x,y) && cur.cost +1 < c)
				{
					HashMap<Integer,Integer>zz=new HashMap<Integer,Integer>();zz.put(y,cur.cost+1);
					cost.put(x,zz);
					q.add(new Triple(x,y,cur.cost+1));
				}
			}
		}
		
		
		return cost.getOrDefault(x1,new HashMap<Integer,Integer>()).getOrDefault(y1,-1);
	}
	static int t;static int n;
	static int []ds;
	static int []gs;
	static int [][]memo;
	static int dp(int lastg,int msk,int sum) {
		if(sum==t)return 1;
		if(msk==(1<<n)-1) {
			return 0;
		}
		if(memo[lastg][msk]!=-1)return memo[lastg][msk];
		int tot=0;
		for(int i=0;i<n;i++) {
			if(((1<<i)&msk)==0 && gs[i]!=lastg) {
				tot=(tot+dp(gs[i],msk|(1<<i),sum+ds[i]))%(1000000007);
			}
		}
		return memo[lastg][msk]=tot;
	}
    public static void main(String[] args) throws IOException{
        MScanner sc = new MScanner(System.in);
        PrintWriter pw=new PrintWriter(System.out);
        n=sc.nextInt();
        t=sc.nextInt();
        ds=new int[n];gs=new int[n];
        for(int i=0;i<n;i++) {
        	ds[i]=sc.nextInt();gs[i]=sc.nextInt();
        }
        memo=new int[4][1<<n];
        for(int []i:memo)Arrays.fill(i,-1);
        pw.println(dp(0, 0,0));
        pw.flush();
    }
    static long gcd(long a, long b) {
 
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
    static int[]primes;
    static int sizeofp=0;
	static int[] isComposite;
 
	static void sieve(int N)	// O(N log log N) 
	{
		isComposite = new int[N+1];					
		isComposite[0] = isComposite[1] = 1;			
		primes = new int[N];
 
		for (int i = 2; i <= N; ++i) 					
			if (isComposite[i] == 0) 					
			{
				primes[sizeofp++]=i;;
				if(1l * i * i <= N)
					for (int j = i * i; j <= N; j += i)	
						isComposite[j] = 1;
			}   
	}
    static class pair implements Comparable<pair>{
    	int num;int idx;
    	pair(int x,int y){
    		num=x;idx=y;
    	}
		@Override
		public int compareTo(pair o) {
			if(num!=o.num) {
				return num-o.num;
			}
			return idx-o.idx;
		}
		 @Override
	       public int hashCode()
	       {
	           return Objects.hash(num,idx) ;
	       }
		public boolean equals(pair o) {
			if(this.compareTo(o)==0)return true;
			return false;
		}
		public String toString() {
			return "("+0+" "+0+")";
		}
    }
	static class MScanner 
	{
	    StringTokenizer st;
	    BufferedReader br;
 
	    public MScanner(InputStream s){    br = new BufferedReader(new InputStreamReader(s));}
 
	    public String next() throws IOException 
	    {
	        while (st == null || !st.hasMoreTokens()) 
	            st = new StringTokenizer(br.readLine());
	        return st.nextToken();
	    }
 
	    public int nextInt() throws IOException {return Integer.parseInt(next());}
	    
	    public long nextLong() throws IOException {return Long.parseLong(next());}
 
	    public String nextLine() throws IOException {return br.readLine();}
	    
	    public double nextDouble() throws IOException
	    {
	        String x = next();
	        StringBuilder sb = new StringBuilder("0");
	        double res = 0, f = 1;
	        boolean dec = false, neg = false;
	        int start = 0;
	        if(x.charAt(0) == '-')
	        {
	            neg = true;
	            start++;
	        }
	        for(int i = start; i < x.length(); i++)
	            if(x.charAt(i) == '.')
	            {
	                res = Long.parseLong(sb.toString());
	                sb = new StringBuilder("0");
	                dec = true;
	            }
	            else
	            {
	                sb.append(x.charAt(i));
	                if(dec)
	                    f *= 10;
	            }
	        res += Long.parseLong(sb.toString()) / f;
	        return res * (neg?-1:1);
	    }
	    
	    public boolean ready() throws IOException {return br.ready();}
 
 
	}
}