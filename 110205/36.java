import java.io.*;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

class Main {
	static String[] num = {"2", "3", "4", "5" ,"6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	static String[] suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n; int k; int method; 
		int ts = scan.nextInt();
		scan.nextLine();
		
		while(ts > 0) 
		{
			// 덱 선언
			int[] order = new int[52];
			for(int i = 0; i < 52; i++) order[i] = i;
			String[] cards = new String[52];
			for(int i = 0; i < 52; i++) cards[i] = num[i%13] + " of " + suit[i/13];
			
			// 덱 섞기 방법
			int m = scan.nextInt();
			// 안 섞었을 때 : C - D - H - S
			int[][] methods = new int[m][52];
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < 52; j++) {
					n = scan.nextInt();
					methods[i][j] = n - 1;
				}
				scan.nextLine();
			}
			
			// 덱 섞기
			while(scan.hasNextLine())
			{
				int s;
				String input = scan.nextLine();
				if(input.equals(""))
					break;
				else
					s = Integer.parseInt(input.trim());
				
				int[] temp = new int[52];
				for(int i = 0; i < 52; i++) temp[i] = i;
				
				s = s-1;
				for(int j = 0; j < 52; j++)
					temp[j] = order[methods[s][j]];
				
				// copy
				for(int z = 0; z < 52; z++) order[z] = temp[z];
			}
			for(int c = 0; c < 52; c++) System.out.println(cards[order[c]]);
			System.out.println();
			
			ts--;
	
		}
	}
}