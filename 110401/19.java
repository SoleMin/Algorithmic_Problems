import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int testCase = input.nextInt();
		
		while(testCase-- > 0) {
			int n = input.nextInt();
			int arr[] = new int[n];
			
			for(int k = 0; k < n; k++)
				arr[k] = input.nextInt();
			
			int i, j, pivot, temp;
			int left = 0;
			int right = n - 1;
			
			do {
				pivot = arr[left];
				i = left;
				j = right;
				while(i <= j) {
					while(i <= right && arr[i] <= pivot)
						i++;
					while(j > left && arr[j] >= pivot)
						j--;
					if(i < j) {
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
				arr[left] = arr[j];
				arr[j] = pivot;
				if(j < n / 2)
					left = j + 1;
				else
					right = j - 1;
			} while(j != n / 2);
			
			int sum = 0;
			for(i = 0; i < j; i++)
				sum += pivot - arr[i];
			for(i = j + 1; i < n; i++)
				sum += arr[i] - pivot;
			
			System.out.println(sum);
		}
		input.close();
	}
}