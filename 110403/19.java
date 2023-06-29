import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		List<Integer> person = new ArrayList<Integer>();
		int casenum = sc.nextInt(), personnum = 0, time;
		
		for (int i = 0; i < casenum; i++) {
			personnum = sc.nextInt();
			person.clear();
			for (int j = 0; j < personnum; j++) {
				person.add(sc.nextInt());
			}
			
			
			
			person.sort(null);
			
			time = 0;
			time = soultion(person, time);
			System.out.printf("%d\n\n", time);
		}
	}
	
	static int soultion (List<Integer> person, int time) {
		
		if (person.size() == 3) {
			for (int i = 0; i < person.size(); i++) {
				time += person.get(i);
			}
		} else if (person.size() == 2) {
			time = person.get(1);
		} else {
			while (person.size() >= 4) {
				if (person.get(0) + 2 * person.get(1) + person.get(person.size() - 1) < 2 * person.get(0) + person.get(person.size() - 2) + person.get(person.size() - 1)) {
					time += person.get(0) + 2 * person.get(1) + person.get(person.size() - 1);
				} else {
					time += 2 * person.get(0) + person.get(person.size() - 2) + person.get(person.size() - 1);
				}
				person.remove(person.size() - 1);
				person.remove(person.size() - 1);
			}
			if (person.size() == 3) {
				for (int i = 0; i < person.size(); i++) {
					time += person.get(i);
				}
			} else {
				time += person.get(1);
			}
		}
		
		return time;
	}
}