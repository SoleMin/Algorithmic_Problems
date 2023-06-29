import java.io.*;
import java.util.regex.*;

public class Main {

	private static String encode(long rowNum) {
			if(rowNum<=26) {
				return String.valueOf((char)('A'+rowNum-1));
			}
			else {
				
				if(rowNum%26==0){
					return encode((long)Math.floor((double)rowNum/26)-1) 
					+ String.valueOf((char)('A'+26-1));				
				}
				else {
					return encode((long)Math.floor((double)rowNum/26)) 
					+ String.valueOf((char)('A'+rowNum%26-1));
				}
			}
	}
	
	private static long decode(String rowNum){
		long result = 0;
		char rowChars[] = rowNum.toCharArray();
		for(int i=rowChars.length-1;i>=0;i--){
			result+= (rowChars[i]-'A'+1) * (long)Math.pow(26,rowChars.length-i-1);
		}
		return result;
	}
	
	public static void main(String arg[])throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		Pattern p1 = Pattern.compile("R\\d+C\\d+");
		Pattern p2 = Pattern.compile("\\d+");
		for(int i=0;i<t;i++){
			String input = in.readLine();
			Matcher m1 = p1.matcher(input);
			Matcher m2 = p2.matcher(input);
			if(m1.matches()){
				String result = "";
				if(m2.find()){
					result = m2.group();
				}
				if(m2.find()){
					result = encode(Long.parseLong(m2.group()))+result;
				}
				System.out.println(result);
			}
			else {
				String result = "R";
				if(m2.find()){
					result += m2.group();
				}				
				result += "C";
				System.out.println(result+decode(input.replaceAll(m2.group(),"")));
			}
		}
	}
}