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
			
			while (p <= mid || q <= end) {
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

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int loopCount = input.nextInt();
		int stop = 0;
		
		// 전체 루프
		while(stop != loopCount) {
			String trash = input.nextLine();
			
			// 사람들 시간 배열
			int n = input.nextInt();
			int[] time = new int[n];
			for(int i = 0; i < n; i++) {
				time[i] = input.nextInt();
			}
			
			// 배열 정렬
			mergeSort(0,n-1,time,n);
			
			// 정답
			int answer = 0;
			
			// 사람이 1명이라면
			if(n == 1) {
				answer = time[0];
			}
			// 사람이 2명이라면
			else if(n == 2) {
				answer = time[1];
			}
			else if(n == 3) {
				answer += time[1];
				answer += time[0];
				answer += time[n-1];
			}
			// 4부터
			else {
				int first = time[0];
				int secound = time[1];
				int checked = 0;
				
				answer += secound;
				int large = n-1;
				
				while(large != 1 && large != 2) {
					if(secound*2 <= first + time[large-1]) {
						answer += 2*secound + first + time[large];
					}
					else {
						answer += 2*first + time[large-1] + time[large];
					}
					large-=2;
				}
				if(large == 2) {
					answer += time[1] + time[0];
				}
			}
			stop++;
		
			System.out.println(answer);
			System.out.println("");
		}
	}

}
