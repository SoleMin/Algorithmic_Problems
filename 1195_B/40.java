import java.util.*;
import java.math.*;

// **** B. Sport Mafia ****

public class B {
	static char [] in = new char [1000000];
	public static void main (String [] arg) throws Throwable {
		int n = nextInt();
		int k = nextInt();
		
		long ate = 0;
		long ans = -1;
		for (long i = 1; ans < 0; ++i) {
			long test = (i * (i+1)) / 2;
			if (test < k) continue;
			
			long adding_moves = i;
			long eating_moves = n-i;
			if (test - eating_moves == k) ans = eating_moves;
		}
		System.out.println(ans);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	/************** HELPER CLASSES ***************/
    //static class HS extends HashSet<Integer>{public HS(){super();}public HS(int a){super(a);}};
	//static class AL extends ArrayList<Integer>{public AL(){super();}public AL(int a){super (a);}};
	static class Pair implements Comparable<Pair> {
		int i,j;long L; public Pair(int xx, int yy, long LL){i=xx;j=yy;L=LL;} 
		public int compareTo(Pair p) { return (this.L < p.L) ? -1 : ((this.L == p.L && this.i < p.i) ? -1 : 1);}
	}
	/************** FAST IO CODE FOLLOWS *****************/
	public static long nextLong() throws Throwable {
		long i = System.in.read();boolean neg = false;while (i < 33) i = System.in.read();if (i == 45) {neg=true;i=48;}i = i - 48;
		int j = System.in.read();while (j > 32) {i*=10;i+=j-48;j = System.in.read();}return (neg) ? -i : i;
	}
	public static int nextInt() throws Throwable {return (int)nextLong();}
	public static String next() throws Throwable {
		int i = 0; while (i < 33 && i != -1) i = System.in.read(); int cptr = 0; while (i >= 33) { in[cptr++] = (char)i; i = System.in.read();}
		return new String(in, 0,cptr);
	}
	/**** LIBRARIES ****/
	public static long gcdL(long a, long b) {while (b != 0) {long tmp = b;b = (a % b);a = tmp;}return a;}
	public static int gcd(int a, int b) {while (b != 0) {int tmp = b;b = (a % b);a = tmp;}return a;}
	public static int[] sieve(int LIM) {
		int i,count = 0;
		boolean [] b = new boolean [LIM];
		for (i = 2;i<LIM; ++i) if (!b[i]) {count++; for (int j = i<<1; j<LIM; j+=i) b[j] = true;}
		int [] primes = new int[count];
		for (i = 2,count=0;i<LIM;++i) if (!b[i]) primes[count++] = i;
		return primes;
	}
	public static int[] numPrimeFactors(int LIM) {
		int i,count = 0;
		int [] b = new int [LIM];
		for (i = 2;i<LIM; ++i) if (b[i] == 0) {count++; for (int j = i; j<LIM; j+=i) b[j]++;}
		return b;
	}
	public static StringBuilder stringFromArray(int [] a) {
		StringBuilder b = new StringBuilder(9*a.length);
		for (int i = 0; i<a.length; ++i) {
			if (i != 0) b = b.append(' ');
			b = b.append(a[i]);
		}
		return b;
	}
	public static long modPow (long a, long n, long MOD) { long S = 1; for (;n > 0; n>>=1, a=(a*a)%MOD) if ((n & 1) != 0) S = (a*S) % MOD; return S;}
}

/* Full Problem Text:
  
Each evening after the dinner the SIS's students gather together to play the game of Sport Mafia.
For the tournament, Alya puts candies into the box, which will serve as a prize for a winner.
To do that, she performs n actions.
The first action performed is to put a single candy into the box.
For each of the remaining moves she can choose from two options:
 
 the first option, in case the box contains at least one candy, is to take exactly one candy out and eat it.
This way the number of candies in the box decreased by 1; 
 the second option is to put candies in the box.
In this case, Alya will 1 more candy, than she put in the previous time.
Thus, if the bank is empty, then it can only use the second option.
For example, one possible sequence of Alya's actions look as follows:
 
 put one candy into the box; 
 put two candies into the box; 
 eat one candy from the box; 
 eat one candy from the box; 
 put three candies into the box; 
 eat one candy from the box; 
 put four candies into the box; 
 eat one candy from the box; 
 put five candies into the box; 
This way she will perform 9 actions, the of candies at the end will be 11, while Alya will eat 4 candies in total.
You know the total number of actions n and the number of candies at the end k.
You need to find the total number of sweets Alya ate.
That is the number of moves of the second option.
It's guaranteed, that for the given n and k the answer always exists.
Please note, that during an action of the first option, Alya takes out and eats exactly one candy.

 */