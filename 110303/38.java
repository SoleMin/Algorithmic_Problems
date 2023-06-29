import java.util.Scanner;

class Main {
	static int ASCII = 97;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextLine()){
			String s1 = in.nextLine();
			String s2 = in.nextLine();
			int[] arr1 = new int[26];
			int[] arr2 = new int[26];
			
			for(int i = 0; i < s1.length(); i++){
				arr1[(int)s1.charAt(i) - ASCII] += 1;
			}
			for(int i = 0; i < s2.length(); i++){
				arr2[(int)s2.charAt(i) - ASCII] += 1;
			}
			String result = "";
			
			for(int i = 0; i < 26; i++){
				if((arr1[i] != 0) && arr2[i] != 0){
					int sum = (arr1[i] < arr2[i]) ? arr1[i] : arr2[i];
					for(int j = 0; j < sum; j++){
						result += (char)(i + ASCII);
					}
				}
			}
			
			System.out.println(result);
		}
	}
}