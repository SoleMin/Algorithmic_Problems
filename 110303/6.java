import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		ArrayList<ArrayList<Character>> arrayLists = new ArrayList<>();
		while (input.hasNextLine()){
			String first = input.nextLine();
			String second = input.nextLine();
			ArrayList<Character> arrayList = new ArrayList<>();
			
			if(first.length()>second.length()){
				String temp = first;
				first = second;
				second = temp;
			}
			for(int i =0;i<first.length();i++){
				if(arrayList.contains(first.charAt(i)))
					second = second.replaceFirst(Character.toString(first.charAt(i)),"");
				for(int j=0;j<second.length();j++){
					if(first.charAt(i)==second.charAt(j)){
						arrayList.add(first.charAt(i));
					break;
				 }
				}
			}
			Collections.sort(arrayList);
			arrayLists.add(arrayList);
		}
		for(int i=0;i<arrayLists.size();i++){
			for(int j=0;j<arrayLists.get(i).size();j++){
			System.out.print(arrayLists.get(i).get(j));
			}
			System.out.println();
		}
	}
}