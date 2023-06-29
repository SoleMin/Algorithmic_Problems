import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		String line = "";
		int remaining = 72;
		boolean newline = false;
		
		while(input.hasNextLine()) {
			String str = input.nextLine();
			if(str.equals("")) {
				if(line.length() != 0)
					System.out.println(line);
				System.out.println(str);
				line = "";
				remaining = 72;
				newline = true;
				continue;
			}
			
			String[] strArr = str.trim().split(" ");
			remaining = 72 - line.length();
			for(int i=0; i<strArr.length; i++) {
				if(strArr[i].length() > 72) {
					if(line.length() != 0)
						System.out.println(line);
					System.out.println(strArr[i]);
					line = "";
					remaining = 72;
					continue;
				}
				
				if(remaining == 72) {
					if(newline) {
						for(int j=0; j<str.length(); j++) {
							if(str.charAt(j) == ' ') {
								System.out.print(" ");
								remaining--;
							}
							else
								break;
						}
						newline = false;
					}
					
					line = strArr[i];
					remaining = remaining - line.length();
				}
				else {
					remaining = remaining - (1 + strArr[i].length());

					if(remaining < 0) {
						System.out.println(line);
						line = strArr[i].trim();
						remaining = 72 - line.length();
					}
					else
						line = line + " " + strArr[i];
				}
			}
		}
		
		if(line.length() != 0)
			System.out.println(line);
	}
}