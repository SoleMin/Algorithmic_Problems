import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		// 편집할 텍스트를 입력받는다.
		Scanner input = new Scanner(System.in);
		LinkedList<String> text = new LinkedList<String>(); 
		while(input.hasNextLine())
			text.add(input.nextLine());

		// 입력받은 텍스트를 깔끔하게 정돈한다.
		int i = 0;
		while(true) {
			if(text.get(i).equals("") || text.get(i+1).equals(""))
				i++;
			else {
				String s = text.remove(i+1);
				text.set(i, text.get(i) + " " + s);
			}

			if(i+1 >= text.size())
				break;
		}

		// 빈줄이 아닌 줄을 찾아서 charAt(72)가 공백인지 확인한다. 아니면 72에서 하나씩 줄이다가 공백을 발견하면 공백을 줄바꿈 문자로 변경한다.
		for(i=0; i<text.size(); i++) {
			String s = text.get(i);
			String print;
			if(s.equals(""))
				System.out.println();
			else {
				while(!s.equals("")) {
					boolean printed = false;
					if(s.length()<73) {
						System.out.println(s);
						break;
					}
					if(!printed) {
						for(int j=72; j>0; j--)
							if(s.charAt(j) == ' ') {
								print = s.substring(0, j);
								s = s.substring(j+1, s.length());
								boolean compl = false;
								int k = print.length()-1;
								while(!compl) {
									if(print.charAt(k) == ' ') {
										print = print.substring(0, k);
										k--;
									}
									else
										compl = true;
								}
								System.out.println(print);
								printed = true;
								break;
							}
					}
					
					if(!printed)
						for(int j=72; j<s.length(); j++) {
							if(s.charAt(j) == ' ') {
								print = s.substring(0, j);
								s = s.substring(j+1, s.length());
								boolean compl = false;
								while(!compl) {
									if(s.charAt(0) == ' ')
										s = s.substring(1, s.length());
									else
										compl = true;
								}
								System.out.println(print);
								printed = true;
								break;
							}
						}
					
					if(!printed) {
						System.out.println(s);
						s = "";
					}
				}
			}
		}

		input.close();
	}
}