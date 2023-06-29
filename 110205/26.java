import java.util.*;

class Main {
	public static Scanner sc = new Scanner(System.in);
	static String[] card_val = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"}; // 카드의 값.
	static String[] card_pat = {"Clubs", "Diamonds", "Hearts", "Spades"}; // 카드의 무늬.
	
	public static void main(String[] args) {
		int testcase_num = sc.nextInt(); // 반복할 테스트 케이스 횟수 입력
		sc.nextLine(); // 공백
		sc.nextLine(); // 공백
		
		for (int i = 0; i < testcase_num; i++) {
			int[][] mix = mix();
			int[] mix_final = mix_final();
			String[] pair = new String[52]; // 카드의 값과 무늬를 최종적으로 묶을 배열.
			
			int idx_pair = 0; // pair의 인덱스.
			
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 13; k++) {
					pair[idx_pair++] = card_val[k] + " of " + card_pat[j];
				}
			}
			
			while (sc.hasNextLine()) {        // 입력이 있을때까지 반복한다.
				String mix_rule = sc.nextLine();
				if (mix_rule.equals("")) { // 공백 입력시 반복문 탈출.
					break;
				}
				
				int idx = Integer.parseInt(mix_rule) - 1; // 입력이 String이므로 인덱스 접근을 위해 정수로 변환.
				int[] mix_tmp = new int[52]; // 섞은 결과를 임시저장 할 배열.
				for (int j = 0; j < 52; j++)
					mix_tmp[j] = mix_final[mix[idx][j]]; // 지정된 방법으로 섞인 배열을 해당 배열에 임시저장.
				mix_final = mix_tmp.clone(); // 딥카피로 mix_final 업데이트.
			}
			
			printCards(pair, mix_final); // 출력
		}
	}
	
	public static int[][] mix() {
		int n = sc.nextInt(); // n개의 카드 세트
		sc.nextLine(); // 공백
		int[][] mix = new int[n][52]; // n층의 카드셋을 가진 이차원 배열 생성 (섞인 인덱스를 가진 카드셋)
		
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < 52; k++) {
				mix[j][k] = sc.nextInt() - 1; // 제로베이스 인덱스로 원본 데이터에 접근하므로 -1 해준다.
			}
			sc.nextLine(); //라인이 끝남.
		}
		
		return mix;
	}
	
	public static int[] mix_final() {
		int[] mix_final = new int[52]; // 가장 최근에 섞인 카드셋을 저장할 배열. (최종적으로 출력할 배열.)
		
		for (int y = 0; y < 52; y++)
			mix_final[y] = y; // 기존 인덱스를 그대로 저장한다. (새로 섞인 카드와 비교할 것이다.)
		
		return mix_final;
	}
	
	public static void printCards(String[] pair, int[] mix_final) {
		for (int j = 0; j < 52; j++) {
			System.out.println(pair[mix_final[j]]);
		}
		
		System.out.println("");
	}
	
}