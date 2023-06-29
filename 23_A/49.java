import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        int max=0;
        for(int i=0;i<s.length();i++){
            int len=0;
            int k=i;
            boolean flag=false;
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(k)==s.charAt(j)){
                len++;
                k++;
                flag=true;
                }
                else if(flag==true){
                    j=j-len;
                    k=i;
                    if(max<len)
                    max=len;
                    len=0;
                    flag=false;
                    
                }
                   
            }
            if(max<len)
            max=len;
        }
        System.out.print(max);
    }}