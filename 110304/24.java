

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String standard = "the quick brown fox jumps over the lazy dog";
		
		int n = sc.nextInt();
		sc.nextLine();
		sc.nextLine();
		
		for (int i = 0; i < n; i++) {
			TreeMap<Character, Character> rule = new TreeMap<>();
			ArrayList<String> cryptlist = new ArrayList<>();
			
			while (sc.hasNextLine()) {
				String input = sc.nextLine();
				if (input.equals("")) {
					break;
				}
				
				cryptlist.add(input);
			}
			
			print_result(cryptlist, Mapping(cryptlist, rule, standard));
		}
	}
	
	public static TreeMap<Character, Character> Mapping(ArrayList<String> cryptlist, TreeMap<Character, Character> rule, String standard) {
		for (String str : cryptlist) {
			if (str.length() == standard.length()) {
				TreeMap<Character, Character> rule_copy = new TreeMap<>();
				
				for (int j = 0; j < str.length(); j++) {
					rule_copy.put(str.charAt(j), standard.charAt(j));
				}
				
				StringBuilder result = new StringBuilder();
				
				for (int j = 0; j < str.length(); j++) {
					result.append(rule_copy.get(str.charAt(j)));
				}
				
				if (!result.toString().equals(standard)) continue;
				
				else {
					rule.putAll(rule_copy);
					break;
				}
			}
		}
		return rule;
	}
	
	public static void print_result(ArrayList<String> cryptlist, TreeMap<Character, Character> rule) {
		String no_solution = "";
		for (String str : cryptlist) {
			StringBuilder result = new StringBuilder();
			
			for (int j = 0; j < str.length(); j++) {
				if (rule.get(str.charAt(j)) == null) {
					no_solution = "No solution.";
					break;
				}
				result.append(rule.get(str.charAt(j)));
			}
			
			if (no_solution.equals  ("No solution.")) {
				break;
			}
			
			System.out.println(result);
		}
		if (no_solution.equals("No solution.")) {
			System.out.println(no_solution);
		}
		
		System.out.println("");
	}
}