
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] keyBoard = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;\'ZXCVBNM,./".split("");
		
		
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			if(line.equals("")) {
				break;
			}
			key_repair(keyBoard, line);
		}
		
	}
	
	public static void key_repair(String[] keyBoard, String line) {
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < line.length(); i++) {
			char temp = line.charAt(i);
			if (temp == ' ') {
				result.append(" ");
			}
			else {
				if (Arrays.asList(keyBoard).contains(Character.toString(temp))) {
					result.append(keyBoard[Arrays.asList(keyBoard).indexOf(Character.toString(temp)) - 1]);
				}
			}
		}
		System.out.println(result);
	}
}
