import java.math.BigInteger;
import java.util.*;

public class Main{
	static ArrayList<BigInteger> fiboArr = new ArrayList<>();
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		BigInteger a = new BigInteger("1");
		BigInteger b = new BigInteger("2");
		fiboArr.add(a);
		//먼저 fib의 리스트에 초기값 1을 넣어줌.
		//다음 값과 그 다음 값을 넣어준다 --> 메소드에 따라서 차례로 들어갈 것
		
		FibArray(b, a.add(b));
		int cnt = 0;
		BigInteger first;
		BigInteger last;
		
		while(sc.hasNextLine()){
			first = sc.nextBigInteger();
			last = sc.nextBigInteger();
			BigInteger zero = new BigInteger("0");
			
			//둘 다 0이면 탈출
			if(first.compareTo(zero) == 0 && last.compareTo(zero) == 0) break;
			
			int idx = 0;
			while(fiboArr.get(idx).compareTo(first) == -1) idx++;
			//fiboArr의 idx번째 인덱스를 가져와서 first와 비교한 다음에 idx번째 인덱스가 그보다 작다면
			//인덱스를 하나 더 증가하고
			//first보다 작으면 개수를 세려는 fibonacci 수의 범위에서 어긋나기 때문(first <= fib <= last)
			//first와 같거나 크고 last보다 작거나 같은 경우 검사할 것. 그 전에 cnt = 0 으로 초기화
			cnt = 0;
			
			while(fiboArr.get(idx).compareTo(last) == 0 || fiboArr.get(idx).compareTo(last) == -1){
				//마찬가지로 fiboArr의 idx번째와 last를 비교하는데 idx번째 인덱스의 수가 last보다 작거나 같다면 범위 내이므로 
				//count ++, idx++둘 다 필요
				cnt++;
				idx++;
			}
			System.out.println(cnt);
		}
	}
	static void FibArray(BigInteger firstNum, BigInteger secondNum){
		fiboArr.add(firstNum);//일단 firstnum 추가
		BigInteger lim = new BigInteger("10");
		lim = lim.pow(100);
		if(firstNum.compareTo(lim) == 0 || firstNum.compareTo(lim) == -1){
			//first가 lim보다 작거나 같으면
			FibArray(secondNum, firstNum.add(secondNum));
			//재귀로 이번엔 last를 넣고, lim 전까지는 계속 first + last넣고... 반복
			//시간 너무 많이 드니까 일부러 이렇게 arrayList에 저장해둔다
		}
	}
}