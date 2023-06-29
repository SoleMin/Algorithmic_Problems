import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[] result = new int[10000000];
		
		while(sc.hasNext()){
			int n = sc.nextInt();
			if(n == 0)
				break;
			int tem = 1, sum = 0;
			for(int i = 1, count = 0; i < result.length; i++, count--){
				result[i] = tem;
				sum += tem;
				if(sum >= n){
					System.out.println(i);
					break;
				}
				if(count <= 0){
					tem++;
					if(tem == 2)
						count = 2;
					else
						count = result[tem];
				}
			}
		}
	}
}