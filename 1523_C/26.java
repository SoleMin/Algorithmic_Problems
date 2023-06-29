import java.io.*;
import java.util.*;

public class C{
	
	public static void main(String[] args) throws IOException {
		// br = new BufferedReader(new FileReader(".in"));
		// out = new PrintWriter(new FileWriter(".out"));
		//new Thread(null, new (), "peepee", 1<<28).start();
		read();
		int t= RI();
		while(t-->0) {
			read();
			int n = RI();
			List<Integer> cur = new ArrayList<Integer>();
			int[] lvl = new int[n+10];
			while(n-->0) {
				read();
				int x = RI();
				
				if (cur.size() == 0) {
					cur.add(x);
					lvl[cur.size()]=x;
				}
				else {
					while (!cur.isEmpty()) {
						if (x == 1+lvl[cur.size()]) {
							int size = cur.size();
							cur.remove(size-1);
							cur.add(1+lvl[size]);
							lvl[size] = x;
							break;
						}
						else {
							// Either add to a new level or go to existing one.
							if (x == 1) {
								// add
								cur.add(x);
								lvl[cur.size()] = x;
								break;
							}
							else {
								lvl[cur.size()] = 0;
								cur.remove(cur.size()-1);
							}
						}
					}
					if (cur.size() == 0) {
						cur.add(x);
						lvl[cur.size()]=x;
					}
				}
				
				
				for (int i = 0; i < cur.size(); i++) {
					out.print(cur.get(i));
					if (i != cur.size()-1) out.print(".");
				}
				out.println();
			}
		}
		out.close();
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	static StringTokenizer st;
	static void read() throws IOException{st = new StringTokenizer(br.readLine());}	
	static int RI() throws IOException{return Integer.parseInt(st.nextToken());}
	static long RL() throws IOException{return Long.parseLong(st.nextToken());}
	static double RD() throws IOException{return Double.parseDouble(st.nextToken());}
	
}
