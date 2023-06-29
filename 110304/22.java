import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.HashSet;
import java.util.Arrays;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		String key = "the quick brown fox jumps over the lazy dog";
		
		int testcase = input.nextInt();
		
		input.nextLine();
		input.nextLine();
		
		for(int t=0; t<testcase;t++){
			ArrayList<String> list = new ArrayList<String>();
			HashMap<Character,Character> map = new HashMap<Character,Character>();
			
			while(input.hasNextLine()){
				
				String string = input.nextLine();
				
				if(string.equals("")){
					break;
				}
				list.add(string);
			}
			
			int check = 0;
			
			for(int i =0;i<list.size();i++){
				String s =list.get(i);
				s.replace(" ","");
				String list2[]=s.split("");
				HashSet<String> hashSet = new HashSet<>(Arrays.asList(list2));
				
				if(s.length()==key.length()&&hashSet.size()==27){
					for(int j =0;j<s.length();j++){
						map.put(s.charAt(j),key.charAt(j));
					}
					check=0;
					break;
				}else{
					check=1;
				}
			}
			
			for(int i =0; i<list.size();i++){
				String s = list.get(i);
				if(check==0){
					for(int j=0;j<s.length();j++){
						System.out.print(map.get(s.charAt(j)));
					}
					System.out.println();
				}else if(check == 1){
					System.out.println("No solution.");
					break;
				}
			}
			
			System.out.println();
		}
		
		
	}
}