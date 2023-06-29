import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String [] args){
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        int a=in.nextInt();
        int b=in.nextInt();
        int []deals=new int[n];
        for(int i=0; i<n; i++){
            deals[i]=in.nextInt();
        }
        Arrays.sort(deals);
        System.out.println(deals[b]-deals[b-1]);
    }
}
