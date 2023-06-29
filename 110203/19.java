import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int[] dayCheck = new int[3651];
		int n = input.nextInt();
		int day, numParty, party, result;
		
		for(int i=0; i < n; i++) {
			day = input.nextInt();
			numParty = input.nextInt();
			
			for(int j=1; j <= day; j++)
				dayCheck[j] = 0;
			result = 0;
			
			for(int j=0; j < numParty; j++) {
				party = input.nextInt();
				
				for(int k=party; k <= day; k+=party)
					if(!isFree(k))
						dayCheck[k] = 1;
			}
			
			for(int j=1; j <= day; j++)
				if(dayCheck[j] == 1)
					result++;
			System.out.println(result);
		}
	}
	
	public static boolean isFree(int n) {
		return (n%7 == 0 || n%7 == 6) ? true : false;
	}
}