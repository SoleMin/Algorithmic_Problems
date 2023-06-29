import java.io.*;
import java.math.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		while ((input = br.readLine()) != null) {
			if (input.equals("")) {
				break;
			}
			
			String inputs[] = input.split(" ");
			int n = Integer.parseInt(inputs[0]);
			String result = "";
			
			if (n == 1) {
				result = "Jolly";
			}
			else {
				int numbers[] = new int[n + 1];
				boolean tfs[] = new boolean[n + 1];
				
				for (int i = 0; i < n + 1; i++) {
					numbers[i] = Integer.parseInt(inputs[i]);
					tfs[i] = false;
				}
				
				boolean tfResult = true;
				
				for (int i = 1; i < n; i++) {
					int sub = Math.abs(numbers[i] - numbers[i + 1]);
					// System.out.println("sub : " + sub);
					
					if (sub >= n || sub <= 0) {
						tfResult = false;
						result = "Not jolly";
						break;
					}
					
					if (!tfs[sub]) {
						tfs[sub] = true;
					}
					else {
						tfResult = false;
						result = "Not jolly";
						break;
					}
				}
				
				if (tfResult) {
					result = "Jolly";
				}
				
			}
			
			System.out.println(result);
			
		}
	}
}