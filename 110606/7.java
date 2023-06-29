import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] arr = new BigInteger[10002];
        arr[0]=BigInteger.ZERO;
        int count = 1;

        for(int i = 1;i <= 10000;){
            int j = count;
            BigInteger op = BigInteger.ONE.shiftLeft(count - 1);
            while(j-- > 0 && i <= 10000) {
                arr[i] = arr[i - 1].add(op);
                i++;
            }
            count++;
        }

        String input= br.readLine();

        while(input != null && input.length() != 0){
            int n = Integer.parseInt(input);
            System.out.println(arr[n]);
            input = br.readLine();
        }
    }
}
