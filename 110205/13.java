import java.io.*;
import java.util.Scanner;
class Main {
	
	static String[] value={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
	static String[] suit={"Clubs","Diamonds","Hearts","Spades"};
	static int[][] set;
	static int[] card=new int[53];
	static int[] result;
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int t=input.nextInt();
		for(int i=0; i<t; i++){
			int n=input.nextInt();
			set = new int[n][53];
			for(int j=0; j<n; j++){
				for(int k=1; k<53; k++){
					set[j][k]=input.nextInt();
				}
			}
			
			for(int x=1; x<53; x++)
				card[x]=x;
			result=card.clone();
			input.nextLine();
			while(true){
				if(!input.hasNext())
					break;
				String s= input.nextLine();
				if(s.equals(""))
				   break;
				int num=Integer.parseInt(s);
				mix(num);
			}
			
			for(int y=1; y<53; y++){
				printCard(result[y]);
			}
			System.out.println();
		}
		
		input.close();
		
	}
	
	public static void mix(int num){
		for(int j=1; j<53; j++){
			int i=set[num-1][j];
			result[j]=card[i];
		}
		card=result.clone();
	}
	
	public static void printCard(int a){
		int v=(a-1)%13;
		int s=(a-1)/13;
		System.out.println(value[v]+" of "+suit[s]);
	}
}