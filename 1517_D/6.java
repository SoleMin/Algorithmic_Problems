import java.util.*;
import java.io.*;

public class D {
	public static int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
		FastScanner sc = new FastScanner();
		FastOutput out = new FastOutput(System.out);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int k=sc.nextInt();
		int ans[][][]=new int[n][m][11];
		int arr[][]=new int[n*m][4];
		for(int i=0;i<n;i++){
			for(int j=0;j<m-1;j++){
				int x=sc.nextInt();
				arr[i*m+j][3]=x;
				arr[i*m+j+1][2]=x;
			}
		}
		for(int i=0;i<n-1;i++){
			for(int j=0;j<m;j++){
				int x=sc.nextInt();
				arr[i*m+j][1]=x;
				arr[(i+1)*m+j][0]=x;
			}
		}
		if(k%2==1){
			for(int i=0;i<n;i++){
				StringBuilder sb=new StringBuilder("");
				for(int j=0;j<m;j++){
					ans[i][j][10]=-1;
					sb.append(ans[i][j][10]+" ");
				}
				out.println(sb.toString());
			}
		}else{
			
			for(int ceng=1;ceng<=k/2;ceng++){
				for(int i=0;i<n;i++){
					for(int j=0;j<m;j++){
						ans[i][j][ceng]=Integer.MAX_VALUE/3;
						for(int dr=0;dr<4;dr++){
							int nx=i+dir[dr][0];
							int ny=j+dir[dr][1];
							if(nx<n&&ny<m&&nx>=0&&ny>=0){
								ans[i][j][ceng]=Math.min(ans[i][j][ceng], ans[nx][ny][ceng-1]+arr[i*m+j][dr]);
							}
						}
					}
				}
			}
			for(int i=0;i<n;i++){
				StringBuilder sb=new StringBuilder("");
				for(int j=0;j<m;j++){
					sb.append(ans[i][j][k/2]*2+" ");
				}
				out.println(sb.toString());
			}
		}
		out.close();
	}

	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readIntArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long[] readLongArray(int n) {
			long[] a=new long[n];
			for (int i=0; i<n; i++) a[i]=nextLong();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
	static class FastOutput implements AutoCloseable, Closeable, Appendable {
		private static final int THRESHOLD = 1 << 13;
		private final Writer os;
		private StringBuilder cache = new StringBuilder(THRESHOLD * 2);

		public FastOutput append(CharSequence csq) {
			cache.append(csq);
			return this;
		}

		public FastOutput append(CharSequence csq, int start, int end) {
			cache.append(csq, start, end);
			return this;
		}

		private void afterWrite() {
			if (cache.length() < THRESHOLD) {
				return;
			}
			flush();
		}

		public FastOutput(Writer os) {
			this.os = os;
		}

		public FastOutput(OutputStream os) {
			this(new OutputStreamWriter(os));
		}

		public FastOutput append(char c) {
			cache.append(c);
			afterWrite();
			return this;
		}

		public FastOutput append(int c) {
			cache.append(c);
			afterWrite();
			return this;
		}

		public FastOutput append(String c) {
			cache.append(c);
			afterWrite();
			return this;
		}

		public FastOutput println(String c) {
			return append(c).println();
		}

		public FastOutput println() {
			return append(System.lineSeparator());
		}

		public FastOutput flush() {
			try {
				os.append(cache);
				os.flush();
				cache.setLength(0);
			} catch (IOException e) {
				throw new UncheckedIOException(e);
			}
			return this;
		}

		public void close() {
			flush();
			try {
				os.close();
			} catch (IOException e) {
				throw new UncheckedIOException(e);
			}
		}
		public String toString() {
			return cache.toString();
		}
	}
}
