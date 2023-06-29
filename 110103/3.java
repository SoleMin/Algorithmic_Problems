import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		double[] num= null;
		double sum=0;
		double avr=0;
		int i=0,j=0;
		int n=0;
		boolean check= true;
		
		while(input.hasNextLine()){
			String s= input.nextLine();
			if(check==true /*&&Integer.parseInt(s)>0 && Integer.parse(s)<=1000*/){
				if(Integer.parseInt(s)<0 || Integer.parseInt(s)>=1000)
					break;
				check=false;
				sum = 0;
				avr = 0;
				n = Integer.parseInt(s);
				num = new double[n];
			}else{
				if(Double.parseDouble(s)>10000.0)
					break;
				num[i] = Double.parseDouble(s);
				sum = sum + num[i];
				
				i++;
				if(i==n){//계산하는것도 넣기
					double p=0;
					double m=0;
					avr = Math.round((sum/(double)n)*100)/100.0;//버림
					//System.out.println(avr);
					for(j=0;j<n;j++){
						double k = num[j]-avr;
						if(k < 0){
							m= m +k;
						}else
							p=p+k;
					}
					if(p+m>0){
						if(m<0){
							m=-(m);
						}
						System.out.printf("$%.2f\n",m);
					}else{
						System.out.printf("$%.2f\n",p);
					}
					
					
					i=0;
					check=true;
				}
			}
		}
	}
}