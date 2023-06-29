import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCaseCount = Integer.parseInt(br.readLine());
		br.readLine();
		
		String keyStr = "the quick brown fox jumps over the lazy dog";
		
		for(int i = 0; i < testCaseCount; i++) {
			String input = "";
			List<String> strList = new ArrayList<>();
			Map<Character, Character> map = new HashMap<>();
			boolean tf = false;
			if(i != 0) {
				System.out.println();
			}
			
			while(true) {
				input = br.readLine();
				
				if(input == null || input.equals("")) {
					break;
				}
				
				if(input.length() == keyStr.length() && input.split(" ").length == keyStr.split(" ").length) {
					boolean foxtf = true;
					String keySplit[] = keyStr.split(" ");
					String inputSplit[] = input.split(" ");
					
					for (int k = 0; k < keySplit.length; k++) {
						if (keySplit[k].length() != inputSplit[k].length()) {
							foxtf = false;
							break;
						}
					}

					if (foxtf) {
						for(int j = 0; j < input.length(); j++) {
							map.put(input.charAt(j), keyStr.charAt(j));
						}
						tf = true;
					}
					else {
						break;
					}
					
					if (foxtf) {
						String semiResult = "";
						for (int j = 0; j < input.length(); j++) {
							semiResult = semiResult + map.get(input.charAt(j));
						}
						
						if (semiResult.equals(keyStr)) {
							tf = true;
						}
						else {
							tf = false;
						}
						
					}
					
					
				}
				strList.add(input);
			}
			
			if (tf) {
				for (String str : strList) {
					String result = "";
					for (int j = 0; j < str.length(); j++) {
						result = result + map.get(str.charAt(j));
					}
					System.out.println(result);
				}
			}
			else {
				System.out.println("No solution.");
			}
		}
	}
}