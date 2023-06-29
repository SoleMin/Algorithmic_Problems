import java.util.Scanner;


public class A_IQTest {

    static int n;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        
        int[] nums = new int[n];
        
        for (int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
        }
        
        
        int ei = -1;
        int oi = -1;
        int ecnt = 0;
        int ocnt = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] % 2 == 0){
                ei = i;
                ecnt++;
            }else{
                oi = i;
                ocnt++;
            }
        }
        if(ecnt == 1){
            System.out.println(ei+1);
        }else{
            System.out.println(oi+1);
        }
    }

}
