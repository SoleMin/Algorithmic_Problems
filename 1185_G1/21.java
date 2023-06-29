import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.regex.*;

public class Main{
	 static long dp[][][][]=new long [16][16][16][4];
	 static void ini() {
		 for(int i=0;i<16;i++) {
			 for(int j=0;j<16;j++) {
				 for(int k=0;k<16;k++) {
					 for(int l=0;l<4;l++) {
						 dp[i][j][k][l]=-1L;
					 }
				 }
			 }
		 }
	 }
	 static int chk(long i) {
		 if(i==0L)
			 return 1;
		 else
			 return 0;
	 }
	 static long f(long a,long b,long c,int taken) {
		int got=(int) (a+b+c);
		int have=chk(a)+chk(b)+chk(c);
		if(have==2) {
			if(got==1)
				return 1L;
			else
				return 0L;
		}
		if(dp[(int) a][(int) b][(int) c][taken]!=-1) {
			return dp[(int) a][(int) b][(int) c][taken];
		}
		long ans=0L;
		 if(taken == 0) {
			 if(a!=0)
			 ans+=(a*f(a-1,b,c,1))%mod; ans%=mod;
			 if(b!=0)
			 ans+=(b*f(a,b-1,c,2))%mod; ans%=mod;
			 if(c!=0)
			 ans+=(c*f(a,b,c-1,3))%mod; ans%=mod;
		 }
		 else {
			 ans+=((taken==1 || a==0)?0L:(a*f(a-1,b,c,1))%mod)%mod; ans%=mod;
			 ans+=((taken==2 || b==0)?0L:(b*f(a,b-1,c,2))%mod)%mod; ans%=mod;
			 ans+=((taken==3 || c==0)?0L:(c*f(a,b,c-1,3))%mod)%mod; ans%=mod;
		 }
		 dp[(int) a][(int) b][(int) c][taken]=ans;
		 return ans;
	 }
	public static void main(String[] args)
   {
       InputReader in=new InputReader(System.in);
       PrintWriter pw = new PrintWriter(System.out);
       int n=in.nextInt();
       int total=in.nextInt();
       int t[]=new int[n];
       int g[]=new int[n];
       for(int i=0;i<n;i++) {
    	   t[i]=in.nextInt();
    	   g[i]=in.nextInt();
       }
       long ans=0L;
       for(int i=0;i<(1<<n);i++) {
    	   int sum=0;
    	   int a[]=new int[4];
    	   for(int j=0;j<n;j++) {
    		   
    		   if(((i>>j)&1)==1) {
    			   sum+=t[j];
    			   a[g[j]]++;
    		   }
    	   }
    	   if(sum==total) {
    		   ini();
    		   ans=(ans+f(a[1],a[2],a[3],0))%mod;
    	   }
       }
       pw.println(ans);
       pw.flush();
       pw.close();
        
        
        }
         private static void debug(Object... o) {
     		System.out.println(Arrays.deepToString(o));
     	}
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
            } while (!isSpaceChar(c));
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
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public int[] nextIntArray(int n) 
        {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
            {
                a[i] = nextInt();
            }
            return a;
        }
        static class tri implements Comparable<tri> {
            int p, c, l;
 
            tri(int p, int c, int l) {
                this.p = p;
                this.c = c;
                this.l = l;
            }
 
            public int compareTo(tri o) {
                return Integer.compare(l, o.l);
            }
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
            } while (!isSpaceChar(c));
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
            } while (!isEndOfLine(c));
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
        public static long mod = 1000000007;
        public static int d;
        public static int p;
        public static int q;
        
        public static int[] suffle(int[] a,Random gen)
        {
            int n = a.length;
            for(int i=0;i<n;i++)
            {
                int ind = gen.nextInt(n-i)+i;
                int temp = a[ind];
                a[ind] = a[i];
                a[i] = temp;
            }
            return a;
        }
        
        public static void swap(int a, int b){
            int temp = a;
            a = b;
            b = temp;
        }
        
       /* public static long primeFactorization(long n)
        {
             HashSet<Integer> a =new HashSet<Integer>();
        	long cnt=0;
            for(int i=2;i*i<=n;i++)
            {
                while(a%i==0)
                {
                    a.add(i);
                    a/=i;
                }
            }
            if(a!=1)
            	cnt++;
                //a.add(n);
            return cnt;
        }*/
        
        public static void sieve(boolean[] isPrime,int n)
        {
            for(int i=1;i<n;i++)
                isPrime[i] = true;
            
            isPrime[0] = false;
            isPrime[1] = false;
            
            for(int i=2;i*i<n;i++)
            {
                if(isPrime[i] == true)
                {
                    for(int j=(2*i);j<n;j+=i)
                        isPrime[j] = false;
                }
            }
        }
        
        public static int GCD(int a,int b)
        {
            if(b==0)
                return a;
            else
                return GCD(b,a%b);
        }
        
        public static long GCD(long a,long b)
        {
            if(b==0)
                return a;
            else
                return GCD(b,a%b);
        }
        
        public static void extendedEuclid(int A,int B)
        {
            if(B==0)
            {
                d = A;
                p = 1 ;
                q = 0;
            }
            else
            {
                extendedEuclid(B, A%B);
                int temp = p;
                p = q;
                q = temp - (A/B)*q;
            }
        }
        
        public static long LCM(long a,long b)
        {
            return (a*b)/GCD(a,b);
        }
        
        public static int LCM(int a,int b)
        {
            return (a*b)/GCD(a,b);
        }
        
        public static int binaryExponentiation(int x,int n)
        {
            int result=1;
            while(n>0)
            {
                if(n % 2 ==1)
                    result=result * x;
                x=x*x;
                n=n/2;
            }
            return result;
        }
        
        public static long binaryExponentiation(long x,long n)
        {
            long result=1;
            while(n>0)
            {
                if(n % 2 ==1)
                    result=result * x;
                x=x*x;
                n=n/2;
            }
            return result;
        }
        
        public static int modularExponentiation(int x,int n,int M)
        {
            int result=1;
            while(n>0)
            {
                if(n % 2 ==1)
                    result=(result * x)%M;
                x=(x%M*x)%M;
                n=n/2;
            }
            return result;
        }
        
        public static long modularExponentiation(long x,long n,long M)
        {
            long result=1;
            while(n>0)
            {
                if(n % 2 ==1)
                    result=(result%M * x%M)%M;
                x=(x%M * x%M)%M;
                n=n/2;
            }
            return result;
        }
        
        public static long modInverse(int A,int M)
        {
            return modularExponentiation(A,M-2,M);
        }
        
        public static long modInverse(long A,long M)
        {
            return modularExponentiation(A,M-2,M);
        }
        
        public static boolean isPrime(int n)
        {
            
            if (n <= 1)  return false;
            if (n <= 3)  return true;
            
            if (n%2 == 0 || n%3 == 0) 
                return false;
         
            for (int i=5; i*i<=n; i=i+6)
            {
                if (n%i == 0 || n%(i+2) == 0)
                   return false;
            }
            
            return true;
        }
        
         public static long[] shuffle(long[] a, Random gen){ 
                for(int i = 0, n = a.length;i < n;i++){ 
                    int ind = gen.nextInt(n-i)+i; 
                    long d = a[i]; 
                    a[i] = a[ind]; 
                    a[ind] = d; 
                } 
                return a; 
            }
         static class pair implements Comparable<pair>{
        	 Long x;
             Long y;
             Integer z;
             pair(long l,long y2,int z){
                 this.x=l;
                 this.y=y2;
                 this.z=z;
             }
              public int compareTo(pair o) {
                     int result = x.compareTo(o.x);
                     if(result==0)
                         result = y.compareTo(o.y);
                     
                 return result;
                 }  
              public String toString(){
                 return (x+" "+y);
             }
       }       
 
      
}