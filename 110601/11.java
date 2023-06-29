import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BigInteger[] bigInt = new BigInteger[1000];
        bigInt[0] = BigInteger.valueOf(1);
        bigInt[1] = BigInteger.valueOf(1);
        bigInt[2] = BigInteger.valueOf(2); 
         for (int i = 3; i < 1000; i++) {
            bigInt[i] = bigInt[i-1].add(bigInt[i-2]);
         }

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            if(s.equals("0 0")){
                break;
            }

            String[] temp = s.split(" ");
            BigInteger x = new BigInteger(temp[0]);
            BigInteger y = new BigInteger(temp[1]);
            int count = 0;
            try{
                if (Integer.parseInt(temp[0]) == 1){
                    count--;
                }
                if (Integer.parseInt(temp[1]) == 1){
                    count--;
                }
            } catch (Exception e){

            }

            for (int i = 0; i < bigInt.length; i++) {
                if (bigInt[i].compareTo(x) == 1 && bigInt[i].compareTo(y) == -1){
                    count++;
                }
                if (bigInt[i].compareTo(x) == 0){
                    count++;
                }
                if (bigInt[i].compareTo(y) == 0){
                    count++;
                }
            }
					
         if (count == 0){
                System.out.println(0);
            } else {
                if (temp[0].equals(temp[1])){
                    System.out.println(1);
                } else{
                    System.out.println(count);
                }
            }
        }
    }
}
