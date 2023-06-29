import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		StringBuilder i1, i2;
		while ((input = br.readLine()) != null) {
			StringBuilder res = new StringBuilder();
			i1 = new StringBuilder(input);
			i2 = new StringBuilder(br.readLine());
			for (int i = 0; i < i1.length(); i++) {
				int ind;
				if ((ind = i2.indexOf(Character.toString(i1.charAt(i)))) > -1) {
					res.append(i2.charAt(ind));
					i2.deleteCharAt(ind);
				}
			}
			char[] ca = new char[res.length()];
			res.getChars(0, res.length(), ca, 0);
			Arrays.sort(ca);
			System.out.println(new String(ca));
		}
		
		
	}
}