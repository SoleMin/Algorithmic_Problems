import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class Main {
	public static int fourdown(int peo[], int n){
		int sum = 0;
		if(n == 1)
			sum += peo[0];
		else if(n ==2)
			sum += peo[1];
		else if(n==3){
			sum += peo[2]+peo[0]+peo[1];
		}
			return sum;
	}
	public static int fourup(int peo[], int n){
		
		/**
		내가 이해하기 위해서 적는 주석
	1)사람이 4명있다고 가정
		1. 먼저 빠른 두명을 보냄 frist, second    ->second
		2. 그다음 first가 돌아옴     ->first
		3. 느린 두명을 보냄 Sback, back  ->back
		4. 두번째로 빠른사람이 돌아옴 ->second
		
		5. first와 second를 보냄    -> second
		 사람이 5명이면 제일 느린 두명을 보내면 peo[0],peo[1],peo[2]만 남음 ->이때 fourdown으로 
		 사람이 6명이면 제일 느린 두명을 보내면 peo[0], peo[1], peo[3], peo[4]가 남으니 가장 느린사람들을 갱신해줌
		 3개 남았을때는 fourdown으로 보내버림
	2)
		4명 일때 
		1. first와 Sback을 보냄 -> Sback 
		2. first 돌아옴 -> first
		3. fist와 back 보냄 -> back
		4. first 돌아옴 -> first
		5. first, second 보냄 -> second
		 Case가 두가지임
		 5명일때도 peo[0], ... peo[2]만 남음
		 6일때도 마찬가지
		*/
		
		// 처음 초기화
		int sum = 0;
		
		int first = peo[0];  // 가장 빠름 
		int second = peo[1]; //  두번째로 빠름
		int Sback = peo[n-2]; // 두번쨰로 느림
		int back = peo[n-1];  // 가장 느림
		
		int Case_1 = 2*second + back + first;
		int Case_2 = 2*first + back + Sback;
		
		if(Case_1  < Case_2){
			sum += Case_1;
		}
		else{
			sum += Case_2;
		}
		if((n-2) < 4){
			return (sum + fourdown(peo,n-2));
		}
		else
			return (sum+ fourup(peo, n-2));
		
	}
	public static void main(String[] args) throws Exception {
	
		Scanner input = new Scanner(System.in);
		
		int testCase= input.nextInt();
		
		for(int test = 0; test < testCase; test++){
			input.nextLine(); // 빈줄 입력
			
			
			int n = input.nextInt(); // 사람들 수
			int peo[] = new int[n];
			//사람들마다 다리를 건너는 시간
			for(int i =0; i < n ; i ++)
				peo[i] = input.nextInt();
			Arrays.sort(peo);  //정렬
			/**
			for(int i= 0; i <n; i++)
				System.out.print(peo[i] +" ");
			*/
			
			int sum = 0;
			/**
			n이 4보다 작은 경우에는 1가지 방법 밖에 없음
			*/
			if(n < 4){ 
				sum +=fourdown(peo, n);
			}
			else{
				sum += fourup(peo, n);
			}
		
			
			System.out.println(sum+"\n");
		}// for test
		
		
		input.close();
	}
}