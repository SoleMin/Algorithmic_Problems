import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(testCase-->0){
			int days = Integer.parseInt(br.readLine());
			boolean[] tfArray = new boolean[days];
			int size = Integer.parseInt(br.readLine());
			
			
			int daysCount = 0;
			for(int i=0; i<size; i++){
				int step = Integer.parseInt(br.readLine());
				int n = step -1;
				while(n<days){
					if(!tfArray[n] && n%7 < 5){
						tfArray[n] = true;
						daysCount++;
					
					}
					n += step;
				}
			}
			sb.append(daysCount).append('\n');
	
		}
		System.out.println(sb);
		
		
		
		
	}
}