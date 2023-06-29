import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		while(scan.hasNextLine()){
			int testCase=scan.nextInt();
			scan.nextLine();
				
			String[] value={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
			String[] suit={"Clubs","Diamonds","Hearts","Spades"};
			String[] deck= new String[52];

			int num=0;
			for(int i=0;i<suit.length;i++){
				for(int j=0;j<value.length;j++){
					deck[num]=value[j]+" of "+suit[i];
					num++;
				}
			}
			
			for(int i=0;i<testCase;i++){
				int mixMathod=scan.nextInt();
				int[][]card=new int[mixMathod][52];
				
				for(int j=0;j<mixMathod;j++){
					for(int a=0;a<52;a++){
						card[j][a]=scan.nextInt()-1;
					}
					scan.nextLine();
				}
				
				int[]temp1=new int[52];
				int[]temp2=new int[52];
				for(int n=0;n<temp2.length;n++){
					temp2[n]=n;
				}
				
				while(scan.hasNextLine()){
					String input=scan.nextLine();
					if(input.equals("")){
						break;
					}
					int mixNum=Integer.parseInt(input)-1;
					for(int a=0;a<deck.length;a++){
						temp1[a]=temp2[card[mixNum][a]];
					}
					for(int b=0;b<temp2.length;b++){
						temp2[b]=temp1[b];
					}
					
				}
				for(int b=0;b<deck.length;b++){
					System.out.println(deck[temp2[b]]);
				}
				System.out.println();
			}
		}
	}
}