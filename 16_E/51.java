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
    
    int ncase = Integer.valueOf(reader.readLine());
    double[][] p = new double[ncase][];
    for(int icase=0;icase<ncase;icase++){
      p[icase] = toDoubleArray(reader.readLine());
    }
    double[] prob = new double[1<<ncase];
    prob[0] = 1;
    for(int x=0;x<(1<<ncase);x++){
      double cp = prob[x];
      int count = 0;
      for(int i=0;i<ncase;i++){
        if((x&(1<<i))!=0) continue;
        count ++;
      }
      if(count == 1) continue;
      double np = cp*2.0/(count)/(count-1);
      for(int i=0;i<ncase;i++){
        if((x&(1<<i))!=0) continue;
        for(int j=i+1;j<ncase;j++){
          if((x&(1<<j))!=0) continue;
          prob[x^(1<<j)] += np*p[i][j];
          prob[x^(1<<i)] += np*p[j][i];
        }
      }
    }
    String out = "";
    for(int i=0;i<ncase;i++){
      if(i>0) out += " ";
      int index = ((1<<ncase)-1)^(1<<i);
      out += String.format("%.6f",prob[index]);
    }
    out += "\r\n";
    writer.write(out,0,out.length());
    writer.flush();
    writer.close();
    reader.close();
  }
  String process(){
    return "1";
  }
  double[] toDoubleArray(String line){
    String[] p = line.split("[ ]+");
    double[] out = new double[p.length];
    for(int i=0;i<p.length;i++) out[i] = Double.valueOf(p[i]);
    return out;
  }
}