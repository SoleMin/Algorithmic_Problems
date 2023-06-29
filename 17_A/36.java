import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
                int n = sc.nextInt(), k = sc.nextInt(), kol = 0, prev;
                boolean ok;
                ArrayList<Integer> al = new ArrayList<Integer>();
                al.add(2);
                prev = 2;
                for(int i=3;i<=n;i+=2)
                {
                	ok = true;
                	for(Integer x: al) 
                	if (i%x == 0)
                	{
                		ok = false;
                		break;
                	}
                	if (ok) 
                	{
                		for(Integer x: al)
                		if (ok) 
                		{
                			prev = x; 
                			ok = false;
                		} else
                		{
	                		if (x + prev + 1 == i) 
	                		{
	                			kol++;
	                			break;
	                		}
	                		if (x + prev + 1 > i) break;
	                		prev = x;
                		}
                		al.add(i);
                	}
                }
                if (kol >= k) System.out.print("YES"); else System.out.print("NO");
	}
}