
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.sound.sampled.ReverbType;


public class N718 {
	static PrintWriter out;
	static Scanner sc;
	static ArrayList<int[]>q,w,x;
	static ArrayList<Integer>adj[];
	static HashSet<Integer>primesH;
	static boolean prime[];
	//static ArrayList<Integer>a;
	static HashSet<Long>tmp;
	static int[][][]dist;
	static boolean[]v;
	static int[]a,b,c,d;
	static Boolean[][]dp;
	static char[][]mp;
	static int A,B,n,m,h,ans,sum;
	//static String a,b;
	static long oo=(long)1e9+7;
	public static void main(String[]args) throws IOException {
		sc=new Scanner(System.in);
		out=new PrintWriter(System.out);
		//A();
		//B();
		//C();
		D();
		//E();
		//F();
		//G();
		out.close();
	}
	  private static void A() throws IOException {
		  int t=ni();
		  while(t-->0) {
				long l=nl();
				if(l%2050!=0)ol(-1);
				else {
					long num=l/2050;
					int cnt=0;
					while(num>0) {
						cnt+=num%10;
						num/=10;
					}
					ol(cnt);
					
				}
		  }
		
	   }
		static void B() throws IOException {
			int t=ni();
			while(t-->0) {
				int n=ni(),m=ni();
				int[][]a=nmi(n,m);
				PriorityQueue<int[]>pq=new PriorityQueue<int[]>((u,v)->u[0]-v[0]);
				ArrayList<Integer>[]nums=new ArrayList[n];
				for(int i=0;i<n;i++) {
					//nums[i]=new ArrayList<Integer>();
					for(int j=0;j<m;j++) {
						///nums[i].add(a[i][j]);
						pq.add(new int[] {a[i][j],i});
					}
				}
				int[][]ans=new int[n][m];
				for(int i=0;i<m;i++) {
					int[]x=pq.poll();
					ans[x[1]][i]=x[0];
				}
				int []indices=new int[n];
				while(!pq.isEmpty()) {
					int[]x=pq.poll();
					int i=x[1];
					while(ans[i][indices[i]]!=0) {
						indices[i]++;
					}
					ans[i][indices[i]]=x[0];
				}
				for(int i=0;i<n;i++) {
					for(int j=0;j<m;j++) {
						out.print(ans[i][j]+" ");
					}
					ol("");
				}
			}
		}
		
		static void C() throws IOException{
			 int t=1;
			 while(t-->0) {
				 int n=ni();
				 a=nai(n);
				 int[][]ans=new int[n][n];
				 for(int i=0;i<n;i++)ans[i][i]=a[i];
				 for(int i=n-1;i>=0;i--) {
					 int j=i,k=i;
					 int cur=ans[i][i];
					 cur--;
					 while(cur>0) {
						 j++;
						 if(j>=n||ans[j][k]!=0) {
							 j--;
							 k--;
						 }
						 ans[j][k]=ans[i][i];
						 cur--;
					 }
				 }
				 for(int i=0;i<n;i++) {
					 for(int j=0;j<=i;j++) {
						 out.print(ans[i][j]+" ");
					 }
					 ol("");
				 }
			 }
		}
		private static Boolean dp(int i, int j) {
			if(j>sum/2)return false;
			if(i==x.size()) {
				return sum/2==j;
			}
			if(dp[i][j]!=null)return dp[i][j];
			
			return dp[i][j]=dp(i+1,j+x.get(i)[0])||dp(i+1,j);
		}
		static boolean isPrime(long n) {
			if(n==2)return true;
			if(n<2||n%2==0)return false;
			
			for(long i=3L;i*i<n;i+=2l) {
				long rem=(n%i);
				if(rem==0)return false;
			}
			return true;
		}
		static void D() throws IOException {
			int t=1;
			while(t-->0) {
				int n=ni(),m=ni(),k=ni();
				int[][]ans=new int[n][m];
				dist=new int[n][m][4];
				for(int i=0;i<n;i++)for(int j=0;j>m;j++)
					Arrays.fill(dist[i][j], Integer.MAX_VALUE);
				int x;
				for(int i=0;i<n;i++) {
					for(int j=0;j<m-1;j++) {
						dist[i][j][2]=(x=ni());
						dist[i][j+1][3]=x;
					}
				}
				for(int i=0;i<n-1;i++) {
					for(int j=0;j<m;j++) {
						dist[i][j][1]=(x=ni());
						dist[i+1][j][0]=x;
					}
				}
				int[][]nans=new int[n][m];
				if(k%2==1) {
					for(int i=0;i<n;i++)Arrays.fill(ans[i], -1);
				}else {
					for(int ii=0;ii<k/2;ii++) {
					for(int i=0;i<n;i++) {
						
						for(int j=0;j<m;j++) {
							nans[i][j]=Integer.MAX_VALUE;
							if(i>0)
								nans[i][j]=Math.min(nans[i][j], ans[i-1][j]+dist[i-1][j][1]);
							if(i<n-1)
								nans[i][j]=Math.min(nans[i][j], ans[i+1][j]+dist[i+1][j][0]);
							if(j>0)
								nans[i][j]=Math.min(nans[i][j], ans[i][j-1]+dist[i][j-1][2]);
							if(j<m-1)
								nans[i][j]=Math.min(nans[i][j], ans[i][j+1]+dist[i][j+1][3]);
						}
					}
					int[][]tmp=ans;
					ans=nans;
					nans=tmp;
					}
				}
				for(int i=0;i<n;i++) {
					for(int j=0;j<m;j++) {
						if(ans[i][j]!=-1)ans[i][j]*=2;
						out.print(ans[i][j]+" ");
					}
					ol("");
				}
			}
		}
		private static int bfs(int i, int j,int k) {
			boolean [][]vis=new boolean[dist.length][dist[0].length];
			Queue<int[]>q=new LinkedList<int[]>();
			int mn=Integer.MAX_VALUE;
			q.add(new int[] {i,j,0,0});
			int[]dx=new int[] {-1,1,0,0};
			int[]dy=new int[] {0,0,1,-1};
			while(!q.isEmpty()) {
				int []x=q.poll();
				vis[x[0]][x[1]]=true;
				int c=x[2];
				if(c>k/2)continue;
				if(c>0&&k%c==0&&(k/c)%2==0) {
					mn=Math.min(mn,x[3]*k/c );
				}
				for(int a=0;a<4;a++) {
					int nx=x[0]+dx[a];
					int ny=x[1]+dy[a];
					if(valid(nx,ny)&&!vis[nx][ny]) {
						q.add(new int[] {nx,ny,c+1,x[3]+dist[x[0]][x[1]][a]});
					}
				}
				
			}
			return mn;
		}
		private static boolean valid(int nx, int ny) {
			return nx>=0&&nx<dist.length&&ny>=0&&ny<dist[0].length;
		}
		static int gcd (int a, int b) {
		    return b==0?a:gcd (b, a % b);
		}
		
	static void E() throws IOException {
		int t=ni();
		while(t-->0) {
			
			
		}
		
	}

	static void F() throws IOException {
		int t=ni();
		while(t-->0) {
			
		}
	}
	static void CC() throws IOException {
		for(int kk=2;kk<21;kk++) {
			ol(kk+"   -------");
		int n=kk;
		int k=n-2;
		int msk=1<<k;
		int[]a=new int[k];
		for(int i=0;i<a.length;i++)a[i]=i+2;
		int mx=1;
		int ms=0;
		for(int i=1;i<msk;i++) {
			long prod=1;
			int cnt=0;
			for(int j=0;j<a.length;j++) {
				if(((i>>j)&1)!=0) {
					prod*=a[j];
					cnt++;
				}
			}
			if(cnt>=mx&&prod%n==1) {
				mx=cnt;
				ms=i;
			}
			
		}
		ol(mx==1?mx:mx+1);
		out.print(1+" ");
		long pr=1;
		for(int j=0;j<a.length;j++) {
			if(((ms>>j)&1)!=0) {
				out.print(a[j]+" ");
				pr*=a[j];
			}
		}
		ol("");
		ol("Prod: "+pr);
		ol(n+"*"+((pr-1)/n)+" + "+1);
		}
	}
	static int ni() throws IOException {
		return sc.nextInt();
	}
	static double nd() throws IOException {
		return sc.nextDouble();
	}
	static long nl() throws IOException {
		return  sc.nextLong();
	}
	static String ns() throws IOException {
		return sc.next();
	}
	static int[] nai(int n) throws IOException {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		return a;
	}
	static long[] nal(int n) throws IOException {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextLong();
		return a;
	}
	static int[][] nmi(int n,int m) throws IOException{
		int[][]a=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				a[i][j]=sc.nextInt();
			}
		}
		return a;
	}

	static long[][] nml(int n,int m) throws IOException{
		long[][]a=new long[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				a[i][j]=sc.nextLong();
			}
		}
		return a;
	}
	static void o(String x) {
		out.print(x);
	}
	static void ol(String x) {
		out.println(x);
	}
	static void ol(int x) {
		out.println(x);
	}
	static void disp1(int []a) {
		for(int i=0;i<a.length;i++) {
			out.print(a[i]+" ");
		}
		out.println();
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public boolean hasNext() {return st.hasMoreTokens();}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public double nextDouble() throws IOException {return Double.parseDouble(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}
			
		public boolean ready() throws IOException {return br.ready(); }
		

	}
}
