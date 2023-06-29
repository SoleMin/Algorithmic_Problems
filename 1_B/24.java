
import java.util.Scanner;

public class B {
    public static String toB(String str){
        String row,col;
        int i=0;
        while(i<str.length() && str.charAt(i)<='Z'&&str.charAt(i)>='A')i++;
        col = str.substring(0,i);
        row = str.substring(i,str.length());
        StringBuffer sb = new StringBuffer(col);
        col = sb.reverse().toString();
        int accum = 0;
        for(i=0;i<col.length();i++){
            int val = getValue(col.charAt(i));
            accum+=val*Math.pow(26, i);
            }
        return "R"+row+"C"+accum;
        
    }
    public static String toA(String str){
        int i = str.indexOf('C');
        String row,col,ans="";
        row = str.substring(1,i);
        col = str.substring(i+1,str.length());
        int colVal = Integer.parseInt(col),mod;
        while(colVal>0){
            mod = colVal%26;
            if(mod==0){
                ans+='Z';
                colVal--;
            }
            else{
                ans+=getLetter(mod);
            }
            colVal/=26;
        }
        StringBuffer sb = new StringBuffer(ans);
        ans = sb.reverse().toString();
        return ans+row;
    }
    public static int getValue(char c){
        return c-'A'+1;
    }
    public static char getLetter(int n){
        return (char)(n+'A'-1);
    }
    public static void main(String[] args)throws Exception{
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 0;i<cases;i++){
            String str = in.next();
            if(str.charAt(0)=='R' && str.charAt(1)>='0'&&str.charAt(1)<='9' && str.indexOf('C')!=-1){
                System.out.println(toA(str));
            }
            else System.out.println(toB(str));
        }
        
    }
}
