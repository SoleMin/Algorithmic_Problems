import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.ArrayList;
class Main {
	static String n;
	static int count;
	static int[] array = {1, 2, 3, 1};
	static boolean isTwoMore = false;
	static ArrayList<BigInteger> list = new ArrayList<BigInteger>();
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()){
			n = input.nextLine();
			if(n.equals(""))
				break;
			int num = Integer.parseInt(n);
			for(int j = 1; j < 4; j++){
				count = 0;
				for(int i = 0; i < array.length; i++){
					if(i >= 2)
						isTwoMore = true;
					func(j, 0, i + 1);
					isTwoMore = false;
				}
				list.add(new BigInteger("" + count));
			}
			for(int i = 4; i <= 1000; i++)
				list.add(list.get(i - 2).add(list.get(i - 2).add(list.get(i - 3)).add(list.get(i - 4))));
			System.out.println(list.get(num - 1));
		}
		input.close();
	}
	static void func(int num, int sum, int len){
		if(len == 1){
			for(int i = 0; i < array.length; i++){
				if(array[i] == num - sum)
					count++;
			}
		}
		if(len >= 2 && len <= num){
			for(int i = 0; i < array.length; i++){
				if(isTwoMore)
					sum += array[i];
				else
					sum = array[i];
				func(num, sum, len - 1);
				if(isTwoMore)
					sum -= array[i];
			}
		}
	}
}