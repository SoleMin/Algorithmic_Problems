import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		String keyboard = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./'";
		
		while((input = br.readLine()) != null){
			String array[] = input.split("");
			
			for(int i = 0; i< input.length(); i++){
				int index = keyboard.indexOf(array[i]);
				if(index >= 0)
					System.out.print(keyboard.charAt(index-1));
				else
					System.out.print(array[i]);
			}
			System.out.println();
			
		}
	}
	
}