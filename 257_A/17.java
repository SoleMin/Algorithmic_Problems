import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
        int[] num = new int[n];
        for(int i = 0 ; i < n ; i++){
        	num[i] = input.nextInt();
        }
        
        System.out.println(str(n,m,k,num));
    }

	static int str(int n,int m,int k,int[] num){
		Arrays.sort(num);
		int total = k;
		int count = 0;
		while(k < m){
			if(count == num.length)return -1;
			k += num[num.length-count-1]-1;
			count++;
		}
		return count;
	}
	
}