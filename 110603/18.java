import java.util.*;
import java.math.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()){
			String numt = input.nextLine();
			BigInteger num = new BigInteger(numt);
			ArrayList<BigInteger> numList = new ArrayList<BigInteger>();
			
			BigInteger num1 = new BigInteger("2");
			BigInteger num2 = new BigInteger("5");
			BigInteger num3 = new BigInteger("13");
			
			numList.add(num1);
			numList.add(num2);
			numList.add(num3);
			
			BigInteger preprepre, prepre, pre;
			preprepre = num1;
			prepre = num2;
			pre = num3;
			
			BigInteger count = new BigInteger("0");
			BigInteger one = new BigInteger("1");
			
			if(num.compareTo(one) == 0)
				count = num1;
			else if(num.compareTo(one.add(one)) == 0)
				count = num2;
			else if(num.compareTo(one.add(one).add(one)) == 0)
				count = num3;
			else{
				BigInteger i = new BigInteger("3");
				while(true){
					if(i.compareTo(num) == 0)
						break;
					count = pre.add(pre).add(prepre).add(preprepre);
					preprepre = prepre;
					prepre = pre;
					pre = count;
					i = i.add(one);
				}
			}
			System.out.println(count);
		}
		input.close();
	}
}