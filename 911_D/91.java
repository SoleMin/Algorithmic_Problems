/* 
 * UMANG PANCHAL
 * DAIICT
 */
import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main
{
 
	static LinkedList<Integer> adj[];
	static ArrayList<Integer> adj1[];
	static int[] color,visited1;
	static boolean b[],visited[],possible;
	static int level[];
	static Map<Integer,HashSet<Integer>> s;
	static int totalnodes,colored;
	static int count[];
	static long sum[];
	static int nodes;
	static double ans=0;
	static long[] as=new long[10001];
	static long c1=0,c2=0;
	static int[] a,d,k;
	static int max=100000000;
	static long MOD = (long)1e9 + 7,sm=0,m=Long.MIN_VALUE;
	static boolean[] prime=new boolean[1000005];
	static int[] levl;
    static int[] eat;
    static int price[];
    static int size[],res[],par[];
    static int result=0;
	// --------------------My Code Starts Here----------------------
	
	public static void main(String[] args) throws IOException
	{
		in=new InputReader(System.in);
		w=new PrintWriter(System.out);
		 int n=ni();
		 int[] a=na(n);
		 int ans=0;
		 for(int i=0;i<n;i++)
		 {
			 for(int j=i+1;j<n;j++)
			 {
				 if(a[j]<a[i])
					 ans++;
			 }
		 }
		 int m=ni();
		 ans=ans%2;
		 while(m-->0)
		 {
			 int l=ni(),r=ni();
			 int range=r-l+1;
			 range=range*(range-1)/2;
			 range=range%2;
			 ans=(ans+range)%2;
			 if(ans==1)
				 w.println("odd");
			 else
				 w.println("even");
		 }
       w.close();
    }
	
	
	
	public static long nCrModp(long n, long r, long p)
	{
	    
	    long[] C=new long[(int)r+1];
	    
	 
	    C[0] = 1; 
	    
	    for (long i = 1; i <= n; i++)
	    {
	        
	        for (long j = Math.min(i, r); j > 0; j--)
	 
	            
	            C[(int)j] = (C[(int)j] + C[(int)(j-1)])%p;
	    }
	    return C[(int)r];
	}
	public static long nCr(long n, long r)
	{
		long x=1;
		for(long i=n;i>=n-r+1;i--)
			x=((x)*(i));
		for(long i=r;i>=1;i--)
			x=((x)/(i));
		
		return x%MOD;
	}
	public static long nCrModpDP(long n, long r, long p)
	{
	
	    long[] C=new long[(int)r+1];
	 
	    C[0] = 1; 
	 
	 
	    for (long i = 1; i <= n; i++)
	    {
	        for (int j = (int)Math.min(i, r); j > 0; j--)
	           C[j] = (C[j] + C[j-1])%p;
	    }
	    return C[(int)r];
	}

	public static long nCrModpLucas(long n,long r, long p)
	{
	  
	   if (r==0)
	      return 1;
	 
	   long ni = n%p, ri = r%p;
	
	   return (nCrModpLucas(n/p,r/p, p) * nCrModpDP(ni,ri, p)) % p;  
	}
	
	 public static void buildgraph(int n){
         adj=new LinkedList[n+1];
         visited=new boolean[n+1];
         levl=new int[n+1];
         par=new int[n+1];
         for(int i=0;i<=n;i++){
             adj[i]=new LinkedList<Integer>();
         
         }


     }
	public static int getSum(long BITree[], int index)
	{
	    int sum = 0;
	    
	    while (index > 0)
	    {
	        sum += BITree[index];
	        index -= index & (-index);
	    }
	    return sum;
	}
	
	public static long[] updateBIT(long BITree[], int n, int index, int val)
	{
	    while (index <= n)
	    {
	       BITree[index] += val;
	       index += index & (-index);
	    }
	    return BITree;
	}
	

	
	public static boolean isPrime(int n)
	{
	    // Corner cases
	    if (n <= 1)  return false;
	    if (n <= 3)  return true;
	 
	    // This is checked so that we can skip 
	    // middle five numbers in below loop
	    if (n%2 == 0 || n%3 == 0)
	    	return false;
	 
	    for (int i=5; i*i<=n; i=i+6)
	        if (n%i == 0 || n%(i+2) == 0)
	           return false;
	 
	    return true;
	}
	
	// --------------------My Code Ends Here------------------------
	
	public static String ns()
	{
		return in.nextLine();
	}
	public static int ni()
	{
		return in.nextInt();
	}
	public static long nl()
	{
		return in.nextLong();
	}
	public static int[] na(int n)
	{
		a=new int[n];
		for(int i=0;i<n;i++)
		a[i]=ni();
		return a;
	}
	public static void sieveOfEratosthenes()
	    {
	       int n=prime.length;
	        for(int i=0;i<n;i++)
	            prime[i] = true;
	         
	        for(int p = 2; p*p <=n; p++)
	        {
	            if(prime[p] == true)
	            {
	                for(int i = p*2; i <n; i += p)
	                    prime[i] = false;
	            }
	        }
	    }

	public static boolean printDivisors(long n)
    {
		long ans=0;
        for (int i=1; i<=Math.sqrt(n); i++)
        {
            if (n%i==0)
            {
                if (n/i == i)
                    ans++;
                else 
                {
                	ans=ans+2;
                }
            }
            if(ans>3)
            	break;
        }
        if(ans==3)
        	return true;
        else
        	return false;
    }

  public static void dfs(int i)
  {
	  visited[i]=true;
	  for(int j:adj[i])
	  {
		  if(!visited[j])
			  {
			  dfs(j);
			  nodes++;
			  }
	  }
	  
  }
  public static String rev(String s)
	{
		StringBuilder sb=new StringBuilder(s);
		sb.reverse();
		return sb.toString();
	}
	static long lcm(long a, long b)
	{
	    return a * (b / gcd(a, b));
	}
	static long gcd(long a, long b)
	{
	    while (b > 0)
	    {
	        long temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}
	static InputReader in;
	static PrintWriter w;
static class InputReader 
{
 
private final InputStream stream;
private final byte[] buf = new byte[8192];
private int curChar, snumChars;
private SpaceCharFilter filter;
 
public InputReader(InputStream stream)
{
  this.stream = stream;
}
 
public int snext()
{
  if (snumChars == -1)
    throw new InputMismatchException();
  if (curChar >= snumChars)
  {
    curChar = 0;
    try 
    {
      snumChars = stream.read(buf);
    }
    catch (IOException e)
    {
      throw new InputMismatchException();
    }
    if (snumChars <= 0)
      return -1;
  }
  return buf[curChar++];
}
 
public int nextInt() 
{
  int c = snext();
  while (isSpaceChar(c)) 
  {
    c = snext();
  }
  int sgn = 1;
  if (c == '-')
  {
    sgn = -1;
    c = snext();
  }
  int res = 0;
  do
  {
    if (c < '0' || c > '9')
      throw new InputMismatchException();
    res *= 10;
    res += c - '0';
    c = snext();
  }
  while (!isSpaceChar(c));
  return res * sgn;
}
 
public long nextLong() 
{
  int c = snext();
  while (isSpaceChar(c)) 
  {
    c = snext();
  }
  int sgn = 1;
  if (c == '-')
  {
    sgn = -1;
    c = snext();
  }
  long res = 0;
  do
  {
    if (c < '0' || c > '9')
      throw new InputMismatchException();
    res *= 10;
    res += c - '0';
    c = snext();
  }
  while (!isSpaceChar(c));
  return res * sgn;
}	    
public String readString() 
{
  int c = snext();
  while (isSpaceChar(c)) 
  {
    c = snext();
  }
  StringBuilder res = new StringBuilder();
  do
  {
    res.appendCodePoint(c);
    c = snext();
  }
  while (!isSpaceChar(c));
  return res.toString();
}
 
public String nextLine() 
{
  int c = snext();
  while (isSpaceChar(c))
    c = snext();
  StringBuilder res = new StringBuilder();
  do
  {
    res.appendCodePoint(c);
    c = snext();
  }
  while (!isEndOfLine(c));
  return res.toString();
}
 
public boolean isSpaceChar(int c)
{
  if (filter != null)
    return filter.isSpaceChar(c);
  return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
}
 
private boolean isEndOfLine(int c) 
{
  return c == '\n' || c == '\r' || c == -1;
}
 
public interface SpaceCharFilter
{
  public boolean isSpaceChar(int ch);
}
}
	
}