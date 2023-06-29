import java.io.*;
import java.util.*;

public class E {

	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int n=sc.nextInt(),k=sc.nextInt();
		boolean [][]adj=new boolean[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				adj[i][j]=sc.nextInt()==1;
		int n1=n/2,n2=n-n1;
		int []clique=new int [1<<n1];
		for(int msk=1;msk<1<<n1;msk++)
		{
			boolean ok=true;
			for(int i=0;i<n1;i++) if((msk & 1<<i) !=0)
				for(int j=i+1;j<n1;j++)
					if((msk & 1<<j) !=0 && !adj[i][j])
						ok=false;
			if(ok)
				clique[msk]=Integer.bitCount(msk);
		}
		
		int []edges=new int [n2];
		for(int i=0;i<n2;i++)
		{
			int msk=0;
			for(int j=0;j<n1;j++)
				if(adj[i+n1][j])
					msk|=1<<j;
			edges[i]=msk;
		}
		int max=0;
		for(int msk=1;msk<1<<n1;msk++)
			for(int i=0;i<n1;i++)
				if((msk & 1<<i) !=0)
					max=Math.max(max, clique[msk]=Math.max(clique[msk], clique[msk^(1<<i)]));
		
		for(int msk=1;msk<1<<n2;msk++)
		{
			int all=(1<<n1)-1;
			for(int j=0;j<n2;j++)
				if((msk & 1<<j) !=0)
					all &=edges[j];
			boolean ok=true;
			for(int i=0;i<n2;i++) if((msk & 1<<i) !=0)
				for(int j=i+1;j<n2;j++)
					if((msk & 1<<j) !=0 && !adj[i+n1][j+n1])
						ok=false;
			if(ok)
				max=Math.max(max, Integer.bitCount(msk)+clique[all]);	
			
			
		}
		
		out.printf("%.9f\n",k*1.0*k*(max-1)/(2*max));
		
		out.close();
		
		
	}
	static class Scanner {
        StringTokenizer st;
        BufferedReader br;
 
        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }
 
        public Scanner(FileReader s) {
            br = new BufferedReader(s);
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
        public boolean ready() throws IOException {return br.ready();}
        public double nextDouble() throws IOException {return Double.parseDouble(next());}
       
    }
}
