import java.io.*;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int loopCount = input.nextInt();
		String trash = input.nextLine();
		int stop = 0;
		
		while(true){
			if(stop == loopCount){
				break;
			}
			
			int ruleCount = input.nextInt();
			String[] allShape = new String[52];
			String[] shape = {"Clubs", "Diamonds", "Hearts", "Spades"};
			
			class cardShape {
				int cardShapeNumber;
				String cardShape;
				
				cardShape(int a, String b){
					cardShapeNumber = a;
					cardShape = b;
				}
			}
			
			int[] test = new int[52];
			int[] rule = new int[52];
			for(int i = 0; i < 52; i++){
				rule[i] = i+1;
				test[i] = i+1;
			}
			
			cardShape[] cs = new cardShape[52];
			for(int i = 0; i < 52; i++){
				cs[i] = new cardShape(i+1, "");
			}
			
			for(int i = 0; i < 4; i++){
				for(int j = 0; j < 13; j++) {
					if(j == 9) {
						cs[j+(i*13)].cardShape = "Jack" + " of " + shape[i];
					}
					else if(j == 10){
						cs[j+(i*13)].cardShape = "Queen" + " of " + shape[i];
					}
					else if(j == 11){
						cs[j+(i*13)].cardShape = "King" + " of " + shape[i];
					}
					else if(j == 12) {
						cs[j+(i*13)].cardShape = "Ace" + " of " + shape[i];
					}
					else {
						cs[j+(i*13)].cardShape = j+2 + " of " + shape[i];
					}
				}
			}
			
			int[][] rulesHouse = new int[ruleCount][52];
			int[] ruleIndex = new int[ruleCount];
			for(int i = 0; i < ruleCount; i++){
				ruleIndex[i] = i;
				for(int j = 0; j < 52; j++) {
					rulesHouse[i][j] = input.nextInt();
				}
			}

			String a = "";
			String[] number = new String[1000];
			int m = 0;
			while(input.hasNextLine()){
				a = input.nextLine();
				if(a.equals("") && a.length() == 0 && m > 0){
					break;
				} 
				number[m] = a;
				m++;
			}
			
			int[] ruleNumber = new int[m-1];
			for(int i = 0; i < m-1; i++){
					ruleNumber[i] = Integer.parseInt(number[i+1])-1;
			}

			for(int i = 0; i < m-1; i++){
						for(int k = 0; k < 52; k++){
								int temp = 0;
								temp = test[rulesHouse[ruleNumber[i]][k]-1];
								test[rulesHouse[ruleNumber[i]][k]-1] = rule[k];
								rule[k] = temp;
						}
				for(int j = 0; j < 52; j++){
					test[j] = rule[j];
				}
					}
	
			for(int i = 0; i < 52; i++){
				for(int j = 0; j < 52; j++){
					if(rule[i] == cs[j].cardShapeNumber){
						System.out.println(cs[j].cardShape);
					}
				}
			}
			 System.out.println("");
			stop++;
		}

	}
}