import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
	
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		for(int i =0; i<n; i++) {
			String garbage = input.nextLine();
			int cnt = Integer.parseInt(input.nextLine());
			HashMap<Integer,Double> result = new HashMap<>();
			
			for(int h =1; h<cnt+1; h++) {
				String[] temp = input.nextLine().split(" ");
				double res = (Double.parseDouble(temp[1])/Double.parseDouble(temp[0])); 
				result.put(h,res);
			}
	
			List<Integer> list = new ArrayList<>(result.keySet());
			Collections.sort(list, (value1, value2) -> (result.get(value2).compareTo(result.get(value1))));
			for(int key : list) {
				System.out.print(key + " ");
			}
			System.out.println("");
			System.out.println("");
		}
		/**S1/T1 -> 다 구한뒤에 오름차순으로 정렬 퀵소트로 구현 가능하면 퀵 -> 안되면 걍 삽입**/
	}
}