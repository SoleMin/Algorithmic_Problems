import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        int N = r.nextInt();
        int K = r.nextInt() - 1;
        
        T[] a = new T[N];
        for(int i = 0; i < N; i++)
            a[i] = new T(r.nextInt(), r.nextInt());
        
        Arrays.sort(a, new Comparator<T>() {

            @Override
            public int compare(T x, T y) {
                if(x.p > y.p)return -1;
                else if(x.p == y.p){
                    if(x.t < y.t)return -1;
                    else if(x.t == y.t)return 0;
                    else return 1;
                }else return 1;
            }
        });
        
        int ret = 0;
        for(int i = 0; i < N; i++)
            if(a[i].p == a[K].p && a[i].t == a[K].t)ret++;
        
        System.out.println(ret);
    }
}

class T{
    int p, t;
    public T(int pi, int ti){
        p = pi;
        t = ti;
    }
}