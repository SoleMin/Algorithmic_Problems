import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		input.nextLine();
		input.nextLine();
		LinkedList<String> card = new LinkedList<String>();
		ArrayList<LinkedList> cardset = new ArrayList<>();
		
		for(int i =0; i<testCase;i++){
			int count=0;
			cardsetting(card);
			LinkedList<String> card2 = new LinkedList<String>();
			int shake = input.nextInt();
			input.nextLine();
			ArrayList<int[]> way = new ArrayList<int[]>();
			while(count<shake){
				int[] order = new int[52];
				for(int j =0;j<52;j++){
					order[j] = input.nextInt();
				}
					input.nextLine();
					way.add(order);
					count++;
			}
			
			if(i!=testCase-1){
				while(true){
				String k = input.nextLine();
				if(k.trim().equals("")) break;
				int s = Integer.parseInt(k);
				
				Shakeway(card,way.get(s-1));
				}
			}
				else{
					while(input.hasNextLine()){
						int s = input.nextInt();
						Shakeway(card,way.get(s-1));
						input.nextLine();
					}
				}
			
			for(int j=0;j<52;j++){
				card2.add(card.get(j));
			}
			cardset.add(card2);
			card.clear();
		}
		
		for(int i =0;i<testCase;i++){
			for(int j =0;j<52;j++){
				System.out.println(cardset.get(i).get(j));
			}
			if(i!=testCase-1) System.out.println();
		}
	}
	private static void cardsetting(LinkedList<String> card){
		int count=0;
		for(int i =2;i<11;i++){
			card.add(i+" of Clubs");
		}
		card.add("Jack of Clubs");
		card.add("Queen of Clubs");
		card.add("King of Clubs");
		card.add("Ace of Clubs");
		for(int i =2;i<11;i++){
			card.add(i+" of Diamonds");
		}
		card.add("Jack of Diamonds");
		card.add("Queen of Diamonds");
		card.add("King of Diamonds");
		card.add("Ace of Diamonds");
		
		for(int i =2;i<11;i++){
			card.add(i + " of Hearts");
		}
		card.add("Jack of Hearts");
		card.add("Queen of Hearts");
		card.add("King of Hearts");
		card.add("Ace of Hearts");
		for(int i =2;i<11;i++){
			card.add(i+" of Spades");
		}
		card.add("Jack of Spades");
		card.add("Queen of Spades");
		card.add("King of Spades");
		card.add("Ace of Spades");
	}
	private static void Shakeway(LinkedList<String> card, int[] order){
		LinkedList<String> card2 = new LinkedList<String>();
		for(int i =0;i<52;i++){
			card2.add(card.get(i));
		}
		for(int i =0;i<52;i++){
			card.set(i,card2.get(order[i]-1));
		}
	}
}