import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;

/**
1= 1번, 2는 2번, 3은 2번, 4는, 3번 5는 3번, 6은 3번 7은 4번
i =3, j =2, sum =3(1번째 + 2번째);
i = 3 부터 시작하여  sum 에는 j의 값을 계속 더함
 i =3 의 값이 2이기 때문에 총 두번 i의 값을 넣어줘야 함
 j는 그냥 1만큼 증가하고 증가하는 기준은 

*/

class Main {
	public static void main(String[] args) throws Exception {
	
		Scanner input = new Scanner(System.in);
		int n [] = new int [100000];
	
		while(true){
			int number = input.nextInt();
			
			if(number == 0)
				break;
			
			n[1] =1;
			n[2] =2;
			
			int sum =3;// n[1] + n[2]
			if(number == 1){
				System.out.println(n[1]);
				continue;
			}
			else if (number <=3){
				System.out.println(n[2]);
				continue;
			}
				
			int i =3, j =2,result = n[2] ,count =2;
			while(true){
				n[i] = j;
				sum += j; // sum 이 number보다 넘으면 종료
				if(sum >= number)
					break;
			  if(count == result){
					j++;
					count = 1;
					result=n[j];
				}
				else
					count++;
				
				i++;
			}
			
			System.out.println(i);
			
			
		}
		
		input.close();
	}
}