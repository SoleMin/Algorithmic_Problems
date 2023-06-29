import java.math.BigInteger;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner x = new Scanner(System.in);
		int Max=10000;
		BigInteger[] table = new BigInteger[10001];
		BigInteger value = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		int count=1;
		int j;
		table[0]=BigInteger.valueOf(0);
		for(int i=1;i<=Max;){
			j= count;
			while(i<=Max&&j>0){
				table[i]=table[i-1].add(value);
				i++;
				j--;
			}
			value=value.multiply(two);
			count++;
		}
		while(x.hasNext()){
			System.out.println(table[x.nextInt()]);
		}
		
	}
}