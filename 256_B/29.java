import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main{

    public static long howMany(long n, long x, long y, long s){
        long res = 0;
        int cnt = 0;
        long[] px = new long[9];
        long[] py = new long[9];
        if(x - s < 1){
            px[cnt] = 1;
            py[cnt++] = y-x+s+1 <= n ? y-x+s+1 : n;
            px[cnt] = 1;
            py[cnt++] = x+y-s-1 > 0? x+y-s-1: 1;
            res += 6;
        }else{
            px[cnt] = x-s;
            py[cnt++] = y;
            res += 2;
        }
        
        if(y - s < 1){
            py[cnt] = 1;
            px[cnt++] = x+y-s-1 > 0 ? x+y-s-1 : 1;
            py[cnt] = 1;
            px[cnt++] = x-(y-s)+1 <= n ? x-y+s+1: n;
            res += 6;
        }else{
            px[cnt] = x;
            py[cnt++] = y-s;
            res += 2;
        }
        
        if(x + s > n){
            px[cnt] = n;
            py[cnt++] = y-(x+s)+n > 0 ? y-(x+s)+n : 1;
            px[cnt] = n;
            py[cnt++] = x+s+y - n <= n ? x+s+y-n : n;
            res += 6;
        }else{
            px[cnt] = x+s;
            py[cnt++] = y;
            res += 2;
        }
        
        if(y + s > n){
            py[cnt] = n;
            px[cnt++] = x+y+s-n <= n? x+y+s-n : n;
            py[cnt] = n;
            px[cnt++] = n-(y+s-x) > 0 ? n-(y+s-x) :1;
            res += 6;
        }else{
            px[cnt] = x;
            py[cnt++] = y+s;
            res += 2;
        }
        
        px[cnt] = px[0];
        py[cnt] = py[0];
        
        long ret = 0;
        long sum = 0;
        for(int i = 0; i < cnt; i++){
            ret += px[i]*py[i+1]-py[i]*px[i+1];
            sum += Math.max(Math.abs(px[i]-px[i+1]), Math.abs(py[i]-py[i+1]))+1;
        }
        return (4*ret + 4*sum - res)/8;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(str.nextToken());
        int x = Integer.parseInt(str.nextToken());
        int y = Integer.parseInt(str.nextToken());
        long c = Long.parseLong(str.nextToken());
        if(c == 1){
            System.out.println(0);
            return;
        }
        long high = 1;
        while(howMany(n, x, y, high) < c){
            high <<= 1;
        }
        long low = high>>1;
        while(high - low > 1){
            long med = (high+low)/2;
            if(howMany(n, x, y, med) < c){
                low = med;
            }else{
                high = med;
            }
        }
        System.out.println(high);
    }

}
