import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()){
			String inputSt = input.nextLine();
			String[] inputS = inputSt.split("");
			
			String changeS = "";
			
			String[] inputss = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=", "\"",
												 "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]",
												 "S", "D", "F", "G", "H", "J", "K", "L", ";",
												 "X", "C", "V", "B", "N", "M", ",", ".", "/"};
			
			String[] changess = {"`", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=",
													"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[",
													"A", "S", "D", "F", "G", "H", "J", "K", "L",
													"Z", "X", "C", "V", "B", "N", "M", ",", "."};
			
			for(int i=0; i<inputS.length; i++){
				if(inputS[i].equals(" "))
					changeS += " ";
				else{
					int indexi = Arrays.asList(inputss).indexOf(inputS[i]);
					changeS += changess[indexi];
				}
			}
			
			System.out.println(changeS);
		}
		
		input.close();
	}
}