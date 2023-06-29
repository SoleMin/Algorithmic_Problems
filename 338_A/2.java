import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		new TaskC().solve(in, out);
		out.close();
	}
}

class TaskC {
	
	static final long mod=1000000009;
	
	public void solve(InputReader in,PrintWriter out) {
		int n=in.nextInt();
		int m=in.nextInt();
		int k=in.nextInt();
		
		int l=0,r=m/k;
		while(l<r) {
			int mid=(l+r)>>>1;
			if(good(n,m,k,mid)){
				r=mid;
			}
			else{
				l=mid+1;
			}
		}
		Mat u=new Mat();
		u.set(k,1,0,0);
		Mat v=new Mat();
		v.set(2,0,k,1);
		u=u.mul(v.powMat(l));
		out.println((u.e[0][0]-k+(m-l*k)+mod)%mod);
	}

	private boolean good(int n, int m, int k, int mid) {
		n-=mid*k;
		m-=mid*k;
		int ans=n/k*(k-1)+n%k;
		if(ans>=m)
			return true;
		return false;
	}
	
	private static class Mat {
		long[][] e=new long[2][2];
		
		Mat mul(Mat u) {
			Mat s=new Mat();
			s.set(0,0,0,0);
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					for(int k=0;k<2;k++){
						s.e[i][j]=(s.e[i][j]+e[i][k]*u.e[k][j])%mod;
					}
				}
			}
			return s;
		}
		
		Mat powMat(int k) {
			Mat u=this;
			Mat s=new Mat();
			s.set(1,0,0,1);
			while(k!=0) {
				if(k%2==1) {
					s=s.mul(u);
				}
				u=u.mul(u);
				k/=2;
			}
			return s;
		}

		void set(long i, long j, long k, long l) {
			e[0][0]=i;
			e[0][1]=j;
			e[1][0]=k;
			e[1][1]=l;
		}
	}
	
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

}