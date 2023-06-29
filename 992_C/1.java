//I AM THE CREED
/* //I AM THE CREED
/* package codechef; // don't place package name! */
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
import java.util.*;
import java.awt.Point;
public class Main{
    static final Random random=new Random();
    public static void main(String[] args) throws IOException 
    { 
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            long x=input.nextLong();
            long k=input.nextLong();
            long mod=1000000007;
            if(x==0){
                System.out.println(x);
                continue;
            }
            if(k==0){
                System.out.println(((long)(2)*x)%mod);
                continue;
            }
            x=x%mod;
            long ans=(x*(pow(k+1)))%mod;
            ans=(ans-(pow(k)-1)+mod)%mod;
            System.out.println(ans);
        }
        
    }
    static long pow(long n)
    {
        long ret = 1;
        long a = 2;
        long MODULO=1000000007;
        while (n > 0) {
            if (n%2==1) ret = ret * a % MODULO;
            a = a * a % MODULO;
            n >>= 1;
        }
        return ret;
    }
    static boolean isPrime(int n)
    {
 
        // Check if number is less than
        // equal to 1
        if (n <= 1)
            return false;
 
        // Check if number is 2
        else if (n == 2)
            return true;
 
        // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;
 
        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2) 
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b; 
        return gcd(b % a, a); 
    }
     
    // method to return LCM of two numbers
    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }
     
    //Credits to SecondThread(https://codeforces.com/profile/SecondThread) for this tempelate
    static void ruffleSort(int [] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n);
			int temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
	}
    //Credits to SecondThread(https://codeforces.com/profile/SecondThread) for this tempelate.
    static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
    
    
}