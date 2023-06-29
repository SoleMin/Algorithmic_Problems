import java.util.Scanner;

public class C_1523 {

	static Scanner input = new Scanner(System.in);
	static int n;

	public static void main(String[] args) {
		int t = input.nextInt();
		for(int test = 0; test < t; test++){
			n = input.nextInt();
			int num = input.nextInt();
			if(num == 1){
				n--;
				recur("");
			}else{
				System.out.println("ERROR");
			}
		}
	}
	
	public static int recur(String before){
		int num = 1;
		System.out.println(before + num);
		while(n > 0){
			int val = input.nextInt();
			n--;
			if(val == 1){
				val = recur(before + num + ".");
			}
			if(val == num + 1){
				num++;
				System.out.println(before + num);
			}else{
				return val;
			}
		}
		return -1;
	}

}
