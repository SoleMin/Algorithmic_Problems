import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		long[] f = new long[10000000];
		long n, result, i = 0;
		int it, index, temp;
		
		n = input.nextLong();
		while(n != 0){
			f[1] = 1;
			f[2] = 2;
			temp = 2;
			index = 3;
			result =  3;
			
			for(it = 3; it < f.length; it++){
				i = it;
				f[it] = temp;
				result += temp;
				if(result >= n)
					break;
				if(it == index){
					temp++;
					index += f[temp];
				}
			}
	
			if(n <= 3){
				i = f[2];
				if(n == 1)
					i = f[1];
			}
		
			System.out.println(i);
			n = input.nextLong();
		}
	}
}