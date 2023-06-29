import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
				Scanner input = new Scanner(System.in);
		
		int loopCount = input.nextInt();
		String trash = input.nextLine();
		int stop = 0;
		
		// 무한루프 돌린다잉
		while(loopCount != stop) {
			if(stop == 0) {String trash_2 = input.nextLine();}
			// 문장들 받기
			String a = "";
			String[] number = new String[1000];
			int m = 0;
			while(input.hasNextLine()) {
				a = input.nextLine();
				if(a.equals("") && a.length() == 0 && m > 0) {
					break;
				}
				number[m] = a;
				m++;
			}
			
			if(m == 0) {
				System.out.println("No solution.");
				System.out.println("");
				
				stop++;
			}
			else {
				//char형으로 집어넣기
				// sentences는 각 줄마다 문장이 들어있음
				char[][] sentences = new char[m][81];
				for(int i = 0; i < m; i++) {
					for(int j = 0; j < number[i].length(); j++) {
						sentences[i][j] = number[i].charAt(j);
					}
				}
				
				// 붉은 여우 문장 샘플
				String bf = "the quick brown fox jumps over the lazy dog";
		
				// 1 - 붉은 여우 문장 char으로 만들기
				char[] bfChar = new char[bf.length()];
				for(int i = 0; i < bf.length(); i++) {
					bfChar[i] = bf.charAt(i); 
				}
				
				//붉은 여우 문장위치 확인
				int foxPoint = -1; // 붉은 여우 인덱스
				int count = 0; // 확인용 변수
				for(int i = 0; i < m; i++) {
					for(int j = 0; j < number[i].length(); j++) {
						if(number[i].length() == bf.length()) { // 붉은여우랑 문장길이가 같고
							if(number[i].substring(3,4).equals(" ") && // 빈칸 위치도 같고
							   number[i].substring(9,10).equals(" ") &&
							   number[i].substring(15,16).equals(" ") &&
							   number[i].substring(19,20).equals(" ") &&
							   number[i].substring(25,26).equals(" ") &&
							   number[i].substring(30,31).equals(" ") &&
							   number[i].substring(34,35).equals(" ") &&
							   number[i].substring(39,40).equals(" ")) {
								for(int y = 0; y < number[i].length(); y++) { 
									for(int x = 0; x < bfChar.length; x++) {
										if(sentences[i][y] == bfChar[x] ) { // 후보문장의 문자와 붉은 여우의 문자가 동일한게
											count++; // count만큼 일어났다.
											break;
										}
									}
								}
								if(count == bf.length()) { // 근데 그게 붉은 문장의 길이와 동일했다. = 후보는 붉은 여우가 암호화 된 것이다.
									foxPoint = i;
								}
							} 
						}
					}
					count = 0; // count 0으로 초기화
				}
				
				// 디코딩
				// 잘못된 불은 여우 문장 하나 만들어주기
				char[] longFox = new char[bf.length()];
				for(int i = 0; i < bf.length(); i++) {
					if(foxPoint != -1) {
						longFox[i] = sentences[foxPoint][i];	
					}
				}
				
				int[][] check = new int[m][81]; // 문자 바뀐거 확인용 배열
				// 2- 다른 문장 하나씩 매칭시켜주기
				for(int i = 0; i < m; i++) { //센텐스 행
					for(int j = 0; j != number[i].length(); j++) { //센텐스 열
						for(int k = 0; k < bf.length(); k++) { //롱폭스 인덱스
							if(sentences[i][j] == longFox[k] && check[i][j] == 0) {
								sentences[i][j] = bfChar[k];
								check[i][j]++;
							}
						}
						
						
					}

				}
				
				// 찐 마지막 확인
					if(foxPoint != -1) {
					for(int i = 0; i < bf.length(); i++) {
						if(bfChar[i] != sentences[foxPoint][i]) {
							foxPoint = -1;
							break;
						}
					}	
				}
				
				// 테스트용
				if(foxPoint != -1 && m != 0) {
					for(int i = 0; i < m; i++) {
						for(int j = 0; j < number[i].length(); j++) {
							System.out.print(sentences[i][j]);
						}
						System.out.println("");
					}
				}
				else {
					System.out.println("No solution.");
				}
				
				System.out.println("");
				
				stop++;
			}
			
		}

	}

}