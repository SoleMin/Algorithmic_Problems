import java.io.*;
import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Main
{
      @SuppressWarnings("unchecked")
      public static void main(String args[])throws IOException
    {
         Reader ob=new Reader();
        Writer out=new Writer(System.out);
        Random oo=new Random();
        long k=ob.nL(),ans=0,p=9,num=0;
        for(int i=1;i<18;i++)
        {
            if(num+i*p<k)
            {
                num+=i*p;p*=10;
                ans=0;
                for(int j=0;j<i;j++)
                ans=9+ans*10;
            }
            else
            {
                long left=k-num;
                long r=left/i;
                left-=r*i;
                ans+=r;
                if(left>0)
                {
                 String s=Long.toString(ans+1);
                
                out.pln(s.charAt((int)left-1));
            }
            else
            {
                
                String s=Long.toString(ans);
                
                out.pln(s.charAt(i-1-(int)left));
            }
                break;
            }
            
        }
out.flush();
}
static void sort(int a[])
{
    RA(a);
    Arrays.sort(a);
}
 public static Pairs[] RA(Pairs [] array){
		Random rgen = new Random();  // Random number generator			
 
		for (int i=0; i<array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    Pairs temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
 
		return array;
	}
	
 public static int[] RA(int [] array){
		Random rgen = new Random();  // Random number generator			
 
		for (int i=0; i<array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    int temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
 
		return array;
	}
	static void sort(long a[])
{
    RA(a);
    Arrays.sort(a);
}
 public static long[] RA(long [] array){
		Random rgen = new Random();  // Random number generator			
 
		for (int i=0; i<array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    long temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
 
		return array;
	}
	static void sort(String a[])
{
    RA(a);
    Arrays.sort(a);
}
 public static String[] RA(String [] array){
		Random rgen = new Random();  // Random number generator			
 
		for (int i=0; i<array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    String temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
 
		return array;
	}
static long inverse(long x, long p)
    {
        return pow(x, p - 2, p);
    }
static boolean isPrime(long n)
{
    long h=(long)Math.sqrt(n);
    for(long i=2;i<=h;i++)
    if(n%i==0)
    return false;
    return true&&n!=1;
}
    static long gcd(long a,long b)
    {
        if(a<b)
        return gcd(b,a);
        else if(b==0)
        return a;
        else
        return gcd(b,a%b);
    }
    static long pow(long a,long b,long mod){
		if(b == 0)	return 1;
		long t = pow(a,b>>1,mod);
		t = (t * t) % mod;
		if((b & 1) == 1)	t = (t * a);
		if(t >= mod)	t %= mod;
		return t;
}
    static long pow(long a,long b){
		if(b == 0)	return 1;
		long t = pow(a,b>>1);
		t = (t * t);
		if((b & 1) == 1)	t = (t * a);
		return t;
}
    static void seive(int n,int prime[])//1 for prime -1 for not prime
    {
        for(int i=2;i<=n;i++)
            if(prime[i]==0)
            {
                prime[i]=1;
                for(int j=2;j*i<=n;j++)
                prime[j*i]=-1;
            }
    }
    static int max(int ...a)
    {
        int m=a[0];
        for(int i=0;i<a.length;i++)
        m=Math.max(m,a[i]);
        return m;
        
    }
    static long max(long ...a)
    {
        long m=a[0];
        for(int i=0;i<a.length;i++)
        m=Math.max(m,a[i]);
        return m;
    }
    static int min(int ...a)
    {
        int m=a[0];
        for(int i=0;i<a.length;i++)
        m=Math.min(m,a[i]);
        return m;
    }
    static long min(long ...a)
    {
        long m=a[0];
        for(int i=0;i<a.length;i++)
        m=Math.min(m,a[i]);
        return m;
    }
    static class Pair<T1,T2>
    {
        T1 x;T2 y;
        Pair(T1 xx,T2 yy)
        {
            x=xx;
            y=yy;
        }
    }
    
	static class Writer {
		private final PrintWriter p;
		Writer(OutputStream o) {
			p = new PrintWriter(new BufferedWriter(new OutputStreamWriter(o)));
		}
		void p(Object... o1) {
			for (Object o11 : o1) {
				p.print(o11 + "" );
			}
		}
		<T>void pa(T a[])
		{
		    for(T i:a)
		    System.out.print(i+" ");
		    System.out.println();
		  }
		void p(String s) {
			p.print(s);
		}
		void pln(Object... o1) {
			p(o1);
			p.println();
		}
		void flush() {
			p.flush();
		}
		void close() {
			p.close();
		}
	}
    static class Reader {
		private byte[] buf = new byte[1024];
		private int curChar;
		private int snumChars;
		int flag=0;
		FileReader file;
		Reader()
		{
		  }
		  Reader(String x)throws IOException
		  {
		      flag=1;
		      file=new FileReader(x);
		  }
		public int read() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = System.in.read(buf);
				
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
		public String nl() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}
		public String n() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
		public long nL() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		public int nI() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		public int[] NIA(int n) //nextINtArray
		{
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nI();
			}
			return arr;
		}
		public int[] NIA1(int n) //nextINtArray
		{
			int[] arr = new int[n+1];
			for (int i = 1; i <=n; i++) {
				arr[i] = nI();
			}
			return arr;
		}
		
		public long[] NLA(int n) //nextLongArray
		{
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nL();
			}
			return arr;
}
		public long[] NLA1(int n) //nextLongArray
		{
			long[] arr = new long[n+1];
			for (int i = 1; i <=n; i++) {
				arr[i] = nL();
			}
			return arr;
}
		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}
	}
static class DSU
{
    int a[],size[],c=1,m;
    HashMap<String,Integer> hm=new HashMap<String,Integer>();
    DSU(int n)
    {
        a=new int[n+1];
        m=n;
        size=new int[n+1];
        for(int i=1;i<=n;i++)
    {
        a[i]=i;
        size[i]=1;
    }
    }
    void add(String x,int i)
    {
        hm.put(x,i);
    }
    int find(int n)
    {
        while(a[n]!=n)
        {
            a[n]=a[a[n]];
        n=a[n];
    }
        return n;
    }
    int[] eval()
    {
       int y[]=new int[m+1];
       for(int i=1;i<=m;i++)
       y[find(i)]++;
       return y;
    }
    void union(int a1,int b)
    {
        int x=find(a1);
        int y=find(b);
        if(size[x]>size[y])
    {
        a[y]=x;
        size[x]+=size[y];
    }
    else
    {
       a[x]=y;
       size[y]+=size[x];
    }
}
        //System.out.println(Arrays.toString(a));
}
class Segment
{
    int sum[];
    void build(int a[],int v,int l,int r)
    {
        if(l==r)
        sum[v]=a[l];
        else
        {
            int m=(l+r)/2;
            build(a,v*2,l,m);
            build(a,2*v+1,m+1,r);
            sum[v]=sum[v*2]+sum[2*v+1];
        }
    }
    void update(int a[],int l,int r,int x,int v,int y)
    {
        if(l==r&&r==y)
            sum[v]+=x;
        else if(l>y||y>r)
        return;
        else
        {
            int m=(l+r)/2;
            update(a,l,m,x,2*v,y);
            update(a,m+1,r,x,2*v+1,y);
            sum[v]=sum[2*v]+sum[2*v+1];
        }
    }
    int query(int v,int l,int r,int x,int y)
    {
        if(x>r||y<l)
        return 0;
        else if(x<=l&&r<=y)
        return sum[v];
        else
        {
            int m=(l+r)/2;
        return query(2*v,l,m,x,y)+query(2*v+1,m+1,r,x,y);  
    }
}
}

static class Trie
  {
      Trie child[]=new Trie[26];
      int count=0;
    }
   /* void insert(String a)
    {
        Trie tmp=root;
        for(int i=0;i<a.length();i++)
        {
            int v=a.charAt(i)-'a';
            if(tmp.child[v]==null)
            {
                tmp.child[v]=new Trie();
                
            }
                tmp=tmp.child[v];
            }
            if(tmp.count==0)
            r++;
            tmp.count=1;
        }*/
    }
    class Pairs implements Comparable<Pairs>
    {
        int x,y;String z;
        Pairs(int a,int b)
        {
            x=a;y=b;
        }
        @Override
         public int compareTo(Pairs a)
            {
            
            if(a.x>this.x||(a.x==this.x&&a.y<this.y)||(a.x==this.x&&a.y==this.y&&(a.z).equals("BhayanakMaut")))
            return 1;
            else
            return -1;
        }
    }