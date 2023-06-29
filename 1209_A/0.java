import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = s.nextInt();
        }
        Arrays.sort(arr);
        int count = 0;
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n; i++){
            if(visited[i] == true){
                continue;
            }
            count++;
            for(int j = 0; j < n; j++){
                if(arr[j] % arr[i] == 0){
                    visited[j] = true;
                }
            }
            if(check(visited)){
                System.out.println(count);
            }
        }
    }
    public static boolean check(boolean visited[]){
        for(int i = 0; i < visited.length; i++){
            if(visited[i] == false){
                return false;
            }
        }
        return true;
    }
}