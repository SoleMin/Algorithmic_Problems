import java.io.*;
import java.util.Scanner;
	
class Main {
	
	public static void swap(int s[], int i, int j){
		int temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
	public static int partition(int s[], int low, int high){
		int i, pivot, firsthigh;
		
		pivot = low;
		firsthigh = low;
		for(i = low; i <high; i++){
			//s[pivot]보다 작으면 firsthigh의 왼쪽으로
			if(s[i] < s[pivot]){
				swap(s, i, firsthigh);
				firsthigh++;
			}
		}
		//마지막에 pivot위치와 firsthigh위치랑 바꿈
		swap(s, pivot, firsthigh);
		return firsthigh;
		
	}
	public static void Quicksort(int not_sorted[],int low, int high){
		
		if(low<=high){
			int p = partition(not_sorted, low, high);
			Quicksort(not_sorted, low, p-1);
			//Quicksort(not_sorted, p+1, high);
		}
	}
	public static void main(String[] args) throws Exception {
	
		Scanner input = new Scanner(System.in);
		
		int testCase = input.nextInt();
	
		
		for(int test = 0; test < testCase; test++){
			int number = input.nextInt(); // 친척집의 수
			int sort [] = new int[number];
			
			//친적집 번지
			for(int i =0; i < number; i++){
				sort[i] = input.nextInt();
			}
			
			//퀵정렬 
		 Quicksort(sort, 0, number-1);
			/**
		for(int i =0; i <number; i++)
			System.out.print(sort[i]+" ");
			*/
			int median = sort[number/2];
			int sum =0;
			for(int i =0; i < number; i++){
				int a = sort[i]-median;
				if(a <0)
					a= -a;
				sum = sum+a;
			}
			System.out.println(sum);
			}
			
		input.close();
	}
}