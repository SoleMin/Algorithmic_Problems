import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		StringTokenizer st = null;
		
		while((input = br.readLine()) != null){
			
			st = new StringTokenizer(input, " ");
			// 변수를 int로 선언할 경우 4번 case 통과하지 못하는 오류 발생
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
						
			long x1 = x;
			long y1 = y;
					
			if(x > y){
				long temp;
				temp = x;
				x = y;
				y = temp;
			}
			
			int max = 0;
			
			for (long i = x; i <= y; i++){
				long j = i;
				int count = 1;
				
				while (j != 1){	
					if ((j & 1) == 1){
						j = (j * 3) + 1;
						count++;
					}
					while((j & 1) == 0){
						j >>= 1;
						count++;
					}
				}
				if(count > max)
					max = count;
			}
			
			System.out.println(x1 + " " + y1 + " " + max);
		}
	}
}