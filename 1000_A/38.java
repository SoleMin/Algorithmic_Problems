//package jsr.codeforces;

import java.util.HashMap;
import java.util.Scanner;

public class AMatchLists {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            String str = in.next();
            if(map.get(str)==null){
                map.put(str, 0);
            }
            map.put(str, map.get(str)+1);
        }

        HashMap<String, Integer> map2 = new HashMap<>();
        for(int i=0; i<N; i++){
            String str = in.next();
            if(map.get(str)!=null){
                if(map.get(str)==1)
                    map.remove(str);
                else
                    map.put(str, map.get(str)-1);
            }
            else{
                if(map2.get(str)==null){
                    map2.put(str, 0);
                }
                map2.put(str, map2.get(str)+1);
            }
        }
        int[] count= {0};

        map2.forEach((key, value)->{
                count[0] += value;
                });

        System.out.println(count[0]);

        //M, XS, XXS, XXXS, L, XL, XXl, XXXL
    }

}
