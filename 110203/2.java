import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		int day = 0, party = 0, count = 0;
		int[] hartals = new int[1];
		int[] parties = new int[1];
		
		while(input.hasNextInt()) {
			int integer = input.nextInt();
			if(day == 0) {
				day = integer;
				hartals = new int[day+1];
				continue;
			}
			
			if(party == 0) {
				party = integer;
				parties = new int[party];
				continue;
			}
			else {
				parties[count] = integer;
				count++;
			}
			
			if(count != 0 && count == party) {
				for(int i=0; i<party; i++) {
					boolean except = false;
					int multiple = 1, hartal = 0;
					
					while(multiple * parties[i] < hartals.length) {
						hartal = multiple * parties[i];
						if(hartal%7 == 0 || hartal%7 == 6)
							except = true;
						else
							except = false;
						
						if(!except)
							hartals[hartal]++;
						
						multiple++;
					}
				}
				
				int counting = 0;
				for(int i=0; i<day+1; i++)
					if(hartals[i] != 0)
						counting++;
				
				System.out.println(counting);
				
				day = 0;
				party = 0;
				count = 0;
			}
		}
	}
}