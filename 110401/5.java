import java.io.*;
import java.util.*;


class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		for(int i=0; i<N; i++){
			int r = scanner.nextInt();
			int [] location = new int[r];
			
			for(int j=0; j<r;j++){
				location[j] = scanner.nextInt();
			}
			
			int min=100000;
			for(int j=0; j<r; j++){
				int stand = location[j];
				int dis=0;
				for(int k=0 ; k<r; k++){
					dis+= Math.abs(stand - location[k]);
				}
				if(min>dis)
					min=dis;
				
			}
			
			System.out.println(min);
		}
		
	}
}