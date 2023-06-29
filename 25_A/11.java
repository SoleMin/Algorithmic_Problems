
import java.util.Scanner;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int kisu = 0;
        int gusu = 0;
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
            if(nums[i] % 2 == 0)gusu++;
            if(nums[i] % 2 == 1)kisu++;
        }
        int ans = -1;
        if(gusu == 1){
            for(int i = 0 ; i < n ; i++){
                if(nums[i]%2 == 0){
                    ans = i+1;
                    break;
                }
            }
        }
        else{
            for(int i = 0 ; i < n ; i++){
                if(nums[i]%2 == 1){
                    ans = i+1;
                    break;
                }
            }
            
        }
        System.out.println(ans);
    }

}
