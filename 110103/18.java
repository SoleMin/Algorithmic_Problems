import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(true){
			int n = input.nextInt();
			if (n==0)
				break;
			
			float sum=0;
			float[] a = new float[n];
			for (int i=0; i<n; i++){
				a[i]=input.nextFloat();
				sum+=a[i];
			}
			float avg=sum/n;
			float result=0.00f;
			for (int j=0; j<n; j++){
				float f =(float)(Math.floor((a[j]-avg)*100)/100.0);
				if (f>0) {
					result+=f;
				}
			}
			System.out.printf("$%.2f\n",result);
		}
		input.close();
	}
}