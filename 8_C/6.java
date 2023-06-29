import java.util.*;
import java.io.*;

public class Main{

    BufferedReader in;
    StringTokenizer str = null;
    PrintWriter out;

    private String next() throws Exception{
    	if (str == null || !str.hasMoreElements())
    	    str = new StringTokenizer(in.readLine());
    	return str.nextToken();
    }
    
    private int nextInt() throws Exception{
	   return Integer.parseInt(next());
    }

    int []x,y;
    int n;
    int []dp, prev;
    
    public void run() throws Exception{
    	in = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(System.out);

    	int xs = nextInt();
    	int ys = nextInt();
    	n = nextInt();
    	x = new int[n];
    	y = new int[n];
    	for(int i=0;i<n;i++){
    		x[i] = nextInt();
    		y[i] = nextInt();
    	}

    	int one[] = new int[n];
    	for(int i=0;i<n;i++){
    		one[i] = dist(xs, ys, x[i], y[i]);
    	}

    	int two[][] = new int[n][n];
    	for(int i=0;i<n;i++){
    		for(int j=i+1;j<n;j++){
    			two[i][j] = two[j][i] = dist(xs, ys, x[i], y[i]) + dist(x[i], y[i], x[j], y[j]) + dist(xs, ys, x[j], y[j]);
    		}
    	}

    	dp = new int[1<<n];
    	Arrays.fill(dp, Integer.MAX_VALUE/2);
    	dp[0] = 0;
    	prev = new int[1<<n];
    	Arrays.fill(prev, -1);

    	for(int mask=1;mask<(1<<n);mask++){
    		int i = 0;
    		while((mask & (1<<i)) == 0) i++;
    		dp[mask] = dp[mask ^ (1<<i)] + 2*one[i];
    		prev[mask] = i+1;
    		for(int j=i+1;j<n;j++){
    			if ((mask & (1<<j)) > 0) {
    				if (dp[mask] > dp[mask ^ (1<<i) ^ (1<<j)] + two[i][j]) {
    					dp[mask] = dp[mask ^ (1<<i) ^ (1<<j)] + two[i][j];
    					prev[mask] = 100 * (i+1) + (j+1);
    				}
    			}
    		}
    	}

    	out.println(dp[(1<<n)-1]);
    	out.print(0 + " ");
    	int cur = (1<<n)-1;
    	int i = 0, j = 0;
    	while(cur > 0) {
    		i = prev[cur]/100;
    		j = prev[cur]%100;
    		
    		if (i > 0) {
    			cur^=1<<(i-1);
    			out.print(i + " ");
    		}

    		if (j > 0) {
    			cur^=1<<(j-1);
    			out.print(j + " ");
    		}

    		out.print(0 + " ");
    	}
    	// if (i == 0 || j == 0) {
    	// 	out.println(0);	
    	// }
		out.close();	
    }

    private String bit2str(int mask, int n) {
    	String s = "";
    	for(int i=0;i<n;i++){
    		if ((mask & (1<<i)) > 0){
    			s+="1";
    		}else{
    			s+="0";
    		}
    	}
    	while(s.length() < n)
    		s+="0";

    	return new StringBuilder(s).reverse().toString();
    }

    private int dist(int x1, int y1, int x2, int y2) {
    	return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

    public static void main(String args[]) throws Exception{
	   new Main().run();
    }
}