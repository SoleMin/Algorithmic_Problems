import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt(); 
		
		for(int i = 0; i < testcase; i++) {
			List<Integer> loc = new LinkedList<>();
			int houses = sc.nextInt();
			
			for(int j = 0; j < houses; j++) {
				loc.add(sc.nextInt());
			}
		
			loc.sort(Comparator.naturalOrder());
			
			int vito_loc = loc.get(loc.size()/2);
	
			int ds = 0;
			
			for(int n : loc) {
				ds += Math.abs(n-vito_loc);
			}
			System.out.println(ds);
		}
	}
}