import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class A {
	public static BufferedReader in;
	public static PrintWriter out;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		boolean showLineError = true;
		if (showLineError) {
			solve();
			out.close();
		} else {
			try {
				solve();
			} catch (Exception e) {
			} finally {
				out.close();
			}
		}

	}

	static void debug(Object... os) {
		out.println(Arrays.deepToString(os));
	}

	private static void solve() throws IOException {
		String[] line = in.readLine().split(" ");
		String l = Long.toBinaryString(Long.parseLong(line[0]));
		String r = Long.toBinaryString(Long.parseLong(line[1]));
		if(l.equals(r)){
			out.println(0);
			return;
		}
		int dif = r.length()-l.length();
		for(int i =0;i<dif;i++)
			l= "0"+l;
		int index=0;
		for(;index<r.length();index++){
			if(l.charAt(index)!=r.charAt(index))
				break;
		}
		long ret=1;
		for(int i=0;i<l.length()-index;i++)
			ret+=ret;
		ret--;
		out.println(ret);
		
	}

}