import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class CodeforcesRound159 {

    /**
     * @param args
     */
    public static void main(String[] args) 
    {
	Scanner kde = new Scanner(System.in);
	int n =kde.nextInt();  //���������� ������� ��������
	int m =kde.nextInt();  //���������� ���������
	int k =kde.nextInt(); //���������� �������
	ArrayList<Integer> count = new ArrayList<Integer>();
	for (int i=0; i<n; i++  )
	{
	    count.add(kde.nextInt()) ; 
	}
	
	Collections.sort(count);
	Collections.reverse(count);
	if(m<=k)
	{
	    System.out.println("0"); 
	    return;
	}
	
	m=m-k+1;
	
	
	
	
	   int  res=0;
	for(int i=0; i<n; i++ ) 
	{
	    if(i!=0)
	    {
	    res+=count.get(i)-1;
	    }
	    else 
	    {
	    res+=count.get(i);
	    }
	  
	    if(res>=m)
	    {
		   System.out.println(i+1);
		   return;
	    }
	    
	}
	
	    
	
	  
	
	
	System.out.println("-1");
	

    }

}
