import java.util.Arrays;
import java.lang.Math;
import java.util.Scanner;

class Main {
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNextInt()){	//입력값이 int 일때 true
		int n = scanner.nextInt();
		int[] arr = new int[n];
		int[] arr2 = new int[n-1];
		
		for(int i = 0; i < n; i++){	//배렬안에 n 만큼 저장
			arr[i] = scanner.nextInt();
		}
		for(int i = 0; i < n-1; i++){	//n-1배열에 두수의 차이를 잘대값으로 저장
			arr2[i] = Math.abs(arr[i+1] - arr[i]);
		}	
	  Arrays.sort(arr2); //정렬
			
			String st = "Jolly";
			
			for(int i = 0; i < arr2.length; i++){
				if(arr2[i] != i+1)
					st = "Not jolly";
			}
			System.out.println(st);
		}
	}
}