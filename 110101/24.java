import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		while((input = br.readLine()) != null) {
		int i = Integer.parseInt(input.split(" ")[0]);
		int j = Integer.parseInt(input.split(" ")[1]);
		int maxCnt=0;
		
		if(i > j) {
		for(int k = j; k <= i; k++){
			int cnt = 1;
			long n = Long.valueOf(k);
			while(n != 1) {
				
				if((n & 1) == 1){
					n = n * 3 + 1;
					cnt++;
				}
				while((n & 1) == 0){
					n = n>>1;
					cnt++;
				}
			}
			if(cnt >= maxCnt) {
				maxCnt = cnt;
			}
			
		}
		}
		else{
		for(int k = i; k<=j; k++) {
			int cnt = 1;
			long n = Long.valueOf(k);
			while(n != 1) {
				
				if((n & 1) == 1){
					n = n * 3 + 1;
					cnt++;
				}
				while((n & 1) == 0){
					n = n>>1;
					cnt++;
				}
			}
			if(cnt >= maxCnt) {
				maxCnt = cnt;
			}
		}
		}
		System.out.println(i + " " + j + " " + maxCnt);
	}
}
}