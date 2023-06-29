import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			// Scanner sc = new Scanner(System.in);
			int num = 0;
			num = sc.nextInt();
			double [] money = new double[num];
			int [] t_money = new int[num];
			int[] t_arr = new int[num];
			int sum = 0;
			double avg = 0;
			double result = 0;
			int[] a = new int[num];
			double mod = 0;
			
			if(num ==0){
				break;
			}

			for(int i=0; i<money.length; i++){
				money[i] = sc.nextDouble();
				money[i] = (money[i]+0.005) * 100;
				t_money[i] = (int)Math.floor(money[i]);
			}
			
			t_arr = t_money;
			Arrays.sort(t_arr);
			
			for(int i=0; i<t_arr.length; i++){
				sum += t_arr[i];
			}
			avg = (int)((double)sum / (double)num);
			mod = sum % num;
			for(int i=0; i<t_arr.length; i++){
				a[i] = t_arr[i];
				a[i] = a[i] - (int)avg;
			}
			
			for(int i=0; i<a.length; i++){
				if(a[i] > 0){
					result += a[i];
					if(mod > 0)
						result -= 1;
				}
			}
			result /= 100;
			System.out.printf("$%.2f", result);
			System.out.printf("\n");
		}
	}
}
