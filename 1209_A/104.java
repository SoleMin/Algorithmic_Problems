import java.io.*;
import java.util.*;
public class Hack{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
int n=sc.nextInt();
int[] arr = new int[n];
for(int i=0;i<n;i++)
arr[i]=sc.nextInt();
Arrays.sort(arr);
Set<Integer> set = new TreeSet<Integer>();
for(int i=0;i<n;i++){
boolean flag=false;
for(Integer x:set){
if(arr[i]%x==0){
flag=true;
break;
}
}
if(!flag)
set.add(arr[i]);
}
System.out.println(set.size());
}
}
