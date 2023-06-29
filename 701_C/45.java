import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.HashSet;
public class C {
	public static void main(String args[]) {
		Kattio sc = new Kattio(System.in);
		int n = sc.getInt();
		String s = sc.getWord();
		int[] found = new int['z' + 1];
		int amount = 0;
		for(int i = 0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(found[c] == 0) amount++;
			found[c]++;
		}
		int contains[] = new int['z' + 1];
		int min = n;
		int start = 0;
		int end = 0;
		int in = 0;
		while(true) {
			if(in<amount) {
				if(end == n) break;
				char c = s.charAt(end);
				if(contains[c] == 0) in++;
				contains[c]++;
				end++;
			} else {
				if(min>end-start) min = end-start;
				char c = s.charAt(start);
				if(contains[c] == 1) in--;
				contains[c]--;
				start++;
			}
		}
		System.out.println(min);


	}
}
class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
	super(new BufferedOutputStream(System.out));
	r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
	super(new BufferedOutputStream(o));
	r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
	return peekToken() != null;
    }

    public int getInt() {
	return Integer.parseInt(nextToken());
    }

    public double getDouble() { 
	return Double.parseDouble(nextToken());
    }

    public long getLong() {
	return Long.parseLong(nextToken());
    }

    public String getWord() {
	return nextToken();
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
	if (token == null) 
	    try {
		while (st == null || !st.hasMoreTokens()) {
		    line = r.readLine();
		    if (line == null) return null;
		    st = new StringTokenizer(line);
		}
		token = st.nextToken();
	    } catch (IOException e) { }
	return token;
    }

    private String nextToken() {
	String ans = peekToken();
	token = null;
	return ans;
    }
}
