import java.util.HashSet;
import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i = 0 ; i < tc ; i++){
			int days = sc.nextInt();
			int parties = sc.nextInt();
			int[] arr = new int[parties];
			for(int j = 0 ; j < parties ; j++){
				int term = sc.nextInt();
				arr[j] = term;
			}
			HashSet<Integer> set = new HashSet<>();
			
			for(int m = 0 ; m < arr.length ; m++){
				for(int k = 1 ; k <= days ; k++){
					if((arr[m] * k) <= days) set.add(arr[m] * k);
				}
				
			}
			for(int l = 0 ; l <= days ; l++){
				if(set.contains((6 + (7 * l)))) set.remove(6 + (7 * l));
				if(set.contains((7 + (7 * l)))) set.remove((7 + (7 * l)));
			}
			System.out.println(set.size());
		}
	}
}