import java.math.BigInteger;
import java.util.Scanner;

public class Main{
	//배열 static으로 선언. 크기는 1 크게(idx를 편하게 쓰기 위해)
	static BigInteger[] dp = new BigInteger[1001];
	
	static int num;
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		//초기값 dp 배열에 저장한다.
		dp[0] = BigInteger.valueOf(1);
		dp[1] = BigInteger.valueOf(2);
		dp[2] = BigInteger.valueOf(5);
		dp[3] = BigInteger.valueOf(13);
		addToDp(4);
		
		while(sc.hasNextInt()){
			//num 입력 받고 한 줄씩 dp에 저장된 num번째 idx 출력
			int num = sc.nextInt();
			System.out.println(dp[num]);
		}
	}
	//이미 계산했던 것을 다시 계산하는 일을 피하고자 dp를 쓴다.
	static void addToDp(int a){
		//점근식 A(n) = A(n-1) * 2 + A(n-2) + A(n-3) 이용할 것
		for(int i = a ; i < 1001 ; i++){// 초기값 입력 받고 그대로 마지막까지
			BigInteger x = dp[i - 1].multiply(BigInteger.valueOf(2)).add(dp[i - 2]).add(dp[i - 3]);
			//A(n) = A(n-1) * 2 + A(n-2) + A(n-3)
			dp[i] = x;
		}
	}
}