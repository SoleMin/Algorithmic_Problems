import java.util.*;

public class Main {
    static long bb(long a, long b, long c, long d){
        long s;
        if((c - a + 1) % 2 == 0 || (d - c + 1) % 2 == 0)
            s = (c - a + 1)*(d - b + 1) / 2;
        else if((a + b) % 2 != 0)
            s = (c - a + 1) * (d - b + 1) / 2;
        else s = (c - a + 1) * (d - b + 1) - (c - a + 1) * (d - b + 1) / 2;
        return s;
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int u;
        long n, m;
        long a, b, c, d, e, f, g, h;
        u = reader.nextInt();
        while(u-- > 0){
            n = reader.nextLong();
            m = reader.nextLong();
            a = reader.nextLong();
            b = reader.nextLong();
            c = reader.nextLong();
            d = reader.nextLong();
            e = reader.nextLong();
            f = reader.nextLong();
            g = reader.nextLong();
            h = reader.nextLong();
            long s;
            s = bb(1, 1, n, m)+(c - a + 1) * (d - b + 1)-bb(a, b, c, d)-bb(e, f, g, h);
            long maxx = Math.max(a, e);
            long minx = Math.min(c, g);
            long maxy = Math.max(b, f);
            long miny = Math.min(d, h);
            if(maxx <= minx && maxy <= miny) s -= (minx -maxx + 1) * (miny - maxy + 1) - bb(maxx, maxy, minx, miny);
            System.out.println(s + " " + (n * m - s));
        }
    }
}
   	 		     							  	  	 	 	 	