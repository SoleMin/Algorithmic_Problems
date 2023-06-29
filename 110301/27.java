import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			if(line.equals("")) break;
			convert(line);
		}
	}
	public static void convert(String line){
		String qwerty = "QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./1234567890-=";
		for(int i = 0 ; i < line.length() ; i++){
			for(int j = 0 ; j < qwerty.length() ; j++){
				if(line.charAt(i) == qwerty.charAt(j)) System.out.print(qwerty.charAt(j-1));
			}
			if(line.charAt(i) == ' ') System.out.print(" ");
		}
		System.out.println();
	}
}