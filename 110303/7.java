import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNextLine()){
	
			String input1 =scanner.nextLine();
			String input2 =scanner.nextLine();
			
			Vector<Character> str1 = new Vector<Character>();
			Vector<Character> str2 = new Vector<Character>();
			ArrayList<Character> result= new ArrayList<Character>();
			
			
			for(int j=0; j<input1.length();j++)
				str1.add(input1.charAt(j));
			
			for(int j=0; j<input2.length();j++)
				str2.add(input2.charAt(j));
			

			for(int j=0; j<str1.size(); j++){
				for(int k=0; k<str2.size();k++){
					if(str1.get(j)==str2.get(k)){
						result.add(str1.get(j));
						str2.remove(k);
						break;
					}
				}
			}
			
			Collections.sort(result, new Comparator<Character>(){
				public int compare(Character o1,Character o2){
					return o1.compareTo(o2);
				}
			});

			
			for(char c:result){
				System.out.print(c);
			}
			System.out.println("");
			
		}
			
		
		scanner.close();
			
	}	
}

