import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input=br.readLine()) != null){
			input = input.trim();
			String[] s = input.split("\\s+");
			int sum=0;
			for (int i=0; i<s.length; i++){
				sum+=s[i].length();
			}
			System.out.print(sum+" ");
			System.out.println(s.length);
				
		}
	}
}