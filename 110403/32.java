import java.util.Scanner;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int n, person[]; //인원수, 각 시간
		
		int tc = sc.nextInt();
		sc.nextLine();
		for(int t=0; t<tc; t++) {
			sc.nextLine();
			n = sc.nextInt();
			person = new int[n];
			for(int i=0; i<n; i++)
				person[i] = sc.nextInt();
			Arrays.sort(person);
			
			System.out.println(move(person,n));
			System.out.println();
		}
		sc.close();
	}
	
	static int move(int[] p, int n) {
		//3명 이하일 경우, 4명 이상일 경우 나누어 게산
		int time = 0;
		
		while(true) {
			if(n == 3) { time += p[0] + p[1] + p[2]; break; }
			else if(n < 3) { time += p[n-1]; break; }
			else {
				// 첫번째: 1,2 - 1 - 3,4 - 2 >> 1+2+2+4
				// 두번째: 1,3 - 1 - 1,4 - 1 >> 1+1+3+4
				// 두 경우 중 더 빠른 것 선택: 2+2와 1+3 비교
				if(p[1]*2 < p[0]+p[n-2]) { // 첫 번째 경우
					time += p[0] + p[1]*2 + p[n-1];
				}
				else { // 두 번째 경우
					time += p[0]*2 + p[n-1] + p[n-2];
				}
				n = n-2;
			}
		}
		
		return time;
	}
}