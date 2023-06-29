import java.util.Scanner;

class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(true){
			int num = in.nextInt();
			if(num == 0 || num > 1000) break;
			
			int arr[] = new int[num];
			double sum = 0;
			for(int i = 0; i < num; i++){
				float new_f = in.nextFloat();
				arr[i] = (int)(new_f * 100);
				sum += (int)(new_f * 100);
			}
			
			int move_money = 0;
			double average = sum/num;
			for(int i = 0; i < num; i++){
				if(arr[i] > average) move_money += (arr[i] - average);
			}
			
			double d_move_money = move_money/100.0;
			System.out.printf("$%.2f%n",d_move_money);
		}
	}
}