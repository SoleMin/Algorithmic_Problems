
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        int [] arr1 = new int [n];
        int [] arr2 = new int [m];
        String result = "";

        for(int i = 0; i < n; i++){
            int num1 = input.nextInt();
            arr1[i] = num1;
        }

        for(int i = 0; i < m; i++){
            int num2 = input.nextInt();
            arr2[i] = num2;
        }


        for(int i = 0; i < arr1.length; i++){

            for(int j = 0; j < arr2.length; j++){

                if(arr1[i] == arr2[j]){
                    result += String.valueOf(arr1[i]) + " ";

                }
            }
        }
        
        System.out.println(result);
    }
}
