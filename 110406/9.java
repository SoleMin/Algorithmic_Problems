import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;


class Main {
	
	
	public static void solve(String[][]str, int[]cent, int size){
		/**
		size가 홀수면 일단 출력은 size/2이다.
		이미 정렬된 상태라 0과 1이 매치 2 와 3이 매치 만약 str[0][0]과 str[1][0]이 다르다면 str[0]은 버림
		*/
		int base_rate =100;
		int Mbase_rate =200;
		
		for(int i =0; i <size-1; i++){
			if(!str[i][0].equals(str[i+1][0])){
				// 예를들어 0과 1이 다르면 1과 2비교
				continue;
			}//if
			else{
				if(str[i][2].equals("enter")&&str[i+1][2].equals("exit")){
					String a1[] = str[i][1].split(":");
					String a2[] = str[i+1][1].split(":");
					//날짜와 시간중에서는 일과 시간만 가져오면됨
					int e1 = Integer.parseInt(str[i][3]); // 입구
					int e2 = Integer.parseInt(str[i+1][3]); //출구
					//System.out.println(Arrays.toString(a1)+" "+Arrays.toString(a2));
					//System.out.println(e1+" "+e2);
					int e3= e2-e1;
					int a1_t = Integer.parseInt(a1[2]);
					//(출구 -입구)*(str[i])
					if(e3 <0)
						e3 = -e3;
				
					
					float result = (e3*cent[a1_t])+base_rate+Mbase_rate;
						
					System.out.print(str[i][0] +" $");
					System.out.printf("%.2f\n",(result/100));
				}
			}
		}// for i
		
	}
	public static void main(String[] args) throws Exception {

		Scanner input = new Scanner(System.in);
		
		int testCase = input.nextInt();
		int cent[] = new int[24]; // 0부터 23까지 차례대로
		
		input.nextLine();
		
		for(int test =0; test<testCase; test++){
			ArrayList<String>list = new ArrayList<String>();
			
			for(int i =0; i < 24; i++)
				cent[i] = input.nextInt(); // 한시간 단위로 나타내는 24개의 정수
			input.nextLine(); //엔터
			
			while(input.hasNextLine()){
				String str= input.nextLine();
				if(str == null|| str.isEmpty())
					break;
				list.add(str);
			}
			
			list.sort(Comparator.naturalOrder()); //리스트로 만들어 정렬 
			//System.out.println(list); 
			
			String str[][] = new String[list.size()][4]; // 다시 나눔
			for(int i=0; i < list.size(); i++)
				str[i]= list.get(i).split(" ");
				
				solve(str, cent,list.size());
			
			/**
			for(int i =0; i <list.size(); i++){
				for(int j=0; j < 4; j++)
				System.out.print(str[i][j]+" ");
			System.out.println();
			}
			*/
			System.out.println();
		} //for test
		
		
		
	}
}