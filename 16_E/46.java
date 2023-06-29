import java.util.*;
import java.io.*;

public class Fish
{
    public static void main(String[] args) throws Exception { new Fish(); }
   
    public Fish() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[][] P = new double[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                P[i][j] = sc.nextDouble();

        
        double[] best = new double[1 << N];
        best[(1 << N)-1] = 1;
        for(int mask = (1 << N)-1; mask > 0; mask--)
        {
            int C = Integer.bitCount(mask);
            if(C == 1) continue;
            for(int i = 0; i < N; i++) if (on(mask, i))
                for(int j = i+1; j < N; j++) if(on(mask, j))
                {
                    int nmask = mask & ~(1 << j);
                    best[nmask] += P[i][j] * best[mask] * 2.0 / (C*(C-1.0));
                    nmask = mask & ~(1 << i);
                    
                    best[nmask] += P[j][i] * best[mask] * 2.0/ (C*(C-1.0));
                }
        }

        for(int i = 0; i < N; i++)
            System.out.printf("%.7f ", best[1 << i] + 1e-9);
        System.out.println();
    }

    boolean on(int mask, int pos) { return (mask & (1 << pos)) > 0; }

}
