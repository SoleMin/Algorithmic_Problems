import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		String str;
		String[] strArr;
		int count = 0;
		
		while(true) {
			str = input.nextLine();
			if(str.equals("")) {
				System.out.println("\n");
				count = 0;
			}
			
			else {
				strArr = str.split(" ");
				for(int i=0; i < strArr.length; i++) {
					if(count + strArr[i].length() > 72 && count != 0) {
						System.out.println();
						count = 0;
					}
					System.out.print(strArr[i] + " ");
					count += strArr[i].length() + 1;
				}
			}
			if(!input.hasNextLine())
				break;
		}
		input.close();
	}
}