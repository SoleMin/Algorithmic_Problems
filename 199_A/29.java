import java.util.LinkedList;
import java.util.Scanner;

public class HexadecimalsTheorem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        LinkedList<Integer> result = new LinkedList<Integer>();
        int temp0 = 1;
        int temp1 = 1;
        int temp2 = 0;
        result.add(0);
        result.add(0);
        result.add(0);
        result.add(temp0);
        result.add(temp1);
        if (num == 2) {
            System.out.println(0 + " " + 1 + " " + 1);
        } else if (num == 0) {
            System.out.println(0 + " " + 0 + " " + 0);
        } else {
            while (temp2 < num) {
                temp2 = temp1 + temp0;
                result.add(temp2);
                temp0 = temp1;
                temp1 = temp2;
            }
            int length = result.size();
            System.out.println(result.get(length - 5) + " "
                    + result.get(length - 4) + " " + result.get(length - 2));
        }
    }

}
