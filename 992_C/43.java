import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

	static boolean visited[] ; 
	static boolean ends[] ;
	static long mod = 1000000007 ;
	static int lens[] ; 
	static int seeds[] ; 
	static int a[] ;
	static double total ; 
	public static ArrayList adj[] ; 
	public static long x,y ;
	public static ArrayList<Long> xx ;	
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc =  new Scanner(System.in) ;

		long x = sc.nextLong() ; 
		long k = sc.nextLong() ; 
		if(x==0)
		{System.out.println(0); return ;}
		if(k==0)
		{System.out.println((2l*x)%mod);return ;}	


		long m=pow(2,k);


		long a = 2l*(x%mod)*(m%mod);


		a = a-m+1 ;

		a=a%mod ; 
		if(a<0)a=(a%mod + mod) % mod;

		System.out.println(a);





	}

	// method to print the divisors
	static ArrayList<Long> divisors(long n)
	{
		ArrayList<Long> arr =  new ArrayList<Long>() ; 
		// Note that this loop runs till square root
		for (int i=1; i<=Math.sqrt(n); i++)
		{
			if (n%i==0)

				// If divisors are equal, print only one
				if (n/i == i)
				{arr.add(1l*i);arr.add(1l*i);}

				else // Otherwise print both
				{arr.add(1l*i); arr.add(1l*n/i);}

		}	

		return arr ;

	}

	public static void generate(long current)
	{
		if(current>10000000000l)
			return ; 

		xx.add(current) ; 
		generate((10*current) +4); 
		generate((10*current) +7);


	}

	public static int neededFromLeft(String x)
	{
		Stack<Character> st = new Stack<Character>() ; 
		int c=0;

		for (int i = 0; i < x.length(); i++)
		{
			char cur = x.charAt(i); 
			if(cur==')' && st.isEmpty())
				c ++; 
			else if(cur==')' && !st.isEmpty())
				st.pop();
			else if(cur=='(')
				st.push(cur);
		}
		return c;
	}

	public static int neededFromRight(String x)
	{
		Stack<Character> st = new Stack<Character>() ; 
		int c=0;
		boolean f=true; 
		for (int i = 0; i < x.length(); i++)
		{
			char cur = x.charAt(i); 
			if(cur==')' && st.isEmpty())
				f=false;  
			else if(cur==')' && !st.isEmpty())
				st.pop();
			else if(cur=='(')
				st.push(cur);
		}
		return st.size(); 
	}

	public static boolean fromBoth(String x)
	{
		Stack<Character> st = new Stack<Character>() ;
		boolean f1=true ,f2=true ; 

		for (int i = 0; i < x.length(); i++)
		{
			char cur = x.charAt(i); 
			if(cur==')' && st.isEmpty())
				f1 =false ; 
			else if(cur==')' && !st.isEmpty())
				st.pop();
			else if(cur=='(')
				st.push(cur);
		}
		if(st.size()>0)f2 = false ;

		if(f1==false && f2==false)
			return true ; 
		else 
			return false;
	}

	public static boolean isRegular(String x)
	{
		Stack<Character> st = new Stack<Character>() ; 
		for (int i = 0; i < x.length(); i++)
		{
			char cur = x.charAt(i); 
			if(cur==')' && st.isEmpty())
				return false ; 
			else if(cur==')' && !st.isEmpty())
				st.pop();
			else if(cur=='(')
				st.push(cur);
		}
		if(st.size()>0)return false ; else return true ;
	}


	public static int gcdExtended(int a, int b)
	{
		// Base Case
		if (a == 0)
		{
			x = 0;
			y = 1;
			return b;
		}

		//int x1=1, y1=1; // To store results of recursive call
		int gcd = gcdExtended(b%a, a);

		// Update x and y using results of recursive
		// call
		long x1 = y - (b/a) * x;
		long y1 = x;
		x = x1 ; 
		y = y1 ;

		return gcd;
	}









	static int even(String x , int b )
	{
		for (int j = b; j>=0; j--)
		{
			int current = x.charAt(j)-48 ; 
			if(current%2==0)
				return current ; 
		}
		return -1;
	}
	static int odd(String x , int b )
	{
		for (int j = b; j>=0; j--)
		{
			int current = x.charAt(j)-48 ; 
			if(current%2!=0)
				return current ; 
		}
		return -1;
	}
	static long pow(long base, long k) {
		long res = 1;
		while(k > 0) {
			if(k % 2 == 1) {
				res = (res * base) % mod;
			}

			base = (base * base) % mod;
			k /= 2;
		}

		return res;
	}
	public static long solve(int k1, long k2)
	{
		long x   = 1l*k2*(pow(2, k1)-1) ;
		return x%(1000000007) ; 
	}


	public static long getN(long x)
	{
		long n = (long) Math.sqrt(x*2) ; 
		long y = n*(n+1)/2; 
		if(y==x)
			return n ; 
		else if(y>x)
			return n ; 
		else
			for (long i = n; ; i++)
			{
				y = i*(i+1)/2 ; 
				if(y>=x)
					return i ; 


			}	}








	public static void dfss(int root , int len)
	{
		visited[root]=true ; 
		if(ends[root] && root!=0) lens[root] = len ; 

		for (int i = 0; i < adj[root].size(); i++)
		{
			int c= (int) adj[root].get(i) ; 
			if(visited[c]==false)
				dfss(c, len+1);
		}
	}

	public static void pr(int root ,  int seed){
		visited[root] = true ;
		int dv = adj[root].size()-1 ; 
		if(root==0) dv++ ;

		for (int i = 0; i < adj[root].size(); i++)
		{
			int c = (int)adj[root].get(i) ; 
			seeds[c]=dv*seed ;
		}

		for (int i = 0; i < adj[root].size() ; i++)
		{
			int c = (int)adj[root].get(i) ; 
			if(visited[c]==false)
				pr(c , seeds[c]);

		}

	}


	public static String concatinate(String s ,int n)
	{
		if(s.length()==n)
			return s ; 
		else return concatinate("0"+s, n) ;
	}
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}


	public static long getGCD(long n1, long n2) {
		if (n2 == 0) {
			return n1;
		}
		return getGCD(n2, n1 % n2);
	}

	public static int cnt1(int mat[][])  //how many swaps to be a 1 matrix
	{
		int m = mat.length ; 
		int c=0 ; 
		for (int i = 0; i < mat.length; i++)
		{
			for (int j = 0; j < mat.length; j++)
			{
				int x =  (i*m) +j ;
				if(x%2==0 && mat[i][j]==0)
					c++; 
				if(x%2!=0 && mat[i][j]==1)
					c++; 

			}
		}
		return c;
	}
	public static int cnt0(int mat[][])
	{
		int m = mat.length ; 
		int c=0 ; 
		for (int i = 0; i < mat.length; i++)
		{
			for (int j = 0; j < mat.length; j++)
			{
				int x =  (i*m) +j ; 
				if(x%2!=0 && mat[i][j]==0)
					c++; 
				if(x%2==0 && mat[i][j]==1)
					c++; 

			}
		}
		return c;
	}

	public static boolean canFit2(int x1, int y1 , int x2 , int y2 , int x3 , int y3){
		if(x1==x2)
			if(x1==x3)
				return true ; 
			else
				return false ;
		else
			if(x1==x3)
				return false ; 
			else
			{
				long a = 1l*(y2-y1)*(x3-x2) ; 
				long b = 1l*(y3-y2)*(x2-x1) ; 

				if(a==b)
					return true;
				else 
					return false ;

			}

	}
	public static void shuffle(pair[] ss){
		if(ss.length==1)
			return ; 
		for (int i = 0; i < ss.length; i++)
		{
			Random rand = new Random();

			int  n = rand.nextInt(ss.length-1) + 0;

			pair temp = ss[i] ; 
			ss[i] = ss[n] ; 
			ss[n] = temp ;
		}
	}
	public static int binary(ArrayList<pair> arr, int l, int r, long x)   /// begin by 0 and n-1
	{
		if (r>=l)
		{
			int mid = l + (r - l)/2;
			if (arr.get(mid).x== x)
				return mid;
			if (arr.get(mid).x> x)
				return binary(arr, l, mid-1, x);
			return binary(arr, mid+1, r, x);
		}
		return -1;
	}

	/// searching for the index of first elment greater than x
	public static int binary1(int[]arr , int x) {
		int low = 0, high = arr.length; // numElems is the size of the array i.e arr.size() 
		while (low != high) {
			int mid = (low + high) / 2; // Or a fancy way to avoid int overflow
			if (arr[mid] <= x) {
				/* This index, and everything below it, must not be the first element
				 * greater than what we're looking for because this element is no greater
				 * than the element.
				 */
				low = mid + 1;
			}
			else {
				/* This element is at least as large as the element, so anything after it can't
				 * be the first element that's at least as large.
				 */
				high = mid;
			}
		}
		return low ; // return high ; 
	}


	////// searching for last element less than X 
	public static int binary2(pair[]arr , int x) {
		int low = 0, high = arr.length; // numElems is the size of the array i.e arr.size() 
		while (low != high) {
			int mid = (low + high) / 2; // Or a fancy way to avoid int overflow
			if (arr[mid].x >= x) {
				/* This index, and everything below it, must not be the first element
				 * greater than what we're looking for because this element is no greater
				 * than the element.
				 */
				high=mid;
			}
			else {
				/* This element is at least as large as the element, so anything after it can't
				 * be the first element that's at least as large.
				 */
				low = mid+1 ; 
			}
		}
		return low ; // return high ; 
	}


	private static boolean triangle(int a, int b , int c){
		if(a+b>c && a+c>b && b+c>a)
			return true ; 
		else 
			return false ;
	}
	private static boolean segment(int a, int b , int c){
		if(a+b==c || a+c==b && b+c==a)
			return true ; 
		else 
			return false ;
	}
	private static int gcdThing(long a, long b) {
		BigInteger b1 = BigInteger.valueOf(a);
		BigInteger b2 = BigInteger.valueOf(b);
		BigInteger gcd = b1.gcd(b2);
		return gcd.intValue();
	}

	public static boolean is(int i){
		if(Math.log(i)/ Math.log(2) ==(int) (Math.log(i)/ Math.log(2)))
			return true ; 
		if(Math.log(i)/ Math.log(3) ==(int) (Math.log(i)/ Math.log(3)) )
			return true ; 
		if(Math.log(i)/ Math.log(6) ==(int) (Math.log(i)/ Math.log(6)) )
			return true ; 

		return false;

	}
	public static boolean contains(int b[] , int x)
	{
		for (int i = 0; i < b.length; i++)
		{
			if(b[i]==x)
				return true ;
		}
		return false ;
	}
	public static int binary(long []arr , long target , int low , long shift) {
		int high = arr.length; 
		while (low != high) {
			int mid = (low + high) / 2; 
			if (arr[mid]-shift <= target) {
				low = mid + 1;
			}
			else {
				high = mid;
			}
		}
		return low ; // return high ; 
	}
	public static boolean isLetter(char x){
		if(x+0 <=122 && x+0 >=97 )
			return true ;
		else if (x+0 <=90 && x+0 >=65 )
			return true ; 
		else return false; 
	}
	public static long getPrimes(long x ){
		if(x==2 || x==3 || x==1)
			return 2 ;
		if(isPrime(x))
			return 5 ;
		for (int i = 2; i*i<=x; i++)
		{
			if(x%i==0 && isPrime(i))
				return getPrimes(x/i) ;
		}
		return -1;
	}
	public static String solve11(String x){

		int n = x.length() ; 
		String y = "" ;
		for (int i = 0; i < n-2; i+=2)
		{
			if(ifPalindrome(x.substring(i, i+2)))
				y+= x.substring(i, i+2) ;
			else 
				break ;
		}
		return y+ solve11(x.substring(y.length(),x.length())) ;

	}
	public static String solve1(String x){
		String y = x.substring(0 , x.length()/2) ; 
		return "" ;

	}
	public static String reverse(String x){
		String y ="" ;
		for (int i = 0; i < x.length(); i++)
		{
			y  = x.charAt(i) + y ;
		}
		return y ;
	}

	public static boolean ifPalindrome(String x){
		int numbers[] = new int[10] ; 
		for (int i = 0; i < x.length(); i++)
		{
			int z = Integer.parseInt(x.charAt(i)+"") ; 
			numbers[z] ++ ;
		}
		for (int i = 0; i < numbers.length; i++)
		{
			if(numbers[i]%2!=0)
				return false; 
		}
		return true ;	
	}

	public static int get(int n){
		return n*(n+1)/2 ; 
	}
	//		public static long getSmallestDivisor( long y){
	//			if(isPrime(y))
	//				return -1;
	//
	//			for (long i = 2; i*i <= y; i++)
	//			{
	//				if(y%i ==0)
	//				{
	//					return i;
	//				}
	//			}
	//			return -1;
	//		}
	public static int lis( int[]a , int n){
		int lis[] = new int[n] ; 
		Arrays.fill(lis,1) ; 

		for(int i=1;i<n;i++)
			for(int j=0 ; j<i; j++)
				if (a[i]>a[j] &&  lis[i] < lis[j]+1)   
					lis[i] = lis[j] + 1;           

		int max = lis[0];

		for(int i=1; i<n ; i++)
			if (max < lis[i])
				max = lis[i] ;
		return (max);

		//			ArrayList<Integer> s = new ArrayList<Integer>() ;
		//			for (int i = n-1; i >=0; i--)
		//			{
		//				if(lis[i]==max)
		//				{
		//					s.add(a[i].z);
		//					max --; 
		//				}
		//			}
		//
		//			for (int i = s.size()-1 ; i>=0 ;  i--)
		//			{
		//				System.out.print(s.get(i)+" ");
		//			}
		//
	}
	public static int calcDepth(Vertix node){
		if(node.depth>0) return node.depth; 
		// meaning it has been updated before;
		if(node.parent != null)
			return 1+ calcDepth(node.parent);
		else
			return -1;
	}

	public static boolean isPrime (long num){
		if (num < 2) return false;
		if (num == 2) return true;
		if (num % 2 == 0) return false;
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0) return false;
		return true;
	}


	public static ArrayList<Long> getDiv(Long n)
	{
		ArrayList<Long>  f = new ArrayList<Long>() ; 

		while (n%2==0)
		{
			if(!f.contains(2))f.add((long) 2) ;
			n /= 2;
		}

		// n must be odd at this point.  So we can
		// skip one element (Note i = i +2)
		for (long i = 3; i <= Math.sqrt(n); i+= 2)
		{
			// While i divides n, print i and divide n
			while (n%i == 0)
			{
				if(!f.contains(i))f.add(i);
				n /= i;
			}
		}

		// This condition is to handle the case whien
		// n is a prime number greater than 2
		if (n > 2)
			if(!f.contains(n))f.add(n);


		return f ;



	}

	//		public static boolean dfs(Vertix v , int target){
	//			try{
	//				visited[v.i]= true ;
	//			} catch (NullPointerException e)
	//			{
	//				System.out.println(v.i);
	//			}
	//			if(v.i == target)
	//
	//				return true ;
	//			for (int i =0 ; i< v.neighbours.size() ; i++)
	//			{ 
	//
	//				Vertix child = v.neighbours.get(i) ;
	//				if(child.i == target){
	//					found = true  ; 
	//				}
	//				if(visited[child.i]==false){
	//					found |= dfs(child, target) ;
	//				}
	//			}
	//			return found; 
	//		}









	public static class Vertix{
		long i ; 
		int depth ;
		ArrayList<Vertix> neighbours ; 
		Vertix parent ; 
		Vertix child ; 


		public Vertix(long i){
			this.i = i ;
			this.neighbours = new ArrayList<Vertix> () ;
			this.parent = null ;
			depth =-1;
			this.child = null ;
		}
	}

	public static class pair implements Comparable<pair> {
		int x ;
		int y ;
		int i;




		public pair(int x, int y, int i ){

			this.x=x ; 
			this.y =y ;
			this.i =i ;


		}


		@Override
		public int compareTo(pair p) {
			if(this.x > p.x)
				return 1 ; 
			else if (this.x == p.x) 
				return 0 ; 
			else 
				return -1 ;
		}




	}

	public static class pair2 implements Comparable<pair2>{
		int i ; 
		int j ;
		int plus ;

		public pair2(int i , int j , int plus){
			this.i =i ;
			this.j = j ; 
			this.plus = plus ;
		}

		@Override
		public int compareTo(pair2 p) {
			if(this.j > p.j)
				return 1 ; 
			else if (this.j == p.j) return 0 ;
			else 
				return -1 ;
		}


	}
	public static class point implements  Comparable<point>
	{
		int x, y ; 
		public point(int x,int y){
			this.x=x ; this.y=y;
		}
		@Override
		public boolean equals(Object o) {

			// If the object is compared with itself then return true  
			if (o == this) {
				return true;
			}

			/* Check if o is an instance of Complex or not
	          "null instanceof [type]" also returns false */
			if (!(o instanceof point)) {
				return false;
			}

			// typecast o to Complex so that we can compare data members 
			point c = (point) o;

			// Compare the data members and return accordingly 
			return Integer.compare(x, c.x) == 0
					&& Integer.compare(y, c.y) == 0;
		}
		@Override
		public int compareTo(point p) {
			if(this.x == p.x && this.y ==p.y)
				return 0 ; 
			else
				return -1 ; 
		}

		@Override
		public int hashCode()
		{
			return 15+x+(y%2) ;
		}



	}


}