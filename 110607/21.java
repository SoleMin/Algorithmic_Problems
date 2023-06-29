import java.io.*;
import java.util.*;
import java.math.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
			String s = input.nextLine();
			
			if(s.equals("0"))
				break;
			
			int n = Integer.parseInt(s);
			
			BigInteger arr[] = new BigInteger[n * 4];
			
			if(n > 3) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(1);
				list.add(2);
				list.add(2);
				arr[0] = BigInteger.valueOf(1);
				arr[1] = BigInteger.valueOf(2);
				arr[2] = BigInteger.valueOf(2);
				arr[3] = BigInteger.valueOf(3);
				arr[4] = BigInteger.valueOf(3);
				BigInteger num = BigInteger.valueOf(4);
				
				int index = 5;
				int count = 0;
				
				while(true) {
					if(num.compareTo(BigInteger.valueOf(n + 1)) == 0) {
						System.out.println(count);
						break;
					}
					
					count = arr[num.intValue() - 1].intValue();
					if(list.size() + n > index) {
						for(int i = 0; i < count; i++)
							arr[index++] = num;
					}
					list.add(count);
					list.remove(0);
					num = num.add(BigInteger.ONE);
				}
			}
			else if(n == 2 || n == 3)
				System.out.println(2);
			else
				System.out.println(1);
		}
	}
}