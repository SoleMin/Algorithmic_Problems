import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args)throws Exception {
        File _=new File("chores.in");
        BufferedReader br=_.exists()? new BufferedReader(new FileReader(_)):new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        
        st=new StringTokenizer(br.readLine());
        int n,a,b;
        n=Integer.parseInt(st.nextToken());
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        
        ArrayList<Integer> chores=new ArrayList<Integer>();
        int k;
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            k=Integer.parseInt(st.nextToken());
            chores.add(k);
        }
        Collections.sort(chores);
        
        System.out.println(chores.get(b)-chores.get(b-1));
        
    }
}
