import java.io.*;
import java.util.*;


public class Contest1_1{
    
    public static void main(String ar[]) throws Exception { 
        
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(buff.readLine());
        if(input==0){
            System.out.println("0 0 0");
        }else if(input==1){
            System.out.println("0 0 1");
        }else if(input==2){
            System.out.println("0 1 1");
        }else if(input==3){
            System.out.println("1 1 1");
        }else {
            int output[] = checkFibo(input);
            int get[] = checkFibo(output[1]);
            output[0] = get[1];
            output[1] = get[2];
            System.out.print(output[0]);
            System.out.print(" " + output[1]);
            System.out.println(" " + output[2]);    
        }
    }
    
    public static int[] checkFibo(int input){
        int output[] = new int[3];
        int fibo_1 = 0;
        int fibo_2 = 1;
        int temp = 0;
        while(fibo_2!=input){
            temp = fibo_2;
            output[1] = fibo_1;
            output[2] = fibo_2;
            fibo_2 += fibo_1;
            fibo_1 = temp;
        }
        return output;
    }   
}