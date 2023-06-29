import java.io.*;

import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int loopCount = input.nextInt();
		int q = 0;
		while(true) {
			if(q == loopCount) {break;}
			int novelNumber = input.nextInt();
			int personNumber = input.nextInt();
			int[] delNumber = new int[novelNumber];
			String trash = input.nextLine();
			String[] names = new String[novelNumber];
			String[] splitNames = null;
			String trainNames = "";
			int[] endCount = new int[novelNumber+1];
			String[] spaceEmpty = new String[personNumber];
			String[] nonSpaceEmpty = new String[personNumber];
			String[] printNumber = new String[personNumber];
			
			for(int i = 0; i < novelNumber; i++){
				names[i] = input.nextLine();
			}
			for(int i = 0; i < personNumber; i++){
				spaceEmpty[i] = input.nextLine();
			}
			for(int i = 0; i < novelNumber; i++){
				delNumber[i] = names[i].indexOf(":");
			}
			for(int i = 0; i < novelNumber; i++){
				names[i] = names[i].substring(0, delNumber[i]+1);
				names[i] = names[i].replaceAll(":",",END.,");
			}
			for(int i = 0; i < novelNumber; i++) {
				trainNames += names[i];
			}
			splitNames = trainNames.split("\\.,");
			
			int[] answerCount = new int[splitNames.length];
			int[] checkCount = new int[splitNames.length];
			int[] section = new int[splitNames.length];
			
			for(int i = 0; i < splitNames.length; i++){
				splitNames[i] = splitNames[i].replaceAll(" ", "");
			}
			
			for(int i = 0; i < personNumber; i++) {
				nonSpaceEmpty[i] = spaceEmpty[i].replaceAll(" ","");
			}
			for(int i = 0; i < splitNames.length; i++) {
				if(splitNames[i].equals("Erdos,P")) {
					answerCount[i] = 100;
					checkCount[i] = 1;
				}
				else if(splitNames[i].equals("END")) {
					answerCount[i] = -10;
					checkCount[i] = 1;
				}
			}
			int k = 0;
			endCount[0] = 0;
			for(int i = 0; i < splitNames.length; i++) {
				if(answerCount[i] == -10){
					endCount[k+1] = i;
					k++;
				}
			}
			int id = 0;
			for(int i = endCount[id]; i < splitNames.length; i++){
				if(answerCount[i] == 100) {
					for(int j = endCount[id]; j < endCount[id+1]; j++) {
						if(checkCount[j] == 0 && answerCount[j] != 100 && answerCount[j] != -10){
							answerCount[j]++;
							checkCount[j]++;
						}
					}
					id++;
				}
			}
			
			int sectionCheck = 1;
			for(int i = 0; i < splitNames.length; i++){
				section[i] = sectionCheck;
				if(answerCount[i] == -10){
					sectionCheck++;
				}
			}
			
			int t = 0;
			int number = 1;
			int stop = 0;
			while(true) {
				if(stop == splitNames.length){
					break;
				}
				stop++;
				for(int i = 0; i < splitNames.length; i++){
					for(int j = i+1; j < splitNames.length; j++) {
						if(splitNames[i].equals(splitNames[j])){
							answerCount[j] = answerCount[i];
							checkCount[j] = checkCount[i];
						}
					}
				} 
				for(int i = 0; i < splitNames.length; i++){
					if(answerCount[i] == number) {
						for(int j = 0; j < splitNames.length; j++) {
							if(answerCount[j] == 0 && checkCount[j] == 0 && section[j] == section[i]){
								answerCount[j] = number+1;
								checkCount[j]++;
							}
						}
					}
				}
				number++;
			}
			for(int i = 0; i < splitNames.length; i++){
				splitNames[i]=splitNames[i]+".";
			}
			for(int i = 0; i < personNumber; i++){
				for(int j = 0; j < splitNames.length; j++){
					if(nonSpaceEmpty[i].equals(splitNames[j])){
						printNumber[i] = Integer.toString(answerCount[j]);
						if(answerCount[j] == 0){
							printNumber[i] = "infinity";
						}
						break;
					}
				}
			} 
			System.out.println("Scenario "+(q+1));
			for(int i = 0; i < personNumber; i++){
				if(nonSpaceEmpty[i].equals("Erdos,P")){
					printNumber[i] = "0";
				}
				System.out.println(spaceEmpty[i]+" "+printNumber[i]);
			}
			q++;
		}
	}
}