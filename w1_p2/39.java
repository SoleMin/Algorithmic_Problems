import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		while((input = br.readLine()) != null)
		{
			if(input.charAt(0) == '0' && input.length() > 1)
				System.out.println(Integer.parseInt(input.substring(2), 16));
			else
				System.out.println("0x" + Integer.toHexString(Integer.parseInt(input)).toUpperCase());
		}
	}
}