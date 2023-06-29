import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		StringBuffer output = new StringBuffer();
		String original = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;\'ZXCVBNM,./";
		
		while(((input = br.readLine()))!=null){
			for(int i = 0;i<input.length();i++){
				for(int j=0;j<original.length();j++){
					if(input.charAt(i) == original.charAt(j)){
						output.append(original.charAt(j-1));
					}else if(input.charAt(i) == ' '){
						output.append(" ");
						break;
					}
				}
			}
			System.out.println(output);
			output.delete(0, output.length());
			
		}
	}
}