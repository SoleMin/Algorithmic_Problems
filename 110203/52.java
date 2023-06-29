import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int caseNumber = input.nextInt();
	for(int i = 0; i < caseNumber ; i++){
		int date = input.nextInt();
		int counter=0;
		int partyNumber = input.nextInt();
		int[] hartal = new int[partyNumber];
				
		for(int j = 0 ; j < partyNumber; j++){
			hartal[j] = input.nextInt();
		}
		
		for(int j = 1 ; j<=date ; j++){
			if(j%7 == 6 || j % 7 == 0)
				continue;
			for(int k =0; k <hartal.length; k++){
				if(j%hartal[k] == 0){
					counter++;
					break;
				}
			}
		}
		System.out.println(counter);
	}
	}
}