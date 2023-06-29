import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input=new Scanner(System.in);
	
		double ndiff=0,pdiff=0;
				double average,b;
		while(input.hasNextDouble()){
			b=input.nextDouble();
			int j=0;
			ndiff=0;
			pdiff=0;
			double min=0;
			if(b==0)
				break;
			double[]a=new double[1000];
			double sum=0;
			average=0;
			for(int i=0;i<b;i++){
				a[i]=input.nextDouble();
sum=sum+a[i];
			}
			average=sum/b;
			for (int k=0;k<b;k++){
				if(a[k]>average){
					pdiff=pdiff+(double)((a[k]-average)*100/100);
				}
				else{
					ndiff=ndiff+(double)((average-a[k])*100/100);
				}
			}
			min=0;
			if(pdiff>ndiff){
				min=ndiff;
			}
			else{
				min=pdiff;
			}
			
			System.out.print("$");
			double result=((int)(min*100)/100.0);
		System.out.printf("%.2f",result);
			System.out.println();
		}
	 }
}