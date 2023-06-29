import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan =  new Scanner(System.in);
		
		while(scan.hasNextLine()){
			String line1 = scan.nextLine();
			String line2 = scan.nextLine();
			int cnt = 0;
			if(line1.equals("") || line2.equals("")) break;
			List<Character> list = new ArrayList<>();
			
			for(int j = 0 ; j < line1.length() ; j++){
				for(int k = 0 ; k < line2.length() ; k++){
					if(line1.charAt(j) == line2.charAt(k)){
						if(countNum(line1, line1.charAt(j)) > countNum(line2, line2.charAt(k)) && !list.contains(line1.charAt(j)) ){
							for(int z = 0 ; z < countNum(line2, line2.charAt(k)); z++){
								list.add(line1.charAt(j));
							}
						} else if(countNum(line1, line1.charAt(j)) <= countNum(line2, line2.charAt(k)) && !list.contains(line1.charAt(j))) {
							for(int x = 0 ; x < countNum(line1,line1.charAt(j)); x++){
								list.add(line2.charAt(k));
							}
						}
					}	
				}
			}
			Collections.sort(list);
			//for(int l = 0; l < list.size(); l ++){
			for(char data: list) {
				System.out.print(data);
			}//list.get(l).toString());
			//}
			System.out.println();
			list.clear();
		}
			
	}
	
	public static int countNum(String abc , char c){
		int count = 0;
		for(int i = 0; i < abc.length(); i++ ){
			if(abc.charAt(i) == c) count++;
		}
		return count;
	}
}