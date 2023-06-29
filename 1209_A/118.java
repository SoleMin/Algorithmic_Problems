import java.util.ArrayList;
import java.util.Scanner;

public class kosyaDetka {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < t; i++){
            arr.add( scan.nextInt());
        }

        int count = 0;

        while (arr.size() != 0){

            int min = Integer.MAX_VALUE;

            for(int i = 0; i < arr.size(); i++){
                int temp = arr.get(i);
                if( temp < min){
                    min = temp;
                }
            }


            for(int i = 0; i < arr.size(); i++){
                int temp = arr.get(i);
                if( temp % min == 0){
                    arr.remove(i);
                    i--;
                }
            }

            count++;
        }

        System.out.println(count);
    }
}
