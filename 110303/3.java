import java.io.*;

import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
			
			int m = 0;
			String[] number = new String[1000];
			//고오난이도 코드
			String a = "";
			while(input.hasNextLine()) {
				a = input.nextLine();
				if(a.equals("") && a.length() == 0 && m > 0) {
					break;
				}
				
				number[m] = a;
				m++;
			}
			
			//저거 받은 거 두 쌍씩 2차원 배열에 넣기
			int trash = 0;
			String[][] find = new String[m][2];
			for(int i = 0; i < m/2; i++) {
				for(int j = 0; j < 2; j++) {
					find[i][j] = number[j + trash];
				}
					trash+=2;
			}
			
			// null없애기
			String[] answer = new String[m/2];
			for(int i = 0; i < m/2; i++) {
				answer[i] = "";
			}
			
			//같은 알파벳 찾기
			int stop = 0;
			while(stop != m/2) {
				//중복 확인용 count
				int[] count_2 = new int[find[stop][0].length()];
				int[] count = new int[find[stop][1].length()];
				// 전줄이랑 다음줄 하나씩 char로 비교해주기
				for(int i = 0; i < find[stop][0].length(); i++) { //윗줄 하나와
					for(int j = 0; j < find[stop][1].length(); j++) { // 아랫줄 여럿
						if(find[stop][0].charAt(i) == find[stop][1].charAt(j) && count[j] == 0 && count_2[i] == 0) {
							answer[stop] += find[stop][1].substring(j,j+1);
							count[j]++;
							count_2[i]++;
						}
					}
				}
				
				stop++;
			}
			
			char[][] real = new char[m/2][1000];
			//char형을 바꿔버리기 
			for(int i = 0; i < m/2; i++) {
				for(int j = 0; j < answer[i].length(); j++) {
					real[i][j] = answer[i].charAt(j);
				}
			}
			
			//순서 비교
			for(int i = 0; i < m/2; i++) {
				for(int j = 0; j < answer[i].length(); j++) {
					for(int k = j+1; k < answer[i].length();k++) {
						if(real[i][j] > real[i][k]) {
							char temp;
							temp = real[i][j];
							real[i][j] = real[i][k];
							real[i][k] = temp;
						}
					}
				}
			}			
			
			for(int i = 0; i < m/2; i++) {
				for(int j = 0; j < answer[i].length(); j++) {
						System.out.print(real[i][j]);	
				}
				System.out.println("");
			}
		}


}