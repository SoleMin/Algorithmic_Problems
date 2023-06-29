import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		int testcase_num = scan.nextInt();
		
		scan.nextLine();
		
		for (int i = 0; i < testcase_num; i++){
			
			int my_index, my_location;
			int dist_sum = 0;
			int relative_num = scan.nextInt();
			ArrayList<Integer> relative_location = new ArrayList<>();
			
			for (int j = 0; j < relative_num; j++){
				relative_location.add(scan.nextInt());
			}
			Collections.sort(relative_location);
			
			if ((relative_num % 2) == 0)
				my_index = relative_num / 2 - 1;
			else 
				my_index = relative_num / 2;
			
			my_location = relative_location.get(my_index);
			
			for (int j = 0; j < relative_num; j++){
				dist_sum += Math.abs(my_location - relative_location.get(j));
			}
			System.out.println(dist_sum);
			
			scan.nextLine();
		}
	}
}