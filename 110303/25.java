import java.util.Scanner;
import java.util.Arrays;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		StringBuilder first, second;
		String result = "", t = "";
		char[] temp = new char[1000];
		int i, j;
		
		while(input.hasNext()) {
			first = new StringBuilder(input.nextLine());
			second = new StringBuilder(input.nextLine());
			
			for(i = 0; i < first.length(); i++) {
				t = first.charAt(i) + "";
				if(second.indexOf(t) >= 0){
					result += t;
					second.deleteCharAt(second.indexOf(t));
				}
			}
			
			temp = result.toCharArray();
			Arrays.sort(temp);
			for(i = 0; i < temp.length; i++)
				System.out.print(temp[i]);
			System.out.println();
			result = "";
			temp = new char[1000];
		}
	}
}