import java.util.Scanner;

class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		while(true){
			int n = input.nextInt();
			double average = 0;
			double result = 0;
			if(n == 0)
				break;
			double[] money = new double[n];
			for(int i = 0; i < n; i++){
				money[i] = input.nextDouble();
				average += money[i];
			}
			average /= n;
			
			for(int i = 0; i < n; i++){
				if(average > money[i])
					result += average - money[i];
			}
			result = Math.floor(result*100)/100;
			String s = String.format("$%.2f",result);
			System.out.println(s);
		}
	}
}