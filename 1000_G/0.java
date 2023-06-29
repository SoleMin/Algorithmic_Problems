import java.io.*;
import java.util.*;

public class Main{
	static LinkedList<int[]>adj[],qs[];
	static long[]in,ans;
	static long[]up,down,prefNodes,prefEdges;
	static long[]parEdge;
	static void dfsDown(int i,int p,long val) {
		prefNodes[i]=in[i];
		prefEdges[i]=val;
		parEdge[i]=val;
		if(p!=-1) {
			prefNodes[i]+=prefNodes[p];
			prefEdges[i]+=prefEdges[p];
		}
		for(int[]nxt:adj[i]) {
			if(nxt[0]==p)continue;
			int u=nxt[0];
			long w=nxt[1];
			dfsDown(u, i, w);
			down[i]+=Math.max(0, down[u]+in[u]-w-w);
		}
		
	}
	static void dfsUp(int i,int p) {
		for(int[]nxt:adj[i]) {
			if(nxt[0]==p)continue;
			int u=nxt[0];
			long w=nxt[1];
			long me=down[i]-Math.max(0, down[u]+in[u]-w-w);
			up[u]=Math.max(0, me+in[i]-w-w+up[i]);
			dfsUp(u, i);
		}
	}
	static int log = 22;
	static int[] level, par[];
	static void preLCA(int root,int n) {
		par = new int[n][log];
		level = new int[n];
		dfs(root, root);
	}
 
	static int lca(int u, int v) {
		 
		if (level[u] < level[v])
			return lca(v, u);
		for (int i = log - 1; i >= 0; i--) {
			int u2 = par[u][i];
			if (level[u2] >= level[v])
				u = u2;
		}
		if (u == v)
			return u;
		for (int i = log - 1; i >= 0; i--) {
			int u2 = par[u][i], v2 = par[v][i];
			if (u2 != v2) {
				u = u2;
				v = v2;
			}
		}
		return par[u][0];
	}
	static int lastChild(int u,int grandPar) {
		for (int i = log - 1; i >= 0; i--) {
			int u2 = par[u][i];
			if (level[u2] > level[grandPar])
				u = u2;
		}
		return u;
	}
	static void dfs(int u, int p) {
		par[u][0] = p;
		for (int i = 1; i < log; i++)
			par[u][i] = par[par[u][i - 1]][i - 1];
		for (int[]v : adj[u])
			if (v[0] != p) {
				level[v[0]] = level[u] + 1;
				dfs(v[0], u);
			}
 
	}
	static long[]pref;
	static void lastDfs(int i,int p,long curPref) {
		pref[i]=curPref;
		for(int[]q:qs[i]) {
			int lca=q[0],idx=q[1];
			ans[idx]+=curPref-pref[lca];
		}
		for(int[]nxt:adj[i]) {
			if(nxt[0]==p)continue;
			int u=nxt[0];
			long w=nxt[1];
			lastDfs(u, i, curPref+down[i]-Math.max(0, down[u]+in[u]-w-w));
		}
	}
	static void main() throws Exception{
		int n=sc.nextInt(),q=sc.nextInt();
		in=sc.longArr(n);
		adj=new LinkedList[n];
		qs=new LinkedList[n];
		for(int i=0;i<n;i++) {
			adj[i]=new LinkedList<int[]>();
			qs[i]=new LinkedList<int[]>();
		}
		for(int i=0;i<n-1;i++) {
			int x=sc.nextInt()-1,y=sc.nextInt()-1,w=sc.nextInt();
			adj[x].add(new int[] {y,w});
			adj[y].add(new int[] {x,w});
		}
		ans=new long[q];
		prefNodes=new long[n];
		prefEdges=new long[n];
		down=new long[n];
		up=new long[n];
		parEdge=new long[n];
		dfsDown(0, -1, 0);
		dfsUp(0, -1);
		preLCA(0, n);
		for(int i=0;i<q;i++) {
			int u=sc.nextInt()-1,v=sc.nextInt()-1;
			if(u==v) {
				ans[i]=down[u]+up[u]+in[u];
				continue;
			}
			int lca=lca(u, v);
			ans[i]=up[lca]+prefNodes[u]+prefNodes[v]-prefNodes[lca]*2+in[lca]-(prefEdges[u]+prefEdges[v]-prefEdges[lca]*2);
			if(u!=lca) {
				qs[u].add(new int[] {lca,i});
				ans[i]+=down[u];
			}
			if(v!=lca) {
				qs[v].add(new int[] {lca,i});
				ans[i]+=down[v];
			}
			if(u!=lca && v!=lca) {
				ans[i]-=down[lca];
			}
		}

		pref=new long[n];
		lastDfs(0,-1,0);
		for(int i=0;i<q;i++) {
			pw.println(ans[i]);
		}
    }
    public static void main(String[] args) throws Exception{
    	sc=new MScanner(System.in);
    	pw = new PrintWriter(System.out);
        int tc=1;
//        tc=sc.nextInt();
        for(int i=1;i<=tc;i++) {
//            pw.printf("Case #%d: ", i);
            main();
        }
        pw.flush();
    }
    static PrintWriter pw;
    static MScanner sc;
    static class MScanner {
        StringTokenizer st;
        BufferedReader br;
        public MScanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }
     
        public MScanner(String file) throws Exception {
            br = new BufferedReader(new FileReader(file));
        }
     
        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        public int[] intArr(int n) throws IOException {
            int[]in=new int[n];for(int i=0;i<n;i++)in[i]=nextInt();
            return in;
        }
        public long[] longArr(int n) throws IOException {
            long[]in=new long[n];for(int i=0;i<n;i++)in[i]=nextLong();
            return in;
        }
        public int[] intSortedArr(int n) throws IOException {
            int[]in=new int[n];for(int i=0;i<n;i++)in[i]=nextInt();
            shuffle(in);
            Arrays.sort(in);
            return in;
        }
        public long[] longSortedArr(int n) throws IOException {
            long[]in=new long[n];for(int i=0;i<n;i++)in[i]=nextLong();
            shuffle(in);
            Arrays.sort(in);
            return in;
        }
        public Integer[] IntegerArr(int n) throws IOException {
            Integer[]in=new Integer[n];for(int i=0;i<n;i++)in[i]=nextInt();
            return in;
        }
        public Long[] LongArr(int n) throws IOException {
            Long[]in=new Long[n];for(int i=0;i<n;i++)in[i]=nextLong();
            return in;
        }
        public String nextLine() throws IOException {
            return br.readLine();
        }
     
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
     
        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
     
        public char nextChar() throws IOException {
            return next().charAt(0);
        }
     
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
     
        public boolean ready() throws IOException {
            return br.ready();
        }
     
        public void waitForInput() throws InterruptedException {
            Thread.sleep(3000);
        }
        
    }
    static void sort(int[]in) {
    	shuffle(in);
        Arrays.sort(in);
    }
    static void sort(long[]in) {
    	shuffle(in);
        Arrays.sort(in);
    }
    static void shuffle(int[]in) {
        for(int i=0;i<in.length;i++) {
            int idx=(int)(Math.random()*in.length);
            int tmp=in[i];
            in[i]=in[idx];
            in[idx]=tmp;
        }
    }
    static void shuffle(long[]in) {
        for(int i=0;i<in.length;i++) {
            int idx=(int)(Math.random()*in.length);
            long tmp=in[i];
            in[i]=in[idx];
            in[idx]=tmp;
        }
    }
}