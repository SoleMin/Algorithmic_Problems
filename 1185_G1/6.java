import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;


public class q5 {
	static NoD[] arr;
	static int index,count,zc;
	static ArrayList<NoD> pos,neg;
	static long[][][][] dp;
	
	static long solve(int a,int b, int c,int d, long mod) {
		long[][][][] a2=dp;
		int p=-1;
		if(a==0 && b==0 && c==0) return 1;
		if(dp[a][b][c][d]!=-1) return dp[a][b][c][d];
		long tr=0;
		if(a>0 && d!=1) {
			tr=+a*solve(a-1,b,c,1,mod);
			tr%=mod;
		}
		if(b >0 && d!=2) {
			tr+=b*solve(a,b-1,c,2,mod);
			tr%=mod;
		}
		if(c>0 && d!=3) {
			tr+=c*solve(a,b,c-1,3,mod);
			tr%=mod;
		}
		tr%=mod;
		return dp[a][b][c][d]=tr;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		Reader.init(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int n=Reader.nextInt(),t=Reader.nextInt();
		long mod=(long)1e9+7,fact[]=new long[16];
		dp=new long[16][16][16][4];
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				for(int k=0;k<16;k++)
				Arrays.fill(dp[i][j][k], -1);
			}
		}
		fact[0]=1;
		for(int i=1;i<=15;i++) {
			fact[i]=i*fact[i-1];
			fact[i]%=mod;
		}
		NoD[] arr=new NoD[n];
		for(int i=0;i<n;i++) {
			int a=Reader.nextInt(),b=Reader.nextInt();
			arr[i]=new NoD(a,b);
			
		}
		long ans=0;
		for(int i=0;i<(1<<n);i++) {
			int time=0;
			int prev=-1;
			int t1=0,t2=0,t3=0;
			long[] c= {i};
			BitSet b=BitSet.valueOf(c);
			for(int j=0;j<n;j++) {
				if(b.get(j)) {
					time+=arr[j].val;
						prev=arr[j].index;
						if(arr[j].index==1) t1++;
						else if(arr[j].index==2) t2++;
						else t3++;	
				}
			}
			if(time==t) {
				long v=1;
				long v2=1;
				v*=solve(t1,t2,t3,0,mod);
				v%=mod;
				ans+=v;
				ans%=mod;
			}
		}
		out.println(ans);
		out.flush();
		
	}
}

class NoD{
	int val, index;
	NoD(int v,int i){
		val=v;index=i;
	}
}

class Pair{
	NoD a, b;
	Pair(NoD aa,NoD bb){
		a=aa;b=bb;
	}
}


class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
    /** get next word */
    static String nextLine() throws IOException{
    	return reader.readLine();
    }
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}