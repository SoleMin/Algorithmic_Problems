import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		
		while((input=br.readLine()) != null){
			if (input.length()>2 && input.substring(0,2).equals("0x")) {
				int n=Integer.parseInt(input.substring(2),16);
				System.out.println(n);
			}
			else {
				String s =Integer.toHexString(Integer.parseInt(input)).toUpperCase();
				System.out.println("0x"+s);
			}
		}
	}
}