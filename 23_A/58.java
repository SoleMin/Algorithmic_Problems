import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        sc.close();
        
        int maxm=0;
        int ind1,ind2;
        
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<str.length();j++){
                int len=0;
                ind1=i;ind2=j;
                while(ind2<str.length() && str.charAt(ind1)==str.charAt(ind2)){
                    ind1++;
                    ind2++;
                    len++;
                }
                maxm=Math.max(maxm,len);
            }
        }
        System.out.println(maxm);
    }
}