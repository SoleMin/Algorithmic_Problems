import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			try{
				StringTokenizer st = new StringTokenizer(br.readLine());
				boolean[] tfArray = new boolean[3001];
				boolean tf = true;
				int size = Integer.parseInt(st.nextToken());
				int lastI = Integer.parseInt(st.nextToken());
				for(int i=1; i<size; i++){
					int newI = Integer.parseInt(st.nextToken());
					int step = Math.abs(newI - lastI);
					if(step==0 || step>=size || tfArray[step]){
						tf = false;
						break;
					}
					tfArray[step] = true;
					lastI = newI;
			
				}
				
				if(tf) sb.append("Jolly");
				else sb.append("Not jolly");
				sb.append('\n');
				
				
				
			}
			catch(NullPointerException ignore){
				break;
			}
		}
		System.out.println(sb);
		
		
		
		
		
	}
}