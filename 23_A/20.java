// by agus.mw
import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws Exception {
    new Main().doWork();
  }
  void doWork() throws Exception{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    
    String text = reader.readLine().trim();
    int out = 0;
    for(int i=0;i<text.length();i++){
      for(int j=i+1;j<text.length();j++){
        for(int len = out+1;len+j<=text.length();len++){
          if(text.substring(i,i+len).compareTo(text.substring(j,j+len))==0){
            out = len;
          }
        }
      }
    }
    String buf = ""+out;
    writer.write(buf,0,buf.length());
    writer.newLine();
    writer.flush();
    writer.close();
    reader.close();
  }
  String process(){
    return "1";
  }
  int[] toIntArray(String line){
    String[] p = line.split("[ ]+");
    int[] out = new int[p.length];
    for(int i=0;i<p.length;i++) out[i] = Integer.valueOf(p[i]);
    return out;
  }
}