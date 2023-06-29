import java.io.*;
import java.text.*;
import java.util.*;

public class CottageVillage {

	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static String LINE() throws Exception { return stdin.readLine(); }
	static String TOKEN() throws Exception {
		while (st == null || !st.hasMoreTokens())st = new StringTokenizer(LINE());
		return st.nextToken();
	}
	static int INT() throws Exception {return Integer.parseInt(TOKEN());}
	static long LONG() throws Exception {return Long.parseLong(TOKEN());}
	static double DOUBLE() throws Exception {return Double.parseDouble(TOKEN());}

	static DecimalFormat DF = new DecimalFormat("0.000",new DecimalFormatSymbols(Locale.ENGLISH));
	
	public static final double EPSILON = 1E-9;
	
	public static void main(String[] args) throws Exception {
		int N = INT(), T = INT();
		House[] list = new House[N];
		for(int i = 0;i<N;i++) {
			list[i] = new House(INT(),INT());
		}
		Arrays.sort(list);
		int cnt = 2;
		for(int i = 1;i<N;i++) {
			int room = list[i].center-list[i-1].center;
			if(2*T<2*room-list[i].side-list[i-1].side)cnt += 2;
			else if(2*T==2*room-list[i].side-list[i-1].side)cnt++;
		}
		System.out.println(cnt);
		
	}
	
	private static class House implements Comparable<House> {
		int center, side;
		House(int c, int s) {
			this.center = c;
			this.side = s;
		}
		public int compareTo(House h) {
			return this.center-h.center;
		}
	}

}
