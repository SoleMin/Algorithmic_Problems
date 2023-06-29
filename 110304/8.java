import java.io.*;
import java.util.*;

class Main {

	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		String standard = "the quick brown fox jumps over the lazy dog";

		
		
		int n = scanner.nextInt();
		scanner.nextLine();
		scanner.nextLine();	
		
		
		for(int i=0; i<n ; i++){
			TreeMap<Character,Character> rule = new TreeMap<Character,Character>();
			ArrayList<String> cryptlist = new ArrayList<String>();
			
			//입력하기
			while(scanner.hasNextLine()) {
				String input = scanner.nextLine();
				if(input.equals("")){
					break;
				}	
				cryptlist.add(input);	
			}
			
			
			//해당 암호 해쉬에 저장
			for(String str: cryptlist){
				if(str.length()==standard.length()){
					TreeMap<Character,Character> rule_copy = new TreeMap<Character,Character>();
					for(int j=0 ; j<str.length();j++){
						rule_copy.put(str.charAt(j), standard.charAt(j));
					}
					String result="";
					for(int j=0; j<str.length(); j++)
						result+=rule_copy.get(str.charAt(j));
						
						
					if(!result.equals(standard)) continue;
					else {
						
						rule.putAll(rule_copy); 
						break;
					}		 
					
				}
			}
		
			
			//출력하기
			String no_solution="";
			for(String str: cryptlist){
				String result="";
				for(int j=0; j<str.length(); j++){
					if(rule.get(str.charAt(j))==null){
						no_solution = "No solution.";
						break;
					}
					result+=rule.get(str.charAt(j));
				}
				if(no_solution.equals("No solution.")){
						break;
				}
				System.out.println(result);
			}
			if(no_solution.equals("No solution.")){
				System.out.println(no_solution);
			}
			System.out.println("");
			
		}
		
	}
}