import java.io.*;
import java.util.*;

class Main {
	
	public static void printDeck(int[] deckArr){
		int card =0;
		String[] cards = {"2" ,"3","4","5","6","7","8","9","10", "Jack" ,"Queen", "King","Ace"};
		String[] shapes ={"Clubs" ,"Diamonds" ,"Hearts", "Spades"};
		for(int deckCard : deckArr){
			card = deckCard -1;
			if((0 <= card) && (card<13)){
        card %=13;
				System.out.println(cards[card] + " of " + shapes[0]);
			}else if((13 <= card) && (card < 26)){
				card %=13;
				System.out.println(cards[(card)] + " of " + shapes[1]);
			}else if((26 <= card) && (card < 39)){
				card%= 13;
				System.out.println(cards[(card)] + " of " + shapes[2]);
			}else if((39 <= card) && (card <52)){
				card %= 13;
				System.out.println(cards[(card)] + " of " + shapes[3]);
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		//입력도구
		String[] inputArr;
		int[] intArr;
		ArrayList<int[]> shuffleDeckList = new ArrayList<>();
		int caseNumber = input.nextInt();
		input.nextLine();
		input.nextLine();
		
		for(int ps = 0; ps < caseNumber;ps++){
			
			int shuffleDeck = input.nextInt();
			
			input.nextLine();
			for(int i=0; i<shuffleDeck; i++){
			inputArr = input.nextLine().split(" ");
			intArr = Arrays.stream(inputArr)
				.mapToInt(Integer::parseInt)
				.toArray();
			shuffleDeckList.add(intArr);
			}
			
			int[] deckArr = new int[52];
			
			for(int j=1; j<=52 ;j++){
				deckArr[j-1] = j;
			}
			while(input.hasNextLine()){
				String inputString = input.nextLine();

				
				if(inputString.length()>0){
					int select = Integer.parseInt(inputString);
					int[] newDeck = new int[52];
					
					intArr = shuffleDeckList.get(select -1);
					
					for(int index =0 ; index<52; index++){
						newDeck[index] = deckArr[intArr[index]-1];
					}
					deckArr =Arrays.copyOfRange(newDeck, 0 , 52);
					// input.nextLine();
				}else if(inputString.equals("")){
					printDeck(deckArr);
					shuffleDeckList.clear();
					break;
				}if(!input.hasNextLine()){
					printDeck(deckArr);
				}
				
			}
			
			
		}
	}
}