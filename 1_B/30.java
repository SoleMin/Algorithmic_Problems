import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RoundOneProblemB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		int n=1;
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in), 50);
		
		try {
			
			n = Integer.valueOf(input.readLine());
			
			if (! ((1 <= n) && (n <= Math.pow(10, 5)))) {
				formatError();
			}
			
			Pattern typeOne = Pattern.compile("^([A-Z]+)([0-9]+)$");
			Pattern typeTwo = Pattern.compile("^R([0-9]+)C([0-9]+)$");
			for (int i=0; i < n; i++) {
				String line = input.readLine();
				Matcher matchOne = typeOne.matcher(line);
				if (matchOne.find()) {
					System.out.println(convertOneToTwo(matchOne.group(2), matchOne.group(1)));
				} else {
					Matcher matchTwo = typeTwo.matcher(line);
					if (matchTwo.find()) {
						System.out.println(convertTwoToOne(matchTwo.group(1), matchTwo.group(2)));
					}
				}
			}
						
		} catch (Exception e) {
			formatError();		
		} 
		
	}
	
	private static String convertTwoToOne(String row, String col) {
		StringBuilder result = new StringBuilder();
		
		long c = Long.parseLong(col);
		while ( c > 0) {
			result.append((char)(((c-1) % 26)+'A'));
			c = (c-1) / 26;
		} 
		result.reverse();
		result.append(Long.parseLong(row));
		
		return result.toString();
	}
	
	private static String convertOneToTwo(String row, String col) {
		StringBuilder result = new StringBuilder();
		
		int l = col.length();
		col = col.toUpperCase();
		
		long base = 1;
		long c = 0;
		for (int i=l-1; i >= 0; i--) {
			c = c + ((col.charAt(i) - 'A' + 1) * base);
			base = base * 26;
		}
		
		result.append("R").append(Long.parseLong(row)).append("C").append(c);
		return result.toString();
	}
	
	/**
	 * Exit with an error due to unexpected standard input. 
	 */
	private static void formatError() {
		System.out.println("Unexpected input");
		System.exit(1);	
	}

}
