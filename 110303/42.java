import java.util.Scanner;

class Main {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		while ((sc.hasNextLine())) {
			String word = sc.nextLine();
			
			if (word.equals("")) {
				break;
			}
			
			System.out.println(check(word));
		}
	}
	
	public static StringBuilder check(String word) {
		
		// 두 단어 각각의 알파벳의 아스키코드에서 a만큼 뺴면 1부터 시작하게 된다 ==> 0부터 25번까지의 알파벳을 직접 카운팅 할 수 있다.
		int[] first_word = new int[26]; //첫 단어 알파벳 인덱스.
		int[] second_word = new int[26]; //두번째 단어 알파벳 인덱스.
		StringBuilder result = new StringBuilder(); // 체크할 때마다 하나씩 더해서 결과를 완성.
		
		// for each 문으로 char 타입으로 번호를 가져오고, 그 숫자에서 90을 빼면, 0번부터 인덱스가 잡혀 알파벳 카운팅 가능.
		for (char c : word.toCharArray()) {
			first_word[c - 'a']++;
		}
		
		// 여기도 위와 마찬가지
		for (char c : sc.nextLine().toCharArray()) {
			second_word[c - 'a']++;
		}
		
		// 총 26번 반복
		for (int i = 0; i < 26; i++) {
			// 배열에서 0보다 큰 값을 가지면 result에 해당 번호의 알파벳 + i를 해서 char 타입으로 추가하면서, 기존에 입력받았던 알파벳을 저장한다.
			while (first_word[i] > 0 && second_word[i] > 0) {
				result.append((char) ('a' + i));
				first_word[i]--; // 한 단어에서 여러개의 알파벳이 중복으로 입력 되었을 수 있으므로, 갯수가 0개가 될 때까지 출력해준다.
				second_word[i]--; // 위와 마찬가지
			}
		}
		
		return result;
	}
}