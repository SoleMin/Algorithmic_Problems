import java.util.*;
import java.io.*;

public class Main
{
	static HashMap<Integer,Integer> hm;
	static int[] array;
	static boolean marked[];
	static int a , b ; 
	static int[] ans ; 
	
	public static void main( String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n ; 
		
		n = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		
		hm = new HashMap<Integer,Integer>();
		array = new int[n];
		marked = new boolean[n];
		
		for( int i = 0 ; i < n ; ++i )
		{
			array[i] = sc.nextInt();
			hm.put( array[i] , i );
		}
		
		if( a == b)
		{
			boolean flag = true ;
			for( int i = 0 ; i < n ; ++i )
				if( !hm.containsKey( a - array[i]))
					flag = false; 
			
			if( !flag) 
				System.out.println( "NO");
			else
			{
				System.out.println("YES");
				for( int i = 0 ; i < n ; ++i)
					System.out.print("0 ");
			}
		}
		
		else
		{
			
			ans = new int[n];
			
			for( int i = 0 ; i < n ; ++i )
			if( marked[i] ) continue; 
			
			else  // hadle odd , even and single self loops
			{
				if( hm.containsKey(a - array[i]) && !hm.containsKey(b - array[i]))
				{
					propagateA(i);
				}
				
				else if( !hm.containsKey(a - array[i]) && hm.containsKey(b - array[i]))
				{
					// propagate b
					propagateB(i);
				}
				
				else if(!hm.containsKey(a - array[i]) && !hm.containsKey(b - array[i]))
				{
					System.out.println("NO");
					System.exit(0);
				}
			}
			
			
			
			for( int i = 0 ; i < n ; ++i )
				if( marked[i] ) continue; 
				
				else  // handle doule self loops , cycles
				{
						start(i);
				}
			
			System.out.println("YES");
			for( int i = 0 ; i < n; ++i)
				System.out.print(ans[i] + " ");
			System.exit(0);
		}
		
		
		
		
	}
	
	static void propagateA(int index)
	{
		
		int i = index;
		
		while( !marked[i])
		{
			
			
					if( hm.containsKey( a - array[i]) && !marked[ hm.get( a - array[i])])
					{
						marked[i] = true ; 
						ans [i] = 0 ; 
						
						
						i = hm.get( a - array[i]);
						marked[i] = true ; 
						ans [i] = 0 ; 
						
						
						if( hm.containsKey( b - array[i]) && !marked[ hm.get( b - array[i])])
						{
							i = hm.get( b - array[i]);
						}

					}
					
					else
					{
						System.out.println("NO");
						System.exit(0);
					}
				
		}
			
	}
	
	static void propagateB(int index)
	{
		
		int i = index;
		
		while( !marked[i])
		{
			
			
					if( hm.containsKey( b - array[i]) && !marked[ hm.get( b - array[i])])
					{
						marked[i] = true ; 
						ans [i] = 1 ;
						
				
						
						i = hm.get( b - array[i]);
						marked[i] = true ; 
						ans [i] = 1 ; 
						
						
						if( hm.containsKey( a - array[i]) && !marked[ hm.get( a - array[i])])
						{
							i = hm.get( a - array[i]);
						}

					}
					
					else
					{
						System.out.println("NO");
						System.exit(0);
					}
				
		}
			
	}
	
	static void start(int index)
	{
		 
		int i = index ; 
		
		while( !marked[i] )
		{
			//System.out.println( a - array[i]);
			if(!marked[ hm.get( a - array[i])])
			{
				marked[i] = true ; 
				ans [i] = 0 ; 
				
				
				
				i = hm.get( a - array[i]);
				marked[i] = true ; 
				ans [i] = 0 ; 
				
				
				i = hm.get( b - array[i]);
			

			}
			
			
		}
	}
		
}