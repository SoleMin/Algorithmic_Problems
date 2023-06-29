import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	static int[] nextInt;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String text = sc.nextLine();
		String pattern = sc.nextLine();
		//kmp에서 next 씀
		kmp(text, pattern);
	}
	static int[] next(String pattern) {
		int len = pattern.length(); // 패턴의 길이. 즉 구할 단어의 길이
		int j = 0;
		nextInt = new int[len];// 패턴의 인덱스마다 suffix == prefix 수를 저장해줘야함
		
		for(int i = 1; i < len; i++) {
			//같으면 j가 한 칸 옆으로 가짐
			//다음글자도 서로 같은지 비교. 다르면 j를 nextInt[j-1]로 이동
			while(j != 0 && !Objects.equals(pattern.charAt(i), pattern.charAt(j))) {
				j = nextInt[j-1];
			}
			//같으면 경우엔 j 하나 키워주고 nextInt의 i에 j값 준다.
			if(Objects.equals(pattern.charAt(i), pattern.charAt(j))) {
				nextInt[i] = ++j;
			}
		}
		return nextInt;
	}
	
	static void kmp(String text, String pattern) {
		int[] next = next(pattern);
		
		//몇 번 등장했는지 세는 용도
		int cnt = 0;
		Vector<Integer> nums = new Vector<>();
		//일치하는 문자 개수 기록
		int num = 0;
		//탐색할 전체 text의 길이만큼
		for(int i=0; i< text.length(); i++) {
			//일치하는 문자 개수가 존재하면서, num번과 i번이 다르면 num을 next배열에의 num-1 인덱스로 옮긴다
			while(num != 0 && !Objects.equals(text.charAt(i), pattern.charAt(num))) {
				num = next[num - 1];
			}
			if(Objects.equals(text.charAt(i), pattern.charAt(num))) {
				//텍스트랑 패턴의 문자가 같을 때 지금까지 일치한 개수가 패턴길이보다 하나 모자라면
				//이번만 같으면 완전히 같은게 되는거
				if(num == pattern.length()-1) {
					//nums에 등장하는 인덱스를 추가함
					nums.add(i - num + 1);
				  cnt += 1;
					num = next[num];
				}
				else {
					num += 1;
				}
			}
		}
		
		System.out.println(cnt);
		for(int i = 0 ; i < nums.toArray().length ; i++){
			System.out.print(nums.get(i) + " ");
		}
	}
}