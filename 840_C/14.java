import java.io.*;
import java.util.*;
import java.math.*;
import java.util.concurrent.*;

public final class on_the_bench
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static FastScanner sc=new FastScanner(br);
    static PrintWriter out=new PrintWriter(System.out);
	static Random rnd=new Random();
	static int[] parent,size;
	static int maxn=(int)500;
	static long mod=(long)(1e9+7);
	static int[] fact,inv_fact;
	
	static int getParent(int u)
	{
		if(u==parent[u])
		{
			return u;
		}
		
		else
		{
			int val=getParent(parent[u]);parent[u]=val;
			
			return val;
		}
	}
	
	static void merge(int u,int v)
	{
		int x=getParent(u),y=getParent(v);
		
		if(x!=y)
		{
			parent[y]=x;
			
			size[x]+=size[y];size[y]=0;
		}
	}
	
	static int add(long a,long b)
	{
		long ret=a+b;
		
		if(ret>=mod)
		{
			ret%=mod;
		}
		
		return (int)ret;
	}
	
	static int mul(long a,long b)
	{
		long ret=a*b;
		
		if(ret>=mod)
		{
			ret%=mod;
		}
		
		return (int)ret;
	}
	
	static int pow(long a,long b)
	{
		long x=1,y=a;
		
		while(b>0)
		{	
			if(b%2==1)
			{
				x=mul(x,y);
			}
			
			y=mul(y,y);b=b/2;
		}
		
		return (int)(x%mod);
	}
	
	static void build()
	{
		fact=new int[maxn];inv_fact=new int[maxn];fact[0]=1;

		for(int i=1;i<maxn;i++)
		{
			fact[i]=mul(fact[i-1],i);
		}

		inv_fact[maxn-1]=pow(fact[maxn-1],mod-2);

		for(int i=maxn-2;i>=0;i--)
		{
			inv_fact[i]=mul(inv_fact[i+1],(i+1));
		}
	}
	
	static int[] mul_poly(int[] a,int[] b,int deg1,int deg2)
	{	
		int[] ret=new int[deg1+deg2+1];
		
		for(int i=0;i<=deg1;i++)
		{
			for(int j=0;j<=deg2;j++)
			{
				int curr=mul(a[i],b[j]);
				
				ret[i+j]=add(ret[i+j],curr);
			}
		}
		
		return ret;
	}
	
	static int C(int n,int r)
	{
		if(n-r<0 || Math.min(n,r)<0)
		{
			return 0;
		}
		
		int val1=fact[n],val2=inv_fact[r],val3=inv_fact[n-r];
		
		int mul=mul(val2,val3);
		
		return mul(val1,mul);
	}
	
    public static void main(String args[]) throws Exception
    {
		int n=sc.nextInt();build();
		
		int[] a=new int[n];parent=new int[n];size=new int[n];
		
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
			
			parent[i]=i;
			
			size[i]=1;
		}
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				long curr=a[i]*1L*a[j],now=(long)Math.sqrt(curr);
				
				if(now*now==curr)
				{
					merge(i,j);
				}
			}
		}
		
		List<Integer> list=new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			if(getParent(i)==i)
			{
				list.add(size[i]);
			}
		}
		
	//	out.println(list);
		
		int res=0;int[] poly=new int[1];poly[0]=1;
		
		for(int i=0;i<list.size();i++)
		{
			int size=list.get(i);
			
			int[] arr=new int[size];arr[0]=1;
			
			for(int j=1;j<size;j++)
			{
				int now1=C(size,j),now2=mul(fact[size-1],inv_fact[size-1-j]);
				
				int qq=mul(now1,now2);
				
				arr[j]=qq;
			}
			
			poly=mul_poly(poly,arr,poly.length-1,size-1);
		}
		
		for(int i=1,x=1;i<poly.length;i++,x*=-1)
		{
			int now=add(x,mod);
			
			int curr=mul(fact[n-i],poly[i]);
			
			curr=mul(curr,now);
			
			res=add(res,curr);
		}
		
	//	out.println(res);
		
		int zz=mul(res,mod-1);res=add(fact[n],zz);
		
		out.println(res);out.close();
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