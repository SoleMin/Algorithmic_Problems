import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()) {
			int m = 0;
			String a = "";
			String[] number = new String[1000];
			while(input.hasNextLine()) { // 전체 루프
				a = input.nextLine();
				if(a.equals("") && a.length() == 0 && m > 0) {
					break;
				}
				
				number[m] = a + " ";
				m++;
			}
			
			
			
			String before = "";
			for(int i = 0; i < m; i++) {
				before += number[i];
			}
				
				String[] st = before.split(" "); // 한 케이스당 쪼개기 완료

				String answer = "";
				String realA = "";
				int pass = 0;
				for(int i = 0; i < st.length; i++) { // 검사와 출력
					if((answer.length() + st[i].length()) > 72) {
						if(answer.length() == 0 && st[i].length() > 72) {
							System.out.println(st[i]);
						}
						else {
							answer = answer.substring(0,answer.length()-1);
							System.out.println(answer);
							answer = "";
							answer += st[i] + " ";	
						}
					}
					else {
						answer += st[i] + " ";
					}
				}
				answer = answer.substring(0,answer.length()-1);
				System.out.println(answer);	
			System.out.println("");
		}
		}

	}
