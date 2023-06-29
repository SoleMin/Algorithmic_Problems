import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		while((input = br.readLine()) != null)
		{
			if(input.charAt(0) == '0')
			{
				int hex = Integer.parseInt(input.substring(2), 16);
				System.out.println(hex);
			}
			else
			{
				int dec = Integer.parseInt(input);
				String hs = Integer.toHexString(dec);
				System.out.println("0x" + hs.toUpperCase());
			}
		}
	}
}