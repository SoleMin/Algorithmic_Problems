import  java.util.*;

public class Solve{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		   int n=sc.nextInt();
		   int[] ar=new int[n+1];
		   Pair[] pr=new Pair[n];
		   for(int i=1;i<=n;i++){
		       ar[i]=sc.nextInt();
		       pr[i-1]=new Pair(ar[i],i);
		   }
		   char[]  c=sc.next().toCharArray();
		   int m=2*n;
		   int[] br=new int[m+1];
		   Arrays.sort(pr,new SortPair());
		  
		   for(int i=1;i<=m;i++){
		       int k=Character.getNumericValue(c[i-1]);
		       br[i]=k;
		   }
		   
		 
		   
		    for(int i=1;i<=m;i++){
		       int k=Character.getNumericValue(c[i-1]);
		       br[i]=k;
		   }
		   
		 
		  
		    StringBuilder sb=new StringBuilder();
		   
		      ArrayList<Integer> al=new ArrayList<Integer>(); 
		      int bot=-1;
		    for(int i=1;i<=m;i++){
		       if (br[i] ==0) {
                bot++;
                int index = pr[bot].y ;
                al.add(index);
                sb.append(index+" ");
            }else{
                int top=al.get(al.size()-1);
                al.remove(al.size()-1);
                sb.append(top+" ");
            }
		    }
		      
		    
		    
		   
		   System.out.println(sb);
		   
		   
		   
		   
	}
}

class Pair{
    int x, y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class SortPair implements Comparator<Pair>{
    public int compare(Pair p1,Pair p2){
        return p1.x-p2.x;
    }
}