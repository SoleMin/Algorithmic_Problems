import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int[][] howS;
		int[] prevSet = new int[52]; 
		int[] nowSet = new int[52];
		int cases, shuffles, i, j, k, suit, value;
		String temp;
		
		cases = input.nextInt();
		input.nextLine();
		
		while(cases > 0){
			shuffles = input.nextInt();
			howS = new int[shuffles][52];
			
			for(i = 0; i < shuffles; i++)
				for(j = 0; j < 52; j++)
					howS[i][j] = input.nextInt();
			
			for(i = 0; i < 52; i++)
				nowSet[i] = i+1;
			
			input.nextLine();
			while(input.hasNext()) {
				temp = input.nextLine();
				if(temp.equals(""))
					break;
				k = Integer.parseInt(temp);
				for(i = 0; i < 52; i++)
					prevSet[i] = nowSet[i];
				for(i = 0; i < 52; i++)
					nowSet[i] = prevSet[howS[k-1][i]-1];
			}
		
			for(i = 0; i < 52; i++) {
				value = (nowSet[i] -1) % 13;
				suit = (nowSet[i] -1) / 13;
				switch(value) {
					case 9: System.out.print("Jack"); break;
					case 10: System.out.print("Queen"); break;
					case 11: System.out.print("King"); break;
					case 12: System.out.print("Ace"); break;
					default: System.out.print(value + 2); break;
				}
				System.out.print(" of ");
				switch(suit) {
					case 0: System.out.println("Clubs"); break;
					case 1: System.out.println("Diamonds"); break;
					case 2: System.out.println("Hearts"); break;
					case 3: System.out.println("Spades"); break;
				}
			}
			System.out.println();
			cases--;
		}
		
	}
}