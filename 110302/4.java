import java.io.*;

import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int loopCount = input.nextInt();
		String trash = input.nextLine();
		int stop = 0;
		
		while(stop != loopCount) {
			int m = input.nextInt();
			int n = input.nextInt();
			
			// mn집어넣기
			char[][] mn = new char[m][n];
			String[] test = new String[m];
			
			String test_2 = input.nextLine();
			
			for(int i = 0; i < m; i++) {
				test[i] = input.nextLine().toLowerCase();
			}
			
			//mn char으로 쪼개 넣기
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					mn[i][j] = test[i].charAt(j);
				}
			}
			
			// 물어볼 단어들 받기
			int q = input.nextInt();
			String[] words = new String[q];
			
			String trash_3 = input.nextLine();
			for(int i = 0; i < q; i++) {
				words[i] = input.nextLine().toLowerCase();
			}
			
			//각 문자의 위치를 저장하는 배열
			String[] point = new String[q];
			
			// 단어 위치 찾는다잉
			int wordCount = 0;
			while(wordCount != q) {

					int count = 0;
					int index = 1;
					int check = 0;
					String changePoint = "";
					for(int a = 0; a < m; a++) {
						for(int b = 0; b < n; b++) {
							if(mn[a][b] == words[wordCount].charAt(0)) { // 첫 번째 글자와 행렬위의 글자가 같다면
								changePoint = (a+1) + " " + (b+1); // 그 위치 일단 체인지포인트에 넣어주기
								
								count = 0;
								index = 1;
								//<-이쪽 방향 1
								if(check == 0) {
									for(int c = b-1; c != -1; c--) {
										if(index == words[wordCount].length()) {
											break;
										}
										if(mn[a][c] == words[wordCount].charAt(index)) {
											count++;
										}
										index++;
									}
									if(count == words[wordCount].length()-1) {
										point[wordCount] = changePoint;
										check = 1;
									}
								}
								
								count = 0;
								index = 1;
								//->이쪽 방향 2
								if(check == 0) {
									for(int c = b+1; c < n; c++) {
										if(index == words[wordCount].length()) {
											break;
										}// <- 요 방향 확인
										if(mn[a][c] == words[wordCount].charAt(index)) {
											count++;
										}
										index++;
									}
									if(count == words[wordCount].length()-1) {
										point[wordCount] = changePoint;
										check = 1;
									}
								}
								
								count = 0;
								index = 1;
								//위쪽 방향 3
								if(check == 0) {
									for(int c = a-1; c > -1; c--) {
										if(index == words[wordCount].length()) {
											break;
										}// <- 요 방향 확인
										if(mn[c][b] == words[wordCount].charAt(index)) {
											count++;
										}
										index++;
									}
									if(count == words[wordCount].length()-1) {
										point[wordCount] = changePoint;
										check = 1;
									}
								}
								
								if(check == 0) {
									count = 0;
									index = 1;
									//아래쪽 방향 4
									for(int c = a+1; c < m; c++) {// <- 요 방향 확인
										if(index == words[wordCount].length()) {
											break;
										}
										if(mn[c][b] == words[wordCount].charAt(index)) {
											count++;
										}
										index++;
									}
									if(count == words[wordCount].length()-1) {
										point[wordCount] = changePoint;
										check = 1;
									}
								}
								
								count = 0;
								index = 1;
								//왼쪽 대각석 위쪽 방향 5
								int y = b-1;
								if(check == 0) {
									for(int c = a-1; c > -1; c--) {
										if(y == -1) {
											break;
										}// <- 요 방향 확인
										if(index == words[wordCount].length()) {
											break;
										}
										if(mn[c][y] == words[wordCount].charAt(index)) {
											count++;
										}
										index++;
										y--;
									}
									if(count == words[wordCount].length()-1) {
										point[wordCount] = changePoint;
										check = 1;
									}
								}
								
								count = 0;
								index = 1;
								//오른쪽 대각석 위쪽 방향 6
								int yy = b+1;
								if(check == 0) {
									for(int c = a-1; c > -1; c--) {// <- 요 방향 확인
										if(index == words[wordCount].length()) {
											break;
										}
										if(yy == n) {
											break;
										}
										if(mn[c][yy] == words[wordCount].charAt(index)) {
											count++;
										}
										index++;
										yy++;
									}
									if(count == words[wordCount].length()-1) {
										point[wordCount] = changePoint;
										check = 1;
									}
								}
								
								count = 0;
								index = 1;
								//왼쪽 대각석 아래쪽 방향 7
								int yyy = b-1;
								if(check == 0) {
									for(int c = a+1; c < m; c++) {// <- 요 방향 확인
										if(index == words[wordCount].length()) {
											break;
										}
										if(yyy == -1) {
											break;
										}
										if(mn[c][yyy] == words[wordCount].charAt(index)) {
											count++;
										}
										index++;
										yyy--;
									}
									if(count == words[wordCount].length()-1) {
										point[wordCount] = changePoint;
										check = 1;
									}
								}
								
								count = 0;
								index = 1;
								//오른쪽 대각석 아래쪽 방향 8
								if(check == 0) {
									int yyyy = b+1;
									for(int c = a+1; c < m; c++) {
										if(index == words[wordCount].length()) {
											break;
										}
										if(yyyy == n) {
											break;
										}// <- 요 방향 확인
										if(mn[c][yyyy] == words[wordCount].charAt(index)) {
											count++;
										}
										index++;
										yyyy++;
									}
									if(count == words[wordCount].length()-1) {
										point[wordCount] = changePoint;
										check = 1;
									}
								}
							}
						}
					}
				wordCount++;
				
			}
			
			for(int i = 0; i < q; i++) {
				System.out.println(point[i]);
			}
			System.out.println("");
			stop++;
		}

	}

}