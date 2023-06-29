import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class A
{
    public A()
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer mas[] = new Integer[n];
        int b = 0;
        for (int i = 0 ; i < n ; i ++)
        {
            mas[i] = sc.nextInt();
            b+=mas[i];
        }
        Arrays.sort(mas, new Comparator<Integer>()
        {

            @Override
            public int compare(Integer o1, Integer o2)
            {
                if(o1>o2)
                    return -1;
                else if(o1==o2)
                    return  0;
                else 
                    return 1;
            }      
        });
        int N = 0; int g = 0;
        for (int i = 0 ; i < n ; i ++)
        {
              g+=mas[i];
              if(g>(int)(b/2))
              {
                  System.out.println(i+1);
                  return;
              }
        }
        System.out.println(n);
    }
    public static void main(String[] args)
    {
        new A();      
    }
}
