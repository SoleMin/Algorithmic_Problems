import java.util.Scanner;
import java.math.BigInteger;

class Main {
	
	static BigInteger count[] = new BigInteger[1001];
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int here, n; //계산 위치 저장, 입력값
		
		count[1] = BigInteger.valueOf(2);
		count[2] = BigInteger.valueOf(5);
		count[3] = BigInteger.valueOf(13);
		here = 3;
		
		while(sc.hasNextInt()) {
			n = sc.nextInt();
			if(n > here) { here = setCount(here,n); }
			System.out.println(count[n]);
		}
		
		sc.close();
	}
	
	//count 계산
	static int setCount(int here, int n) {
		// (n) = (n-1)*2 + (n-2) + (n-3)
		// 하나 적을때 1또는4 추가, 2 적을때 2 추가, 3 적을때 3 추가
		BigInteger two = new BigInteger("2");
		for(int i=here+1; i<=n; i++) {
			count[i] = count[i-1].multiply(two);
			count[i] = count[i].add(count[i-2]);
			count[i] = count[i].add(count[i-3]);
		}
		return n;
	}
}