import java.io.*;
import java.util.Scanner;

class Main {
	String[] values = new String[52];
	int[] order = new int[52];
	
	public Main() {
		for (int i = 0; i < 52; i++) {
			this.values[i] = String.format("%s of %s", getCard(i), getSuit(i));
			this.order[i] = i;
		}
	}
	
	String getCard(int index) {
		String[] cards = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		return cards[index % 13];
	}
	
	String getSuit(int index) {
		switch (index / 13) {
			case 0: return "Clubs";
			case 1: return "Diamonds";
			case 2: return "Hearts";
			case 3: return "Spades";
			default: return null;
		}
	}
	
	public void shuffle(int[] pattern) {
		int[] temp = new int[52];
		for (int i = 0; i < 52; i++) {
			temp[i] = this.order[pattern[i]];
		}
		this.order = temp;
	}
	
	public void printResult() {
		for (int i=0; i < 52; i++) {
			System.out.println(this.values[this.order[i]]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int tc = Integer.parseInt(input.nextLine());
		input.nextLine();
		
		for (int i = 0; i < tc; i++) {
			Main stackUp = new Main();
			
			int N = Integer.parseInt(input.nextLine());
			int[][] patterns = new int[N][52];
			
			for (int j=0; j < N; j++) {
				for (int k = 0; k < 52; k++) {
					patterns[j][k] = input.nextInt() -1;
				}
			}
			input.nextLine();
			
			while (input.hasNextLine()) {
				String line = input.nextLine();
				if (line == null || line.length() == 0) {
					break;
				}
				int num = Integer.parseInt(line) -1;
				stackUp.shuffle(patterns[num]);
			}
			
			stackUp.printResult();
		}
		input.close();
	}
}