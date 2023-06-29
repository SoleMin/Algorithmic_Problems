import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);

		while(input.hasNextInt()) {
			long start = input.nextInt();
			long end = input.nextInt();
			long max = 0;
			boolean isExchange = false;
			
			if(start > end) {
				long temp = start;
				start = end;
				end = temp;
				isExchange = true;
			}
			
			for(long i=start; i <= end; i++) {
				long n = i, count = 1;
				while(n != 1) {
					if(n % 2 == 0)
						n /= 2;
					else
						n = 3*n + 1;
					count++;
				}
				if(count > max)
					max = count;
			}
			
			if(isExchange)
				System.out.println(end + " " + start + " " + max);
			else
				System.out.println(start + " " + end + " " + max);
		}
		
		input.close();
	}
}