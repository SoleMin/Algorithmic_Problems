import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class CF22_1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
    if(num!=1)
    {
        ArrayList<Integer>data=new ArrayList<Integer>();
        for (int i=0;i<num;i++){
            data.add(sc.nextInt());
            
        }
        Collections.sort(data);
        
        int ind=1;
    
        while( data.get(ind-1)==data.get(ind) )
            {
            ind++;
            if(ind ==data.size())
                break;
            }
        
        if(data.size()>ind)
        System.out.println(data.get(ind));
        else
            System.out.println("NO");
        
        
    }
    else
        System.out.println("NO");
    }
    
}
