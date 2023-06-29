import java.util.*;
import java.io.*;
import java.math.*;

public class Main

{ 
	 static FastReader sc=new FastReader(); 
	 static long dp[][][];
	 static int mod=1000000007;
	 
	  public static void main(String[] args)  throws IOException
{
		    //CHECK FOR N=1
       	//CHECK FOR N=1
	    //CHECK FOR N=1			
       	//CHECK FOR N=1
		  
		  
		  
		   PrintWriter out=new PrintWriter(System.out);
		  // StringBuffer sb=new StringBuffer("");
		  int ttt=1;
		//  ttt =i(); 	
		   
	        outer :while (ttt-- > 0) 
			{

	        	int n=i();
	        	int m=i();
	        	int k=i();
	        	int A[][]=input(n,m-1);
	        	int B[][]=input(n-1, m);
	        	dp=new long[n+1][m+1][k+1];
	        	for(int ii=0;ii<n;ii++) {
	        		for(int jj=0;jj<m;jj++) {
	        			Arrays.fill(dp[ii][jj],-1);
	        		}
	        	}
	        	if(k%2!=0) {
	        		for(int i=0;i<n;i++) {
	        			for(int j=0;j<m;j++) {
	        				System.out.print("-1 ");
	        			}
	        			System.out.println();
	        		}
	        	}
	        	else {
	        	go(A, B, 0, 0, k/2, n, m);
	        	for(int i=0;i<n;i++) {
        			for(int j=0;j<m;j++) {
        				System.out.print(dp[i][j][k/2]*2+" ");
        			}
        			System.out.println();
        		}
	        	}
	        	
			}
		     out.close();
    	//System.out.println(sb.toString());
	     
	     
	    //CHECK FOR N=1                    //CHECK FOR M=0
        //CHECK FOR N=1                    //CHECK FOR M=0
       	//CHECK FOR N=1
       	//CHECK FOR N=1
       	//CHECK FOR N=1
		        	
    }
	  static long go(int A[][],int B[][],int i,int j,int k,int l,int p) {
		 if(k==0)
			 return 0;
		 if(i>=l || j>=p)
			 return Integer.MAX_VALUE;
		  if(dp[i][j][k]!=-1)
			  return dp[i][j][k];
//		  if(i==m && j==n && k<org) {
//			  return Integer.MAX_VALUE;
//		  }
		  long op1=Long.MAX_VALUE;
		  if(i+1<l)
		  op1=Math.min(op1,go(A, B, i+1, j, k-1,l,p)+B[i][j]);
		  if(i-1>=0)
		 op1=Math.min(op1,go(A, B, i-1, j, k-1,l,p)+B[i-1][j]);
		  if(j+1<p)
		  op1=Math.min(op1,go(A, B, i, j+1, k-1,l,p)+A[i][j]);
		  if(j-1>=0)
		   op1=Math.min(op1,go(A, B, i, j-1, k-1,l,p)+A[i][j-1]);
		  go(A, B, i+1, j, k, l, p);
		  go(A, B, i, j+1, k, l, p);
		  return dp[i][j][k]=op1;
	  }
		  
		  
		  
		


static int[] input(int n) {
	int A[]=new int[n];
	   for(int i=0;i<n;i++) {
		   A[i]=sc.nextInt();
	   }
	   return A;
   }
static long[] inputL(int n) {
	long A[]=new long[n];
	   for(int i=0;i<n;i++) {
		   A[i]=sc.nextLong();
	   }
	   return A;
   }
static String[] inputS(int n) {
	String A[]=new String[n];
	   for(int i=0;i<n;i++) {
		   A[i]=sc.next();
	   }
	   return A;
   }
static long sum(int A[]) {
	long sum=0;
	for(int i : A) {
		sum+=i;
	}
	return sum;
}
static long sum(long A[]) {
	long sum=0;
	for(long i : A) {
		sum+=i;
	}
	return sum;
}
static void reverse(long A[]) {
	int n=A.length;
	long B[]=new long[n];
	for(int i=0;i<n;i++) {
		B[i]=A[n-i-1];
	}
	for(int i=0;i<n;i++)
		A[i]=B[i];
	
}
static void reverse(int A[]) {
	int n=A.length;
	int B[]=new int[n];
	for(int i=0;i<n;i++) {
		B[i]=A[n-i-1];
	}
	for(int i=0;i<n;i++)
		A[i]=B[i];
	
}
static void input(int A[],int B[]) {
	   for(int i=0;i<A.length;i++) {
		   A[i]=sc.nextInt();
		   B[i]=sc.nextInt();
	   }
}
static int[][] input(int n,int m){
	int A[][]=new int[n][m];
	for(int i=0;i<n;i++) {
		for(int j=0;j<m;j++) {
			A[i][j]=i();
		}
	}
	return A;
}
static char[][] charinput(int n,int m){
	char A[][]=new char[n][m];
	for(int i=0;i<n;i++) {
		String s=s();
		for(int j=0;j<m;j++) {
			A[i][j]=s.charAt(j);
		}
	}
	return A;
}
static int max(int A[]) {
	int max=Integer.MIN_VALUE;
	for(int i=0;i<A.length;i++) {
		max=Math.max(max, A[i]);
	}
	return max;
}
static int min(int A[]) {
	int min=Integer.MAX_VALUE;
	for(int i=0;i<A.length;i++) {
		min=Math.min(min, A[i]);
	}
	return min;
}
static long max(long A[]) {
	long max=Long.MIN_VALUE;
	for(int i=0;i<A.length;i++) {
		max=Math.max(max, A[i]);
	}
	return max;
}
static long min(long A[]) {
	long min=Long.MAX_VALUE;
	for(int i=0;i<A.length;i++) {
		min=Math.min(min, A[i]);
	}
	return min;
}
static long [] prefix(long A[]) {
	long p[]=new long[A.length];
	p[0]=A[0];
	for(int i=1;i<A.length;i++)
		p[i]=p[i-1]+A[i];
	return p;
}
static long [] prefix(int A[]) {
	long p[]=new long[A.length];
	p[0]=A[0];
	for(int i=1;i<A.length;i++)
		p[i]=p[i-1]+A[i];
	return p;
}
static long [] suffix(long A[]) {
	long p[]=new long[A.length];
	p[A.length-1]=A[A.length-1];
	for(int i=A.length-2;i>=0;i--)
		p[i]=p[i+1]+A[i];
	return p;
}
static long [] suffix(int A[]) {
	long p[]=new long[A.length];
	p[A.length-1]=A[A.length-1];
	for(int i=A.length-2;i>=0;i--)
		p[i]=p[i+1]+A[i];
	return p;
}
static void print(int A[]) {
	for(int i : A) {
		System.out.print(i+" ");
	}
	System.out.println();
}
static void print(long A[]) {
	for(long i : A) {
		System.out.print(i+" ");
	}
	System.out.println();
}
static long mod(long x) {
	 int mod=1000000007;
	  return ((x%mod + mod)%mod);
}
static String reverse(String s) {
	StringBuffer p=new StringBuffer(s);
	p.reverse();
	return p.toString();
}

     static int i() {
    	 return sc.nextInt();
     }
     static String s() {
    	 return sc.next();
     }
     static long l() {
    	 return sc.nextLong();
     }  
     static void sort(int[] A){
        int n = A.length;
        Random rnd = new Random();
        for(int i=0; i<n; ++i){
            int tmp = A[i];
            int randomPos = i + rnd.nextInt(n-i);
            A[i] = A[randomPos];
            A[randomPos] = tmp;
        }
        Arrays.sort(A);
     }
     static void sort(long[] A){
	        int n = A.length;
	        Random rnd = new Random();
	        for(int i=0; i<n; ++i){
	            long tmp = A[i];
	            int randomPos = i + rnd.nextInt(n-i);
	            A[i] = A[randomPos];
	            A[randomPos] = tmp;
	        }
	        Arrays.sort(A);
	     }
  static String sort(String s) {
 	 Character ch[]=new Character[s.length()];
 	 for(int i=0;i<s.length();i++) {
 		 ch[i]=s.charAt(i);
 	 }
 	 Arrays.sort(ch);
 	 StringBuffer st=new StringBuffer("");
 	 for(int i=0;i<s.length();i++) {
 		 st.append(ch[i]);
 	 }
 	 return st.toString();
  }
  static HashMap<Integer,Integer> hash(int A[]){
	  HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
	  for(int i : A) {
		  if(map.containsKey(i)) {
			  map.put(i, map.get(i)+1);
		  }
		  else {
			  map.put(i, 1);
		  }
	  }
	  return map;
  }
  static TreeMap<Integer,Integer> tree(int A[]){
	  TreeMap<Integer,Integer> map=new TreeMap<Integer, Integer>();
	  for(int i : A) {
		  if(map.containsKey(i)) {
			  map.put(i, map.get(i)+1);
		  }
		  else {
			  map.put(i, 1);
		  }
	  }
	  return map;
  }
     static boolean prime(int n) 
	    { 
	        if (n <= 1) 
	            return false; 
	        if (n <= 3) 
	            return true; 
	        if (n % 2 == 0 || n % 3 == 0) 
	            return false; 
	        double sq=Math.sqrt(n);
	  
	        for (int i = 5; i <= sq; i = i + 6) 
	            if (n % i == 0 || n % (i + 2) == 0) 
	                return false; 
	        return true; 
	    } 
     static boolean prime(long n) 
	    { 
	        if (n <= 1) 
	            return false; 
	        if (n <= 3) 
	            return true; 
	        if (n % 2 == 0 || n % 3 == 0) 
	            return false; 
	        double sq=Math.sqrt(n);
	  
	        for (int i = 5; i <= sq; i = i + 6) 
	            if (n % i == 0 || n % (i + 2) == 0) 
	                return false; 
	        return true; 
	    } 
     static int gcd(int a, int b) 
     { 
         if (a == 0) 
             return b; 
         return gcd(b % a, a); 
     } 
     static long gcd(long a, long b) 
     { 
         if (a == 0) 
             return b; 
         return gcd(b % a, a); 
     } 
     static class Pair implements Comparable<Pair>
     {
    	 int x;
    	 int y;
    	 int z;
    	 Pair(int x,int y,int z){
    		 this.x=x;
    		 this.y=y;
    		 this.z=z;
    	 }
		@Override
//		public int compareTo(Pair o) {
//			if(this.x>o.x)
//				return 1;
//			else if(this.x<o.x)
//				return -1;
//			else {
//				if(this.y>o.y)
//					return 1;
//				else if(this.y<o.y)
//					return -1;
//				else
//					return 0;
//			}
//		}
		
		
		public int compareTo(Pair o) {
			int p=this.x-this.y;
			int q=o.x-o.y;
		if(p>q)
			return 1;
		else if(p<q)
			return -1;
			
				return 0;
		
	}
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



