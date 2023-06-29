import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		while(true) {
			input = br.readLine();
			
			if(input == null || input.equals("")) {
				break;
			}
			
			String secondinput =  br.readLine();
			
			int a[] = new int[26];
			int b[] = new int[26];
			
			String result = "";
			
			for(int i = 0; i < input.length(); i++) {
				a[input.charAt(i) - 'a'] += 1;
			}
			
			for(int i = 0; i < secondinput.length(); i++) {
				b[secondinput.charAt(i) - 'a'] += 1;
			}
			
			for(int i = 0; i < 26; i++) {
				if(a[i] >= b[i]) {
					for(int j = 0; j < b[i]; j++) {
						char c = (char)(i + 97);
						result = result + c;
					}
				}
				else if(a[i] <= b[i]){
					for(int j = 0; j < a[i]; j++) {
						char c = (char)(i + 97);
						result = result + c;
					}
				}
			}
			System.out.println(result);
		}
	}
}