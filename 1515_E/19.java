
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

public class Global14 {
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
		//D();
		E();
		//F();
		//G();
		out.close();
	}
	  private static void A() throws IOException {
		  int t=ni();
		  while(t-->0) {
				int n=ni(),w=ni();
				a=nai(n);
				int sum=0;
				for(int i=0;i<n;i++)sum+=a[i];
				if(sum==w) {ol("NO");continue;}
				if(sum<w) {
					ol("YES");
					disp2(a);continue;
				}
				Arrays.sort(a);
				int cur=0;
				for(int i=n-1;i>=0;i--) {
					if(cur==w) {
						int tmp=a[i+1];
						a[i+1]=a[i];
						a[i]=tmp;
						break;
					}
					cur+=a[i];
				}
				ol("YES");
				disp2(a);
				
		  }
		
	   }
		static void B() throws IOException {
			int t=ni();
			while(t-->0) {
				long n=nl();
				if(n%2==0) {
				n/=2;
				int sq=(int)Math.sqrt(n);
				if(sq*sq==n&&sq!=0) {
					ol("YES");continue;
				}
				}
				if(n%2==0) {
				n/=2;
				 int sq=(int)Math.sqrt(n);
				if(sq*sq==n&&sq!=0) {
					ol("YES");continue;
				}
				}
				ol("NO");
			}
			}
		
		
		static void C() throws IOException{
			 int t=ni();
			 while(t-->0) {
				int n=ni(),m=ni(),x=ni();
				int[][]a=new int[n][2];
				int mx=0;
				for(int i=0;i<n;i++) {
					a[i][0]=ni();
					a[i][1]=i;
					mx=Math.max(mx, a[i][0]);
				}
				Arrays.sort(a,(u,v)->u[0]-v[0]);
				PriorityQueue<int[]>vals=new PriorityQueue<int[]>((u,v)->u[0]-v[0]);
				int[]ans=new int[n];
				//int grp=1;
				vals.add(new int[] {a[0][0],1});
				ans[a[0][1]]=1;
				for(int i=1;i<n;i++) {
					if(vals.size()<m) {
						ans[a[i][1]]=vals.size()+1;
						vals.add(new int[] {a[i][0],vals.size()+1});
						mx=Math.max(mx, a[i][0]);
					}else {
						int[]p=vals.poll();
						vals.add(new int[] {p[0]+a[i][0],p[1]});
						ans[a[i][1]]=p[1];
						mx=Math.max(mx, a[i][0]+p[0]);
					}
				}
				if(mx-vals.peek()[0]>x)ol("NO");
				else {
					
					ol("YES");
					for(int i=0;i<n;i++) {
						out.print(ans[i]+" ");
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
			int t=ni();
			while(t-->0) {
				int n=ni(),l=ni(),r=ni();
				int[]occ1=new int[n+1];
				a=nai(n);
				for(int i=0;i<l;i++) {
					occ1[a[i]]++;
				}
				int[]occ2=new int[n+1];
				for(int i=l;i<n;i++) {
					occ2[a[i]]++;
				}
				int base=Math.abs((n/2)-l);
				int tk=0;
				int[]lrg=l>r?occ1:occ2;
				int[]sml=l<=r?occ1:occ2;
				for(int i=0;i<=n&&tk<base;i++) {
					int rem=base-tk;
					int taken=Math.min(rem, 
							Math.max(0,(lrg[i]-sml[i])/2));
					lrg[i]-=taken;
					sml[i]+=taken;
					tk+=taken;
				}
				for(int i=0;i<n&&tk<base;i++) {
					if(lrg[i]<=sml[i])continue;
					lrg[i]--;
					sml[i]++;
					tk++;
				}
				int c1=0,c2=0;
				for(int i=0;i<=n;i++) {
					if(lrg[i]>sml[i]) {
						if(c1<0) {
							int diff=Math.min(-c1, -sml[i]+lrg[i]);
							lrg[i]-=diff;
							c1+=diff;
						}
						int nd=lrg[i]-sml[i];
						c2-=nd;
						base+=nd;
						sml[i]=lrg[i];
					}else if(lrg[i]<sml[i]) {
						if(c2<0) {
							int diff=Math.min(-c2, sml[i]-lrg[i]);
							sml[i]-=diff;
							c2+=diff;
						}
						int nd=-lrg[i]+sml[i];
						base+=nd;
						c1-=nd;
						lrg[i]=sml[i];
					}
				}
				ol(base);
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
		int t=1;
		while(t-->0) {
			int n=ni();
			long oo=nl();
			long fc[]=new long[n+1];
			fc[0]=fc[1]=1l;
			long []pow2=new long[n+1];
			pow2[0]=1l;
			for(int i=1;i<pow2.length;i++) {
				pow2[i]=(pow2[i-1]*2l)%oo;
			}
			for(int i=2;i<fc.length;i++) {
				fc[i]=(fc[i-1]*1l*i)%oo;
			}
			
			long ncr[][]=new long[n+1][n+1];
			for(int i=0;i<=n;i++) {
				for(int j=0;j<=i;j++) {
					ncr[i][j]=i==0||j==0?1l:(ncr[i-1][j-1]+ncr[i-1][j])%oo;
				}
			}
			long ans=0;
			long dp[][]=new long[n+2][n+2];
			dp[0][0]=1l;
			for(int i=0;i<n;i++) {
				for(int j=0;j<=i;j++) {
					for(int k=1;i+k<=n;k++) {
						dp[i+k+1][j+k]+=((dp[i][j]*pow2[k-1]%oo)*ncr[j+k][k])%oo;
						dp[i+k+1][j+k]%=oo;
					}
				}
			}
			for(int i=0;i<=n;i++) {
				ans=(ans+dp[n+1][i])%oo;
			}
			ol(""+ans);
			//ol(""+pow2[3]);
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
	static void disp2(int []a) {
		for(int i=a.length-1;i>=0;i--) {
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

