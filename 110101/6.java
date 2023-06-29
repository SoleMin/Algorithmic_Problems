import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int min, max = 0;
		int count = 0;
		int originMax, originMin = 0;
		
		while(input.hasNextInt()){
			originMin = input.nextInt();
			originMax = input.nextInt();
			
			if((originMin > 0 && originMin <1000000) && (originMax > 0 && originMin < 1000000) ) {
	
			max = originMax;
			min = originMin;
			
			if(max < min) {
				int temp = 0;
				temp = min;
				min = max; 
				max = temp;
			}
		
			int lenght = (max-min) + 1;
		
			long[] numbers = new long[lenght];
			int[] cycle = new int[lenght];
		
			for(int i = 0; i < lenght; i++) {
				numbers[i] = min+i;
			}
		
			int j = 0;
			while(j < lenght) {
				
				if((numbers[j] == 1)) {
					count++;
					cycle[j] = count;
					j++;
					count = 0;
				}
				else if((numbers[j] % 2) == 0) {
					numbers[j] = numbers[j] / 2;
					count++;
				}
				
				else{
					numbers[j] = numbers[j] * 3 + 1;
					count++;
				}
				
			}
			int answer = cycle[0];
			for(int i = 1; i < lenght; i++) {
				if(answer < cycle[i]){
					int temp = 0;
					temp = cycle[i];
					cycle[i] = answer;
					answer = temp;
				}
			}
		
			System.out.println(originMin + " " + originMax + " " + answer);
			}
		}
	}
}