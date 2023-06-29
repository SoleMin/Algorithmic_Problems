import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
public class LuckyNumbers {

    public static void main(String[] args)throws IOException
    {
        BufferedReader scan=new BufferedReader(new InputStreamReader(System.in));
        short num=Short.parseShort(scan.readLine());
        if(funcion(num))
        {
            System.out.println("YES");
        }
        else
            System.out.println("NO");
    }
    public static boolean funcion(short num)
    {
        LinkedList<Short>queue=new LinkedList<Short>();
        queue.offer((short) 4);
        queue.offer((short) 44);
        queue.offer((short) 444);
        queue.offer((short) 47);
        queue.offer((short) 477);
        queue.offer((short) 7);
        queue.offer((short) 77);
        queue.offer((short) 777);
        queue.offer((short) 74);
        queue.offer((short) 744);
        while(queue.peek()!=null)
        {
            if(num%queue.poll()==0)
            {
                return true;
            }
        }
        return false;

    }
}
