import java.awt.Checkbox;
import java.awt.Point;
import java.io.*;
                    import java.math.*;
                    import java.util.*;
import java.util.Map.Entry;

import javax.print.attribute.SetOfIntegerSyntax;
import javax.swing.plaf.FontUIResource;


             
                    public class CODE2{
                      private static InputStream stream;
                        private static byte[] buf = new byte[1024];
                        private static int curChar,MAX;
                        private static int numChars;
                        private static SpaceCharFilter filter;
                        private static PrintWriter pw;
                        private static long count = 0,mod=1000000007;
                        static int BIT[];
                        private static boolean primer[];
                    //    private static TreeSet<Integer> ts=new TreeSet[200000];
public final static int INF = (int) 1E9;

public static void main(String args[]) {
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
    static StringBuilder sb;
    public static void test(){
         sb=new StringBuilder();
        int t=nextInt();
        while(t-->0){
            
            solve();
           
        }
        pw.println(sb);
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
    }    
    
    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
 
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
        static long co=0,ans=0;
        static int parent[];
        static int size[],color[],res[],k;
        static ArrayList<Integer> al[];
        static long MOD = (long)1e9 + 7;
        private static void buildgraph(int n){
            adj=new LinkedList[n+1];
            Visited=new boolean[n+1];
            levl=new int[n+1];
            
            for(int i=0;i<=n;i++){
                adj[i]=new LinkedList<Integer>();
            
            }


        }
      
       
        static int[] levl;
        static int[] eat;
      //  static int n,m;
        static int price[];
        //ind frog crab
   static  boolean check(char c)
    {
    	if(c!='a' && c!='e' && c!='i' && c!='o' && c!='u' )
    		return true;
    	else
    		return false;
    }
        public static void solve(){
       
     
    	  
   int n= nextInt();
   int a[]=new int[n];
   a=nextIntArray(n);
   
   
   int invcount=0;
   for(int i=0;i<n;i++)
   {
	   for(int j=i+1;j<n;j++)
	   {
		   if(a[i]>a[j])
			   invcount++;
	   }
   }
   
   
   int m=nextInt();
   
   int initial = invcount%2;
   while(m--!=0)
   {
	   int l=nextInt();
	   int r=nextInt();
	   
	   
	   int diff = r-l+1;
	   int totalpair = (diff*(diff-1))/2;
	   
	   if(((totalpair%2)+initial)%2==1)
	   {
		   pw.println("odd");
		   initial=1;
	   }
	   else
	   {
		   pw.println("even");
		   initial=0;
	   }
	   
   }
     
    
    }
        
        static void seive2(int n)
        {
        	primer=new boolean[n+1];
        	Arrays.fill(primer,true);
        	primer[0]=false;
        	primer[1]=false;
        	primer[2]=true;
        	
        	for(int i=2;i*i<=n;i++)
        	{
        		if(primer[i])
        		{
        			for(int j=2*i;j<=n;j=j+i)
        			{
        				primer[j]=false;
        			}
        		}
        	}
        }
       
        
     /*   static void BITupdate(int x,int val)
        {
        	while(x<=n)
        	{
        		BIT[x]+=val;
        		x+= x & -x;
        	}
        }*/
     /*   static void update(int x,long val)
        {
      
        	val=val%MOD;
        	while(x<=n)
        	{
        		// System.out.println(x);
        	BIT[x]=(BIT[x]+val)%MOD;
        	x+=(x & -x);
        	}
        //	System.out.println("dfd");
        }*/
        static int BITsum(int x)
        		{
        	int sum=0;
        	while(x>0)
        	{
        		sum+=BIT[x];
        		x-= (x & -x);
        	}
        		return sum;
        		}
  /*      static long sum(int x)
        {
        	long sum=0;
        	while(x>0)
        	{
        		sum=(sum+BIT[x])%MOD;
        		x-=x & -x;
        	}
        	return sum;
        }*/
        static boolean union(int x,int y)
        {
        	int xr=find(x);
        	int yr=find(y);
        	if(xr==yr)
        		return false;
        	if(size[xr]<size[yr])
        	{
        		size[yr]+=size[xr];
        		parent[xr]=yr;
        	}
        	else
        	{
        		size[xr]+=size[yr];
        		parent[yr]=xr;
        		
        	}
        	return true;
        	
        }
        static int  find(int x)
        {
        	if(parent[x]==x)
        		return x;
        	else
        	{
        		parent[x]=find(parent[x]);
        		return parent[x];
        	}
        	
        }
        public static class Edge implements Comparable<Edge>
        {
        	int u, v,s;
			public Edge(int u, int v) 
			{
				this.u = u;
				this.v = v;
				//this.s = s;
			}
			public int hashCode() 
			{
				return Objects.hash();
			}
			public int compareTo(Edge other) 
			{
			return (Integer.compare(u, other.u) != 0 ? (Integer.compare(u, other.u)):(Integer.compare(v, other.v)));
				//		&((Long.compare(s, other.s) != 0 ? (Long.compare(s, other.s)):(Long.compare(u, other.v)!=0?Long.compare(u, other.v):Long.compare(v, other.u))));
				//return this.u-other.u;
			}
			public String toString()
			{
				return this.u + " " + this.v;
			}
        }
       
        static int col[];
    public static boolean isVowel(char c){
        if(c=='a' || c=='e'||c=='i' || c=='o' || c=='u')
            return true;
        return false;
    }
static int no_vert=0;

  private static void dfs(int start){
      Visited[start]=true;
    if(al[color[start]].size()>=k)
    {
    	res[start]=al[color[start]].get(al[color[start]].size()-k);
    }
    al[color[start]].add(start);
      for(int i:adj[start]){
          if(!Visited[i])
              {
              dfs(i);
              }
      }
      (al[color[start]]).remove(al[color[start]].size()-1);
      
  }
    
    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return (sb.toString());
    }
    
  /*  
   private static void BFS(int sou){
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(sou);
        Visited[sou]=true;
        levl[sou]=0;
        while(!q.isEmpty()){
            int top=q.poll();
            
            for(int i:adj[top]){
                //pw.println(i+" "+top);
            if(!Visited[i])
            {
                
                q.add(i);
                levl[i]=levl[top]+1;
            }
            
            Visited[i]=true;
            
            }
        }
    }*/
    



                  static int indeg[];
               /* private static void kahn(int n){
                    
                    PriorityQueue<Integer> q=new PriorityQueue<Integer>();
                    for(int i=1;i<=n;i++){
                        if(indeg[i]==0){
                            q.add(i);
                        }
                    }
                    while(!q.isEmpty()){
                        int top=q.poll();
                        st.push(top);
                        for(Node i:adj[top]){
                            indeg[i.to]--;
                            if(indeg[i.to]==0){
                                q.add(i.to);
                            }
                        }
                    }
                }
                    
                    static int state=1;
                    static long no_exc=0,no_vert=0;
                  static Stack<Integer> st;
                  static HashSet<Integer> inset;
                 /*   private static void topo(int curr){
                        
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
                    }*/
                    static HashSet<Integer> hs;
                   
                 
                     static boolean prime[];
                    static int spf[];
                    public static void sieve(int n){
                        prime=new boolean[n+1];
                        spf=new int[n+1];
                        
                        Arrays.fill(spf, 1);
                        Arrays.fill(prime, true);
                    prime[1]=false;
                        spf[2]=2;
                        
                    for(int i=4;i<=n;i+=2){
                        spf[i]=2;
                    }
                    for(int i=3;i<=n;i+=2){
                        if(prime[i]){
                            spf[i]=i;
                            for(int j=2*i;j<=n;j+=i){
                                
                                prime[j]=false;
                            if(spf[j]==1){
                                spf[j]=i;
                            }
                            }
                        }
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