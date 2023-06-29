import java.util.Scanner;

public class A1177 {
    public static long exponential(long a, long b){
        long result = 1;
        for(int i=0;i<b;i++){
            result *= a;
        }
        return result;
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        long  k = scanner.nextLong();
        //int k =21;
        long sum = 0;
        long i=1;
        while(true){
            long interval = 9 * exponential(10,i-1) * i;
            if(sum + interval >= k){
                break;
            } else {
                i++;
                sum += interval;
            }
        }
        long t = k-sum;
        long targetNumber = exponential(10, i-1) + (t-1)/i;
        String s = "" + targetNumber;
        int hedef = (int)((t-1)%i);
        System.out.println(s.charAt(hedef));
    }
}
