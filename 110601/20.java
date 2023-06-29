import java.io.*;
import java.util.*;
import java.math.*;
class Main {

		
	public static void main(String[] args) throws Exception {
		
		Scanner input= new Scanner(System.in);
		
		while(true){
			BigInteger a=input.nextBigInteger();
			BigInteger b=input.nextBigInteger();
			if(BigInteger.ZERO.equals(a) && BigInteger.ZERO.equals(b)) //둘다 0이면 끝
				break;
			
			int result=Fib(a,b);
			System.out.println(result);
			
		}
	}
		public static int Fib(BigInteger a, BigInteger b){
			List<BigInteger> list=new ArrayList<>();
			list.add(BigInteger.ZERO);
			list.add(BigInteger.ONE);
			int count=0;
			while(true){
				int Index=list.size()-1;
				BigInteger current=list.get(Index).add(list.get(Index-1));
				//System.out.println("current:"+current+"count:"+count);
				list.add(current);
				if(current.compareTo(a)>=0 && current.compareTo(b)<=0){//a이상 b이하일때
					count++;}
				if(current.compareTo(b)>0)//b이상일때
					return count;
				
				//list.add(current);
			}
			
		}
		
		
		
	}
