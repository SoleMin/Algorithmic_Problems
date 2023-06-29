import java.util.Scanner;

class Main {
	public static boolean is_zero(int[] arr){
		boolean judge = true;
		
		for (int i = 0; i < arr.length; i++){
			if (arr[i] != 0){
				judge = false;
				break;
			}
		}
		return judge;
	}
	
	public static boolean compare(int[] arr_1, int[] arr_2){
		boolean judge = true;
		
		for (int i = 0; i < arr_1.length; i++){
			if (arr_1[i] > arr_2[i]){
				break;
			}
			else if (arr_1[i] < arr_2[i]){
				judge = false;
			}
		}
		return judge;
	}
	
	public static int[] plus(int[] arr_1, int[] arr_2){
		int[] sum = new int[arr_1.length];
		
		for (int i = arr_1.length - 1; i >= 0; i--){
			if (arr_1[i] + arr_2[i] < 10)
				sum[i] = arr_1[i] + arr_2[i];
			else {
				sum[i] = arr_1[i] + arr_2[i] - 10;
				arr_1[i-1] += 1;
			}
		}
		return sum;
	}	
	
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		int max_size = 100;
		
		while (scan.hasNextLine()){
			
			int[] a_arr = new int[max_size + 1];
			int[] b_arr = new int[max_size + 1];
			
			String a = scan.next();
			String b = scan.next();
			
			for (int i = 0; i < a.length(); i++){
				a_arr[max_size - i] = Integer.parseInt(String.valueOf(a.charAt(a.length() - 1 - i)));
			}
			for (int i = 0; i < b.length(); i++){
				b_arr[max_size - i] = Integer.parseInt(String.valueOf(b.charAt(b.length() - 1 - i)));
			}
			
			if (is_zero(a_arr) && is_zero(b_arr))
				break;
			
			int[] first_f = new int[max_size + 1];
			int[] second_f = new int[max_size + 1];
			int[] third_f;
			int count = 0;
			
			first_f[max_size] = 1;
			second_f[max_size] = 2;
			
			if (compare(first_f, a_arr) && compare(b_arr, first_f))
				count += 1;
			
			if (compare(second_f, a_arr) && compare(b_arr, second_f))
				count += 1;
			
			while (true){
				third_f = plus(first_f, second_f);
				first_f = second_f;
				second_f = third_f;
				
				if (compare(third_f, a_arr) && compare(b_arr, third_f))
					count += 1;
				
				if (compare(third_f, b_arr))
					break;
			}
			System.out.println(count);
		}
	}
}