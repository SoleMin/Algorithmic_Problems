//package codeforces;

import java.util.*;

public class Main {
    class team implements Comparable<team>{
        int pro,time;

        public int compareTo(team oth) {
            if(pro>oth.pro)
                return -1;
            if(pro==oth.pro&&time<oth.time)
                return -1;
            // TODO Auto-generated method stub
            return 1;
        }
        
    }
    Scanner scan=new Scanner(System.in);
    void run(){
        int n=scan.nextInt();
        int k=scan.nextInt()-1;
        team tm[]=new team[n];
        for(int i=0;i<n;i++){
            tm[i]=new team();
            tm[i].pro=scan.nextInt();
            tm[i].time=scan.nextInt();
        }
        Arrays.sort(tm);
        int sum=0;
        
        for(int i=k;i>=0;i--)
            if(tm[i].pro==tm[k].pro&&tm[i].time==tm[k].time)
                sum++;
        for(int i=k;i<n;i++)
            if(tm[i].pro==tm[k].pro&&tm[i].time==tm[k].time)
                sum++;
        System.out.println(sum-1);
    }
    public static void main(String args[]) {
         
        new Main().run();
    }

}