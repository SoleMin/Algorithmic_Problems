import java.util.*;
import java.io.*;
public class hamsters{
public static void main(String args[]) throws IOException{
BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
String tmp = lector.readLine();
tmp = lector.readLine();
int cantH = 0;
for(int n = 0;n<tmp.length();n++)
if(tmp.charAt(n)=='H')cantH++;
int cantT = tmp.length()-cantH;
int min = Math.max(cantT,cantH);
for(int n = 0;n<tmp.length();n++){
int rr = 0;
for(int m = 0;m<cantH;m++)
if(tmp.charAt((m+n)%tmp.length())=='T')rr++;
min = Math.min(rr,min);
rr = 0;
for(int m =0;m<cantT;m++)
if(tmp.charAt((m+n)%tmp.length())=='H')rr++;
min = Math.min(rr,min);
}
System.out.println(min);
}
}
