import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HexTheorem {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(read.readLine());
        System.out.println("0 0 "+x);
    }
}
