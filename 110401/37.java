import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(testCase-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			for(int i=0; i<n; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
			int key = arr[n/2];
			int distance = 0;
			for(int i=0; i<n; i++){
				distance += Math.abs(key-arr[i]);
				
			}
			sb.append(distance).append('\n');
			
			
		}
		System.out.println(sb);
		
		
		
		
		
	}
}