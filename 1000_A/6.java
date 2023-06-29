
import java.util.*;
public class hackerearth {

    public  static  void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        HashMap<String,Integer> map=new HashMap<>();
        HashMap<String,Integer> map2=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            String s=sc.next();
            if(map.containsKey(s))
                map.put(s,map.get(s)+1);
            else
                map.put(s,1);
        }
        for(int i=0;i<n;i++)
        {
            String s=sc.next();
            if(map2.containsKey(s))
                map2.put(s,map2.get(s)+1);
            else
                map2.put(s,1);

            if(map.containsKey(s)) {
                int feq = map.get(s);
                feq--;
                if (feq <= 0)
                    map.remove(s);
                else
                    map.put(s, feq);
            }

        }


        int ans=0;
        for(Map.Entry<String,Integer> entry:map.entrySet())
        {
            ans+=entry.getValue();
        }
        System.out.println(ans);


    }



}
