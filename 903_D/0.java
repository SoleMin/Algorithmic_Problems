import java.util.*;
import java.io.*;
import java.math.BigInteger;

import static java.lang.Math.*;
public class template {
	final static int MOD = 1000000007;
	final static int intMax = 1000000000;
	final static int intMin = -1000000000;
	final static int[] dx = { 0, 0, -1, 1 };
	final static int[] dy = { -1, 1, 0, 0 };

	static int add(int a, int b) {
		return (a + b) % MOD;
	}
	
	static int sub(int a, int b) {
		return (a - b + MOD) % MOD;
	}
	
	static int mult(int a, int b) {
		return (int)((((long)(a)) * b) % MOD);
	}
	
	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[360]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
	
	static class Sb_Output implements Closeable, Flushable{
	    StringBuilder sb;
	    OutputStream os;
	    int BUFFER_SIZE;
	    public Sb_Output(String s) throws Exception {
	    	os = new BufferedOutputStream(new FileOutputStream(new File(s)));
	    	BUFFER_SIZE = 1 << 16;
	    	sb = new StringBuilder(BUFFER_SIZE);
	    }
	    public void print(String s) {
	        sb.append(s);
	        if(sb.length() >= (BUFFER_SIZE>>1)) {
	            flush();
	        }
	    }
	    public void println(String s) {
	        print(s);
	        print("\n");
	    }
	    public void println(int i) {
	    	println("" + i);
	    }
	    public void println(long i) {
	    	println("" + i);
	    }
	    public void flush() {
	        try {
	            os.write(sb.toString().getBytes());
	            sb = new StringBuilder(BUFFER_SIZE);
	        }catch(IOException e) {
	            e.printStackTrace();
	        }
	    }
	    public void close() {
	        flush();
	        try {
	            os.close();
	        }catch(IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public static void main(String[] args) throws Exception {
		Reader in = new Reader();
//		Reader in = new Reader(".in");
		Sb_Output out = new Sb_Output(".out");
		int n = in.nextInt();
		int[] a = new int[n];
		HashMap<Integer, Integer> freq = new HashMap<>();
		for(int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
			freq.put(a[i], 0);
			freq.put(a[i] + 1, 0);
			freq.put(a[i] - 1, 0);
		}
		long sum = 0;
		BigInteger ans = new BigInteger("0");
		for(int i = n - 1; i >= 0; --i) {
			long num = n - 1 - i;
			long add = sum - num * a[i];
			add -= freq.get(a[i] + 1);
			add += freq.get(a[i] - 1);
			BigInteger biadd = new BigInteger("" + add);
			ans = ans.add(biadd);
			sum += a[i];
			freq.put(a[i], freq.get(a[i]) + 1);
		}
		System.out.println(ans.toString());
		in.close();
		out.close();
	}
}