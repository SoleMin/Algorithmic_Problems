
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DD {
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        long k=Long.parseLong(br.readLine());
        long ans=9*(int)Math.pow(10,0);
        int c=0;
        long start=0;
        while(k>ans) {
            c++;
            start=ans;
            ans+=9*(long)Math.pow(10,c)*(c+1);

        }
        long ms=(k-start-1)%(c+1);
        long a=(long)Math.pow(10,c)+(k-start-1)/(c+1);
        System.out.println((a+"").charAt((int)ms));
    }
}
