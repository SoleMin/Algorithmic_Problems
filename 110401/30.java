import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		int num= input.nextInt();
		
		for(int i=0; i<num; i++){
			int relN= input.nextInt();
			int[] relL = new int[relN];
			
			for(int j=0; j<relN; j++){
				relL[j] = input.nextInt();
			}
			
			int min = 99999999;
			
			for(int j=0; j<relN; j++){
				int loc = relL[j];
				int disSum=0;
				for(int k=0; k<relN; k++){
					disSum += Math.abs(loc-relL[k]);
				}
				if(min>disSum){
					min = disSum;
				}
			}
			System.out.println(min);
		}
	}
}