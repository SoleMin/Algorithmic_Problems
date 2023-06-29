import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int n, numbers[], minus;
		boolean has[], jolly;
		
		while(sc.hasNextInt()) {
			n = sc.nextInt();
			numbers = new int[n];
			has = new boolean[n];
			jolly = true;
			
			numbers[0] = sc.nextInt();
			for(int i=1; i<n; i++) {
				numbers[i] = sc.nextInt();
				minus = Math.abs(numbers[i] - numbers[i-1]);
				
				if(minus < n) {
					if(has[minus] || minus==0) {
						jolly = false;
						break;
					}
					else
						has[minus] = true;
				}
				else {
					jolly = false;
					break;
				}
			}
			sc.nextLine();
			
			if(jolly)
				System.out.println("Jolly");
			else
				System.out.println("Not jolly");
		}
		
		sc.close();
	}
}