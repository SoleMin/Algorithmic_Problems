import java.util.*;
public class paintTheNumbers {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.print(paint(arr));
    }
    public static int paint(int [] arr){
        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet<>();
        int num = arr[0];
        set.add(num);
        for(int i = 1; i < arr.length; i++){
            if(!divBySet(set, arr[i])){
                set.add(arr[i]);
            }

        }
        return set.size();
    }

    /**
     *
     * @param set
     * @param a
     * @return
     */
    public static boolean divBySet(HashSet<Integer> set, int a){
        for(int s: set){
            if(a % s == 0){
                return true;
            }
        }
        return false;
    }

}
