import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		long num1,num2,countLength = 0;
		long saveCount =0;
		long temp,temp1;
		long a,b;
		
		while(input.hasNext()){
			num1 = input.nextInt();
			num2 = input.nextInt();
			saveCount = 0;
			
			a = num1;
			b = num2;
			
			if (num1>num2){
				temp = num1;
				num1 = num2;
				num2 = temp;
			}
			for(long i = num1; i<= num2; i++){
				temp1 = i;
				countLength = 1;
				while(true){
					countLength++;
					if (temp1 == 1) {
						break;
					}
					if ((temp1&1) == 0){
						temp1 = temp1>>1;
					}else{
						temp1 = temp1*3+1;
					}
					
					if(countLength > saveCount){
						saveCount = countLength;
					}
				}
			}
			System.out.println(a + " "+b+ " " + saveCount);
		}
	
	}
}