import java.io.*;

import java.util.Scanner;

class Main {
	
	static void mergeSort(int start, int end, int[] array, int size) {
		int[] newArray = new int[size];
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid, array, size);
			mergeSort(mid+1, end, array, size);
			
			int p = start;
			int q = mid + 1;
			int idx = p;
			
			while ( p <= mid || q <= end) {
				if(q > end || (p <= mid && array[p] < array[q])) {
					newArray[idx++] = array[p++];
				}
				else {
					newArray[idx++] = array[q++];
				}
			}
			for(int i = start; i <= end; i++) {
				array[i] = newArray[i];
			}
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int size = 0;
		String answer = null;
		
		while(input.hasNextInt()) {
			int[] jolly = new int[3000];

			size = input.nextInt();
			
			for(int i = 0; i < size; i++) {
				jolly[i] = input.nextInt();
			}
			
			int[] compare = new int[size];
			
			for(int i = 0; i < size; i++) {
				compare[i] = Math.abs(jolly[i] - jolly[i+1]);
			}
			
			mergeSort(0, size - 1, compare, size);
			
			for(int i = 1; i < size - 1; i++) {
				if(compare[0] != 1) {
					answer = "Not jolly";
					break;
				}
				if(compare[i] - compare[i-1] == 1) {
					answer = "Jolly";
				}
				else {
					answer = "Not jolly";
				}
			}
			if(compare.length == 1) {
				answer = "Jolly";
			}
			System.out.println(answer);
		}
	}
}