import java.util.Scanner;
import java.util.Arrays;

class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()){
			short max = in.nextShort();
			long num[] = new long[max];
			String diff[] = new String[max-1];
			//Arrays.fill(diff,"-1");
			boolean pass = true;
			
			for(int i = 0; i < max; i++){
				num[i] = in.nextLong();
			}
			for(int i = 1; i < max; i++){
					//i와 i-1 번째의 차이를 절댓값과 문자열 타입으로 나타냄
				String new_diff = String.valueOf(Math.abs(num[i-1] - num[i]));
				if((Arrays.asList(diff).contains(new_diff) != true) && (Short.parseShort(new_diff) < max) && (Short.parseShort(new_diff) > 0)){
					diff[i-1] = new_diff;
				}
				else {
					pass = false;
					break;
				}
			
			}
			if(pass){
				System.out.println("Jolly");
			}
			else{
				System.out.println("Not jolly");
			}
		}
	}
}