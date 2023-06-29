import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);

		long firstNum , secondNum , maxNum, minNum;
		long num ,counter, result=0;
		while(input.hasNextLong()){
			firstNum = input.nextLong();
			secondNum = input.nextLong();
			
			if(firstNum > secondNum){
				maxNum = firstNum;
				minNum = secondNum;
			}else {
				maxNum = secondNum;
				minNum = firstNum;
			}
	
			
			for(long i = minNum ; i<= maxNum ; i++){
				counter = 1;
				num = i;
				while(num!=1){
					if((num%2)==1){
						num = 3*num+1;
						counter++;
					}	
					while((num%2)==0){
						num/=2;
						counter++;
					}
				}
				if(counter >= result) result = counter;
			}
				System.out.printf("%d %d %d\n" , firstNum, secondNum, result);
				result = 0;
			}
			
		}
}