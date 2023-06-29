import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int c = input.nextInt();
		
		while(c > 0){
			
			int num = input.nextInt();
			int[] address = new int[num];
			
			for(int i =0; i < num; i++){
				address[i] = input.nextInt();
			}
			
			Arrays.sort(address);
			
			int bito = num/2;
			int sum = 0;
			
			for(int i =0; i<address.length; i++){
				int tmp = address[bito]-address[i];
				if(tmp < 0)
					tmp = -tmp;
				sum+= tmp;
			}
			System.out.println(sum);
			c--;
		}
	}
}