import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		int n = nextInt();
		String nn = Integer.toString(n);
		if(n >= 0){
			println(n);
		} else {
			println(Math.max(Integer.parseInt(nn.substring(0,nn.length() - 1)), Integer.parseInt(nn.substring(0, nn.length() - 2) + nn.charAt(nn.length() - 1))));
		}
	}
	
	private static PrintWriter out =  new PrintWriter(System.out);
	private static BufferedReader inB = new BufferedReader(new InputStreamReader(System.in));	
	private static StreamTokenizer in = new StreamTokenizer(inB);
	
	private static void exit(Object o) throws Exception {
		out.println(o);
		out.flush();
		System.exit(0);
	}
	private static void println(Object o) throws Exception{
		out.println(o);
		out.flush();
	}
	private static void print(Object o) throws Exception{
		out.print(o);
		out.flush();
	}
	private static long nextLong() throws Exception {
		in.nextToken();
		return (long)in.nval;
	}  
	private static int nextInt() throws Exception {
		in.nextToken();
		return (int)in.nval;
	}  
	private static String nextString() throws Exception {
		in.nextToken();
		return in.sval;        
	}
	
} 