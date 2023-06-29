import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ProblemA {

	public static void main(String [] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num1,num2;
		if(n % 2 == 0){
			num1 = n / 2;
			if(num1 % 2 == 0){
				num2 = num1;
			}
			else{
				num1--;
				num2 = num1 + 2;
			}
		}
		else{
			num1 = 9;
			num2 = n - num1;
		}
		
		System.out.println(num1+" "+num2);
	}
}
