import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		String str, key;
		int[] intArr;
		
		while(true) {
			str = input.nextLine();
			key = input.nextLine();
			if(str.equals("") || key.equals(""))
				break;
			
			intArr = next(key);
			findStr(str, key, intArr);
			if(!input.hasNextLine())
				break;
		}
		input.close();
	}
	
	public static void findStr(String str, String key, int[] arr) {
		int i=0; int j=0;
		int count = 0;
		int[] numArr = new int[100];
		
		while(i <= str.length()) {
			if(j == key.length()) {
				numArr[count] = i - key.length() + 1;
				j = arr[j - 1];
				count++;
			}
			
			if(i == str.length()) break;
			
			if(str.charAt(i) == key.charAt(j)) {
				i++; j++;
			}
			else
				if(j == 0) 
					i++;
				else
				j = arr[j - 1];
		}
		System.out.println(count);
		for(int k=0; k < count; k++)
			System.out.print(numArr[k] + " ");
	}
	
	public static int[] next(String s) {
		int[] nextArr = new int[s.length()];
		nextArr[0] = 0;
		int j=0; int i=1;
		
		while(i < s.length()) {
			if(s.charAt(j) == s.charAt(i)) {
				nextArr[i] = j + 1;
				j++; i++;
			}
			else
				if(j == 0)
					i++;
				else
					j = nextArr[j - 1];
		}
		return nextArr;
	}
}