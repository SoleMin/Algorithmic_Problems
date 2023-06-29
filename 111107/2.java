import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int loopCount = input.nextInt();
		int stop = 0;
		
		while(stop != loopCount) {
			
			int people = input.nextInt();
			int chopstic = input.nextInt();
			
			// 가족수 더하기
			people += 8;
			
			// 젓가락 길이 배열
			int[] cm = new int[chopstic];
			for(int i = 0; i < chopstic; i++) {
				cm[i] = input.nextInt();
			}
			
			// 젓가락 길이 배열 뒤집기
			int[] reverse = new int[chopstic + 1];
			int k = 0;
			for(int i = chopstic; i >= 1; i--) {
				reverse[i] = cm[k];
				k++;
			}
			
			// 젓가락 길이 나눈다 (동적계획)
			int[][] smallP = new int[5001][5001];
			for(int i = 1; i <= chopstic; i++) {
				smallP[i][0] = 0;
				for(int j = 1; j <= people; j++) {
					smallP[i][j] = 33000;
				}
			}
			
			for(int i = 3; i <= chopstic; i++) {
				for(int j = 1; j <= people; j++) {
					if(i >= 3 * j && smallP[i-2][j-1] != 33000) { // 젓가락 길이 공란아니면
						if(smallP[i-1][j] < smallP[i - 2][j-1] + 
						(reverse[i] - reverse[i-1]) * (reverse[i] - reverse[i-1])) { // 점화식 사용
							smallP[i][j] = smallP[i-1][j];
						}
						else {
							smallP[i][j] = smallP[i - 2][j-1] 
										+ (reverse[i] - reverse[i-1]) * (reverse[i] - reverse[i-1]);
						}
					}
				}
			}
			
			// 답 출력
			System.out.println(smallP[chopstic][people]);
			
			stop++;
		}

	}

}
