import java.util.*;

public class test 
{    
    static boolean isOK(String str, int len)
    {
	HashSet<String> hs=new HashSet<String>();
	
	for(int i=0;i<=str.length()-len;i++)
	{
	    String s=str.substring(i,len+i);
	    if(hs.contains(s))
		return true;
	    else
		hs.add(s);
	}
	
	return false;
    }
    public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);
        String str=in.next();
        
        int i;
        for(i=str.length()-1;i>=1;i--)
            if(isOK(str,i))
            {
        	break;
            }
        
        System.out.println(i);
    }
}

