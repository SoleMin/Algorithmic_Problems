import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String lines[], temp;
		char texts[], tmp;
		
		while(sc.hasNextLine()) {
			lines = new String[5000];
			int index = 0; //줄 수
			int number = 0; //글자 수 - char 생성시 이용
			while(sc.hasNextLine()) {
				temp = sc.nextLine();
				if(temp.equals("")) { break; }
				number += temp.length();
				lines[index] = temp;
				index++;
			}
			
			int check = 0; //공백 줄 발생시 개수 저장
			texts = new char[number+index-1]; //글자수 + 엔터수
			number = 0;
			for(int i=0; i<index; i++) {
				temp = lines[i];
				if(temp.trim().length() == 0) {
					check += lines[i].length() + 1;
					continue;
				}
				for(int j=0; j<lines[i].length(); j++) {
					tmp = lines[i].charAt(j);
					texts[number] = tmp;
					number++;
				}
				if(i!=index-1) { //엔터를 스페이스로 대체
					texts[number] = ' ';
					number++;
				}
			}
			make_line(texts, texts.length-check);
			System.out.println();
		}
		sc.close();
	}
	
	static void make_line(char[] texts, int here) {
		int count = 0, length = 0; //문장 길이, 단어 길이
		int idx = 0;
		String prt, tp = "";
		
		big: while(true) {
			prt = "";
			if(count == -1) {
				prt += tp;
				count = tp.length(); length = 0;
			}
			while(idx < here) {
				tp = "";
				while(idx < here) {
					if(texts[idx] == ' ') {
						tp += " "; length++;
						idx++; break;
					}
					else {
						tp += Character.toString(texts[idx]);
						length++; idx++;
					}
				}
				if(count + length <= 72) {
					prt += tp; count += length;
					length = 0;
				}
				else if(count+length==73 && texts[idx-1]==' ') {
					prt += tp.stripTrailing();
					System.out.println(prt);
					count = 0; length = 0;
					continue big;
				}
				else if(length >= 72) {
					if(!prt.equals(""))
						System.out.println(prt);
					System.out.println(tp);
					count = 0; length = 0;
					continue big;
				} else {
					count = -1;
					length = 0;
					break;
				}
			}
			if(idx == here) {
				prt = prt.stripTrailing();
				System.out.println(prt);
				break;
			}
			System.out.println(prt);
		}
	}
}