
import java.util.Scanner;

public class HexadecimalTheorem {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int num = read.nextInt();
        int zero, one, two, three;
        zero = 0;
        one = 1;
        two = 1;
        three = 2;
        if(num == 0)
            System.out.println("0 0 0");
        else if(num == 1)
            System.out.println("0 0 1");
        else{
            while(num != three){
                zero = one;
                one = two;
                two = three;
                three = three + one;
            }
            System.out.println(zero + " " + one + " " + one);
        }
    }
}
