import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.InputMismatchException;




public class TestClass11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in=new InputReader(System.in);
		OutputWriter out=new OutputWriter(System.out);
		int n=in.readInt();
		String s=in.readString();
		int low[]=new int[26];
		int upper[]=new int[26];
		boolean islow[]=new boolean[26];
		boolean isupper[]=new boolean[26];
		Arrays.fill(low,Integer.MAX_VALUE);
		Arrays.fill(upper, Integer.MAX_VALUE);
		
		int ans[]=new int[n];
		int finalsans=Integer.MAX_VALUE;
		for(int i=0;i<n;i++){
			int c=s.charAt(i);
			if(c>='a'&&c<='z'){
				islow[c-'a']=true;
			}
			else{
				isupper[c-'A']=true;
			}
			
		}
		
		
		for(int i=n-1;i>=0;i--){
			int c=s.charAt(i);
			
			if(c>='a'&&c<='z'){
				low[c-'a']=i;
			}
			else{
				upper[c-'A']=i;
			}
			
			
			for(int j=0;j<26;j++){
				if(islow[j]==true){
					ans[i]=Math.max(ans[i], low[j]);
				}
			}
          for(int j=0;j<26;j++){
        	  if(isupper[j]==true){
        		  ans[i]=Math.max(ans[i], upper[j]);
				}
			}
          
          finalsans=Math.min(ans[i]-i+1, finalsans);
		}
		

		System.out.println(finalsans);
		
		
	}

}

class InputReader {
	 
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;
 
	public InputReader(InputStream stream) {
		this.stream = stream;
	}
 
	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}
 
	public int readInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
 
	public String readString() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}
 
	public boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
 
	public String next() {
		return readString();
	}
 
	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}
 
class OutputWriter {
	private final PrintWriter writer;
 
	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}
 
	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}
 
	public void print(Object...objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}
 
	public void printLine(Object...objects) {
		print(objects);
		writer.println();
	}
 
	public void close() {
		writer.close();
	}
 
	public void flush() {
		writer.flush();
	}
 
	}
 
class IOUtils {
 
	public static int[] readIntArray(InputReader in, int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = in.readInt();
		return array;
	}
 
	}
