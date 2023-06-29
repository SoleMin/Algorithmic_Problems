import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		Scanner input = new Scanner(System.in);
		
		int tc = Integer.parseInt(input.nextLine()); // 테스트 케이스 갯수
		
		for (int i = 0; i < tc; i++) {
			int nDays = Integer.parseInt(input.nextLine()); // 시뮬레이션을 돌릴 기간 (날 수)
			int nParty = Integer.parseInt(input.nextLine()); // 정당의 갯수
			int[] H = new int[nParty]; // 정당의 동맹 휴업 지수
			
			for (int j = 0; j < nParty; j++) {
				H[j] = Integer.parseInt(input.nextLine());
			}
			
			int days = 0; // 손실된 근무일 수 
			
			for (int j = 1; j <= nDays; j++) {
				if (j % 7 == 6 || j % 7 == 0) {
					continue;
				}
				for (int k = 0; k < H.length; k++) {
					if (j % H[k] == 0) {
						days++;
						break;
					}
				}
			}
			list.add(days);
		}
	
		// 결과 출력
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		input.close();
	}
}