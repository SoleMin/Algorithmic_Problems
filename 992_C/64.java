
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Tester
{
    
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
    
    static long mod = 1000000007;
    public static void main(String[] args) {
    	
    	solveQ3();
    
    }

	private static void solveQ3() {
		// TODO Auto-generated method stub
		
		FastReader sc = new FastReader();
		
		long x = sc.nextLong();
		long k = sc.nextLong();
		
		if(x == 0) {
			System.out.println(0);
			return;
		}
		long ans = modExp(2, k);
		x = (2*x)%mod;
		x = (x - 1 + mod)%mod;
		ans = (ans*x)%mod;
		ans = (ans + 1)%mod;
		
		System.out.println(ans);
		
	}
	
	private static long modExp(long a, long n) {
		
		if(n == 0)
			return 1;
		if(n%2 == 0)
			return modExp((a*a)%mod, n/2);
		else
			return (a*modExp((a*a)%mod, n/2))%mod;
		
	}

	private static void solveQ2() {
		// TODO Auto-generated method stub
		
		FastReader sc = new FastReader();
		long l = sc.nextLong();
		long r = sc.nextLong();
		
		long x = sc.nextLong();
		long y = sc.nextLong();
		
		long n = x*y;
		long count = 0;
		
		for(long i=l; (i<=Math.sqrt(n)) && (n/i<=r); i++) {
			
			if((n%i == 0) && (gcd(i, n/i)==x)) {
				
				if(i*i != n)
					count += 2;
				else
					count += 1;
				
			}
			
		}
		
		System.out.println(count);
		
		
	}
	
	public static long gcd(long a, long b) {
		
		if(b==0)
			return a;
		else
			return gcd(b, a%b);
		
	}

	private static void solveQ1() {
		// TODO Auto-generated method stub
		
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			if(x != 0) {
				hs.add(x);
			}
		}
		
		System.out.println(hs.size());
				
		
	}
}
