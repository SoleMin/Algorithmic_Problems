import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		long start, end, temp; //범위
		long save_s, save_e; //범위 저장
		long cycle, max_cycle, c; //사이클 체크
		
		while(sc.hasNextLong()) {
			start = sc.nextLong();
			end = sc.nextLong();
			save_s = start; save_e = end;
			
			if(start > end) {
				temp = start;
				start = end;
				end = temp;
			}
			
			max_cycle = 0;
			for(Long i=start; i<=end; i++) {
				c = i;
				cycle = 1;
				
				while(c!=1) {
					if(c%2!=0){
						c = c * 3 + 1;
						cycle++;
					}
					while(c%2==0){
						c >>= 1;
						cycle++;
					}
				}
				
				if(cycle > max_cycle) {
					max_cycle = cycle;
				}
			}
			
			System.out.printf("%d %d %d\n", save_s, save_e, max_cycle);
		}
		
		sc.close();
	}
}