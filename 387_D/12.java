//Author: net12k44
import java.io.*;
import java.util.*;
public
class Main{//}
	
static PrintWriter out;

static int c[][];
static int x[] , y[] , n;
static int degIn[];
static ArrayList< ArrayList<Integer> >a = new ArrayList< ArrayList<Integer> >();
static int cnt = 0;
static boolean b[];

private static boolean dfs(int i) {
	if (i == -1) return true;
	if (b[i]) return false;
	b[i] = true;
	for(Integer j : a.get(i) ) 
		if ( dfs( y[j] ) ) {
			x[i] = j;
			y[j] = i;
			return true;
		}
	return false;
}

private static void find(int k) {
	int _cnt = -1;
	if (k>=0) { x[k] = k; y[k] = k; }
	while (_cnt != cnt) {
		_cnt = cnt;
		Arrays.fill( b , false );
		if (k>=0) b[k] = true;
		for(int i = 0; i < n; ++i)
		   if (x[i] == -1 && dfs(i) ) ++cnt;
	}
	if (k>=0) { x[k] = -1; y[k] = -1; }

}

public static void solve() {
	n = in.nextInt();
	int m = in.nextInt();
	
	b = new boolean[n]; c = new int [n][n];
	degIn = new int[n]; x = new int[n]; y = new int[n];	
	Arrays.fill(x , -1); Arrays.fill(y , -1);
	for(int i = 0; i < n; ++i) a. add( new ArrayList< Integer > () );
	
	while (m-- > 0) {
		int i = in.nextInt()-1 , j = in.nextInt()-1;
		a.get(i).add(j);
		degIn[j]++;
		c[i][j] = 1;
	}
	
	find(-1);
	int kq = Integer.MAX_VALUE;
	
	for(int k = 0; k < n; ++k) {
		if (x[k] != -1) {y[ x[k] ] = -1; x[k] = -1; cnt--; }
		if (y[k] != -1) {x[ y[k] ] = -1; y[k] = -1; cnt--; }
		find(k);
		
		int t = n*2 - 1 - a.get(k).size() - degIn[k] + c[k][k];
		for(int i = 0; i < n; ++i)
		 if (i!=k) 
			t = t + a.get(i).size() - c[i][k];		
		t = t - cnt + (n-1) - cnt;
		if (kq > t) kq = t;		
	}
	out.println(kq);
	
}
	
public static void main (String[] args) throws java.lang.Exception {		
	long startTime = System.currentTimeMillis();

	out = new PrintWriter(System.out);
	solve();	
	//out.println((String.format("%.2f",(double)(System.currentTimeMillis()-startTime)/1000)));
	out.close();
}
	
static class in {
	static BufferedReader reader = new BufferedReader( new InputStreamReader(System.in) ) ;
	static StringTokenizer tokenizer = new StringTokenizer("");				
	static String next() {		
		while ( !tokenizer.hasMoreTokens() )
			try { tokenizer = new StringTokenizer( reader.readLine() ); }
			catch (IOException e){
				throw new RuntimeException(e);			
			}		
		return tokenizer.nextToken();
	}
	static int nextInt() { return Integer.parseInt( next() ); }		
	static double nextDouble(){ return Double.parseDouble( next() ); }
}
//////////////////////////////////////////////////
}//