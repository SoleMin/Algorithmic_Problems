import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		
		char[] keys = {'`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '=', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', '\\', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', '\'', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/'};
		
		Scanner scan = new Scanner(System.in);
		
		while (scan.hasNextLine()){
			String input = scan.nextLine();
			
			for (int i = 0; i < input.length(); i++){
				for (int j = 0; j < keys.length; j++){
					if (input.charAt(i) == ' '){
						System.out.print(" ");
						break;
					} else {
						if (input.charAt(i) == keys[j]){
							System.out.print(keys[j-1]);
						}
					}
				}
			}
			System.out.println();
		}
	}
}