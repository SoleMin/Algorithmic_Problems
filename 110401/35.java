import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		/**중간 값 구하는 문제 최초 입력부터 최종 입력까지 중에서 중간값 -> 그냥 다 입력 받아서 1.횟수 중간 값은 안되나? 구하기**/
		/**이거 안되면 뭐 값 일일이 다 해봐야 하나?**?**/
		
		for(int i =0; i<n; i++) {
			String[] temp = input.nextLine().split(" ");
			int [] t = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
			int[] num = Arrays.copyOfRange(t,1,t.length);
			Arrays.sort(num);
			int result = 0;
			if(num.length%2 ==0) {
				result = num.length/2;
			}
			else {
				result = (num.length)/2;
			}
			int done =0;
			for(int j=0; j<num.length; j++) {
				int number = num[j] - num[result];
				if(number<0) {
					done += -(number);
				}
				else {
					done += number;
				}
			}
			System.out.println(done);
			/**System.out.println(num[result]);**/
		}
	}
}