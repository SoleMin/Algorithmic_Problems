import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                String T = input.nextLine();
                String P = input.nextLine();
                int n = T.length();
                int m = P.length();
                int [] kmp = new int[m];
                int i=0;
                for(int j=1; j<m; j++){
                 while(i>0 && P.charAt(j) != P.charAt(i)){
                        i = kmp[i-1];
                    }
                    if(P.charAt(j) == P.charAt(i)){
                        kmp[j] = ++i;
                    }
                }
                int count =0;
                String res="";
                i=0;
                for(int j=0; j<n;j++){
                    while(i>0 && T.charAt(j)!= P.charAt(i)){
                        i = kmp[i-1];
                    }
                    if(T.charAt(j)==P.charAt(i)){
                        if(i == m-1){
                            count++;
                            res = res + (j-m+2)+" ";
                            i = kmp[i];
													}
                        else{
                            i++;
													}
                    }
                }
                System.out.println(count);
                System.out.println(res);

    }
}
