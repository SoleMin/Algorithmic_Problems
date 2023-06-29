import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int c = input.nextInt();
		while(c > 0){
			System.out.println();
			int n = input.nextInt();
			int[] days = new int[n];
			int[] fines = new int[n];
			for(int i = 0; i < n; i++){
				days[i] = input.nextInt();
				fines[i] = input.nextInt();
			}
			double[] array = new double[n]; //fines/days
			for(int i = 0; i < n; i++){
				array[i] = (double)fines[i]/(double)days[i];
			}
			int max;
			for(int i = 0; i < n; i++){
				max = i;
				for(int j = 0; j < n; j++){
					if(array[j] > array[max]){
						max = j;
					}
				}
				System.out.print((max + 1) + " ");
				array[max] = -1;
			}
			System.out.println();
			c--;
		}
	}
}