

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        double[] arr = new double[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int count = 2;
        for(int i = 0; i < n-1; i++){
            double temp = (arr[i+1] - arr[i]) / 2;
            if(temp > d){
                count += 2;
            }else if(temp == d){
                count++;
            }
        }
        System.out.println(count);
    }
}
				  	 	   		  		 		 			    	