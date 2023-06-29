import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		String keypad = "1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
		while (sc.hasNextLine()) {
			str = sc.nextLine();
			//입력받은 String길이와 키보드의 길이만큼 반복(이중for)
			for (int i=0; i<str.length(); i++) {
				for (int k=0; k<keypad.length(); k++) {
					//공백 입력받으면 공백 출력
					if (str.charAt(i) == ' ') {
						System.out.print(" ");
						break;
					}
					//공백x일 때
					else {
						//입력받은 문자와 키패드의 문자가 같을 때 왼쪽의 키값 출력
						if (str.charAt(i) == keypad.charAt(k)) {
							if (str.charAt(i)=='Q' || str.charAt(i)=='A' || str.charAt(i)=='Z'){
								if (str.charAt(i)=='Q') {
									System.out.print("Q");
									break;
								}
								if (str.charAt(i)=='A') {
									System.out.print("A");
									break;
								}
								if (str.charAt(i)=='Z') {
									System.out.print("Z");
									break;
								}
							}
							System.out.print(keypad.charAt(k-1));
						}
						//다르면 pass
						else {
							continue;
						}
					}
				}
			}
			System.out.println();
		}
		sc.close();
	}
}