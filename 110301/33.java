import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		String qwerty = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input = br.readLine())!=null && !input.isEmpty()){
			for(int i=0; i<input.length(); i++){
				for(int j=1; j<qwerty.length(); j++){
					if(input.charAt(i)== ' '){
						System.out.print(' ');
						break;
					}
					else if(input.charAt(i) == qwerty.charAt(j)){
						System.out.print(qwerty.charAt(j-1));
					}
				}
			}
			System.out.println();
		}
	}
}