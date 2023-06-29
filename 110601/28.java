import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Fibonacci{
	
	private List<BigInteger> fiboList;
	private BigInteger maxValue;
	
	public Fibonacci(BigInteger maxValue){
		this.maxValue = maxValue;
		makeFiboList();
	}
	public int countFibo(BigInteger num_0, BigInteger num_1){
		int count = 0;
		
		for(int i=1; i<fiboList.size(); i++){
			BigInteger current = fiboList.get(i);
			if(current.compareTo(num_0)>= 0 && current.compareTo(num_1)<=0)
				count++;
			if(current.compareTo(num_1)> 0)
				return count;
		}
		return count;
	}
	private void makeFiboList(){
		  fiboList = new ArrayList<>();
		  fiboList.add(BigInteger.ONE);
		  fiboList.add(BigInteger.ONE);
		while(true){
			int lastIndex = fiboList.size()-1;
			BigInteger currentValue = fiboList.get(lastIndex).add(fiboList.get(lastIndex-1));
			
			if(currentValue.compareTo(maxValue)>0)
				break;
			else fiboList.add(currentValue);
		}
	}
}
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BigInteger num_0, num_1;
		
		String max = "1";
		for(int i=0; i<100; i++)
			max+= "0";
		BigInteger maxValue = new BigInteger(max);
		Fibonacci fibo = new Fibonacci(maxValue);
		
		while(true){
			num_0 = sc.nextBigInteger();
			num_1 = sc.nextBigInteger();
			
			if(num_0.equals(BigInteger.ZERO)&& num_1.equals(BigInteger.ZERO))
				break;
			
			System.out.println(fibo.countFibo(num_0, num_1));
			
		}
		sc.close();
	}
}