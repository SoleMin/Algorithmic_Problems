import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextLine()) {
			String temp = "";
			String paragraph = "";
			
			temp = sc.nextLine();
			paragraph = temp;
			
			while (sc.hasNextLine()) {
				temp = sc.nextLine();
				if (temp.equals("")) break;
				paragraph += " " + temp;
			}
			
			String[] word = paragraph.split(" ");
			String line = word[0];
			int num = 1;
			while (num != word.length) {
				if (line.length() + word[num].length() + 1 > 72) {
					System.out.println(line);
					line = "";
					line += word[num];
				} else if (word[num].length() > 72) {
					if (line.length() > 0) {
						System.out.println(line);
					}
					System.out.println(word[num]);
					line = "";
				}
				else {
					line += " " + word[num];
				}
					
				num++;
				
			}
			System.out.println(line);
			System.out.println();
		}
	}
}