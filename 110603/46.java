import java.io.*;
import java.util.*;
import java.math.*;
class Main {
	//f(n)=f(n-1)*f(1) + f(n-2) +f(n-3)  n>=4일때
	BigInteger c[]=new BigInteger[1001];
	
	public static void main(String[] args) throws Exception {
		List<BigInteger> f=new ArrayList<>();
		
		//f list에 1000까지의 결과 미리 넣어놓고 꺼내기
		//점화식 이기때문에 값때마다 구하는것보다 이게 더 효율적일거같음
		
		f.add(new BigInteger(""+0));
		f.add(new BigInteger(""+2));
		f.add(new BigInteger(""+5));
		f.add(new BigInteger(""+13));
		
		for(int i=4;i<1001;++i){
			f.add( f.get(i-1).add(f.get(i-1).add(f.get(i-2)).add(f.get(i-3))) );	
		}
		
		Scanner input=new Scanner(System.in);
		while(input.hasNext()){
			int number=input.nextInt();
			System.out.println(f.get(number));
		}
		
		
		

	}
}