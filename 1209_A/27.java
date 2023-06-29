
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Colours {
    public static void main(String args[] ) throws Exception {

    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        line = br.readLine();
        String[] values = line.split(" ");
        int[] arr = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
            set.add(arr[i]);
        }
        int count=0;
        TreeSet<Integer> copy = new TreeSet<>();
        
        // for(int i=0;i<n;i++)
        copy.addAll(set);
        int prev = copy.size();
        
        for(Integer i: set){
           // System.out.println("i "+i);
            if(copy.size()==0){
                break;
            }
            Iterator<Integer> iterator = copy.iterator();
            while (iterator.hasNext()) {
                Integer e = iterator.next();
                if (e % i == 0) {
                    iterator.remove();
                }
            }
            if(copy.size()!=prev){
                count++;
                prev = copy.size();
            }
           // System.out.println("size "+copy.size());
            
        }
        

        System.out.println(count);
    }
}
