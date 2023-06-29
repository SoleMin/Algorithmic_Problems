import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
class Main {
	static final double golden = ((1 + Math.sqrt(5)) / 2);
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		long num;
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		while((num = input.nextLong()) != 0){
			long sum = 0;
			map.put((long)1, (long)1);
			sum += map.get((long)1);
			if(num == 1)
				System.out.println(1);
			else{
				long i;
				for(i = 2; i <= num; i++){
					long temp = 1 + map.get((i - 1) + 1 - map.get(map.get(i - 1)));
					map.put(i, temp);
					sum += map.get(i);
					if(sum >= num)
						break;
				}
				System.out.println(i);
			}
		}
		input.close();
	}
}