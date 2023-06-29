import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		/**쌍방으로 바뀌어야함**/
		/**~~~가 바뀐거임**/
		/**소문자와 스페이스만으로 구성**/
		/**한 줄에 최대 80문자, 최대 100줄**/
		/**복호화 불가 -> 길이 같다면 띄어쓰기 까지 같은거 그것도 불가하면 No solution   
		그리고 두개의 서로 다른 글자가 같은 글자로 치환될 경우**/
		/**사전 사용 입력 들어온 거 -> 원래 값으로**/
		/**xtm ceu ~저 문장에서 집합 만들어 이거 개수 26개 되냐?**/
		/**스페이스가 문자가 될 수는 없음**/
		
		int n = Integer.parseInt(input.nextLine());
		String garbage = input.nextLine();
		String result = "No solution.";
		String temp = "The quick brown fox jumps over the lazy dog";
		
		for(int i =0; i<n; i++) {

				ArrayList<String> str = new ArrayList<>();
				HashMap<Character,Character> map = new HashMap<>();
			while(input.hasNextLine()) {
				String s = input.nextLine();
				
				if(s.isEmpty() || !(input.hasNextLine()) && s.length() != 43) {
					if(map.isEmpty()) {
						System.out.println(result);
					}
					else {
						for(int r =0; r<s.length(); r++) {
							System.out.print(map.get(s.charAt(r)));
						}
					}
					break;
				}
				
				if((s.length() == 43 )) {
				for(int z = 0; z<43; z++) {
						map.put(s.charAt(z),temp.charAt(z));
				}
					if(map.size() != 27) {
						map.clear();
						str.add(s);
					}
					else if(!(str.isEmpty())) {
						for(String line : str) {
							char[] tem = line.toCharArray();
							for(int m =0; m<tem.length; m++) {
								System.out.print(map.get(tem[m]));
							}
							System.out.println(" ");
						}
					}
				}
				
				else if(map.isEmpty()) {
					str.add(s);
				}
				if(!(map.isEmpty())){
					for(int d = 0; d<s.length(); d++) {
						System.out.print(map.get(s.charAt(d)));
					}
					System.out.println("");
				}
			}
			System.out.println("");
		}
	}
}