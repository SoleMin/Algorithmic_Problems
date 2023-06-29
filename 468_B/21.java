import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class B {
	static Set<Integer> A;
	static Set<Integer> B;
	static TreeSet<Integer> ts;
	static int a;
	static int b;
	static boolean noAns;
	public static void main(String[] args) throws Exception{
		int n = readInt();
		a = readInt();
		b = readInt();
		ts = new TreeSet<Integer>();
		int[] table = new int[n];
		for(int i = 0; i<n; i++){
			table[i] = readInt();
			ts.add(table[i]);
		}
		A = new HashSet<Integer>();
		B = new HashSet<Integer>();
		noAns = false;
		for(Integer cur:ts){
			boolean fitsA = false;
			boolean fitsB = false;
			if(A.contains(cur) || B.contains(cur)){
				continue;
			}
			if(ts.contains(a-cur)){
				fitsA = true;
			}
			if(ts.contains(b-cur)){
				fitsB = true;
			}
			if(fitsA && fitsB){
				continue;
			}
			else if(!(fitsA || fitsB)){
				noAns = true;
			}
			else if(fitsA){
				tour(cur, false);
			}
			else if(fitsB){
				tour(cur, true);
			}
		}
		for(Integer cur:ts){
			if(A.contains(cur) || B.contains(cur)){
				continue;
			}
			else{
				A.add(cur);
			}
		}
		if(!noAns){
			System.out.println("YES");
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i< n; i++){
				if(A.contains(table[i])){
					sb.append("0");
				}
				else{
					sb.append("1");
				}
				sb.append(" ");
			}
			System.out.println(sb);
		}
		else{
			System.out.println("NO");
		}
	}

	static void tour(Integer cur, boolean bb){
		if(A.contains(cur) || B.contains(cur)){
			return;
		}
		if(bb){
			B.add(cur);
			B.add(b-cur);
			
			if(ts.contains(a-cur)){
				B.add(a-cur);
				if(ts.contains(b-(a-cur))){
					tour(b-(a-cur), true);
				}
				else{
					noAns = true;
				}
			}			
			if(ts.contains(a-(b-cur))){
				B.add(a-(b-cur));
				if(ts.contains(b-(a-(b-cur)))){
					tour(b-(a-(b-cur)), true);
				}
				else{
					noAns = true;
				}
			}
		}
		else{
			A.add(cur);
			A.add(a-cur);
			if(ts.contains(b-cur)){
				A.add(b-cur);
				if(ts.contains(a-(b-cur))){
					tour(a-(b-cur), false);
				}
				else{
					noAns = true;
				}
			}
			if(ts.contains(b-(a-cur))){
				A.add(b-(a-cur));
				if(ts.contains(a-(b-(a-cur)))){
					tour(a-(b-(a-cur)), false);
				}
				else{
					noAns = true;
				}
			}
		}
	}

	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer(" ");
	static String readString() throws Exception{
		while(!st.hasMoreTokens()){
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}
	static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
	static long readLong() throws Exception {
		return Long.parseLong(readString());
	}
}
