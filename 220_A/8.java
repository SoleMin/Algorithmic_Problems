import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;


public class Main {

    
    public static void main(String[] args) {
        Scanner in=new Scanner(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int n=in.nextInt();
        Vector<Integer> mas=new Vector<Integer>();
        Vector<Integer> mas2=new Vector<Integer>();
        int index=-1;
        boolean res=false;
        for(int i=0; i<n; i++){
            mas.add(in.nextInt());
            if(i!=0 && mas.get(i)<mas.get(i-1)){
                index=i-1;
                break;
            }
        }
        if(index==-1) res=true;
        else{
            int min=mas.get(index+1);
            int minIndex=index+1;
            for(int i=index+2; i<n; i++){
                mas.add(in.nextInt());
                if(mas.get(i)<=min){
                    min=mas.get(i);
                    minIndex=i;
                    
                }
            }
            
            mas2.addAll(mas);
            mas.set(minIndex, mas.get(index));
            mas.set(index, min);
            int o=mas.hashCode();
            Collections.sort(mas);
            int nw=mas.hashCode();
            res=nw==o;
        }
        if(!res){
            mas=mas2;
            for(int i=n-1; i>=0; i--){
                if(i!=n-1 && mas.get(i)>mas.get(i+1)){
                    index=i+1;
                    break;
                }
            }
            if(index==-1) res=true;
            else{
                int max=mas.get(index-1);
                int maxIndex=index-1;
                for(int i=index-1; i>=0; i--){
                    if(mas.get(i)>=max){
                        max=mas.get(i);
                        maxIndex=i;
                    }
                }
                mas.set(maxIndex, mas.get(index));
                mas.set(index, max);
                int o=mas.hashCode();
                Collections.sort(mas);
                int nw=mas.hashCode();
                res=res||nw==o;
            }
        }
        if(res) out.println("YES");
        else out.println("NO");
        out.close();
    }

}