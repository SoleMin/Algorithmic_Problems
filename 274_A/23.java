import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.TreeSet;

public class Main{

	
	public static void main(String[] args) throws Exception {
		Parserdoubt3 s = new Parserdoubt3(System.in);
		int n = s.nextInt();
		long k = s.nextInt();
		Long a[] = new Long[n];
		TreeSet<Long> tree = new TreeSet<Long>();
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextLong();
			tree.add(a[i]);
		}
		Arrays.sort(a);
		
		int ans = 0;
		
		for (int i = 0; i < a.length; i++) {
			if(tree.contains(a[i])){ 
				ans++;
				long next = a[i] * k;
				if(tree.contains(next)) tree.remove(next);
			}
		}
		System.out.println(ans);
	}

}

class Parserdoubt3 {
	final private int BUFFER_SIZE = 1 << 17;

	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public Parserdoubt3(InputStream in) {
		din = new DataInputStream(in);
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}

	public String nextString() throws Exception {
		StringBuffer sb = new StringBuffer("");
		byte c = read();
		while (c <= ' ')
			c = read();
		do {
			sb.append((char) c);
			c = read();
		} while (c > ' ');
		return sb.toString();
	}

	public char nextChar() throws Exception {
		byte c = read();
		while (c <= ' ')
			c = read();
		return (char) c;
	}

	public int nextInt() throws Exception {
		int ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = c == '-';
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
			c = read();
		} while (c > ' ');
		if (neg)
			return -ret;
		return ret;
	}

	public long nextLong() throws Exception {
		long ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = c == '-';
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
			c = read();
		} while (c > ' ');
		if (neg)
			return -ret;
		return ret;
	}

	private void fillBuffer() throws Exception {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}

	private byte read() throws Exception {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}
}