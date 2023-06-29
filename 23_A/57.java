import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	public static void main(String[] args) /*throws FileNotFoundException*/ { 
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastScanner in = new FastScanner(inputStream);
		FastPrinter out = new FastPrinter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA{
     static boolean twofind(String s, String t){
    	 int index = s.indexOf(t);
    	 int index2 = s.indexOf(t, index + 1);
    	 if(index2 != -1)return true;
    	 return false;
     }
	public void solve(int testNumber, FastScanner scan, FastPrinter out) /*throws FileNotFoundException*/ {
		//Scanner sscan = new Scanner(new File("input.txt"));
		//PrintStream oout = new PrintStream(new File("output.txt"));
	     String s = scan.next();
	     String ans = "";
	     boolean ok = false;
	     for(int i = s.length(); i >= 0; i--){
	        for(int j = 0; j <= s.length() - 1; j++){
	        	try{
	        		if(twofind(s, s.substring(j, j + i))){
	        			ans = s.substring(j, j + i); break;
	        		}
	        	}catch(Exception e){
	        		break;
	        	}
	        }
	        if(!ans.equals(""))break;
	     }
	     
	     out.println(ans.length());
		//sscan.close();
		//oout.close();
	}
}

class FastScanner extends BufferedReader {
	public FastScanner(InputStream is) {
		super(new InputStreamReader(is));
	}
	
	public int read() {
		try{
			int ret = super.read();
			return ret;
		}catch(Exception e){
			throw new InputMismatchException();
		}
	}
	
	public String next() {
        StringBuilder sb = new StringBuilder();
        int c = read();
        while (isWhiteSpace(c)) {
            c = read();
        }
        if (c < 0) {
            return null;
        }
        while (c >= 0 && !isWhiteSpace(c)) {
            sb.appendCodePoint(c);
            c = read();
        }
        return sb.toString();
    }
	
	static boolean isWhiteSpace(int c) {
        return c >= 0 && c <= 32;
    }
	
	public int nextInt() {
        int c = read();
        while (isWhiteSpace(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int ret = 0;
        while (c >= 0 && !isWhiteSpace(c)) {
            if (c < '0' || c > '9') {
                throw new NumberFormatException("digit expected " + (char) c
                        + " found");
            }
            ret = ret * 10 + c - '0';
            c = read();
        }
        return ret * sgn;
    }
	
	public long nextLong() {
		return Long.parseLong(next());
	}
	
	public BigInteger nextBigInteger() {
		return new BigInteger(next());
	}
	
	public BigDecimal nextBigDecimal(){
		return new BigDecimal(next());
	}
	
	public String readLine(){
		try{
			return super.readLine();
		}catch(IOException e){
			return null;
		}
	}
}

class FastPrinter extends PrintWriter {
	
	public FastPrinter(OutputStream out) {
		super(out);
	}
	public FastPrinter(Writer out) {
		super(out);
	}
}
