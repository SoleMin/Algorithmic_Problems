import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		String Casetemp = input.nextLine();
		int cases = Integer.parseInt(Casetemp);
		//System.out.println("케이스 개수 : " + cases);
		input.nextLine();
		
		for(int c=0; c<cases; c++){
			//System.out.println((c+1) + "번째");
			String Ntemp = input.nextLine();
			int N = Integer.parseInt(Ntemp);
			//System.out.println("셔플개수 : " + N);
			
			int[] preCards = new int[53];
			int[] cards = new int[53];
			
			for(int i=0; i<53; i++)
				cards[i] = i;
			
			int[][] shuffle = new int[N][53];
			
			for(int i=0; i<N; i++){
				String inputS = input.nextLine();
				//System.out.println(inputS);
				String[] temp = inputS.split(" ");
				for(int j=1; j<53; j++){
					shuffle[i][j] = Integer.parseInt(temp[j-1]);
				}
				//System.out.println((i+1) +"번째 셔플");
			}
			//System.out.println("셔플입력끝");
			
			while(input.hasNextLine()){
				String shuffleNumTemp = input.nextLine();
				
				if(shuffleNumTemp.equals(""))
					break;
				
				int shuffleNum = Integer.parseInt(shuffleNumTemp);
				
				for(int i=1; i<53; i++){
					preCards[i] = cards[i];
				}
				for(int i=1; i<53; i++){
					cards[i] = preCards[shuffle[shuffleNum-1][i]];
				}
			}
			
			//System.out.println("결과출력");
			for(int i=1; i<53; i++){
				int suit = (cards[i]-1) / 13;
				int value = cards[i] % 13;
				
				if(value == 1 || value == 2 || value == 3 || value == 4 || value == 5
					|| value == 6 || value == 7 || value == 8 || value == 9)
					System.out.print((value + 1) + " of ");
				else if(value == 10)
					System.out.print("Jack of ");
				else if(value == 11)
					System.out.print("Queen of ");
				else if(value == 12)
					System.out.print("King of ");
				else
					System.out.print("Ace of ");
				
				if(suit == 0)
					System.out.print("Clubs");
				else if(suit == 1)
					System.out.print("Diamonds");
				else if(suit == 2)
					System.out.print("Hearts");
				else
					System.out.print("Spades");
				
				System.out.println();
			}
			if(c != cases-1)
				System.out.println();
		}
		input.close();
	}
}