import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(int i = 0; i < testcase; i++) {
			int people = sc.nextInt();
			List<Integer> hours = new LinkedList<>();
			for(int j = 0; j < people; j++) {
				hours.add(sc.nextInt());
			}
			hours.sort(Comparator.naturalOrder());
			int hours_s  = 0;
			if(hours.size() == 1) {
				System.out.println(hours.get(0));
			}
			else {


				int a = hours.get(1);
				int b = hours.get(0);
				
			

				hours.remove(0);
				hours.remove(0);
				Stack<Integer> rest = new Stack<>();
				
				for(int k : hours) {
					rest.push(k);
				}

				boolean change = false;
				boolean rest_r = true;
				while(rest.size() != 0 ) {
					if(rest.size() == 1) {
						int h = rest.pop();
						hours_s += h + b + a;
						rest_r = false;
					}
					else {
						int h1 = rest.pop();
						int h2 = rest.pop();
						
						int h_1 = 2*a + b + h1;
						int h_2 = 2*b + h1 + h2;
						
					
						
						if(change) {
							hours_s += h_2;
						}
						else if(h_2 <= h_1) {
							change = true;
							hours_s += h_2;
						}
						else {
							hours_s += h_1;
						}
						
				
					}
				}
				
				if(rest_r)
					hours_s += a;
			}
			
			System.out.println(hours_s);
			System.out.println();
		
		}
		
	}
}
