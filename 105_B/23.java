import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;


public class Main {
    
    static int N;
    static int K;
    static int A;
    static double dl[];
    static int base[];
    static int needed;
    static int b[] = new int[N];
    static int l[] = new int[N];
    
    static double best;
    
    static void printLevels() {
        int i;
        for (i=0;i<N;i++) {
            System.out.println(i+" "+dl[i]);
        }
    }
    
    static void giveCandies(int i, int remaining) {
        
        if (remaining == 0) {
            check();
            return;
        }
        
        if (i == N) {
            check();
            return;
        }
        
        int j;
        double ns;
        double orig = dl[i];
        
        for (j=0;j<=remaining;j++) {
            
            ns = orig+j*0.1;
            
            if (ns <= 1.0) {
                dl[i] = ns;
                giveCandies(i+1, remaining-j);
                dl[i] = orig;
            } else {
                break;
            }
            
        }
        
    }
    
    static void check() {
        int i,j,k;
        
        double res = 0.0;
        int total;
        double prob;
        int max = 1<<N;
        
        double sumg, sumb;
        double pk, da = (double)A;
        
        for (k=0;k<max;k++) {
            
            prob = 1.0;
            total = 0;
            
            sumg = 0;
            sumb = 0;
            
            for (i=0;i<N;i++) {
                if ((base[i]&k) > 0) {
                    prob *= dl[i];
                    total++;
                    sumg += b[i];
                    
                } else {
                    prob *= (1.0-dl[i]);
                    sumb += b[i];
                    
                }
            }
            
            if (total >= needed) {
                // needed number of senators voted positivelly
                res += prob;
            } else {
                pk = da/(da+sumb);
                
                res += prob*pk;
                
            }
            
        }
        
        best = Math.max(best, res);
        
    }
    
    public static void main(String[] args) throws Exception {
        int i,j,k;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        
        needed = N/2+1;
        
        b = new int[N];
        l = new int[N];
        dl = new double[N];
        
        for (i=0;i<N;i++) {
            
            st = new StringTokenizer(br.readLine());
            b[i] = Integer.parseInt(st.nextToken());
            l[i] = Integer.parseInt(st.nextToken());
            dl[i] = ((double)l[i])/100.0;
            
        }
        
        base = new int[8];
        base[0] = 1;
        for (i=1;i<N;i++) {
            base[i] = base[i-1]*2;
        }
        
        best = 0.0;
        
        giveCandies(0, K);
        
        DecimalFormat df = new DecimalFormat("0.0000000000");
        
        String rs = df.format(best);
        String mrs = "";
        
        for (i=0;i<rs.length();i++) {
            if (rs.charAt(i) == ',') {
                mrs += '.';
            } else {
                mrs += rs.charAt(i);
            }
        }
        
        System.out.println(mrs);
        
        
        
    }

}
