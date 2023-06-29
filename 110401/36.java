import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int test_case = in.nextInt();
		in.nextLine();
		for(int i = 0; i < test_case; i++){
			
			int num = in.nextInt();
			int[] family = new int[num];
			for(int j = 0; j < num; j++){
				family[j] = in.nextInt();
			}
			in.nextLine();
			Arrays.sort(family);
			int result = 0;
			int mid = family[num/2];
			for(int j = 0; j < num; j++){
				if(family[j] > mid){
					result += (family[j] - mid);
				}
				else result += (mid - family[j]);
			}
			System.out.println(result);
		}
	}
}