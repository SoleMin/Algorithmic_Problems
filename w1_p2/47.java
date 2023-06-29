import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input = br.readLine()) !=null){
			if(!(input.indexOf("0x") == 0 || input.indexOf("0X") == 0)){
				int num = Integer.parseInt(input);
				String result = Integer.toHexString(num);
				System.out.println("0x"+result.toUpperCase());
			}else{
				input = input.replace("0x", "");
				int result = Integer.parseInt(input, 16);
				System.out.println(result);
			}
		}
		
	}
}