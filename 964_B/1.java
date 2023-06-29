//package codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

//import codes.Reference.i;

public class Messages {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			long n1[] = i.la();
			long n = n1[0];
			long A = n1[1];
			long B = n1[2];
			long C = n1[3];
			long T = n1[4];
			
			long t[]=i.la();
			HashMap<Long, Integer> map = new HashMap<Long, Integer>();
			for(int i=0;i<t.length;i++)
			{
				if(!map.containsKey(t[i]))
				{
					map.put(t[i],1);
				}
				else
				{
					map.put(t[i], map.get(t[i])+1);
				}
			}
			
			long sum=0;
			long cnt=0;
			ArrayList<Long> al = new ArrayList<Long>();
			for(int i=2;i<=T;i++)
			{
				if(map.containsKey((long)i-1))
				{
					cnt+=map.get((long)(i-1));
					al.add(cnt);
				}
				else
					al.add(cnt);
			}
			cnt = al.parallelStream().reduce((long) 0, Long::sum);
			System.out.println(Math.max(A*n, cnt*(C-B)+A*n));
	}
	static private class i
	{
		//input taking methods
		static BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		
		public static String[] sa()
	    {
	    	try {
				return b.readLine().split(" ");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	    	return null;
	    }
		
		public static long l()
		{
			try {
				return Long.parseLong(b.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return 0;
		}
		
		public static String s()
		{
			try {
				return b.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return null;
		}
		
		public static long[] la()
		{
			return Arrays.stream(sa()).parallel().mapToLong(Long::parseLong).toArray();
		}
		
		public static ArrayList<Long> lal()
		{
			return (ArrayList<Long>)Arrays.stream(la()).parallel().boxed().collect(Collectors.toList());
		}
		public static StringBuilder so(String a)
		{
			return new StringBuilder(a);
		}

	}
	/*
	 HashMap<String,Integer> map = new HashMap<String,Integer>();
	 if(!map.containsKey(key))
	 {
	 	map.put(key,value);
	 }
	 else
	 {
	 	map.replace(key,map.get(key));
	 } 
	 */
	static private class algo{
		
		public static boolean isPrime(int a)
		{
			for(int i=2;i<a;i++)
			{
				if(a%i==0)
				{
					return false;
				}
			}
			return true;
		}
		static String reverse(String s)
		{
			return i.so(s).reverse().toString();
		}
		static String replace(String s,int st,int e,String repl)
		{
			return i.so(s).replace(st, e, repl).toString();
		}
		static String insert(String s,int pos,String ins)
		{
			return i.so(s).insert(pos, ins).toString();
		}
		static long sod(long n) 
	    { 
	        long sum; 
	        for (sum = 0; n > 0; sum += n % 10, 
	                                  n /= 10); 
	  
	        return sum; 
	    } 

		static int gcd(int a, int b) 
	    { 
			if (a == 0) 
				return b;  
			return gcd(b % a, a);  
	    } 
		
	    static int lcm(int a, int b) 
	    { 
	        return (a*b)/gcd(a, b); 
	    }
	    static long sumOfSquares(long[] a)
	    {
	    	
	    	return (long) Arrays.stream(a).mapToDouble(i->i*i).sum();
	    }
	    //use of filter
	    //Arrays.stream(a).filter(k->k==1).count();
	    //            array       variable->condition returning boolean  . lot fof functionsa re available
	    
	    static String[] generateBinSeq(int cnt)
	    {
	    	int loopvar=(int) Math.pow(2, cnt);
			String a[][] = new String[cnt+1][loopvar];
			
			for(int i=1;i<=cnt;i++)
			{
				int temp = (int) Math.pow(2, i);
				for(int j=0;j<temp;j++)
				{
					if(i==1 || i==2)
					{
						if(i==1)
						{
							a[i][0]="0";
							a[i][1]="1";
							continue;
						}
						else
						{
							a[2][0]="00";a[2][1]="01";a[2][2]="10";a[2][3]="11";
							continue;
						}
					}
					else
					{
						if(j<(temp/2))
						{
							a[i][j] = a[i-1][j]+"0"; 
						}
						else
						{
							a[i][j] = a[i-1][j%((temp+1)/2)]+"1";
						}
				
					}
						
				}
			}
	    
			return a[cnt];
	    }
	    
	 // USe this snippet for calling
//	    int ndx = algo.bs(a,key,0,a.length-1);
//		if(ndx<0)
//			ndx=0;
//		if(ndx==a.length)
//			ndx=a.length-1;

	    static public int bs(long a[],long key,int s,int e)
		{
			int m = (s+e)/2;
			if(s>e)
				return s;
				
			if(a[m]==key)
				return m;
			else if(a[m]>key)
				return bs(a,key,s,m-1);
			else
				return bs(a,key,m+1,e);
			
		}
	 // USe this snippet for calling
//	    int ndx = bsa(al,key,0,al.size()-1);
//		if(ndx<0)
//			ndx=0;
//		if(ndx==al.size())
//			ndx=al.size()-1;
	    static public int bsa(ArrayList<Long> a,long key,int s,int e)
		{
			int m = (s+e)/2;
			if(s>e)
				return s;
				
			if(a.get(m)==key)
				return m;
			else if(a.get(m)>key)
				return bsa(a,key,s,m-1);
			else
				return bsa(a,key,m+1,e);
			
		}
	    static public long fact(long a)
	    {
	    	long i,fact=1;  
	    	 long number=a;   
	    	  for(i=1;i<=number;i++){    
	    	      fact=fact*i;    
	    	  } 
	    	  return fact;
	    }
	    
	}
}
