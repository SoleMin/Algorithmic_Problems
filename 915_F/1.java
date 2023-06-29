import java.io.*;
import java.util.*;
import java.math.*;
import java.util.concurrent.*;

public final class imbalance_value
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static FastScanner sc=new FastScanner(br);
    static PrintWriter out=new PrintWriter(System.out);
	static Random rnd=new Random();
	static int[] parent,size;
	
	static int getParent(int u)
	{
		if(parent[u]==u)
		{
			return u;
		}
		
		else
		{
			int val=getParent(parent[u]);
			
			parent[u]=val;return val;
		}
	}
	
	static void merge(int u,int v)
	{
		parent[v]=u;
		
		size[u]+=size[v];
		
		size[v]=0;
	}
	
    public static void main(String args[]) throws Exception
    {
		int n=sc.nextInt();int[] a=new int[n];
		
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		
		List<Pair> list1=new ArrayList<>(),list2=new ArrayList<>();
		
		for(int i=1;i<n;i++)
		{
			int u=sc.nextInt()-1,v=sc.nextInt()-1;
			
			int max=Math.max(a[u],a[v]),min=Math.min(a[u],a[v]);
			
			list1.add(new Pair(u,v,max));list2.add(new Pair(u,v,min));
		}
		
		Collections.sort(list1);Collections.sort(list2);
		
		parent=new int[n];size=new int[n];
		
		for(int i=0;i<n;i++)
		{
			parent[i]=i;
			
			size[i]=1;
		}
		
		long sum1=0,sum2=0;
		
		for(int i=0;i<list1.size();i++)
		{
			int u=list1.get(i).u,v=list1.get(i).v;
			
			long val=list1.get(i).val;
			
			int x=getParent(u),y=getParent(v);
			
			long val1=size[x],val2=size[y];
			
			long mul=(val1*val2);
			
			mul=mul*val;
			
			sum1=sum1+mul;
			
			merge(x,y);
		}
		
		for(int i=0;i<n;i++)
		{
			parent[i]=i;
			
			size[i]=1;
		}
		
		for(int i=list2.size()-1;i>=0;i--)
		{
			int u=list2.get(i).u,v=list2.get(i).v;
			
			long val=list2.get(i).val;
			
			int x=getParent(u),y=getParent(v);
			
			long val1=size[x],val2=size[y];
			
			long mul=(val1*val2);
			
			mul=mul*val;
			
			sum2=sum2+mul;
			
			merge(x,y);
		}
		
		long res=sum1-sum2;
		
		//out.println(sum1+" "+sum2);
		
		out.println(sum1-sum2);out.close();
    }
	
	private static class Pair implements Comparable<Pair>
	{
		int u,v,val;
		
		public Pair(int u,int v,int val)
		{
			this.u=u;this.v=v;this.val=val;
		}
		
		public int compareTo(Pair x)
		{
			return Integer.compare(this.val,x.val);
		}
	}
}
class FastScanner
{
    BufferedReader in;
    StringTokenizer st;

    public FastScanner(BufferedReader in) {
        this.in = in;
    }
	
    public String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
	
	public String next() throws Exception {
		return nextToken().toString();
	}
	
    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
}