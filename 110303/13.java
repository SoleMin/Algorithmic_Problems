import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()){
			ArrayList<Character> list = new ArrayList<>();
			ArrayList<Character> list1 = new ArrayList<>();
			ArrayList<Character> list2 = new ArrayList<>();
			String a =input.nextLine();
			for(int i=0; i<a.length(); i++){
				list.add(a.charAt(i));
			}
			String b = input.nextLine();
			for(int i=0; i<b.length(); i++){
				list1.add(b.charAt(i));
			}
			Collections.sort(list);
			Collections.sort(list1);
			for(int i=0; i<list.size(); i++){
				for(int j=0; j<list1.size(); j++){
					if(list.get(i).equals(list1.get(j))){
						list2.add(list1.get(j));
						list.remove(list1.get(j));
						list1.remove(list1.get(j));
						i=0;
						j=-1;
				}
			}
		}
			for(Character i : list2){
				System.out.print(i);
			}
			System.out.println();
		}
	}
}