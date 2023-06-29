import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		while (scan.hasNextLine()){
			String str1 = scan.nextLine();
			String str2 = scan.nextLine();
			
			ArrayList<Character> str1_chr = new ArrayList<>();
			ArrayList<Character> str2_chr = new ArrayList<>();
			ArrayList<Character> common = new ArrayList<>();
			
			for (int i = 0; i < str1.length(); i++){
				str1_chr.add(str1.charAt(i));
			}
			
			for (int i = 0; i < str2.length(); i++){
				str2_chr.add(str2.charAt(i));
			}
			
			for (int i = 0; i < str1_chr.size(); i++){
				for (int j = 0; j < str2_chr.size(); j++){
					if (str1_chr.get(i) == str2_chr.get(j)){
						common.add(str1_chr.get(i));
						str2_chr.remove(str2_chr.get(j));
						break;
					}
				}
			}
			
			Collections.sort(common);
			
			for (int i = 0; i < common.size(); i++){
				System.out.print(common.get(i));
			}
			System.out.println();
		}
	}
}