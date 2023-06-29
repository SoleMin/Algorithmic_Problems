
import java.util.*; 
public class Main
{
    static boolean Eveness(int x)
    {
        if(x%2==1)
        {
            return false;
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n= input.nextInt();
        int tmp=0,es=0,os=0,ans=0;
        Vector<Integer> nums= new Vector<Integer>();
        for(int i=0;i<n; i++)
        {
            tmp=input.nextInt();
            nums.add(tmp);
        }
        for (int i=0;i<3;i++)
        {
            tmp= nums.elementAt(i);
            if(Eveness(tmp))es++;
            else os++;
        }
        if(es>os)
        {
            for(int i=0; i<nums.size();i++)
            {
                tmp=nums.elementAt(i);
                if(!Eveness(tmp))ans=i;
            }
        }
        else
        {
            for(int i=0; i<nums.size();i++)
            {
                tmp=nums.elementAt(i);
                if(Eveness(tmp))ans=i;
            }
        }
        System.out.println(ans+1);
        
    }
    
}
