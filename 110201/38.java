import java.io.*;
import java.util.Scanner;
import java.lang.Math;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int present[] = new int[3000]; // 차 값이 이전에 나왔던 것인지 체크할때 쓰는 배열
		
		while(input.hasNext()){
			String s = input.nextLine();	// 개행문자 이슈를 피하기 위해 줄 단위로 입력받아 split
 			String [] arr2 = s.split(" ");
			int [] arr = new int[arr2.length]; 
			int jolly = 1;
			
			for(int i = 0; i<arr2.length; i++) // String 배열 int로 형변환
				arr[i] = Integer.parseInt(arr2[i]);
						
			int n = arr[0];
			
			if(n != 1){
				//n이 1인 경우 바로 Jolly. 아닐 경우 하단의 코드.
				for(int i = 1; i<=n; i++)
					present[i] = 0; // present배열 0으로 초기화

				for(int i = 1; i < n ; i++){ 
					int prev = arr[i];
					int curr = arr[i+1];
					int diff = Math.abs(curr-prev);

					if(diff <= 0 || diff >= n || (present[diff] != 0)){
						jolly = 0; // present 배열의 diff 자리가 차 있는 경우. 
						break;
					}

					present[diff] = 1;
					prev = curr;
				}
			}	
			if(jolly == 0)
				System.out.println("Not jolly");
			else
				System.out.println("Jolly");
		}
	}
}