import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CodeForce275A {
    
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(in.readLine());
        long l = Long.parseLong(token.nextToken());
        long r = Long.parseLong(token.nextToken());
        
        
        if(r-l<2) {
            System.out.println(-1);
            return;
        }
        if(l%2==1&&r-l<3) {
            System.out.println(-1);
            return;
        }
        if(l%2==0) {
            System.out.println(l+" "+(l+1)+" "+(l+2));
            return;
        }
        if(l%2==1) {
            System.out.println((l+1)+" "+(l+2)+" "+(l+3));
        }
    }

}