import java.io.*;
import java.util.*;

public class C {

	static int ar[];
	static HashMap<String, ArrayList<String>> map;
	static int location = 0;
	static StringBuilder sb;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		while(t --> 0) {
			
			int n = Integer.parseInt(br.readLine());
			ar = new int[n];
			location = 0;
			map = new HashMap<String, ArrayList<String>>();
			sb = new StringBuilder();
			N = n;
						
			for(int i = 0; i < n; i++) {
				
				ar[i] = Integer.parseInt(br.readLine());
				
			}
			
			int idx = 2;
			location = 1;
			
			sb.append("1\n");
			
			while(location < n) {
				
				if(ar[location] == 1) {
					
					nl((idx-1)+".");
					
				}else {
					
					sb.append(idx+"\n");
					idx++;
					location++;
					
				}
				
			}
			
			System.out.println(sb);
			
		}	
		
	}
	
	public static void nl(String l) {
		
		int idx = 1;
		//System.out.println(location + " " + l);
		
		while(location < N) {
						
			if(idx == ar[location]) {
				
				sb.append(l + idx + "\n");
				idx++;
				location++;
				
			}else if(ar[location] == 1) {
				
				nl(l + (idx-1) + ".");
				
			}else {
				
				return;
				
			}
			
		}
		
	}

}