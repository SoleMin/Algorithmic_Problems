import java.io.*;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		/**문자열 최대 길이 1000
		최소 1 모든 입력 알파벳 소문자**/
		/**조건 ) - x가 여러개면 알파벳 순으로 맨 앞에 있는 것**/
		/**contain 했니~~? 했으면 리스트 저장하고 뒤에 있는 거에서 너는 나가**/
		
		while(input.hasNextLine()) {
			String[] s1 = input.nextLine().split("");
			String[] s2 = input.nextLine().split("");
			
			LinkedList<String> list2 = new LinkedList<>(Arrays.asList(s2));
			ArrayList<String> result = new ArrayList<>();
		
			for(int n=0; n<s1.length; n++) {
				if(list2.contains(s1[n])) {
					result.add(s1[n]);
					list2.remove(s1[n]);
				}
			}
			
			
			Collections.sort(result);
			Iterator<String> iter = result.iterator();
			while(iter.hasNext()) {
			System.out.print(iter.next());
			}
			System.out.println("");
		}
	}
}