import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double st[]; //학생
		int num[] = new int[100];
		
		int index = 0;
		int s = 0;
		
		double sum[] = new double[100];
		double dif[] = new double[100];
		double fin[] = new double[100];
		double result[] = new double[100];
		
		while(true) {
			num[index] = input.nextInt(); //num[index] == 학생 수
			if(num[index] == 0) break;
			
			st = new double[num[index]];
			
			for(int i = 0; i < num[index]; i++) { 
				st[i] = input.nextDouble();
				sum[s] += st[i];
			}
			result[s] = sum[s]/num[index];
			
			for(int i = 0; i < num[index]; i++) {
				if(st[i] >= result[s])
					dif[s] = st[i] - result[s];
				else
					dif[s] = result[s] - st[i];
				
				fin[s] += dif[s];
				fin[s] = (int)(fin[s]*100)*0.01;//버림
			}
			s++;
			index++;
		}
		for(int i = 0; i < s; i++) {
			System.out.println(String.format("$%.2f", fin[i]/2));
		}
		input.close();
	}
}