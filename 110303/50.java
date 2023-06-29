import java.io.*;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		String[] word1 = new String[0];
		String[] word2 = new String[0];
		int num;
		String temp;
		String[] alpha = new String[0];
		
		while (true){
			
			input = br.readLine();
			if(input == null) break;
			else {
				word1 = new String[input.length()];
				for(int a=0;a<input.length();a++){
					word1[a] = String.valueOf(input.charAt(a));
				}
				String input2 = br.readLine();
				word2 = new String[input2.length()];
				for(int a=0;a<input2.length();a++){
					word2[a] = String.valueOf(input2.charAt(a));
				}
			}
			
			num = word1.length;
			alpha = new String[num];
			for(int i = 0;i<word1.length;i++){
				for(int j=0;j<word2.length;j++){
					if(word1[i].equals(word2[j])){
						alpha[i] = String.valueOf(word1[i]);
						word1[i] = "";
						word2[j] = "";
						break;
					}
				}
			}
			for(int d = 0;d<alpha.length;d++){
				if(alpha[d] == null){
					alpha[d] = " ";
				}
			}
			Arrays.sort(alpha);
			for(String a : alpha){
				if(a.equals(" "));
				else System.out.print(a);
			}
			
			System.out.println();
		}
	}
}