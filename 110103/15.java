import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		
		int n=0;

		Scanner input = new Scanner(System.in);
		while(true){
			double sum =0;
			double money=0;
			n = input.nextInt();
			
			if(n==0){
				break;
			}
			double m[] = new double[n];
			for(int i=0; i<n; i++){
				m[i]=input.nextDouble();
				sum += m[i];
			}
			sum = sum/n;
		
		for(int i=0;i<n; i++){
			if(m[i] < sum){
				money = money+(sum-m[i]);
			}
		}
		money = Math.floor(money*100)/100;
		System.out.printf("$%.2f\n",money);
	}
	}
}