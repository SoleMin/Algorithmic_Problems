import java.io.*;
import java.util.*;

public class Main{
public static void main(String[] args) throws IOException{
BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
String a=buffer.readLine();
int b=Integer.parseInt(a);
if(b%4==0 || b%7==0 || b%44==0 || b%47==0 || b%74==0 || b%77==0 || b%444==0 || b%447==0 || b%474==0 || b%477==0 || b%744==0 || b%747==0 || b%774==0 || b%777==0)
System.out.println("YES");
else
System.out.println("NO");
}}