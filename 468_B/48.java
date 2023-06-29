import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import static java.lang.Integer.*;

public class BDiv1 {
static int n; 
static int a;
static int b;
static HashMap<Integer,Integer> graphA=new HashMap<>();
static HashMap<Integer,Integer> graphB=new HashMap<>();
static int [] array;
static int [] original;
static boolean x=true;

    public static void main(String[] args) throws Exception{
        BufferedReader buf =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(buf.readLine());
        n=parseInt(st.nextToken());
        a=parseInt(st.nextToken());
        b=parseInt(st.nextToken());
        st =new StringTokenizer(buf.readLine());
        array=new int[n];
        original=new int [n];
        for (int i=0;i<n;i++){
            array[i]=parseInt(st.nextToken());
            original[i]=array[i];
        }
        Arrays.sort(array);
for (int i=0;i<n;i++){
    int k= Arrays.binarySearch(array,a-array[i]);
    if (k>=0){
        graphA.put(array[i],array[k]);
        graphA.put(array[k],array[i]);
    }
}
for (int i=0;i<n;i++){
    int k= Arrays.binarySearch(array,b-array[i]);
    if (k>=0){
        graphB.put(array[i],array[k]);
        graphB.put(array[k],array[i]);
    }
    }


for (int i=0;i<n;i++){
    Integer j=graphA.get(array[i]);
    if (j!=null){
        if (graphB.containsKey(array[i]) && graphB.containsKey(j)){
            graphA.remove(array[i]);
            graphA.remove(j);
        }
        else if (graphB.containsKey(array[i]) && !graphB.containsKey(j)){
            
            graphB.remove(graphB.get(array[i]));
            graphB.remove(array[i]);
        }
        else if (!graphB.containsKey(array[i]) && graphB.containsKey(j)){
            graphB.remove(graphB.get(j));
            graphB.remove(j);
        }
        
    }
    
}

int [] res=new int [n];
for (int i=0;i<n;i++){
    if (graphA.containsKey(original[i]))res[i]=0;
    else if (graphB.containsKey(original[i])) res[i]=1;
    else {
        System.out.println("NO");
        return;
    }
}
System.out.println("YES");
for (int k:res)System.out.print(k+" ");
}

    }