
import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<BigInteger> list = new ArrayList<>();

        BigInteger[] array = new BigInteger[10001];
        BigInteger exp = new BigInteger("1");

        array[0] = BigInteger.ZERO;
        int count = 1;
        for (int i = 1; i <= 10000;) {
            for (int j = count; i <= 10000 && j > 0; i++, j--)
               array[i] = array[i-1].add(exp);

            count++;
            exp = exp.shiftLeft(1);
        }

        while(input.hasNextLine()) {
           String n = input.nextLine();
           if(n.isEmpty()) break;
            list.add(array[Integer.valueOf(n)]);
           
        }
        for(int i = 0; i < list.size(); i++) {
           System.out.println(list.get(i));
        }
        
        input.close();
    }

}