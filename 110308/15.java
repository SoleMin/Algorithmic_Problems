import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		String sentence = "";
		
		while(input.hasNextLine()) {
			String s = "";
			int count = 0;
			while(input.hasNextLine()) {
				s = input.nextLine();
				
				if(s.equals(""))
					break;
				
				sentence += s + " ";
			}
			sentence = sentence.substring(0, sentence.length() - 1);
			
			
				String arr[] = sentence.split("\\s");
				for(int i = 0; i < arr.length; i++) {
					count += arr[i].length();
					if(count < 73) {
						System.out.print(arr[i] + " ");
						count += 1;
					}
					else {
						if(i == 0)
							System.out.print(arr[i] + " ");
						else
						System.out.print("\n" + arr[i] + " ");
						count = arr[i].length() + 1;
					}
				
			}
			sentence = "";
			System.out.println();
			System.out.println();
		}
		input.close();
	}
}