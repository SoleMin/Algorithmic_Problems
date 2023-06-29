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
			double[][] arr = new double[n][2];
			for(int i=0; i<n; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Double.parseDouble(st.nextToken())/Double.parseDouble(st.nextToken());
				arr[i][1] = i;
			}
			
		
			Arrays.sort(arr, Comparator.comparing(o1->o1[0]));
			for(int i=0; i<n; i++){
				sb.append((int)arr[i][1]+1).append(' ');
			}
			sb.append('\n');
			sb.append('\n');
		
		}
		System.out.println(sb);
	}
}