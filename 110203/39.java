import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
	Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();

		
		for(int i=0; i< num ; i++){
			int count = 0;
			int day = scan.nextInt();
			int p = scan.nextInt();
		  int pday[] = new int[3650];
			Arrays.fill(pday, 0);
			
			for(int j = 0 ; j < p ; j++){
				int	h = scan.nextInt();
				for(int k = 1 ; h * (k-1) + h <= day; k++ ){
					if((h * (k-1) + h)%7 == 6 || (h * (k-1) + h)%7 == 0 ){
						continue;
					}
					pday[h * (k-1) + h] = 1;
				}	
			}
				for(int l = 0; l < pday.length ; l++){
					if(pday[l]==1) count++; 
				}

			
			System.out.println(count);
		}
	
	
	
	
	
	
	}
}