

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.*;

public class Third{
	static long mod=1000000007;
	
    public static void main(String[] args) throws Exception{           	
    	 InputReader in = new InputReader(System.in);       
    	PrintWriter pw=new PrintWriter(System.out);   
    	
    	
    	//int t=in.readInt();
        //while(t-->0)
        //{
    	
        int n=in.readInt();
    	//long n=in.readLong();
    	/*int a[]=new int[n];
    	for(int i=0;i<n;i++)
    	{
    		a[i]=in.readInt();
    	}*/
    	String a=in.readString();
    	char c[]=a.toCharArray();
    	HashSet<Character>ht=new HashSet<Character>();
    	Deque<Character>q=new LinkedList<Character>();
    	HashSet<Character>hs=new HashSet<Character>();
    	HashMap<Character,Integer>hm=new HashMap<Character,Integer>();
    	for(int i=0;i<n;i++)
    	{
    		ht.add(c[i]);
    	}
    	int t=ht.size();
    	q.addLast(c[0]);
    	hs.add(c[0]);
    	hm.put(c[0],1);
    	int ans=Integer.MAX_VALUE;
    	if(hs.size()==t)
		{   			
			ans=min(ans,q.size());
		}
    	
    	for(int i=1;i<n;i++)
    	{
    		q.addLast(c[i]);
			hs.add(c[i]);
			if(hm.containsKey(c[i]))
			{
				int x=hm.get(c[i]);
				hm.put(c[i],x+1);
			}
			else
				hm.put(c[i],1);
    		while(hs.size()==t)
    		{   			
    			ans=min(ans,q.size());
    			char ch=q.peekFirst();
    			int x=hm.get(ch);
    			if(x==1)
    				break;
    			else
    				{
    				hm.put(ch, x-1);
    				q.pollFirst();
    				}
    			
    		}
    		    			
    		
    	}
		pw.println(ans);	     	
    	
    	//}
    	
    	pw.close();
    }
    

	
public static long gcd(long x,long y)
{
	if(x%y==0)
		return y;
	else
		return gcd(y,x%y);
}
public static int gcd(int x,int y)
{
	if(x%y==0)
		return y;
	else 
		return gcd(y,x%y);
}
public static int abs(int a,int b)
{
	return (int)Math.abs(a-b);
}
public static long abs(long a,long b)
{
	return (long)Math.abs(a-b);
}
public static int max(int a,int b)
{
	if(a>b)
		return a;
	else
		return b;
}
public static int min(int a,int b)
{
	if(a>b)
		return b;
	else 
		return a;
}
public static long max(long a,long b)
{
	if(a>b)
		return a;
	else
		return b;
}
public static long min(long a,long b)
{
	if(a>b)
		return b;
	else 
		return a;
}


public static long pow(long n,long p,long m)
{
	 long  result = 1;
	  if(p==0)
	    return 1;
	if (p==1)
	    return n;
	while(p!=0)
	{
	    if(p%2==1)
	        result *= n;
	    if(result>=m)
	    result%=m;
	    p >>=1;
	    n*=n;
	    if(n>=m)
	    n%=m;
	}
	return result;
}
public static long pow(long n,long p)
{
	long  result = 1;
	  if(p==0)
	    return 1;
	if (p==1)
	    return n;
	while(p!=0)
	{
	    if(p%2==1)
	        result *= n;	    
	    p >>=1;
	    n*=n;	    
	}
	return result;

}
static class Pair implements Comparable<Pair>
{
	int a,b;
	Pair (int a,int b)
	{
		this.a=a;
		this.b=b;
	}

	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		if(this.a!=o.a)
		return Integer.compare(this.a,o.a);
		else
			return Integer.compare(this.b, o.b);
		//return 0;
	}
	public boolean equals(Object o) {
        if (o instanceof Pair) {
            Pair p = (Pair)o;
            return p.a == a && p.b == b;
        }
        return false;
    }
    public int hashCode() {
        return new Integer(a).hashCode() * 31 + new Integer(b).hashCode();
    }
    
} 
    
static long sort(int a[])
{  int n=a.length;
	int b[]=new int[n];	
	return mergeSort(a,b,0,n-1);}
static long mergeSort(int a[],int b[],long left,long right)
{ long c=0;if(left<right)
 {   long mid=left+(right-left)/2;
	 c= mergeSort(a,b,left,mid);
	 c+=mergeSort(a,b,mid+1,right);
	 c+=merge(a,b,left,mid+1,right); }	
	return c;	 }
static long merge(int a[],int  b[],long left,long mid,long right)
{long c=0;int i=(int)left;int j=(int)mid; int k=(int)left;
while(i<=(int)mid-1&&j<=(int)right)
{ if(a[i]<=a[j]) {b[k++]=a[i++]; }
else	{ b[k++]=a[j++];c+=mid-i;}}
while (i <= (int)mid - 1)   b[k++] = a[i++]; 
while (j <= (int)right) b[k++] = a[j++];
for (i=(int)left; i <= (int)right; i++) 
	a[i] = b[i];  return c;  }
    
public static int[] radixSort(int[] f)
{
	int[] to = new int[f.length];
	{
		int[] b = new int[65537];
		for(int i = 0;i < f.length;i++)b[1+(f[i]&0xffff)]++;
		for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
		for(int i = 0;i < f.length;i++)to[b[f[i]&0xffff]++] = f[i];
		int[] d = f; f = to;to = d;
	}
	{
		int[] b = new int[65537];
		for(int i = 0;i < f.length;i++)b[1+(f[i]>>>16)]++;
		for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
		for(int i = 0;i < f.length;i++)to[b[f[i]>>>16]++] = f[i];
		int[] d = f; f = to;to = d;
	}
	return f;
}    
   static  class InputReader
    {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream)
        {
            this.stream = stream;
        }

        public int read()
        {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars)
            {
                curChar = 0;
                try
                {
                    numChars = stream.read(buf);
                } catch (IOException e)
                {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do
            {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
        public double readDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, readInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, readInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }
        public long readLong() {
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
        public boolean isSpaceChar(int c)
        {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next()
        {
            return readString();
        }

        public interface SpaceCharFilter
        {
            public boolean isSpaceChar(int ch);
        }
    }

  
//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	//StringBuilder sb=new StringBuilder("");
	 //InputReader in = new InputReader(System.in);
	//PrintWriter pw=new PrintWriter(System.out);
	//String line=br.readLine().trim();
	       	
	//int t=Integer.parseInt(br.readLine());
  //	while(t-->0)
  	//{
  	//int n=Integer.parseInt(br.readLine());
	//long n=Long.parseLong(br.readLine());
	//String l[]=br.readLine().split(" ");
  //int m=Integer.parseInt(l[0]);
	//int k=Integer.parseInt(l[1]);
	//String l[]=br.readLine().split(" ");
	//l=br.readLine().split(" ");
	/*int a[]=new int[n];
	for(int i=0;i<n;i++)
	{
		a[i]=Integer.parseInt(l[i]);
	}*/
	   //System.out.println(" ");	     	
	
	//}
}