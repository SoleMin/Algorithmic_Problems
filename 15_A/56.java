import java.util.*;

public class test 
{  
    public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int t=in.nextInt();
        
        House[] houses=new House[n];
        
        for(int i=0;i<n;i++)
        {
            houses[i]=new House(in.nextInt(),in.nextInt());
        }
        
        Arrays.sort(houses);
        
        int count=2;
        
        for(int i=0;i<n-1;i++)
        {
            double start=houses[i].x+(double)houses[i].a/2;
            double end=houses[i+1].x-(double)houses[i+1].a/2;
            
            if(end-start==t)
        	count++;
            if(end-start>t)
        	count+=2;
        }
        
        System.out.println(count);
 
    }
}

class House implements Comparable<House>
{
    int x;
    int a;
    
    public House(int _x, int _a)
    {
	x=_x;
	a=_a;
    }

    @Override
    public int compareTo(House o) {
	return x-o.x;
    }
    
}


