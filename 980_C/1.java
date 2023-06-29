import java.util.*;


import java.io.*;
public class A
	
	{ 
		 static FastReader sc=new FastReader(); 
		 static long dp[][];
		 static int mod=1000000007;
			  public static void main(String[] args)
	    {
		  PrintWriter out=new PrintWriter(System.out);
		  StringBuffer sb=new StringBuffer("");
		 
	  int ttt=1;
	   //ttt =i();
        outer :while (ttt-- > 0) 
		{
        	int n=i();
        	int k=i();
        	int A[]=input(n);
        	int B[]=new int[257];
        	int C[]=new int[257];
        	Arrays.fill(C, -1);
        	for(int i=0;i<n;i++) {
        		
        		int v=A[i];
        		if(B[v]>0) {
        			A[i]=C[v];
        			continue;
        		}
        		int y=v-k+1;
        		if(y<0)
        			y=0;
        		if(B[y]==0) {
        			int len=v-y+1;
        			for(int j=y;j<=v;j++) {
        				B[j]=len;
        				C[j]=y;
        			}
        			A[i]=y;
        		}
        		else {
        			if(y==0 || C[y]!=C[y-1]) {
        				int len=v-y+1;
            			for(int j=y;j<=v;j++) {
            				B[j]=len;
            				C[j]=y;
            			}
            			A[i]=y;
        			}
        			else {
        				int ind=-1;
        				for(int j=y;j<=v;j++) {
        					if(C[j]!=C[j-1]) {
        						ind=j;
        						break;
        					}
        				}
        				int len=v-ind+1;
        				for(int j=ind;j<=v;j++) {
        					B[j]=len;
        					C[j]=ind;
        				}
        				A[i]=ind;
        			}
        		}
        		
        		
        		
        	}
        	
        
        	for(int i : A)
        	  out.print(i+" ");
        	
        		 
        	 
        	
        	
        	
		}
	   out.close();
      // System.out.println(sb.toString());
       
       
       //CHECK FOR N=1                    //CHECK FOR M=0
        //CHECK FOR N=1                    //CHECK FOR M=0
       	//CHECK FOR N=1
       	//CHECK FOR N=1
       	//CHECK FOR N=1
    }
			 
			  
			  
			  
  static class Pair implements Comparable<Pair>
   {
	   int x;
	   int y;
	  	 Pair(int x,int y){
	  		 this.x=x;
	  		 this.y=y;
	  	 }
	@Override
//	public int compareTo(Pair o) {
//		if(this.x>o.x)
//			return 1;
//		else if(this.x<o.x)
//			return -1;
//		else {
//			if(this.y<o.y)
//				return 1;
//			else if(this.y>o.y)
//				return -1;
//			else
//				return 0;
//		}
//	}
	
	
	public int compareTo(Pair o) {
			if (x > o.x) {
				return 1;
			}
			if (x < o.x) {
				return -1;
			}
			if (y > o.y) {
				return 1;
			}
			if (y < o.y) {
				return -1;
			}
			return 0;
		}
	
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
static HashMap<Long,Integer> hash(long A[]){
	  HashMap<Long,Integer> map=new HashMap<Long, Integer>();
	  for(long i : A) {
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
static TreeMap<Long,Integer> tree(long A[]){
	  TreeMap<Long,Integer> map=new TreeMap<Long, Integer>();
	  for(long i : A) {
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
   static long power(long x, long y, long p)
   {

       long res = 1;
       x = x % p;

       while (y > 0) {

           if (y % 2 == 1)
               res = (res * x) % p;

           y = y >> 1; 
           x = (x * x) % p;
       }

       return res;
   }

   static long modInverse(long n, long p)
   {
       return power(n, p - 2, p);
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



