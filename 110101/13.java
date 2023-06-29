import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] array = new int[1000001];
		array[1] = 1;
		for(int i=2; i<=1000000; i++){
			long k = i;
			int count = 1;
			while(k!=1){
				if((k&1)==1){
					k = k*3 +1;
					count++;
				}
				while((k&1)==0){
					if(k<1000001 && array[(int)k]!=0){
						count += array[(int)k] -1;
						k = 1;
						break;
					}
					k >>=1;
					count++;
				}
			}
			array[i] = count;
		}
		while(true){
			try{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				sb.append(start).append(' ').append(end).append(' ');
				if(start > end){
					int tmp=start;
					start = end;
					end = tmp;
				}
				
				int maxLength = 0;
				for(int i=start; i<=end; i++){
					maxLength = Math.max(maxLength, array[i]);
				}
				sb.append(maxLength).append('\n');
				
				
				
				
				
			}
			catch(NullPointerException ignore){
				System.out.println(sb);
				break;
			}
			
			
			
		}
	}
}