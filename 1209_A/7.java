import java.util.*;
import java.io.*;

public class Main {

	static Scanner console;
	public static void main(String[] args) {
		console = new Scanner(System.in);
		int n = console.nextInt();
		List<Integer> arr= new ArrayList<>();		
		for(int i = 0; i < n; i++) arr.add( console.nextInt());
		Collections.sort(arr);
		List<Integer> groups = new ArrayList<>();
//		System.out.println(arr);
		for(int i = 0; i < arr.size() - 1; i++) {
			int j = i+1;
			groups.add(arr.get(i));
//			System.out.println(groups);
			while(j < arr.size()) {
//				System.out.println(j);
				if(arr.get(j) % arr.get(i) == 0) {
					arr.remove(j);
					
				}
				else {
//					groups.add(arr.get(j));
					j++;
				}
			}
		}
//		System.out.println(arr);
		System.out.println(arr.size());
	}
}
