import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
	Scanner scan = new Scanner(System.in);

		
		while(true){
		int pl = scan.nextInt();
		if(pl == 0) break;
		int[] pr = new int[pl];
		int[] fin = new int[pl];
		int sum = 0;
			
		for(int i=0;i<pl;i++) {
			pr[i] = (int)(scan.nextFloat()*100+ 0.1);
			sum += pr[i];
			}
		Arrays.sort(pr);
		int a = sum % pl;
		if(a > 0){
		for(int i = pl-1; i >= pl-a; i--){
			pr[i] = pr[i] - 1;
		}
		}
		int avg = sum/pl;
		for(int i = 0; i <pl;i++){
			if(pr[i]>avg){
				fin[i] = pr[i] - avg;
			} else{
				fin[i] = avg - pr[i];
			}
		}
		double pay = Arrays.stream(fin).sum()/2;
		System.out.printf("$%.2f",pay*0.01);
		System.out.println("");
	
	
	
	
	
	
		}
	
	}
}