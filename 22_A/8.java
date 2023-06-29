import java.util.*; 
 
public class Main{ 
        public static void main(String[] args){ 
                Scanner sc = new Scanner(System.in); 
                int n = sc.nextInt(); 
                TreeSet<Integer> set = new TreeSet<Integer>(); 
 
                for(int i=0;i<n;i++){ 
                        set.add(sc.nextInt()); 
                } 
 
                if(set.size() >= 2) 
                        System.out.println(set.toArray()[1]); 
                else 
                        System.out.println("NO"); 
        } 
}