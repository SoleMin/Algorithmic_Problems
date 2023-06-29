import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int date, p, out; //날짜, 정당 수, 손실 근무 일수
		int rest[]; //동맹휴업 정당
		
		int tc = sc.nextInt();
		
		for(int t=0; t<tc; t++) {
			date = sc.nextInt();
			p = sc.nextInt();
			rest = new int[p];
			for(int i=0; i<p; i++)
				rest[i] = sc.nextInt();
			
			out = 0;
			for(int i=0; i<date; i++) {
				//일0 월1 화2 수3 목4 금5 토6
				//금,토 휴업X
				if(i%7 >= 5)
					continue;
				
				//각 정당에 대해 휴일 계산
				for(int j=0; j<p; j++) {
					if((i+1)%rest[j] == 0) {
						out++;
						break; //중복 체크 방지
					}
				}
			}
			
			System.out.println(out);
		}
		
		sc.close();
	}
}