import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] arr = new BigInteger[1002];

        arr[0]=BigInteger.ONE;
        arr[1]=BigInteger.valueOf(2);
        arr[2]=BigInteger.valueOf(5);

        for(int i=3;i<arr.length;i++){
            arr[i] = arr[i - 1].multiply(BigInteger.TWO).add(arr[i - 2]).add(arr[i - 3]);
        }

        String input= br.readLine();

        while(input != null && input.length() != 0){
            int n = Integer.parseInt(input);
            System.out.println(arr[n]);
            input = br.readLine();
        }
    }
}
