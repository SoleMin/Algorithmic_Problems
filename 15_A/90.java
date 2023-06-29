
import java.util.*;


public class main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int houses = sc.nextInt();
        int size = sc.nextInt();
        hizzy[] array = new hizzy[houses];
        long total =2;
        for(int a=0;a<houses;a++)array[a]=new hizzy(sc.nextInt(),sc.nextInt());
        Arrays.sort(array);
        for(int a=0;a<houses-1;a++){
            double L = array[a].loc+array[a].size/2;
            double R = array[a+1].loc-array[a+1].size/2;
            if(R-L>size)total+=2;
            else if((R-L)==size)total++;
        }
        System.out.println(total);
    }   

}
class hizzy implements Comparable{
    double loc;
    double size;
    hizzy(double l, double s){
        this.loc=l;
        this.size=s;
    }
    
    public int compareTo(Object o) {
        hizzy other = (hizzy) o;
        return (int) (this.loc-other.loc);
    }
    
}