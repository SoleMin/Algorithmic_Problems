import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		char[] array = new char[93];
		String[] s = new String[]{"1234567890-=", "QWERTYUIOP[]\\", "ASDFGHJKL;\'", "ZXCVBNM,./"};
		
		while(input.hasNextLine()) {
			/**조건)
			-스페이스 그대로
			-대문자만 나옴
			-위에 나온 구두 기호 (,./';[]\-=') 총 10개
			-Q, A, Z 제외
				즉 아스키 코드만 하면 됨**/
			
			/**생각할 것)
			입력 들어오면 고치는 것 oㅋ 근데 공통 규칙 있나?\
			없음 일일히 다 정의해줄 것 다만 숫자는 예외 문자도 아스키 코드 가능
			다만 숫자 왼쪽 문자가 있더나, 문자 왼쪽에 글자가 있는 경우, 문자 옆에 숫자가 있는 경우 예외**/
			
			/**1쓰면 ` 출력됨**/
			char [] line = input.nextLine().toCharArray();
			for(int i=0; i<line.length; i++) {
				
				if(line[i] == ' ') {
					System.out.print(" ");
					continue;
				}
				
				boolean start = true;
				while(start) {
					for(int z =0; z<4; z++) {
						for(int h =0; h<s[z].length(); h++) {
							if(line[i] == s[z].charAt(h)) {
								System.out.print(s[z].charAt(h-1));
								start = false;
							}
						}
					}
				}
			}
			System.out.println(" ");
		}
	}
}