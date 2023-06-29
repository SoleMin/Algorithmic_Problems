import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long K = Long.valueOf(br.readLine());
        long n = 0;
        long k = 0; //len * Math.pow(10, len) * 0.9;
        long len = 0;
        while(true){
            len++;
            long preK = k;
            long preN = n;
            k += len * Math.pow(10, len) * 0.9;
            n += Math.pow(10, len) * 0.9;
            if(K < k) {
                k = preK;
                n = preN;
                break;
            }
        }
        long step = len - 1;
        while(true){
            while(k <= K){
                long preK = k;
                long preN = n;
                if(step == 0){
                    k += len;
                    n++;
                }else{
                    k += len * Math.pow(10, step) * 0.9;
                    n += Math.pow(10, step) * 0.9;
                }
                if(k == K || (k >= K && k - K < len)){
                    //System.out.println(k);
                    //System.out.println(n);
                    String nStr = Long.toString(n);
                    System.out.println(nStr.charAt(nStr.length() - (int)(k-K) - 1));
                    return;
                }
                if(K < k){
                    k = preK;
                    n = preN;
                    break;
                }
            }
            step--;
        }
    }
}
