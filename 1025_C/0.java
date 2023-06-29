import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
    public static void main(String args[])throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder(st.nextToken());
        sb.append(sb.toString());
        int max=0;
        int flag=-1;
        int count=0;
        for(int i=0;i<sb.length();i++){
            //System.out.print(count+" ");
            if(flag==-1){
                if(sb.charAt(i)=='w'){
                    flag=1;
                }else{
                    flag=2;
                }
                count++;
                max=Math.max(max,count);
            }
            else if(flag==1){
                if(sb.charAt(i)=='w'){
                    max=Math.max(count,max);
                    flag=1;
                    count=1;
                }
                else{
                    max=Math.max(count,max);
                    flag=2;
                    count++;
                }
            }else if(flag==2){
                if(sb.charAt(i)=='w'){
                    max=Math.max(count,max);
                    flag=1;
                    count++;
                }
                else{
                    max=Math.max(count,max);
                    flag=2;
                    count=1;
                }
            }
        }
        max=Math.max(count,max);
        if(max==sb.length())
            System.out.println(max/2);
        else{
            System.out.println(max);
        }


    }
}
