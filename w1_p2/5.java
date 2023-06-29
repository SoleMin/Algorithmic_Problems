import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		String check = null;
		
		while(input.hasNext()) {
			check = input.next();
			
			if(check.charAt(0) == '0'){
				int sixteen = Integer.parseInt(check.substring(2,check.length()), 16);
				System.out.println(sixteen);
			}
			
			else{
				int beforeten = Integer.parseInt(check);
				String ten = Integer.toHexString(beforeten);
				String realten = ten.toUpperCase();
				System.out.println("0x" + realten);
			}
		}
	}
}