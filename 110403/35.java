import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		int testcase_num = scan.nextInt();
		
		scan.nextLine();
		scan.nextLine();
		
		for (int testcase = 0; testcase < testcase_num; testcase++){
			
			ArrayList<Integer> speed = new ArrayList<>();
			int people_num = scan.nextInt();
			int spend_time = 0;
			
			for (int people = 0; people < people_num; people++){
				speed.add(scan.nextInt());
				scan.nextLine();
			}
			
			Collections.sort(speed);
			
			while (true){
				if (speed.size() <= 3){
					spend_time += (speed.get(0) + speed.get(1) + speed.get(2));
					break;
				}
				else {
					int case_1 = 0;
					int case_2 = 0;
					case_1 += (speed.get(0) + speed.get(1) * 2 + speed.get(speed.size()-1));
					case_2 += (speed.get(0) * 2 + speed.get(speed.size()-2) + speed.get(speed.size()-1));
					spend_time += Math.min(case_1, case_2);
					speed.remove(speed.get(speed.size()-1));
					speed.remove(speed.get(speed.size()-1));
					
					if (speed.size() == 2){
						spend_time += speed.get(1);
						break;
					}
				}
			}
			System.out.println(spend_time);
			System.out.println();
		}
	}
}