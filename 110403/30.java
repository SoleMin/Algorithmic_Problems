import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(testCase-->0){
			br.readLine();
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			for(int i=0; i<n; i++){
				arr[i] = Integer.parseInt(br.readLine());
				
			}
			Arrays.sort(arr);
			int right = n-1;
			int total = 0;
			for(int i=0; i<n-3; i+=2){
				int time1 = arr[0] + 2*arr[1] + arr[right];
				int time2 = 2*arr[0] + arr[right] + arr[right-1];
				
				total += Math.min(time1, time2);
				right -=2;
			}
			
			
			
		
			if(right==2){
				total += arr[0] + arr[1] + arr[2];
			}
			
			else if(right==1){
				total += arr[1];
			}
			
			sb.append(total).append('\n').append('\n');
		}
		System.out.println(sb);
	}
}