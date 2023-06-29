import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()){
			int studentNum = input.nextInt();
			Integer[] price = new Integer[studentNum];
			
			int sum = 0;
			int eveg = 0;
			int priceSum = 0;
			int cent = 0;
			
			if(studentNum == 0)
				break;
			
			for(int i=0; i<studentNum; i++){
				price[i] = (int)(input.nextFloat()*100);
				sum = sum + price[i];
			}
			
			eveg = sum / studentNum;
			cent = sum % studentNum;
			
			Arrays.sort(price, Collections.reverseOrder());
			
			int[] mustPrice = new int[studentNum];
			Arrays.fill(mustPrice, eveg);
			
			for(int i=0; i<cent;  i++){
				mustPrice[i]++;
			}
			
			for(int i=0; i<studentNum; i++){
				if(price[i] > mustPrice[i]){
					priceSum = priceSum + (price[i] - mustPrice[i]);
				}
				if(price[i] < mustPrice[i]){
					priceSum = priceSum + (mustPrice[i] - price[i]);
				}
			}
			
			System.out.printf("$%.2f", (float)priceSum/200);
			System.out.println();
		}
		input.close();
	}
}