import java.io.*;
import java.util.Scanner;
import java.util.Collections;
import java.util.LinkedList;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		/**가장 짧은 시간안에 건너는 방법**/
		/**짧은 것 2개 묶기 , 큰 것 2개 묶기 -> 
		
		짧은 것 먼저가 -> 그 다음에 큰 거 가
		응 님 가 그리고 다시 전등들고 컴백하는 애들은 그 중에서 가장 작은 걸로**/
		int n = Integer.parseInt(input.nextLine());
		for(int h =0; h<n; h++) {
			int time =0;
			String garbage = input.nextLine();
			int test = Integer.parseInt(input.nextLine());
			LinkedList<Integer> arr = new LinkedList<>();
			LinkedList<Integer> end = new LinkedList<>();
			for(int i =0; i<test; i++) {
				arr.add(Integer.parseInt(input.nextLine()));
				
			}
			Collections.sort(arr);
			
			while(arr.size() > 3) {
					int one = arr.get(0) + arr.get(1)*2 + arr.get(arr.size()-1);
					int two = (arr.get(0)*2) + arr.get(arr.size()-2) + arr.get(arr.size()-1);
				if(one < two) {
					end.add(arr.get(0));
					end.add(arr.get(1));
					time += arr.get(1);
					arr.remove(0);
					arr.remove(0);

					Collections.sort(end);
					arr.add(end.get(0));
					time += end.get(0);
					end.remove(0);
					Collections.sort(arr);
					Collections.sort(end);

					end.add(arr.get(arr.size()-1));
					end.add(arr.get(arr.size()-2));
					time += arr.get(arr.size()-1);
					arr.remove(arr.size()-1);
					arr.remove(arr.size()-1);
					Collections.sort(end);

					arr.add(end.get(0));
					Collections.sort(arr);
					time += end.get(0);
					end.remove(0);
					Collections.sort(end);
				}
				else {
					end.add(arr.get(0));
					end.add(arr.get(arr.size()-1));
					time += arr.get(arr.size()-1);
					arr.remove(0);
					arr.remove(arr.size()-1);
					
					Collections.sort(end);
					
					arr.add(end.get(0));
					time += end.get(0);
					end.remove(0);
					Collections.sort(arr);
					
					end.add(arr.get(0));
					end.add(arr.get(arr.size()-1));
					time += arr.get(arr.size()-1);
					arr.remove(0);
					arr.remove(arr.size()-1);
					
					Collections.sort(end);
					
					arr.add(end.get(0));
					time += end.get(0);
					end.remove(0);
					Collections.sort(arr);
					
				}
			}
			if(arr.size() == 3) {
				time += (arr.get(1) + arr.get(2) + arr.get(0));
			}
			else if(arr.size() == 2) {
				time += arr.get(1);
			}
			else if(arr.size() == 1) {
				time += arr.get(0);
			}
			System.out.println(time);
			System.out.println("");
		}
	}
}