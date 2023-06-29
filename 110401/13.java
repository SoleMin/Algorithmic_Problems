import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int c = input.nextInt();
		while(c > 0){
			int n = input.nextInt(); //친척집의 수
			int[] array = new int[n]; //친척집의 번지수 배열
			for(int i = 0; i < n; i++)
				array[i] = input.nextInt();
			
			int min;
			int temp;
			for(int i = 0; i < n; i++){
				min = i;
				for(int j = i+1; j < n; j++){
					if(array[j] < array[min])
						min = j;
				}
				temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
			
			int mid = array[(int)(n/2)];
			int result = 0;
			for(int i = 0; i < n; i++){
				if(array[i] < mid)
					result += (mid - array[i]);
				else if(array[i] > mid)
					result += (array[i] - mid);
			}
			System.out.println(result);
			
			c--;
		}
	}
}