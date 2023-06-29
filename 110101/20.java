import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		while (scan.hasNextLong()) {
		
			long max = 0;
			long lower_org = scan.nextLong();
			long upper_org = scan.nextLong();
			long temp;
			
			long lower = lower_org;
			long upper = upper_org;
			
			if (upper < lower) {
				temp = lower;
				lower = upper;
				upper = temp;
			}
			
			for (long i = lower; i <= upper; i++) {

				long j = i;
				long count = 1;

				while (j != 1) {

					if (j % 2 == 0) {
						j = j / 2;
					} else {
						j = j * 3 + 1;
					}
					
					count += 1;

				}
				
				if (count > max) {
					max = count;
				}

			}
			
			System.out.println(lower_org + " " + upper_org + " " + max);
			
		}
	}
}