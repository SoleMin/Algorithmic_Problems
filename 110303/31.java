import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()){
			String in1 = sc.nextLine();
			String in2 = sc.nextLine();
			
			ArrayList<Character> list1 = new ArrayList<>();
			ArrayList<Character> list2 = new ArrayList<>();
			ArrayList<Character> result = new ArrayList<>();
			
			for(int i = 0 ; i < in1.length(); i++)
				list1.add(in1.charAt(i));
			for(int i = 0 ; i < in2.length(); i++)
				list2.add(in2.charAt(i));
			
			for(int i = 0 ; i < list1.size(); i++){
				for (int j = 0 ; j < list2.size(); j++){
					if(list1.get(i) == list2.get(j)){
						result.add(list1.get(i));
						list2.remove(j);
						break;
					}					
				}
			}
			Collections.sort(result);
			for(char c : result)
				System.out.print(c);
			System.out.println();
		}
	}
}