import java.util.*;
public class file{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        scn.nextLine();
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
        String str=scn.nextLine();
        map.put(str,map.getOrDefault(str,0)+1);
        }
        
        for(int i=0;i<n;i++){
            String stri=scn.nextLine();
            if(map.containsKey(stri)){
                if(map.get(stri)==1){
                    map.remove(stri);
                }else{
                        map.put(stri,map.get(stri)-1);  
                }
          
            }
        }
        int sum=0;
        
        for(String i:map.keySet()){
            sum+=(map.get(i));
        }
        System.out.println(sum);
    }
}