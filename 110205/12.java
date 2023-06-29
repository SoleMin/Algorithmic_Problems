import java.io.*;
import java.util.*;

class Main {
static String [] cards = new String [52];
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int [] check = new int [52];
		int caseNum = sc.nextInt();
		
		sc.nextLine();
		
		for (int l = 0; l < caseNum; l++) {
			setCards();
			for (int i = 0; i < 52; i++) check[i] = i;
			
			int n = sc.nextInt();
			int [][] shake = new int [n][52];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 52; j++)
					shake[i][j] = sc.nextInt()-1;
			}
			sc.nextLine();
			String line;
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				if(line.length() == 0) break;
				int shakeNum = Integer.parseInt(line);
				shakeNum -= 1;
				int [] tmp = new int [52];
				for (int i = 0; i < 52; i++)
					tmp[i] = check[shake[shakeNum][i]];
				check = tmp;
			}
			for (int i = 0; i < 52; i++)
				System.out.println(cards[check[i]]);
			System.out.println();
		}
	}
	
	// 카드를 정렬한다.
	public static void setCards() {
		String[] shape = {" of Clubs", " of Diamonds", " of Hearts", " of Spades"};
		String[] num = {"Jack", "Queen", "King", "Ace"};
		int cnt = 0;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++){
				if (j > 8) cards[cnt++] = num[j-9] + shape[i];
				else cards[cnt++] = "" + (j+2) + shape[i];
			}
		}
	}
}