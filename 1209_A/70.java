import java.util.*;

public class PaintTheNumers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        
        int nums = sc.nextInt();
        
        HashSet<Integer> elements = new HashSet<Integer>();
        for (int i = 0; i < nums; i++) {
            elements.add(sc.nextInt());
        }
        
        ArrayList<Integer> sortedElements = new ArrayList<Integer>(elements);

        Collections.sort(sortedElements);
        
        ArrayList<Integer> lcms = new ArrayList<Integer>();
        
        outer:
        for (int i = 0; i < sortedElements.size(); i++) {
            int ele = sortedElements.get(i);
            for (int j = 0; j < lcms.size(); j++) {
                if (ele % lcms.get(j) == 0) {
                    continue outer;
                }
            }
            lcms.add(ele);
        }
        System.out.println(lcms.size());
        sc.close();
    }
}
   
