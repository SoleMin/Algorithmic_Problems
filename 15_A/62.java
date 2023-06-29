import java.util.*;

public class village {
    static int[] X, A;
    public void solve()
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), T = in.nextInt();
        X = new int[N];
        A = new int[N];

        for(int i = 0; i < N; i++) {
            X[i] = in.nextInt(); A[i] = in.nextInt();
        }

        if(N == 1) {
            System.out.println("2");
            return; 
        }

        List<Integer> x = new ArrayList<Integer>();
        for(int i = 0; i < N; i++) {
            x.add(i);
        }

        Collections.sort(x, new Comp());

        int places = 0;
        for(int i = 0; i < N-1; i++) {
            double space = (X[x.get(i+1)]-X[x.get(i)]-A[x.get(i+1)]/2.0-A[x.get(i)]/2.0);
            if(space < T) {
                continue;
            } if(space - T < 1e-9) {
                places++;
            } else if(space > T) {
                places+=2;
            }
        }
        System.out.println(places+2);
    }

    public class Comp implements Comparator<Integer> {
            public int compare(Integer i1, Integer i2) {
                return X[i1]-X[i2];
            }
    }

    public static void main(String[] args)
    {
        new village().solve();
    }
}
 