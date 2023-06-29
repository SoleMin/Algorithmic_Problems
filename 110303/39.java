import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (sc.hasNextLine()) {
	String line1 = sc.nextLine();
	String line2 = sc.nextLine();
	int[] alphabet1 = new int[26];
	int[] alphabet2 = new int[26];
	
	if (line1.equals("")) break;
	
	for (int i = 0; i < line1.length(); i++) {
		int ascii = line1.charAt(i);
		alphabet1[ascii-97]++;
	}
	for (int i = 0; i < line2.length(); i++) {
		int ascii = line2.charAt(i);
		alphabet2[ascii-97]++;
	}
	for(int i = 0 ; i < 26 ; i++){
		int printNum = 0;
		if(alphabet1[i] != 0 && alphabet2[i] != 0){
			if(alphabet1[i] <= alphabet2[i])
			for(int j = 0 ; j < alphabet1[i] ; j++){
				System.out.print((char) (i+97));
			}
			else{
				for(int j = 0 ; j < alphabet2[i] ; j++){
					System.out.print((char)(i+97));
				}
			}
		}
	}
	System.out.println();
	}
	}
}