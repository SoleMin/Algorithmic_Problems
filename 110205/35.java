import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int testcase = input.nextInt();
		input.nextLine();
		
		for(int t=0; t<testcase; t++){
			
			int a = input.nextInt();
			int shuffleWay[][] = new int[a][52];
			
			for(int i=0; i<a; i++){
				for(int j=0;j<52;j++){
					shuffleWay[i][j]=input.nextInt()-1;
				}
				input.nextLine();
			}
			
			String cardNum[] = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
			String cardPattern[] = {"Clubs","Diamonds","Hearts","Spades"};
			String card[] = new String[52];
			String cardMix[] = new String[52];
			int num=0;
			
			for(int i=0; i<4; i++){
				for(int j=0; j<13; j++){
					card[num++]=cardNum[j]+" of "+cardPattern[i];
				}
			}
			
			while(input.hasNextLine()){
				
				String shuffle = input.nextLine();
				if(shuffle.equals("")){
					break;
				}
				int shuffleNum = (Integer.parseInt(shuffle))-1;
				int cardMixWay[] = new int[52];
				
				for(int i=0; i<52; i++){
					cardMixWay[i]=shuffleWay[shuffleNum][i];
				}
				for(int i=0; i<52; i++){
					cardMix[i]=card[cardMixWay[i]];
				}
				for(int i=0; i<52; i++){
					card[i]=cardMix[i];
				}
			}
			
			for(int i=0; i<52; i++){
				System.out.println(card[i]);
			}
			System.out.println();
		}
		
	}
}