import java.io.*;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		boolean checkPerson = false;
		int personCnt = 0;
		Double[] personPay = null;
		
		while(!(input = br.readLine()).equals("0")){
			
			double sum = 0;
			double result = 0;
			
			if(!checkPerson){
				personCnt = Integer.parseInt(input);
				personPay = new Double[personCnt];
				checkPerson = true;
			}
			
			for (int i = 0; i < personPay.length; i++){
				personPay[i] = Double.parseDouble(br.readLine());
				if(i==(personPay.length-1)){
					checkPerson = false;
					
				}
				sum += personPay[i];
			}
			Arrays.sort(personPay);
			double average = sum/personPay.length;
			
			for(int i =0; i < personPay.length; i++){
				if(personPay[i] < average)
					result += average - personPay[i];
				
			}
			System.out.printf("$%04.2f", Math.floor(result*100)/100.0);
			System.out.println();
			
		}
	}
}