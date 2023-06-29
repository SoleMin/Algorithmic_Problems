// Main Code at the Bottom
import java.util.*;
import java.io.*; 
public class Main{
	//Fast IO class
    static class FastReader {
        BufferedReader br; 
        StringTokenizer st; 
        public FastReader() {
        	boolean env=System.getProperty("ONLINE_JUDGE") != null;
        	//env=true;
        	if(!env) {
        		try {
					br=new BufferedReader(new FileReader("src\\input.txt"));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
        	}
        	else br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) {
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
        int nextInt() {
            return Integer.parseInt(next()); 
        } 
        long nextLong() {
            return Long.parseLong(next()); 
        } 
        double nextDouble() {
            return Double.parseDouble(next()); 
        } 
        String nextLine() {
            String str = ""; 
            try {
                str = br.readLine(); 
            } 
            catch (IOException e) {
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }     
    static long MOD=(long)1e9+7;
    //debug
    static void debug(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
    static FastReader sc=new FastReader();
    static PrintWriter out=new PrintWriter(System.out);  
    //Global variables and functions
    static int code(int x,int y) {
    	return 505*x+y;
    }
    static class pair{
    	int x,y;
    	pair(int a,int b){
    		this.x=a;
    		this.y=b;
    	}
    	public boolean equals(Object obj) {
    		if(obj == null || obj.getClass()!= this.getClass()) return false;
            pair p = (pair) obj;
            return (this.x==p.x && this.y==p.y);
        }
    	public int hashCode() {
            return Objects.hash(x,y);
        }
    }
    static int hor[][],ver[][];
    static int moves[][]= {{-1,0},{1,0},{0,-1},{0,1}};
    static int n,m;
    static int dp[][][];
    static int solve(int x,int y,int k) {
    	if(k==0) {
    		return 0;
    	}
    	if(dp[x][y][k]!=0) return dp[x][y][k];
    	int min=(int)MOD;
    	for(int mo[]: moves) {
			int X=x+mo[0],Y=y+mo[1];
			if(X<0 || X>=n || Y<0 || Y>=m) continue;
			int val=0;
			if(mo[0]==1) val=ver[x][y];
			else if(mo[0]==-1) val=ver[x-1][y];
			else if(mo[1]==1) val=hor[x][y];
			else val=hor[x][y-1];
			min=Math.min(min, 2*val+solve(X,Y,k-2));
		}
    	return dp[x][y][k]=min;
    }
    //Main function(The main code starts from here)
    public static void main (String[] args) throws java.lang.Exception {
    	int test=1;
    	//test=sc.nextInt();
    	while(test-->0) {
    		n=sc.nextInt();m=sc.nextInt();
    		int k=sc.nextInt();
    		if(k%2!=0) {
    			for(int i=0;i<n;i++) {
    				for(int j=0;j<m;j++) out.print(-1+" ");
    				out.println();
    			}
    			continue;
    		}
    		hor=new int[n][m-1];
    		ver=new int[n-1][m];
    		for(int i=0;i<n;i++) {
    			for(int j=0;j<m-1;j++) {
    				hor[i][j]=sc.nextInt();
    			}
    		}
    		for(int i=0;i<n-1;i++) {
    			for(int j=0;j<m;j++) {
    				ver[i][j]=sc.nextInt();
    			}
    		}
    		dp=new int[n][m][k+1];
    		for(int i=0;i<n;i++) {
    			for(int j=0;j<m;j++) {
    				out.print(solve(i,j,k)+" ");
    			}
    			out.println();
    		}
    		
    	}
        out.flush();
        out.close();
    }
}