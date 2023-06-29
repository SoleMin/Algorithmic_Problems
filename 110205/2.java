import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		
		while (t-- > 0){
			Card card = new Card();
			int n = input.nextInt();
			int[][] sets = new int[n][52];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < 52; j++)
					sets[i][j] = input.nextInt() - 1;
			input.nextLine();
			while (input.hasNextLine()) {
				String line = input.nextLine();
				
				if (line.equals("")) {
					break;
				} else {
					int k = Integer.parseInt(line);
					card.shuffle(sets[k - 1]);
				}
			}
			card.printCards();
			System.out.println();
		}
	}
}

class Card {
	String[] cards = new String[52];
	int[] seqence = new int[52];
	public Card() {
		String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		String[] patterns = {"Clubs", "Diamonds", "Hearts", "Spades"};
		
		for(int i = 0; i < 52; i++) {
			cards[i] = numbers[i % 13] + " of " + patterns[i / 13];
			seqence[i] = i;
		}
	}
	public void shuffle(int index[]) {
		int[] newSeqence = new int[52];
		for (int i = 0; i < index.length; i++)
			newSeqence[i] = seqence[index[i]];
		seqence = newSeqence;
	}
	
	public void printCards() {
		for (int i = 0; i < seqence.length; i++)
			System.out.println(cards[seqence[i]]);
	}
}