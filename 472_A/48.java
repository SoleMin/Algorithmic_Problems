import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Problem1 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        long n=Long.parseLong(br.readLine());
        if(n%2==0){
            System.out.println(4+" "+(n-4));
        }
        else{
            System.out.println(9+" "+(n-9));
        }
        
    }

}
