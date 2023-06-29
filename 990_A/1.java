

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.util.*;
  
public class er45a
{ 
    //By shwetank_verma
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
    static int mod=1000000007;
    static boolean primes[]=new boolean[1000007];
    static ArrayList<Integer> b=new ArrayList<>();
    static boolean seive(int n){
        Arrays.fill(primes,true);
        primes[0]=primes[1]=false;
        for(int i=2;i*i<=n;i++){
            if(primes[i]==true){
                for(int p=i*i;p<=n;p+=i){
                    primes[p]=false;
                }
            }
        }
        if(n<1000007){
        	for(int i=2;i<=n;i++) {
        		if(primes[i])
        			b.add(i);
        	}
            return primes[n];
        }
        return false;
        
    }
    static int gcd(int a,int b){
        if(b==0)
        return a;
        return gcd(b,a%b);
    }
    static long GCD(long a,long b){
        if(b==0)
        return a;
        return GCD(b,a%b);
    }
    static ArrayList<Integer> segseive(int l,int r){
    	
    	ArrayList<Integer> isprime=new ArrayList<Integer>();
    	boolean p[]=new boolean[r-l+1];
    	Arrays.fill(p, true);
        
    	for(int i=0;b.get(i)*b.get(i)<=r;i++) {
    		int currprime=b.get(i);
    		int base=(l/currprime)*currprime;
    		if(base<l) {
    			base+=currprime;
    		}
    		for(int j=base;j<=r;j+=currprime) {
    			p[j-l]=false;
    		}
    		
    		
    		if(base==currprime) {
    			p[base-l]=true;
    		}
    		
    	}
    	for(int i=0;i<=r-l;i++) {
    		if(p[i])
    			isprime.add(i+l);
    	}
    	return isprime;
    }
      
  
    public static void main(String[] args) 
    { 
        FastReader sc=new FastReader(); 
        try{
           long n=sc.nextLong();
           long m=sc.nextLong();
           long a=sc.nextLong();
           long b=sc.nextLong();
           long ans1=n/m * m + m - n;
           long ans2=n%m;
           long ans=Long.min(ans1*a,ans2*b);
           System.out.println(ans);
            
        }catch(Exception e){
            return;
        }
    } 
}

