import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);		
		
		final double[] money_spent = new double[1000];	
		
		double[] all_money_spent = new double[1000];
		double[] each_money_spent = new double[1000];
		double[] money_exchange = new double[1000];
		
		double[] result = new double[1000];
		
		int n;
		int count = 0;
		while((n = sc.nextInt()) > 0)
		{
			if(n > 1000)
				break;		
			
			for(int i = 0; i < n; i++)
			{
				double input;
				input = sc.nextDouble();
				if(input > 10000.00)
					break;
				money_spent[i] = input;
				all_money_spent[count] += money_spent[i];
			}		
			
			each_money_spent[count] = all_money_spent[count] / (double)n;
			
			for(int i = 0; i < n; i++)
			{
				money_exchange[count] = Math.abs(money_spent[i] - each_money_spent[count]);
				result[count] += (int)(money_exchange[count]*100);
			}
			
			result[count] /= 2;
			count++;
		}
		sc.close();
		
		System.out.println();
		
		for(int i = 0; i < count; i++)
		{
			System.out.printf("$%.2f\n", result[i]/100.0);
		}
	}
}