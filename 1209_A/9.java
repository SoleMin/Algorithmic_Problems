import java.util.Arrays;
import java.util.Scanner;

public class problemA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] numbs = new int[n];
        int[] smallest_color = new int[n];
        for(int i =  0; i < n;i++){
            numbs[i] = scan.nextInt();
        }
        Arrays.sort(numbs);
        int count = 0;
        for(int i =0; i < n; i++){
            for(int j=0; j <n;j++ ){
                if(smallest_color[j] == 0){
                    count++;
                    smallest_color[j] = numbs[i];
                    break;
                }
                if(numbs[i] % smallest_color[j] == 0){
                    break;
                }
            }
        }
        System.out.println(count);
    }
}