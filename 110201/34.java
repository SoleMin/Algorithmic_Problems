import java.util.Scanner;
import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			int num = sc.nextInt();
			int[] arr = new int[num];
			
			HashSet<Integer> set = new HashSet<>();
			boolean jollyJump = true;
			
			for(int i = 0 ; i < num ; i++){
				int input = sc.nextInt();
				arr[i] = input;
			}
			for(int i = 1 ; i < num ; i++){
				int toAdd = (arr[i] - arr[i-1]);
				if(toAdd < 0) toAdd = -toAdd;
				set.add(toAdd);
			}
			if(set.size() < (num - 1)) jollyJump = false;
			
			for(int i = 1 ; i < num ; i++){
				if(!(set.contains(i))) jollyJump = false;
			}
			if(jollyJump == true) System.out.println("Jolly");
			else System.out.println("Not jolly");
		}
	}
}