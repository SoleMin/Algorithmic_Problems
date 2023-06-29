import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		String temp, masterK = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./'";
		ArrayList<String> list = new ArrayList<String>();
		int i, j;
		
		while(input.hasNext()){
			list.add(input.nextLine());
		}

		Iterator<String> li = list.iterator();
		while(li.hasNext()) {
			temp = li.next();
			for(i = 0; i < temp.length(); i++) {
				for(j = 0; j < masterK.length(); j++) {
					if(temp.charAt(i) == ' '){
						System.out.print(" ");
						break;
					}
					if(temp.charAt(i) == masterK.charAt(j)){
						System.out.print(masterK.charAt(j-1));
						break;
					}
				}
			}
			System.out.println();
		}
	}
}