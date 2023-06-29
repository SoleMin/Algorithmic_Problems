import java.security.KeyException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class P15A
{
    public static void main (String [] args)
    {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt(), t = scan.nextInt();

        TreeMap<Integer,Integer> hm = new TreeMap<Integer, Integer>();

        for (int i = 0; i < n; i++) hm.put(scan.nextInt(),scan.nextInt());

        int _x = 0, _a = 0, res = 2;

        boolean started = false;

        for (Integer key : hm.keySet())
        {

            if (!started)
            {
                _x = key;
                _a = hm.get(_x);
                started = true;
                continue;
            }

            if (key - _x - ((Integer)hm.get(key) + _a)/2.0 > t) res +=2;
            else if (key - _x - ((Integer)hm.get(key) + _a)/2.0 == t) res++;

            _x = key;
            _a = hm.get(_x);

        }

        System.out.println(res);


    }

}