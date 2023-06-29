import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while ((input = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(input);
			input = input.replaceAll(" ", "");
			input = input.replaceAll("\t", "");
			System.out.println(input.length() + " " + st.countTokens());
		}
	}
}