
/**
 *
 * @author saurabh
 */
public class myTemplate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
       java.io.BufferedReader br = new java.io.BufferedReader(new 
                 java.io.InputStreamReader(System.in));
       
       int ch[],arr[];
       int x,i,j,k,t,n=Integer.parseInt(br.readLine());
        //System.out.println(n);
        
       if(n>0)
            System.out.println(n);
       else
       {
           //n= -n;
           //n=-n;
           x= n/100;
           
           x = x*10 + n%10;
         //  System.out.println(x);
           if(n/10 > x)
               System.out.println(n/10);
           else
              System.out.println(x);
           
       }
       
    }
}
