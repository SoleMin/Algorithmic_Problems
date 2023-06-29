import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan= new Scanner(System.in);
		
		BigInteger[] bigI=new BigInteger[10001];
		BigInteger temp= new BigInteger("1");
		
		bigI[0]=BigInteger.ZERO;
		int count =1;
		for(int i=1;i<10001;){
			for(int j=count;i<10001&&j>0;i++,j--){
					bigI[i]=bigI[i-1].add(temp);
			}
				count++;
				temp=temp.shiftLeft(1);
		}
		while(scan.hasNext()){
				System.out.println(bigI[scan.nextInt()].toString());
		}
	}
}