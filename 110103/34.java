import java.util.Scanner;
import java.util.ArrayList;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		while (scan.hasNextLine()) {
			
			int student = scan.nextInt();
			
			if (student == 0) {
				break;
			}
			
			double mean;
			double sum_tot = 0;
			double sum_pos = 0;
			double sum_neg = 0;
			
			ArrayList<Double> money = new ArrayList<>();
			
			for (int i = 0; i < student; i++) {
				double coin = scan.nextDouble();
				money.add(coin);
				sum_tot += coin;
			}

			mean = Math.ceil(sum_tot / (double)student * 100.0) / 100.0;
						
			for (int i = 0; i < money.size(); i++) {
				
				if ((money.get(i) - mean) < 0) {
					sum_neg += mean - money.get(i);
				}
				
				else {
					sum_pos += money.get(i) - mean;
				}
				
			}
			
			double result = Math.min(sum_pos, sum_neg);
			
			System.out.print("$");
			System.out.printf("%.2f%n", result);
			
		}
	}
}