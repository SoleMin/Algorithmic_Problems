import java.util.Scanner;
import java.util.ArrayList;

class Main {
	public static int collect(ArrayList<Integer> input) {
		int sum = 0;
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i) != 0)
				sum += 1;
		}
		return sum;
	}
		
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		int count = 0;
		
		while (true) {
			count += 1;
				
			ArrayList<Integer> hartal_par = new ArrayList<>();
			ArrayList<Integer> day = new ArrayList<>();
			
			int days = scan.nextInt();
			int party = scan.nextInt();
			
			for (int i = 0; i < party; i++) {
				hartal_par.add(scan.nextInt());
			}
			
			for (int i = 0; i < days; i++) {
				day.add(0);
			}
			
			for (int i = 0; i < party; i++) {
				int term = hartal_par.get(i);
				for (int j = 0; j < days; j++) {
					if ((j+1) % term == 0) {
						day.set(j, day.get(j) + 1);
					}
				}
			}
			
			for (int i = 0; i < days; i++) {
				if (((i+1) % 7 == 6) || ((i+1) % 7 == 0))
					day.set(i, 0);
			}
			System.out.println(collect(day));
			
			if (count == T)
				break;
		}
	}
}