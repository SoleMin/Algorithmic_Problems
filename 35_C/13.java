import java.io.*;
import java.math.*;
import java.security.KeyStore.Entry;
import java.util.*;

	
		
		
		
		
			public class QA {
				
				static long MOD = 1000000007;
				static boolean b[], b1[], check;
				static ArrayList<Integer>[] amp, pa;
				static ArrayList<Pair>[] amp1;
				static ArrayList<Pair>[][] damp;
				static int left[],right[],end[],sum[],dist[],cnt[],start[],color[],parent[],prime[],size[];
				static int ans = 0,k;
				static int p = 0;
				static FasterScanner sc = new FasterScanner(System.in);
				//static Queue<Integer> q = new LinkedList<>();
				static BufferedWriter log;
				static HashSet<Pair> hs;
				static HashMap<Pair,Integer> hm;
				static PriorityQueue<Integer> pri[];
				static ArrayList<Integer>[] level;
				static Stack<Integer> st;
				static boolean boo[][];
				static Pair prr[];
				static long parent1[],parent2[],size1[],size2[],arr1[],SUM[],lev[], fibo[];
				static int arr[], ver[][];
				static private PrintWriter out = new PrintWriter(System.out);
				public static void main(String[] args) throws Exception {
			    	new Thread(null, new Runnable() {
						public void run() {
							try {
				soln();
						} catch (Exception e) {
								System.out.println(e);
							}
						}
					}, "1", 1 << 26).start();
					
				}
				private static boolean oj = System.getProperty("ONLINE_JUDGE") != null;
				private static void tr(Object... o) {
					if (!oj)
						System.out.println(Arrays.deepToString(o));
				}
				static int dp[][];
				static int N,K,T,A,B;
				static long time;
				static int cost[][];
				static boolean b11[];
				static HashMap<Integer,Integer> h = new HashMap<>();
				static HashSet<Pair> chec;
				static long ans1;		static long ans2;
				static int BLOCK, MAX = 1000001;
				static double pi = Math.PI;
				static int Arr[], Brr[], pow[],  M;
				static long fact[] = new long[100000+1];
				static HashMap<Integer,Long> hm1;
				static HashSet<Integer> hs1[], hs2[];
				static String[] str2;
				static char[] ch1, ch2;
				static int[] s,f,D;
				static int tf,ts;
				static int see[][] = new int[2050][2050];
				static boolean bee[][] = new boolean[2050][2050];
				static Queue<Pair> q = new LinkedList<>();
				//static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
				public static void soln() throws IOException {
					//System.setIn(new FileInputStream("input.txt"));
					//System.setOut(new PrintStream("output.txt"));
					FasterScanner sc = new FasterScanner(new FileInputStream("input.txt"));//("C:\\Users\\Admin\\Desktop\\QAL2.txt"));
					//PrintWriter log1 = new PrintWriter("C:\\Users\\Admin\\Desktop\\input01");
					PrintWriter log = new PrintWriter("output.txt");//("C:\\Users\\Admin\\Desktop\\output00");
					//log = new BufferedWriter(new OutputStreamWriter(System.out));
					int n = sc.nextInt() , m = sc.nextInt();
					int k = sc.nextInt();
					for(int i = 1; i <= n ; i++) for(int j  =1;j<=m;j++) see[i][j]= 100000000;
					for(int i = 0; i < k; i++){
						int x = sc.nextInt(), y = sc.nextInt();
						bee[x][y] = true;
						see[x][y] = 0;
						q.add(new Pair(x,y));
					}
					while(!q.isEmpty()){
						//System.out.println(q);
						int x = q.peek().u, y = q.poll().v;
						if(x>1){
							see[x-1][y] = min(see[x][y]+1,see[x-1][y]);
							if(!bee[x-1][y]) q.add(new Pair(x-1,y));
							bee[x-1][y] = true;
						}
						if(x<n){
							see[x+1][y] = min(see[x][y]+1,see[x+1][y]);
							if(!bee[x+1][y]) q.add(new Pair(x+1,y));
							bee[x+1][y] = true;
						}
						if(y>1){
							see[x][y-1] = min(see[x][y]+1,see[x][y-1]);
							if(!bee[x][y-1]) q.add(new Pair(x,y-1));
							bee[x][y-1] = true;
						}
						if(y<m){
							see[x][y+1] = min(see[x][y]+1,see[x][y+1]);
							if(!bee[x][y+1]) q.add(new Pair(x,y+1));
							bee[x][y+1] = true;
						}
					}
					int ans = -1;
					Pair temp = null;
					for(int i = 1;i<=n;i++){
						for(int j = 1;j<=m;j++){
							if(see[i][j]>ans) {
								ans = see[i][j];
								temp = new Pair(i,j);
							}
						}
					}
					log.write(temp.u+" "+temp.v);
					log.close();
				}
				static int min(int a, int b){
					if(a>b) return b;
					return a;
				}
				private static double dfs(int cur,int prev){
					double r=0,n=0;
					for(int i : amp[cur]){
						if(i!=prev){
							r+=(1+dfs(i,cur));
							n++;
						}
					}
					if(n!=0){
						r=r/n;
					}
					return r;
				}
				static double fa1 = 0;
				static int fa = -1;
				static long nCr1(int n, int r){
					if(n<r) return 0;
					return (((fact[n] * modInverse(fact[n-r], MOD))%MOD)*modInverse(fact[r], MOD))%MOD;
				}
				static class Node{
					Node arr[] = new Node[2]; 
					int cnt[] = new int[2];
				}
				public static class Trie{
					Node root;
					public Trie(){
						root = new Node();
					}
					public void insert(String x){
						Node n = root;
						for(int i = 0;i < x.length() ;i++){
							int a1 = x.charAt(i)-'0';
							if(n.arr[a1]!=null){
								n.cnt[a1]++;
								n = n.arr[a1];
								continue;
							}
							n.arr[a1] = new Node();
							n.cnt[a1]++;
							n = n.arr[a1];
						}
					}
					public void delete(String x){
						Node n = root;
						for(int i = 0;i < x.length() ;i++){
							int a1 = x.charAt(i)-'0';
							if(n.cnt[a1]==1){
								n.arr[a1] = null;
								return;
							}
							else {
								n.cnt[a1]--;
								n = n.arr[a1];
							}
						}
					}
					public long get(String x){
						Node n = root;
						long ans = 0;
						for(int i = 0;i < x.length() ;i++){
							int a1 = '1' - x.charAt(i);
							if(n.arr[a1]!=null){
								ans += Math.pow(2, 30-i);
								n = n.arr[a1];
							}
							else n = n.arr[1-a1];
						//	System.out.println(ans);
						}
						return ans;
					}
				}
				public static class FenwickTree {
					
				    int[] array; // 1-indexed array, In this array We save cumulative information to perform efficient range queries and updates
	
				    public FenwickTree(int size) {
				        array = new int[size + 1];
				    }
				    public int rsq(int ind) {
				        assert ind > 0;
				        int sum = 0;
				        while (ind > 0) {
				            sum += array[ind];
				            //Extracting the portion up to the first significant one of the binary representation of 'ind' and decrementing ind by that number
				            ind -= ind & (-ind);
				        }
				        return sum;
				    }
				    public int rsq(int a, int b) {
				        assert b >= a && a > 0 && b > 0;
				        return rsq(b) - rsq(a - 1);
				    }
				    public void update(int ind, int value) {
				        assert ind > 0;
				        while (ind < array.length) {
				            array[ind] += value;
				            //Extracting the portion up to the first significant one of the binary representation of 'ind' and incrementing ind by that number
				            ind += ind & (-ind);
				        }
				    }
	
				    public int size() {
				        return array.length - 1;
				    }
				}
				static double power(double x, long y)
				{
				    if (y == 0)
				        return 1;
				    double p = power(x, y/2);
				    p = (p * p);
				 
				    return (y%2 == 0)? p : (x * p);
				}
				static int Dfs(int x, int val){
					b[x] = true;
					for(int p:hs2[x]){
						if(!b[p]){
							if(!hs1[x].contains(p)) val++;
							val += Dfs(p,0);
						}
					}
					return val;
				}
				static long nCr(int n, int r){
					if(n<r) return 0;
					else return (((fact[n]*modInverse(fact[r], MOD))%MOD)*modInverse(fact[n-r], MOD))%MOD;
				}
				static void dfs1(int x, int p){
					arr1[x] += lev[x];
					for(int v:amp[x]){
						if(v!=p){
							dfs1(v,x);
						}
					}
				}
				
				static void bfs(int x){
					
				}
				public static void seive(int n){
					b = new boolean[(n+1)];
					Arrays.fill(b, true);
					b[1] = true;
					for(int i = 2;i*i<=n;i++){
						if(b[i]){
							for(int p = 2*i;p<=n;p+=i){
								b[p] = false;
							}
						}
					}
					/*for(int i = 2;i<=n;i++){
						if(b[i]) prime[i] = i;
					}*/
				}
				
				static class Graph{
					int vertex;
					int weight;
					Graph(int v, int w){
						vertex = v;
						weight = w;
					}
				}
				static class Pair implements Comparable<Pair> {
					int u;
					int v;
					int ans;
					public Pair(){
						u = 0;
						v = 0;
					}
					public Pair(int u, int v) {
						this.u = u;
						this.v = v;
					}
					public int hashCode() {
						return Objects.hash();
					}
					public boolean equals(Object o) {
						Pair other = (Pair) o;
						return ((u == other.u && v == other.v && ans == other.ans));
					}
			 
					public int compareTo(Pair other) {
						//return Double.compare(ans, other.ans);
						return Long.compare(u, other.u); 
					}
					
					public String toString() {
						return "[u=" + u + ", v=" + v + "]";
					}
				}
				
				public static void buildGraph(int n){
					for(int i =0;i<n;i++){
						int x = sc.nextInt()-1, y = sc.nextInt()-1;
						amp[x].add(y);
						amp[y].add(x);
					}
				}
				
				
				public static int getParent(long x){
					while(parent[(int) x]!=x){
						parent[ (int) x] = parent[(int) parent[ (int) x]];
						x = parent[ (int) x];
					}
					return (int) x;
				}
				static long min(long a, long b, long c){
					if(a<b && a<c) return a;
					if(b<c) return b;
					return c;
				}
				/*
				
				static class Pair3{
					int x, y ,z;
					Pair3(int x, int y, int z){
						this.x = x;
						this.y = y;
						this.z = z;
					}
				}*/
				 static void KMPSearch(String pat, String txt)
				    {
				        int M = pat.length();
				        int N = txt.length();
				 
				        // create lps[] that will hold the longest
				        // prefix suffix values for pattern
				        int lps[] = new int[M];
				        int j = 0;  // index for pat[]
				 
				        // Preprocess the pattern (calculate lps[]
				        // array)
				        computeLPSArray(pat,M,lps);
				 
				        int i = 0;  // index for txt[]
				        while (i < N)
				        {
				            if (pat.charAt(j) == txt.charAt(i))
				            {
				                j++;
				                i++;
				            }
				            if (j == M)
				            {
				               // parent.add((i-j));
				                j = lps[j-1];
				            }
				 
				            // mismatch after j matches
				            else if (i < N && pat.charAt(j) != txt.charAt(i))
				            {
				                // Do not match lps[0..lps[j-1]] characters,
				                // they will match anyway
				                if (j != 0)
				                    j = lps[j-1];
				                else
				                    i = i+1;
				            }
				        }
				    }
				 static void computeLPSArray(String pat, int M, int lps[])
				    {
				        // length of the previous longest prefix suffix
				        int len = 0;
				        int i = 1;
				        lps[0] = 0;  // lps[0] is always 0
				 
				        // the loop calculates lps[i] for i = 1 to M-1
				        while (i < M)
				        {
				            if (pat.charAt(i) == pat.charAt(len))
				            {
				                len++;
				                lps[i] = len;
				                i++;
				            }
				            else  // (pat[i] != pat[len])
				            {
				                // This is tricky. Consider the example.
				                // AAACAAAA and i = 7. The idea is similar 
				                // to search step.
				                if (len != 0)
				                {
				                    len = lps[len-1];
				 
				                    // Also, note that we do not increment
				                    // i here
				                }
				                else  // if (len == 0)
				                {
				                    lps[i] = len;
				                    i++;
				                }
				            }
				        }
				    }
				private static void permutation(String prefix, String str) {
				    int n = str.length();
				    if (n == 0); //hs.add(prefix);
				    else {
				        for (int i = 0; i < n; i++)
				            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
				    }
				}
				
				public static void buildTree(int n){
					int arr[] = sc.nextIntArray(n);
					for(int i = 0;i<n;i++){
						int x = arr[i]-1;
						amp[i+1].add(x);
						amp[x].add(i+1);
					}
				}
				
				static class SegmentTree {
					boolean st[];
					boolean lazy[];
		
					SegmentTree(int n) {
						int size = 4 * n;
						st = new boolean[size];
						Arrays.fill(st, true);
						lazy = new boolean[size];
						Arrays.fill(lazy, true);
						//build(0, n - 1, 1);
					}
					
					/*long[] build(int ss, int se, int si) {
						if (ss == se) {
							st[si][0] = 1;
							st[si][1] = 1;
							st[si][2] = 1;
							return st[si];
						}
						int mid = (ss + se) / 2;
						long a1[] = build(ss, mid, si * 2), a2[] = build(mid + 1, se,
								si * 2 + 1);
						long ans[] = new long[3];
						if (arr[mid] < arr[mid + 1]) {
							ans[1] = Math.max(a2[1], Math.max(a1[1], a1[2] + a2[0]));
							if (a1[1] == (mid - ss + 1))
								ans[0] = ans[1];
							else
								ans[0] = a1[0];
							if (a2[2] == (se - mid))
								ans[2] = ans[1];
							else
								ans[2] = a2[2];
						} else {
							ans[1] = Math.max(a1[1], a2[1]);
							ans[0] = a1[0];
							ans[2] = a2[2];
						}
						st[si] = ans;
						return st[si];
					}*/
		
					void update(int si, int ss, int se, int idx, long x) {
						if (ss == se) {
							//arr[idx] += val;
							st[si]=false;
						} 
						else {
							int mid = (ss + se) / 2;
							if(ss <= idx && idx <= mid)
					        {
					             update(2*si, ss, mid, idx, x);
					        }
					        else
					        { update(2*si+1, mid+1, se, idx, x);
					        }
							st[si] = st[2*si]|st[2*si+1];
						}
					}
					/*boolean get(int qs, int qe, int ss, int se, int si){
						if(qs>se || qe<ss) return 0;
						if (qs <= ss && qe >= se) {
							return st[si];
						}
						int mid = (ss+se)/2;
						return get(qs, qe, ss, mid, si * 2)+get(qs, qe, mid + 1, se, si * 2 + 1);
					}*/
					void updateRange(int node, int start, int end, int l, int r, boolean val)
					{
					    if(!lazy[node])
					    { 
					        // This node needs to be updated
					        st[node] = lazy[node];    // Update it
					        if(start != end)
					        {
					            lazy[node*2] = lazy[node];                  // Mark child as lazy
					            lazy[node*2+1] = lazy[node];                // Mark child as lazy
					        }
					        lazy[node] = true;                                  // Reset it
					    }
					    if(start > end || start > r || end < l)              // Current segment is not within range [l, r]
					        return;
					    if(start >= l && end <= r)
					    {
					        // Segment is fully within range
					        st[node] =  val;
					        if(start != end)
					        {
					            // Not leaf node
					            lazy[node*2] = val;
					            lazy[node*2+1] = val;
					        }
					        return;
					    }
					    int mid = (start + end) / 2;
					    updateRange(node*2, start, mid, l, r, val);        // Updating left child
					    updateRange(node*2 + 1, mid + 1, end, l, r, val);   // Updating right child
					    st[node] = st[node*2] | st[node*2+1];        // Updating root with max value 
					}
		
					boolean queryRange(int node, int start, int end, int l, int r)
					{
					    if(start > end || start > r || end < l)
					        return false;         // Out of range
					    if(!lazy[node])
					    {
					        // This node needs to be updated
					        st[node] = lazy[node];            // Update it
					        if(start != end)
					        {
					            lazy[node*2] = lazy[node];         // Mark child as lazy
					            lazy[node*2+1] = lazy[node];    // Mark child as lazy
					        }
					        lazy[node] = true;                 // Reset it
					    }
					    if(start >= l && end <= r)             // Current segment is totally within range [l, r]
					        return  st[node];
					    int mid = (start + end) / 2;
					    boolean p1 = queryRange(node*2, start, mid, l, r);         // Query left child
					    boolean b = queryRange(node*2 + 1, mid + 1, end, l, r); // Query right child
					    return (p1 | b);
					}
					void print() {
						for (int i = 0; i < st.length; i++) {
							System.out.print(st[i]+" ");
						}
						System.out.println();
					}
				}
				static int convert(int x){
					int cnt = 0;
					String str = Integer.toBinaryString(x);
					//System.out.println(str);
					for(int i = 0;i<str.length();i++){
						if(str.charAt(i)=='1'){
							cnt++;
						}
					}
					int ans = (int) Math.pow(3, 6-cnt);
					return ans;
				}
				static class Node2{
					Node2 left = null;
					Node2 right = null;
					Node2 parent = null;
					int data;
				}
				static boolean check(char ch[][], int i, int j){
					if(ch[i][j]=='O') return false;
					char c = ch[i][j];
					ch[i][j] = 'X';
					if(c=='X'){
					if(i>=4){
						int x = 0;
						int l = 0;
						for(x = 0;x<=4;x++){
							if(ch[i-x][j]!='X'){ if(ch[i-x][j]!='.') break;else l++;}
						}
						if(x==5 && l<=1) return true;
						l = 0;
						if(j>=4){
							for(x = 0;x<=4;x++){
								if(ch[i-x][j-x]!='X'){ if(ch[i-x][j-x]!='.') break; else l++;}
							}
							if(x==5 && l<=1) return true;
							 l =0;
							for(x = 0;x<=4;x++){
								if(ch[i][j-x]!='X'){ if(ch[i][j-x]!='.') break; else l++;}
							}
							if(x==5 && l<=1) return true;
						}
						if(j<=5){
							l = 0;
							for(x = 0;x<=4;x++){
								if(ch[i][j+x]!='X'){ if(ch[i][j+x]!='.') break; else l++;}
							}
							if(x==5 && l<=1) return true;
							l = 0;
							for(x = 0;x<=4;x++){
								if(ch[i-x][j+x]!='X'){ if(ch[i-x][j+x]!='.') break; else l++;}
							}
							if(x==5 && l<=1) return true;
						}
					}
					if(i<=5){
						int x = 0;
						int l = 0;
						for(x = 0;x<=4;x++){
							if(ch[i+x][j]!='X'){ if(ch[i+x][j]!='.') break; else l++;}
						}
						if(x==5 && l<=1) return true;
						l = 0;
						if(j>=4){
							for(x = 0;x<=4;x++){
								if(ch[i+x][j-x]!='X'){ if(ch[i+x][j-x]!='.') break; else l++;}
							}
							if(x==5 && l<=1) return true;
							 l =0;
							for(x = 0;x<=4;x++){
								if(ch[i][j-x]!='X'){ if(ch[i][j-x]!='.') break; else l++;}
							}
							if(x==5 && l<=1) return true;
						}
						if(j<=5){
							l = 0;
							for(x = 0;x<=4;x++){
								if(ch[i][j+x]!='X'){ if(ch[i][j+x]!='.') break; else l++;}
							}
							if(x==5 && l<=1) return true;
							l = 0;
							for(x = 0;x<=4;x++){
								if(ch[i+x][j+x]!='X'){ if(ch[i+x][j+x]!='.') break; else l++;}
							}
							if(x==5 && l<=1) return true;
						}
					}
					}
					else{
						if(i>=4){
							int x = 0;
							int l = 0;
							for(x = 0;x<=4;x++){
								if(ch[i-x][j]!='X'){ if(ch[i-x][j]!='.') break;else l++;}
							}
							if(x==5 && l<=0) return true;
							l = 0;
							if(j>=4){
								for(x = 0;x<=4;x++){
									if(ch[i-x][j-x]!='X'){ if(ch[i-x][j-x]!='.') break; else l++;}
								}
								if(x==5 && l<=0) return true;
								 l =0;
								for(x = 0;x<=4;x++){
									if(ch[i][j-x]!='X'){ if(ch[i][j-x]!='.') break; else l++;}
								}
								if(x==5 && l<=0) return true;
							}
							if(j<=5){
								l = 0;
								for(x = 0;x<=4;x++){
									if(ch[i][j+x]!='X'){ if(ch[i][j+x]!='.') break; else l++;}
								}
								if(x==5 && l<=0) return true;
								l = 0;
								for(x = 0;x<=4;x++){
									if(ch[i-x][j+x]!='X'){ if(ch[i-x][j+x]!='.') break; else l++;}
								}
								if(x==5 && l<=0) return true;
							}
						}
						if(i<=5){
							int x = 0;
							int l = 0;
							for(x = 0;x<=4;x++){
								if(ch[i+x][j]!='X'){ if(ch[i+x][j]!='.') break; else l++;}
							}
							if(x==5 && l<=0) return true;
							l = 0;
							if(j>=4){
								for(x = 0;x<=4;x++){
									if(ch[i+x][j-x]!='X'){ if(ch[i+x][j-x]!='.') break; else l++;}
								}
								if(x==5 && l<=0) return true;
								 l =0;
								for(x = 0;x<=4;x++){
									if(ch[i][j-x]!='X'){ if(ch[i][j-x]!='.') break; else l++;}
								}
								if(x==5 && l<=0) return true;
							}
							if(j<=5){
								l = 0;
								for(x = 0;x<=4;x++){
									if(ch[i][j+x]!='X'){ if(ch[i][j+x]!='.') break; else l++;}
								}
								if(x==5 && l<=0) return true;
								l = 0;
								for(x = 0;x<=4;x++){
									if(ch[i+x][j+x]!='X'){ if(ch[i+x][j+x]!='.') break; else l++;}
								}
								if(x==5 && l<=0) return true;
							}
						}
					}
					ch[i][j] = c;
					
					return false;
				}
				static class BinarySearchTree{
					Node2 root = null;
					int height = 0;
					int max = 0;
					int cnt = 1;
					ArrayList<Integer> parent = new ArrayList<>();
					HashMap<Integer, Integer> hm = new HashMap<>();
					public void insert(int x){
						Node2 n = new Node2();
						n.data = x;
						if(root==null){
							root = n;
						}
						else{
							Node2 temp = root,temb = null;
							while(temp!=null){
								temb = temp;
								if(x>temp.data) temp = temp.right;
								else temp = temp.left;
							}
							if(x>temb.data) temb.right = n;
							else temb.left = n;
							n.parent = temb;
							parent.add(temb.data);
						}
					}
					public Node2 getSomething(int x, int y, Node2 n){
						if(n.data==x || n.data==y) return n;
						else if(n.data>x && n.data<y) return n;
						else if(n.data<x && n.data<y) return getSomething(x,y,n.right);
						else return getSomething(x,y,n.left);
					}
					public Node2 search(int x,Node2 n){
						if(x==n.data){
							max = Math.max(max, n.data);
							return n;
						}
						if(x>n.data){
							max = Math.max(max, n.data);
							return search(x,n.right);
						}
						else{
							max = Math.max(max, n.data);
							return search(x,n.left);
						}
					}
					public int getHeight(Node2 n){
						if(n==null) return 0;
						height = 1+ Math.max(getHeight(n.left), getHeight(n.right));
						return height;
					}
				}
				static long findDiff(long[] arr, long[] brr, int m){
					int i = 0, j = 0;
					long fa = 1000000000000L;
					while(i<m && j<m){
						long x = arr[i]-brr[j];
						if(x>=0){
							if(x<fa) fa = x;
							j++;
						}
						else{
							if((-x)<fa) fa = -x;
							i++;
						}
					}
					return fa;
				}
				public static long max(long x, long y, long z){
					if(x>=y && x>=z) return x;
					if(y>=x && y>=z) return y;
					return z;
				}
				
				static long modInverse(long a, long mOD2){
				            return  power(a, mOD2-2, mOD2);
				}
				static long power(long x, long y, long m)
				{
				    if (y == 0)
				        return 1;
				    long p = power(x, y/2, m) % m;
				    p = (p * p) % m;
				 
				    return (y%2 == 0)? p : (x * p) % m;
				}
				static long d,x,y;
				public static void extendedEuclidian(long a, long b){
					if(b == 0) {
				        d = a;
				        x = 1;
				        y = 0;
				    }
				    else {
				        extendedEuclidian(b, a%b);
				        int temp = (int) x;
				        x = y;
				        y = temp - (a/b)*y;
				    }
				}
				
				public static long gcd(long n, long m){
					if(m!=0) return gcd(m,n%m);
					else return n;
				}
				
				static BufferedReader reader;
			    static StringTokenizer tokenizer;
			    static PrintWriter writer;
			
			
			   
			    static class FasterScanner {
		
					private final InputStream stream;
					private final byte[] buf = new byte[8192];
					private int curChar, snumChars;
					private SpaceCharFilter filter;
		
					public FasterScanner(InputStream stream) {
						this.stream = stream;
					}
		
					public int snext() {
						if (snumChars == -1)
							throw new InputMismatchException();
						if (curChar >= snumChars) {
							curChar = 0;
							try {
								snumChars = stream.read(buf);
							} catch (IOException e) {
								throw new InputMismatchException();
							}
							if (snumChars <= 0)
								return -1;
						}
						return buf[curChar++];
					}
		
					public int nextInt() {
						int c = snext();
						while (isSpaceChar(c)) {
							c = snext();
						}
						int sgn = 1;
						if (c == '-') {
							sgn = -1;
							c = snext();
						}
						int res = 0;
						do {
							if (c < '0' || c > '9')
								throw new InputMismatchException();
							res *= 10;
							res += c - '0';
							c = snext();
						} while (!isSpaceChar(c));
						return res * sgn;
					}
		
					public long nextLong() {
						int c = snext();
						while (isSpaceChar(c)) {
							c = snext();
						}
						int sgn = 1;
						if (c == '-') {
							sgn = -1;
							c = snext();
						}
						long res = 0;
						do {
							if (c < '0' || c > '9')
								throw new InputMismatchException();
							res *= 10;
							res += c - '0';
							c = snext();
						} while (!isSpaceChar(c));
						return res * sgn;
					}
		
					public int[] nextIntArray(int n) {
						int a[] = new int[n];
						for (int i = 0; i < n; i++) {
							a[i] = nextInt();
						}
						return a;
					}
		
					public long[] nextLongArray(int n) {
						long a[] = new long[n];
						for (int i = 0; i < n; i++) {
							a[i] = nextLong();
						}
						return a;
					}
			                
					public String readString() {
						int c = snext();
						while (isSpaceChar(c)) {
							c = snext();
						}
						StringBuilder res = new StringBuilder();
						do {
							res.appendCodePoint(c);
							c = snext();
						} while (!isSpaceChar(c));
						return res.toString();
					}
		
					public String nextLine() {
						int c = snext();
						while (isSpaceChar(c))
							c = snext();
						StringBuilder res = new StringBuilder();
						do {
							res.appendCodePoint(c);
							c = snext();
						} while (!isEndOfLine(c));
						return res.toString();
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