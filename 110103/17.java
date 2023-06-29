import java.util.Scanner;

class Main {
	public static void main(String[] args)  {
		Scanner input = new Scanner(System.in);
		
		int people;
		double budget[];
		
		while(true) {
			people = input.nextInt();
			double sum = 0;
			budget = new double[people];
			
			if (people == 0)
				break;
			
			for (int i = 0; i < people; i++) {
				budget[i] = input.nextDouble();
				sum += budget[i];
				//System.out.println(i + " budget : "+ budget[i]);
			}
			
			
			//System.out.println(Math.ceil((sum/people) *100));
			//System.out.println(sum/people);
			sum = Math.ceil((sum / people) * 100) / 100 ;
			//System.out.println("sum : " + sum);
			
			double exchange = 0;
			
			for (int i = 0; i < people; i++){
				if(budget[i] > sum)
					exchange += budget[i] - sum ;
				
			}
			
			System.out.printf("$%.2f\n", exchange);
			
		}
	}
}