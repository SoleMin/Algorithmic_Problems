import java.io.*;
import java.util.*;

class Elephant implements Comparable<Elephant>{
	int index;
	int weight;
	int iq;
	int seq=0;
	
	public int compareTo(Elephant e){
		if(this.seq==0){
			int tmp = this.weight - e.weight;
			return tmp;
		}
		else{
			if(this.seq>e.seq || (this.seq == e. seq && this.index< e.index))
				return 1;
			else if(this.seq<e.seq || (this.seq == e. seq && this.index> e.index)){
				return -1;
			}
			else{
				return 0;
			}
		}
	}
	
	
}

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<Elephant> elephants = new ArrayList<Elephant>();
		int idx=1;
		
		while(scanner.hasNextInt()){
			int tmp1= scanner.nextInt();
			int tmp2= scanner.nextInt();
		//	scanner.nextLine();
			Elephant tmp = new Elephant();
			tmp.index = idx;
			tmp.weight = tmp1;
			tmp.iq = tmp2;
			idx++;
			elephants.add(tmp);

		}
		
		int N = elephants.size();
		Collections.sort(elephants);
		
		int arr [] = new int[N];
		arr[0]=1;
		
		for(int i=1; i<N ; i++){
			arr[i]= Math.max(1,arr[i]);
			for(int j=0; j< i; j++){
				if(elephants.get(i).iq<elephants.get(j).iq && elephants.get(i).weight > elephants.get(j).weight){
					arr[i] = Math.max(arr[j]+1, arr[i]);
				}
			}
		}
		
	//	System.out.println(Arrays.toString(arr));
		
		int mx =0;
		for(int i=0; i<N; i++){
			if(arr[i]>mx)
				mx = arr[i];
		}
		System.out.println(mx);
		
		int [] result = new int[mx];
		int f=1;
		int last=0;
		

		
		for(int i=0; i<N; i++){
			elephants.get(i).seq = arr[i];
		}
		Collections.sort(elephants);
		
	//	for(Elephant e: elephants){
	//		System.out.println(e.weight+ " "+ e.index + " "+e.iq);
	//	}
		

		
		for( int i=N-1; i>=0 &&mx>0; i--){
			if(arr[i] == mx && (f==1 || last <elephants.get(i).iq)){
				last = elephants.get(i).iq;
				result[--mx] = elephants.get(i).index;
				f=0;
			}
		}
		
		
		for(int i=0; i<result.length; i++)
			System.out.println(result[i]);
		
	}
}