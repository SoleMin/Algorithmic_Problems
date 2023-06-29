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
		
		while(loopCount != stop) {
			int n = input.nextInt(); // 친척 집 개수
			int[] houses = new int[n];
			
			// 집 받기
			for(int i = 0; i < n; i++) {
				houses[i] = input.nextInt();
			}
			
			// 정렬하기
			mergeSort(0,n-1,houses,n);
			
			// 비토 집 찾기
			int vitoIndex = 0;
			if(n % 2 == 0) {
				vitoIndex = (n / 2)-1;
			}
			else {
				vitoIndex = ((n+1)/2)-1;
			}
			
			// 비토 집
			int vitoH = houses[vitoIndex];
			
			// 거리구하기
			int distence = 0;
			for(int i = 0; i < n; i++) {
				distence += Math.abs(houses[i]-vitoH);
			}
			
			System.out.println(distence);
			
			stop++;
		}

	}

}