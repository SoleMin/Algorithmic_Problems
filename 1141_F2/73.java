import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Codeforces{
	
	static class MyScanner{
		BufferedReader br;
		StringTokenizer st;
		
		MyScanner(FileReader fileReader){
			br = new BufferedReader(fileReader);
		}
		
		MyScanner(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String nn(){
			while(st == null || !st.hasMoreElements()){
				try{
					st = new StringTokenizer(br.readLine());
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		char nc(){
			return nn().charAt(0);
		}
		
		int ni(){
			return Integer.parseInt(nn());
		}
		
		long nl(){
			return Long.parseLong(nn());
		}
		
		double nd(){
			return Double.parseDouble(nn());
		}
		
		int[] niArr0(int n){
			int[] ar = new int[n];
			for(int i = 0; i < n; i++) ar[i] = ni();
			return ar;
		}
		
		int[] niArr1(int n){
			int[] ar = new int[n + 1];
			for(int i = 1; i <= n; i++) ar[i] = ni();
			return ar;
		}
		
		long[] nlArr0(int n){
			long[] ar = new long[n];
			for(int i = 0; i < n; i++) ar[i] = nl();
			return ar;
		}
	}
	
	public static <T> void mprintln(T ... ar){
		for(T i: ar) out.print(i + " ");
		out.println();
	}
	
	private static PrintWriter out;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		// Input from file
		// File inputFile = new File("JavaFile.txt");
		// File outputFile = new File("JavaOutputFile.txt");
		// FileReader fileReader = new FileReader(inputFile);
		// Here it ends
			
		MyScanner sc = new MyScanner();
		// MyScanner sc = new MyScanner(fileReader);
		
		out = new PrintWriter(new BufferedOutputStream(System.out)); // Output to console
		// out = new PrintWriter(new PrintStream(outputFile)); // Output to file
		
		getAns(sc);
		
		out.close();
	}
	
	private static void getAns(MyScanner sc){
		int n = sc.ni();
		long[] ar = sc.nlArr0(n);
		
		HashMap<Long, ArrayList<int[]>> map = new HashMap();
		
		for(int i = 0; i < n; i++){
			long cur = 0;
			for(int j = i; j >= 0; j--){
				cur += ar[j];
				if(!map.containsKey(cur)) map.put(cur, new ArrayList());
				map.get(cur).add(new int[]{j + 1, i + 1});
			}
		}
		
		// System.out.println(map);
		
		Set<Long> set = map.keySet();
		// System.out.println(set);
		ArrayList<int[]> ans = new ArrayList();
		
		for(Long l: set){
			ArrayList<int[]> cur = new ArrayList();
			int right = -1;
			for(int[] arc: map.get(l)) if(arc[0] > right){
				right = arc[1];
				cur.add(arc);
			}
			
			if(cur.size() > ans.size()) ans = cur;
		}
		
		out.println(ans.size());
		for(int[] arc: ans) mprintln(arc[0], arc[1]);
	}
}