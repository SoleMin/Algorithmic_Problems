import java.util.Scanner;

class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextLine()){
			String s = in.nextLine();
			if(s.charAt(0) == '0'){
				System.out.println(Integer.parseInt(s.substring(2), 16));
			}
			else{
				System.out.println("0x" + Integer.toHexString(Integer.parseInt(s)).toUpperCase());
			}
		}
	}
}