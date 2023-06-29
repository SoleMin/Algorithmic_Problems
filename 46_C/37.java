import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		
		int size= Integer.parseInt(r.readLine());
		String line = r.readLine();
		
		int counter =0;
		for (int i = 0; i < line.length(); i++) {
			if(line.charAt(i)=='H')counter++;
		}
		
		int minimum = Integer.MAX_VALUE;
		for (int i = 0; i < line.length(); i++) {
			if(line.charAt(i)=='H'){
				int current = 0;
				for (int j = i; j < i+counter; j++) {
					if(line.charAt(j%line.length())=='T')current++;
				}
				minimum = Math.min(current, minimum);
			}
		}
		
		System.out.println(minimum);
		
	}
}
