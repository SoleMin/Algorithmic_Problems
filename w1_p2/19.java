import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()){
			String decOrHex = input.nextLine();
			String newNum = "";
			
			if(decOrHex.startsWith("0x")){
				decOrHex = decOrHex.substring(2);
				newNum = Integer.toString(Integer.parseInt(decOrHex, 16));
			}
			else{
				newNum = "0x" + Integer.toHexString(Integer.parseInt(decOrHex)).toUpperCase();
			}
			System.out.println(newNum);
		}
		input.close();
	}
}