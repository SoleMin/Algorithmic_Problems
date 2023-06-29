import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LookingOrder {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line=in.readLine().split("\\s+");
        int xs= Integer.parseInt(line[0]);
        int ys= Integer.parseInt(line[1]);
        int n=Integer.parseInt(in.readLine());
        int []x=new int[n];
        int []y=new int[n];
        for(int i=0;i<n;++i){
            line=in.readLine().split("\\s+");
            x[i]= Integer.parseInt(line[0]);
            y[i]= Integer.parseInt(line[1]);
        }
        int maxBitmap=1<<n;
        long[] dis=new long[maxBitmap];
        int[] last=new int[maxBitmap];
        dis[0]=0;
        int ci=0;
        int[][] dismap=new int[n][n];
        
        for(int i=0;i<n;++i){
            for(int j=0;j<=i;++j){
                int delx,dely;
                if(i==j){
                    delx=x[i]-xs;
                    dely=y[i]-ys;
                }else{
                    delx=x[i]-x[j];
                    dely=y[i]-y[j];
                }
                dismap[i][j]=delx*delx+dely*dely;
            }
        }
        
        for(int i=1;i<maxBitmap;++i){
            if((i&(1<<ci))==0)
                ++ci;
            int i2=i-(1<<ci);
            
            long min=dis[i2]+2*dismap[ci][ci];
            last[i]=ci;
            for(int j=0;j<ci;++j){
                if((i&(1<<j))!=0){
                    long m=dis[i2-(1<<j)]+dismap[ci][ci]+dismap[j][j]+dismap[ci][j];
                    if(m<min){
                        min=m;
                        last[i]=j;
                    }
                }
            }
            dis[i]=min;
        }
        
        out.write(""+dis[maxBitmap-1]);
        out.newLine();
        out.write("0");
        
        int bmap=maxBitmap-1;
        ci=n-1; 
        while(bmap!=0){
            while((bmap&(1<<ci))==0&&ci>=0)--ci;
            int ci2=last[bmap];
            if(ci2!=ci){
                out.write(" "+(ci+1)+" "+(ci2+1)+ " 0");
                bmap-=(1<<ci)+(1<<ci2);
            }else{
                out.write(" "+(ci+1)+" 0");
                bmap-=1<<ci;
            }
        }
        out.close();
    }
}