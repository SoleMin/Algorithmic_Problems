import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int counts, words;
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			
			counts = 0; words = 0;
			for(int i=0; i<line.length(); i++) {
				//단어개수: 이전 공백 + 현재 문자
				if(i==0) {
					if(line.charAt(i)!=' ' && line.charAt(i)!='\t') {
						counts++;
						words++;
					}
					continue;
				}
				if((line.charAt(i-1)==' ' || line.charAt(i-1)=='\t') && (line.charAt(i)!=' ' && line.charAt(i)!='\t')) {
					words++;
				}
				//문자개수: 공백이 아닐 때
				if(line.charAt(i)!=' ' && line.charAt(i)!='\t') {
					counts++;
				}
			}
			
			System.out.printf("%d %d\n", counts, words);
		}
		
		sc.close();
	}
}