import java.util.*;
public class C23A {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();

        for(int k=str.length()-1;k>=1;k--){
            for(int i=0;i<=str.length()-k;i++){
                for(int j=i+1;j<=str.length()-k;j++){
                    if(str.substring(i,i+k).equals(str.substring(j,j+k))){
                            System.out.println(k);
                            return;
                    }
                }
            }
        }
        System.out.println(0);

    }
}
