/*
 * DA-IICT
 * Author: Jugal Kalal
 */
import java.util.*;
import java.io.*;
import java.math.*;
import java.text.DecimalFormat;
public class Practice{
	static long MOD=(long)Math.pow(10,9)+7;
	public static void main(String args[]) {
        new Thread(null, new Runnable() {
            public void run() {
                try{
                    solve();
                    w.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }, "1", 1 << 26).start();
	}
	static InputReader in;
    static PrintWriter w;
    static void solve(){
        in = new InputReader(System.in);
        w = new PrintWriter(System.out);
        long n=in.nextLong();
        long s=in.nextLong();
        long low=1,high=n,ans=-1;
        while(low<=high){
        	long mid=(low+high)/2;
        	if(check(mid,s)){
        		ans=mid;
        		high=mid-1;
        	}else{
        		low=mid+1;
        	}
        }
        if(ans==-1){
        	w.println(0);
        }else
        	w.println(n-ans+1);
    }
    static boolean check(long n,long s){
    	long temp=n;
    	long sum=0;
    	while(temp>0){
    		sum+=temp%10;
    		temp=temp/10;
    	}
    	if(n-sum>=s){
    		return true;
    	}
    	return false;
    }
    static int adj[][];
//    static ArrayList<Integer> adj[]; //Adjacency Lists
    static int V;   // No. of vertices
    // Constructor
    static void Graph(int v){
        V = v;
        adj=new int[v][v];
//        adj = new ArrayList[v];
//        for (int i=0; i<v; ++i){
//        	adj[i] = new ArrayList();
//        }
    }
    // Function to add an edge into the graph
    static void addEdge(int u,int v,int w){
//		adj[u].add(v);
//		adj[v].add(u);
    	adj[u][v]=w;
    }
//    static void bfs(int s,int n){
//    	boolean visited[]=new boolean[n];
//    	LinkedList<Integer> queue=new LinkedList<Integer>();
//    	queue.add(s);
//    	visited[s]=true;
//    	while(!queue.isEmpty()){
//    		int num=queue.pop();
////    		System.out.println(ans.toString());
//    		for(int i=0;i<adj[num].size();i++){
//    			if(!visited[adj[num].get(i)]){
//    				visited[adj[num].get(i)]=true;
//    				queue.add(adj[num].get(i));
//    			}
//    		}
//    	}
//    }
    static long gcd(long a,long b){
		if(a==0){
			return b;
		}
		return gcd(b%a,a);
	}
    static long power(long base, long exponent, long modulus){
	    long result = 1L;
	    while (exponent > 0) {
	        if (exponent % 2L == 1L)
	            result = (result * base) % modulus;
	        exponent = exponent >> 1;
	        base = (base * base) % modulus;
	    }
	    return result;
	}
    static HashMap<Long,Long> primeFactors(long n){
        HashMap<Long,Long> ans=new HashMap<Long,Long>();
    	// Print the number of 2s that divide n
        while (n%2L==0L)
        {
            if(ans.containsKey(2L)){
            	ans.put(2L,ans.get(2L)+1L);
            }else{
            	ans.put(2L,1L);
            }
            n /= 2L;
        }
 
        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (long i = 3; i <= Math.sqrt(n); i+= 2L)
        {
            // While i divides n, print i and divide n
            while (n%i == 0)
            {
            	if(ans.containsKey(i)){
                	ans.put(i,ans.get(i)+1L);
                }else{
                	ans.put(i,1L);
                }
                n /= i;
            }
        }
 
        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if (n > 2)
            ans.put(n,1L);
        return ans;
    }
////for marking all prime numbers greater than 1 and less than equal to N
	static void sieve(int N) {
	 boolean isPrime[]=new boolean[N+1];
	 isPrime[0] = true;
	 isPrime[1] = true;
	 for(int i = 2; i * i <= N; ++i) {
	      if(isPrime[i] == false) {//Mark all the multiples of i as composite numbers
	          for(int j = i * i; j <= N ;j += i)
	              isPrime[j] = true;
	     }
	 }
	}
//  //if  str2 (pattern) is subsequence of str1 (Text) or not
//	static boolean function(String str1,String str2){
//	     str2 = str2.replace("", ".*");  //returns .*a.*n.*n.*a.
//	     return (str1.matches(str2));  // returns true
//	}
    static int Arr[];
    static long size[];
  //modified initialize function:
    static void initialize(int N){
    	Arr=new int[N];
    	size=new long[N];
        for(int i = 0;i<N;i++){
        	Arr[ i ] = i ;
        	size[ i ] = 1;
        }
    }
    static boolean find(int A,int B){
        if( root(A)==root(B) )       //if A and B have same root,means they are connected.
        return true;
        else
        return false;
    }
 // modified root function.
    static void weighted_union(int A,int B,int n){
        int root_A = root(A);
        int root_B = root(B);
        if(size[root_A] < size[root_B ]){
        	Arr[ root_A ] = Arr[root_B];
        	size[root_B] += size[root_A];
        }
        else{
        	Arr[ root_B ] = Arr[root_A];
        	size[root_A] += size[root_B];
        }
    }
    static int root (int i){
        while(Arr[ i ] != i){
            Arr[ i ] = Arr[ Arr[ i ] ] ; 
            i = Arr[ i ]; 
        }
        return i;
    }
    
 
	static boolean isPrime(long n) {
		if(n < 2L) return false;
		if(n == 2L || n == 3L) return true;
		if(n%2L == 0 || n%3L == 0) return false;	
		long sqrtN = (long)Math.sqrt(n)+1L;
		for(long i = 6L; i <= sqrtN; i += 6L) {
			if(n%(i-1) == 0 || n%(i+1) == 0) return false;
		}
		return true;
	}
//	static HashMap<Integer,Integer> level;;
//	static HashMap<Integer,Integer> parent;
	static int maxlevel=0;
	
//	static boolean T[][][];
//	static void subsetSum(int input[], int total, int count) {
//        T = new boolean[input.length + 1][total + 1][count+1];
//        for (int i = 0; i <= input.length; i++) {
//        	T[i][0][0] = true;
//        	for(int j = 1; j<=count; j++){
//        		T[i][0][j] = false;
//        	}
//        }
//        int sum[]=new int[input.length+1];
//        for(int i=1;i<=input.length;i++){
//            sum[i]=sum[i-1]+input[i-1];
//        }
//        for (int i = 1; i <= input.length; i++) {
//            for (int j = 1; j <= (int)Math.min(total,sum[i]); j++) {
//            	for (int k = 1; k <= (int)Math.min(i,count); k++){
//            		 if (j >= input[i - 1]) {//Exclude and Include
//                         T[i][j][k] = T[i - 1][j][k] || T[i - 1][j - input[i - 1]][k-1];
//                     } else {
//                         T[i][j][k] = T[i-1][j][k];
//                     }
//            	}
//            }
//        }
//    }
//	static <K,V extends Comparable<? super V>>
//	SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
//	    SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
//	        new Comparator<Map.Entry<K,V>>() {
//	            @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
//	                int res = e2.getValue().compareTo(e1.getValue());
//	                return res != 0 ? res : 1;
//	            }
//	        }
//	    );
//	    sortedEntries.addAll(map.entrySet());
//	    return sortedEntries;
//	}
	
 
	 
	//minimum prime factor of all the numbers less than n
    static int minPrime[];
	static void minimumPrime(int n){
		minPrime=new int[n+1];
		minPrime[1]=1;
        for (int i = 2; i * i <= n; ++i) {
            if (minPrime[i] == 0) {         //If i is prime
                for (int j = i * i; j <= n; j += i) {
                    if (minPrime[j] == 0) {
                        minPrime[j] = i;
                    }
                }
            }
        }
        for (int i = 2; i <= n; ++i) {
            if (minPrime[i] == 0) {
                minPrime[i] = i;
            }
        }
	}
	static long modInverse(long A, long M)
	{
		long x=extendedEuclid(A,M)[0];
		return (x%M+M)%M;    //x may be negative
	}
	static long[] extendedEuclid(long A, long B) {
		if(B == 0) {
			long d = A;
			long x = 1;
			long y = 0;
			return new long[]{x,y,d};
		}
		else {
			long arr[]=extendedEuclid(B, A%B);
			long temp = arr[0];
			arr[0] = arr[1];
			arr[1] = temp - (A/B)*arr[1];
			return arr;
		}
	}
 
	static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, numChars;
        private SpaceCharFilter filter;
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
        
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
 
        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }
 
        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
 
        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
 
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
	}
}