import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
        String[] savestr = new String[52];
         int cases = input.nextInt();
        input.nextLine();
        input.nextLine();
        for (int i = 0; i < cases; i++) {
            String[] str = new String[52];
            for (int j = 0; j < 52; j++) {
                if (j < 13) {
                    str[j] = String.format("%s of Clubs", Integer.toString(j+2) );
                    if (j == 9) str[j] = String.format("Jack of Clubs");
                    if (j == 10) str[j] = String.format("Queen of Clubs");
                    if (j == 11) str[j] = String.format("King of Clubs");
                    if (j == 12) str[j] = String.format("Ace of Clubs");
                }
                if( 13 <= j && j < 26){
                    str[j] = String.format("%s of Diamonds", Integer.toString(j+2-13));
                    if (j == 22) str[j] = String.format("Jack of Diamonds");
                    if (j == 23) str[j] = String.format("Queen of Diamonds");
                    if (j == 24) str[j] = String.format("King of Diamonds");
                    if (j == 25) str[j] = String.format("Ace of Diamonds");
                }
                if( 26 <= j && j < 39){
                    str[j] = String.format("%s of Hearts", Integer.toString(j+2-26));
                    if (j == 35) str[j] = String.format("Jack of Hearts");
                    if (j == 36) str[j] = String.format("Queen of Hearts");
                    if (j == 37) str[j] = String.format("King of Hearts");
                    if (j == 38) str[j] = String.format("Ace of Hearts");
                }
                if( 39 <= j && j < 52){
                    str[j] = String.format("%s of Spades", Integer.toString(j+2-39));
                    if (j == 48) str[j] = String.format("Jack of Spades");
                    if (j == 49) str[j] = String.format("Queen of Spades");
                    if (j == 50) str[j] = String.format("King of Spades");
                    if (j == 51) str[j] = String.format("Ace of Spades");
                }
            }
					savestr = str.clone();
            
            int t = input.nextInt();
            int[][] swap = new int[100][52];
            int[] temp = new int[52];

            for (int j2 = 0; j2 < t; j2++) {
               
                for (int j = 0; j < 52; j++) {
                    temp[j] = input.nextInt();
                    swap[j2][j] = temp[j];                    
                }
            }
           input.nextLine();
            while(input.hasNextLine()){
                String numSwap = input.nextLine();
                if (numSwap.equals("")) {
                    break;
                }
                for (int j3 = 0; j3 < 52; j3++) {
                    savestr[j3] = str[swap[Integer.parseInt(numSwap)-1][j3]-1];
                }
							str = savestr.clone();
            }
           

            for (int j = 0; j < str.length; j++) {
                System.out.println(savestr[j]);
            }
					System.out.println();
        }
	}
}

