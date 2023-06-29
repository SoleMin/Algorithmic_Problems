import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		while(true){
			
			double money=0,give=0,aver;
			int student = input.nextInt();
			double arr[]=new double[student];
			if(student==0){
				break;
			}
			for(int i=0;i<student;i++){
				arr[i]=input.nextDouble();
				money=money+arr[i];
			}
			aver=money/student;
			for(int i=0;i<student;i++){
				if(arr[i]>aver){
					double a = Math.floor((arr[i]-aver)*100)/100;
					give+=a;
				}
			
			}
			System.out.printf("$%.2f\n",give);
			
		}

	}
}