import java.util.Scanner;

public class Main {

	static int cnt[][] = new int[10001][2];
	static int ferry, n, max, lensum; // 페리 길이, 차량 수
	
	public static void main(String[] args) {
		// 문제 페리 탑승
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		int temp;
		
		for(int t=0; t<tc; t++) {
			ferry = sc.nextInt() * 100; //페리 길이 미터단위 입력
			n = 1;
			
			for(int i=0; i<=ferry; i++) {
				cnt[i][0] = -1;
				cnt[i][1] = 0;
			}
			
			cnt[0][0] = 0;
			lensum = 0;
			max = 0;
			while(true) {
				temp = sc.nextInt();
				if(temp==0) { break; }
				if(lensum <= 2*ferry) {
					dynamic(n++, temp);
					lensum += temp;
				}
			}
			System.out.println(cnt[max][0]);
			System.out.println();
		}
		sc.close();
	}

	static void dynamic(int carnum, int carlen) {
		for(int i=ferry; i>=carlen; i--) {
				if(cnt[i-carlen][0] != -1 &&
					lensum-i+carlen<=ferry & cnt[i][0] < carnum) {
					cnt[i][0] = carnum;
					cnt[i][1] = lensum - i + carlen;
					if(cnt[max][0]<cnt[i][0] || (cnt[max][0]==cnt[i][0] &&
						Math.abs(max - cnt[max][1]) > Math.abs(i - cnt[i][1])))
						max = i;
			}
		}
	}
}