import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		while (scan.hasNextInt()) {
			
			int num_of_int = scan.nextInt();
			ArrayList<Integer> series = new ArrayList<>();
			ArrayList<Integer> diff = new ArrayList<>();
			
			for (int i = 0; i < num_of_int; i++){
				series.add(scan.nextInt());
			}
			
			if (num_of_int == 1){
				System.out.println("Jolly");
			} else {
				
				for (int i = 0; i < num_of_int-1; i++){
					diff.add(Math.abs(series.get(i) - series.get(i+1)));
				}
				
				Collections.sort(diff);
				
				for (int i = 0; i < num_of_int-1; i++){
					if (diff.get(i) != i+1){
						System.out.println("Not jolly");
						break;
					} else if ((diff.get(i) == i+1) && i == num_of_int - 2){
						System.out.println("Jolly");
					}
				}
			}
		}
	}
}