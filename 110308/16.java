import java.util.*;
class Main {
	
	static List<String> format(List<String> paragraph, int maxLength) {
		List<String> result = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		
		for (int i=0; i < paragraph.size(); i++) {
			String line = paragraph.get(i);
			
			if (i > 0 && paragraph.size() != 0 && line.charAt(0) == ' ') {
				result.add(sb.toString());
				sb = new StringBuffer();
			}
			
			if (sb.length() > 0) {
				sb.append(' ');
			}
			
			for (int k, j=0, l=line.length(); j < l; j++) {
				if (line.charAt(j) == ' ') {
					sb.append(line.charAt(j));
				} else {
					for (k = j; k < line.length(); k++) {
						if (line.charAt(k) == ' ') break;
					}
					
					if(sb.length() + k - j > maxLength) {
						result.add(sb.toString());
						sb = new StringBuffer();
					}
					
					while (j < k) {
						sb.append(line.charAt(j++));
					}
					j -= 1;
				}
			}
		}
		
		result.add(sb.toString());
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		do {
			List<String> list = new ArrayList<>();
			
			while (input.hasNextLine()) {
				String line = input.nextLine();
				if (line == null || line.length() == 0) break;
				list.add(line);
			}
			
			List<String> result = format(list, 72);
			
			for (String line : result) {
				if (line.length() > 0)
					System.out.println(line);
			}
			System.out.println();
			
		} while (input.hasNextLine());
		
		input.close();
	}
}