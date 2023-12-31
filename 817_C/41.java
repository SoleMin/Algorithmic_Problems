	        			/*
	        		     * Author- Priyam Vora
	        		     * BTech 2nd Year DAIICT
	        		     */
	     
	     
	        		    import java.awt.Checkbox;
	import java.awt.Point;
	import java.io.*;
	        		    import java.math.*;
	        		    import java.util.*;
	import java.util.Map.Entry;
	
	import javax.print.attribute.SetOfIntegerSyntax;
	
	     
	        		    public class Main{
	        		  	private static InputStream stream;
	        		    	private static byte[] buf = new byte[1024];
	        		    	private static int curChar;
	        		    	private static int numChars;
	        		    	private static SpaceCharFilter filter;
	        		    	private static PrintWriter pw;
	        		    	private static long count = 0,mod=1000000007;
	        		    //	private static TreeSet<Integer> ts=new TreeSet[200000];
	        		    	public final static int INF = (int) 1E9;
	
	        		        
	        		        public static void main(String[] args) {
	        		        	InputReader(System.in);
	        		    		pw = new PrintWriter(System.out); 
	        		            new Thread(null ,new Runnable(){
	        		               public void run(){
	        		                   try{
	        		                       solve();
	        		                       pw.close();
	        		                   } catch(Exception e){
	        		                       e.printStackTrace();
	        		                   }
	        		               }
	        		           },"1",1<<26).start();
	        		       }
	        		        public static void test(){
	        		        	int t=nextInt();
	        		        	while(t-->0){
	        		        		solve();
	        		        	}
	        		        }
	        		        public static long pow(long n, long p,long mod) {
	        					if(p==0)
	        						return 1;
	        					if(p==1)
	        						return n%mod;
	        					if(p%2==0){
	        						long temp=pow(n, p/2,mod);
	        					return (temp*temp)%mod;
	        					}else{
	        						 	long temp=pow(n,p/2,mod);
	        						 	temp=(temp*temp)%mod;
	        						 	return(temp*n)%mod;
	        						 	
	        					}
	        				}
	        		        public static long pow(long n, long p) {
	        					if(p==0)
	        						return 1;
	        					if(p==1)
	        						return n;
	        					if(p%2==0){
	        						long temp=pow(n, p/2);
	        					return (temp*temp);
	        					}else{
	        						 	long temp=pow(n,p/2);
	        						 	temp=(temp*temp);
	        						 	return(temp*n);
	        						 	
	        					}
	        				}
	        		        public static void Merge(long a[],int p,int r){
	        		            if(p<r){
	        		                int q = (p+r)/2;
	        		                Merge(a,p,q);
	        		                Merge(a,q+1,r);
	        		                Merge_Array(a,p,q,r);
	        		            }
	        		        }
	        		        public static void Merge_Array(long a[],int p,int q,int r){
	        		           long b[] = new long[q-p+1];
	        		            long c[] = new long[r-q];
	        		            for(int i=0;i<b.length;i++)
	        		                b[i] = a[p+i];
	        		            for(int i=0;i<c.length;i++)
	        		                c[i] = a[q+i+1];
	        		            int i = 0,j = 0;
	        		            for(int k=p;k<=r;k++){
	        		                if(i==b.length){
	        		                    a[k] = c[j];
	        		                    j++;
	        		                }
	        		                else if(j==c.length){
	        		                    a[k] = b[i];
	        		                    i++;
	        		                }
	        		                else if(b[i]<c[j]){
	        		                    a[k] = b[i];
	        		                    i++;
	        		                }
	        		                else{
	        		                    a[k] = c[j];
	        		                    j++;
	        		                }
	        		            }
	        		        }
	        		    	public static long gcd(long x, long y) {
	        		    		if (x == 0)
	        		    			return y;
	        		    		else
	        		    			return gcd( y % x,x);
	        		    	}	public static boolean isPrime(int n) {
	        		    	// Corner cases
				    		if (n <= 1)
				    			return false;
				    		if (n <= 3)
				    			return true;
				     
				    		// This is checked so that we can skip 
				    		// middle five numbers in below loop
				    		if (n % 2 == 0 || n % 3 == 0)
				    			return false;
				     
				    		for (int i = 5; i * i <= n; i = i + 6)
				    			if (n % i == 0 || n % (i + 2) == 0)
				    				return false;
				     
				    		return true;
				    	}
	        		        static LinkedList<Integer> adj[];
	        		        static boolean Visited[];
	        		        static HashSet<Integer> exc;
	        		        static long oddsum[]=new long[1000001];
	        		        static int co=0,ans=0;
	        		       
	        		        static int n,m;
	        		        static String s[];
	        		        static int ind;
	        		        public static void solve() {
	        		  
	        		    	
	        	
	        		        	long n=nextLong();
	        		        	long s=nextLong();
	        		        	long low=1,high=n,ans=-1;
	        		        	while(low<=high){
	        		        		long mid=(low+high)/2;
	        		        		if(check(mid,s)){
	        		        			ans=mid;
	        		        			high=mid-1;
	        		        		}else
	        		        		{
	        		        			low=mid+1;
	        		        		}
	        		        				
	        		        	}
	        		        	if(ans==-1)
	        		        		pw.println(0);
	        		        	else
	        		        		pw.println(n-ans+1);
	        	
	        		        }
	        		        private static boolean check(long mid,long s){
	        		        	long n=mid;
	        		        	int sum=0;
	        		        	while(mid>0){
	        		        		sum+=(mid%10);
	        		        		mid/=10;
	        		        	}
	        		        	if(n-sum >=s)
	        		        		return true;
	        		        	return false;
	        		        				
	        		        }
	        		        
	        		        static int[] levl;
	        		        static int h_max=0;
	        		     public static void dfs(int curr,int lev){
	        		    	 Visited[curr]=true;
	        		    	 levl[curr]=lev;
	        		    	 h_max=Math.max(h_max, levl[curr]);
	        		    	 for(int x:adj[curr]){
	        		    		 if(!Visited[x]){
	        		    			 dfs(x,lev+1);
	        		    		 }
	        		    	 }
	        		     }
	        		       
	        		        public static String reverseString(String s) {
	        					StringBuilder sb = new StringBuilder(s);
	        					sb.reverse();
	        					return (sb.toString());
	        				}
	        		        
	        		        
	        		        private static void BFS(int sou,int dest){
	        		        	Queue<Integer> q=new LinkedList<Integer>();
	        		        	q.add(sou);
	        		        	Visited[sou]=true;
	        		        	while(!q.isEmpty()){
	        		        		int top=q.poll();
	        		        		
	        		        		for(int i:adj[top]){
	        		        			//pw.println(i+" "+top);
	        		        			if(!Visited[i])
	        		        			{
	        		        				
	        		        				q.add(i);
	        		        			}
	        		        			
	        		        			Visited[i]=true;
	        		        			if(i==dest){
	        		        				pw.println("Yes");
	        		        			return;	
	        		        			}
	        		        		}
	        		        	}
	        		        	pw.println("No");
	        		        	
	        		        	
	        		        }
	        		        
	        		        private static long ncr(int n,int k){
	    				    	if (k < 0 || k > n) return 0;
	    				        if (n-k < k) k = n-k;
	    			
	    				        BigInteger x = BigInteger.ONE;
	    				        for (int i = 1; i <= k; i++) {
	    				            x = x.multiply(new BigInteger(""+(n-i+1)));
	    				            x = x.divide(new BigInteger(""+i));
	    				        }
	    			
	    				return x.longValue();
	    				    }
	        		       private  static long fact(long count){
	        		        	long ans=1;
	        		        	for(int i=1;i<=count;i++){
	        		        		ans*=i;
	        		        	}
	        		        	return ans;
	        		        }
	        		        
	        		        
	        		        static int state=1;
	        		        static long no_exc=0,no_vert=0;
	        		      static Stack<Integer> st;
	        		      static HashSet<Integer> inset;
	        		        private static void topo(int curr){
	        		        	
	        		        	Visited[curr]=true;
	        		        	inset.add(curr);
	        		        	for(int x:adj[curr]){
	        		        		if(adj[x].contains(curr) || inset.contains(x)){
	        		        			state=0;
	        		        			return;
	        		        		}
	        		        		if(state==0)
	        		        			return;
	        		        		
	        		        	}
	        		        	st.push(curr);
	        		        	
	        		        	inset.remove(curr);
	        		        }
	        		        static HashSet<Integer> hs;
	        		       
	        		     	private static void buildgraph(int n){
	        		    		adj=new LinkedList[n+1];
	        		    		Visited=new boolean[n+1];
	        		    		
	        		    		for(int i=0;i<=n;i++){
	        		    			adj[i]=new LinkedList<Integer>();
	        		    		
	        		    		}
	     
	     
	        		    	}
	        		     	
	        		    	// To Get Input
	        		    	// Some Buffer Methods
	     
	        		     	public static void sort(long a[]){
	        		     		Merge(a, 0, a.length-1);
	        		     	}
	        		    	public static void InputReader(InputStream stream1) {
	        		    		stream = stream1;
	        		    	}
	     
	        		    	private static boolean isWhitespace(int c) {
	        		    		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	        		    	}
	     
	        		    	private static boolean isEndOfLine(int c) {
	        		    		return c == '\n' || c == '\r' || c == -1;
	        		    	}
	     
	        		    	private static int read() {
	        		    		if (numChars == -1)
	        		    			throw new InputMismatchException();
	        		    		if (curChar >= numChars) {
	        		    			curChar = 0;
	        		    			try {
	        		    				numChars = stream.read(buf);
	        		    			} catch (IOException e) {
	        		    				throw new InputMismatchException();
	        		    			}
	        		    			if (numChars <= 0)
	        		    				return -1;
	        		    		}
	        		    		return buf[curChar++];
	        		    	}
	     
	        		    	private static int nextInt() {
	        		    		int c = read();
	        		    		while (isSpaceChar(c))
	        		    			c = read();
	        		    		int sgn = 1;
	        		    		if (c == '-') {
	        		    			sgn = -1;
	        		    			c = read();
	        		    		}
	        		    		int res = 0;
	        		    		do {
	        		    			if (c < '0' || c > '9')
	        		    				throw new InputMismatchException();
	        		    			res *= 10;
	        		    			res += c - '0';
	        		    			c = read();
	        		    		} while (!isSpaceChar(c));
	        		    		return res * sgn;
	        		    	}
	     
	        		    	private static long nextLong() {
	        		    		int c = read();
	        		    		while (isSpaceChar(c))
	        		    			c = read();
	        		    		int sgn = 1;
	        		    		if (c == '-') {
	        		    			sgn = -1;
	        		    			c = read();
	        		    		}
	        		    		long res = 0;
	        		    		do {
	        		    			if (c < '0' || c > '9')
	        		    				throw new InputMismatchException();
	        		    			res *= 10;
	        		    			res += c - '0';
	        		    			c = read();
	        		    		} while (!isSpaceChar(c));
	        		    		return res * sgn;
	        		    	}
	     
	        		    	private static String nextToken() {
	        		    		int c = read();
	        		    		while (isSpaceChar(c))
	        		    			c = read();
	        		    		StringBuilder res = new StringBuilder();
	        		    		do {
	        		    			res.appendCodePoint(c);
	        		    			c = read();
	        		    		} while (!isSpaceChar(c));
	        		    		return res.toString();
	        		    	}
	     
	        		    	private static String nextLine() {
	        		    		int c = read();
	        		    		while (isSpaceChar(c))
	        		    			c = read();
	        		    		StringBuilder res = new StringBuilder();
	        		    		do {
	        		    			res.appendCodePoint(c);
	        		    			c = read();
	        		    		} while (!isEndOfLine(c));
	        		    		return res.toString();
	        		    	}
	     
	        		    	private static int[] nextIntArray(int n) {
	        		    		int[] arr = new int[n];
	        		    		for (int i = 0; i < n; i++) {
	        		    			arr[i] = nextInt();
	        		    		}
	        		    		return arr;
	        		    	}
	     
	        		    	private static long[][] next2dArray(int n, int m) {
	        		    		long[][] arr = new long[n][m];
	        		    		for (int i = 0; i < n; i++) {
	        		    			for (int j = 0; j < m; j++) {
	        		    				arr[i][j] = nextLong();
	        		    			}
	        		    		}
	        		    		return arr;
	        		    	}
	        		    	private static char[][] nextCharArray(int n,int m){
	        		    		char [][]c=new char[n][m];
	        		    		for(int i=0;i<n;i++){
	        		    			String s=nextLine();
	        		    			for(int j=0;j<s.length();j++){
	        		    				c[i][j]=s.charAt(j);
	        		    			}
	        		    		}
	        		    		return c;
	        		    	}
	     
	        		    	private static long[] nextLongArray(int n) {
	        		    		long[] arr = new long[n];
	        		    		for (int i = 0; i < n; i++) {
	        		    			arr[i] = nextLong();
	        		    		}
	        		    		return arr;
	        		    	}
	     
	        		    	private static void pArray(int[] arr) {
	        		    		for (int i = 0; i < arr.length; i++) {
	        		    			pw.print(arr[i] + " ");
	        		    		}
	        		    		pw.println();
	        		    		return;
	        		    	}
	     
	        		    	private static void pArray(long[] arr) {
	        		    		for (int i = 0; i < arr.length; i++) {
	        		    			pw.print(arr[i] + " ");
	        		    		}
	        		    		pw.println();
	        		    		return;
	        		    	}
	     
	        		    	private static void pArray(boolean[] arr) {
	        		    		for (int i = 0; i < arr.length; i++) {
	        		    			pw.print(arr[i] + " ");
	        		    		}
	        		    		pw.println();
	        		    		return;
	        		    	}
	     
	        		    	private static boolean isSpaceChar(int c) {
	        		    		if (filter != null)
	        		    			return filter.isSpaceChar(c);
	        		    		return isWhitespace(c);
	        		    	}
	     
	        		    	private interface SpaceCharFilter {
	        		    		public boolean isSpaceChar(int ch);
	        		    	}
	     
	     
	    }
	        		    
	        		           		    class Node{
	        		    	int to;
	        		    	long dist;
	        		    	Node(int to,long dist){
	        		    		this.to=to;
	        		    		this.dist=dist;
	        		    	}
	        		    	
	        		    }
	        		   /* class Pair implements Comparable<Pair>{
	        				
	    					
	    					int ele,ind;
	    					Pair(int ele,int ind){
	    					
	    						this.ele=ele;
	    						this.ind=ind;
	    					
	    					}
	    					@Override
	    					public int compareTo(Pair o) {
	    				
	    							
	    							return ele-o.ele;
	    					}
	    					public int hashCode() {
	    							//int hu = (int) (x ^ (x >>> 32));
	    							//int hv = (int) (y ^ (y >>> 32));
	    							//int hw = (int) (mass ^ (mass >>> 32));
	    							//return 31 * hu + hv ;
	    						return 0;
	    						}
	    						public boolean equals(Object o) {
	    							Pair other = (Pair) o;
	    						//	return x == other.x && y == other.y;
	    						return false;
	    						}
	    				}  */class Dsu{
		    		    	private int rank[], parent[] ,n;
		    		    	private static int[] parent1;
		    		    	Dsu(int size){
		    		    		this.n=size+1;
		    		    		rank=new int[n];
		    		    		//parent=new int[n];
		    		    		parent=new int[n];
		    		    	makeSet();
		    		
		    		    	}
		    		    	
		    		    	void makeSet(){
		    		    		for(int i=0;i<n;i++){
		    		    			parent[i]=i;
		    		    		}
		    		    	}
		    		    	
		    		    	int find(int x){
		    		    		if(parent[x]!=x){
		    		    			
		    		    			parent[x]=find(parent[x]);
		    		    		}
		    		    		return parent[x];
		    		    	}
		    		    
		    		    	
		    		    	boolean union(int x,int y){
		    		    		int xRoot=find(x);
		    		    		int yRoot=find(y);
		    		    		
		    		    		if(xRoot==yRoot)
		    		    			return false;
		    		    		if(rank[xRoot]<rank[yRoot]){
		    		    		parent[xRoot]=yRoot;	
		    		    		}else if(rank[yRoot]<rank[xRoot]){
		    		    			parent[yRoot]=xRoot;
		    		    		}else{
		    		    			parent[yRoot]=xRoot;
		    		    			rank[xRoot]++;
		    		    		}
		    		    		return true;
		    		    	}
	
		    		     
		    		    }