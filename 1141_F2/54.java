import java.util.*;
import java.io.*;
public class Solution1{

	static class Node{
		int start,end;
		Node(int start, int end){
			this.start=start;
			this.end=end;
		}
		public String toString(){
			return start+" "+end;
		}
	}

	public static void sameSumBlock(int a[],int n){
		HashMap<Long,ArrayList<Node>> map=new HashMap<>();

		long sum;
		for(int i=0;i<n;i++){
			sum=0;
			for(int j=i;j<n;j++){
				sum+=a[j];
				if(!map.containsKey(sum))
					map.put(sum,new ArrayList<>());
				map.get(sum).add( new Node(i+1, j+1) );
			}
		}

		//for(Map.Entry<Long,ArrayList<Node>> pair: map.entrySet())
			//System.out.println(pair.getKey()+" "+pair.getValue());


		int max=0;	LinkedList<Node> list=new LinkedList<>();
		for(Map.Entry<Long,ArrayList<Node>> pair: map.entrySet()){

			ArrayList<Node> arr=pair.getValue();
			Collections.sort(arr, (Node x, Node y)->{	return x.end-y.end;	});

			int count=0,end=0;
			LinkedList<Node> temp=new LinkedList<>();
			for(Node item: arr){
				if(end<item.start){
					end=item.end;
					count+=1;
					temp.add(new Node(item.start, item.end));
				}
			}

			if(count>max){
				max=count;
				list=temp;
			}
		}

		System.out.println(max);
		for(Node item: list)
			System.out.println(item.start+" "+item.end);
	}

	public static void main(String args[]){
		Scanner in=new Scanner(System.in);

		int n=in.nextInt();

		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();

		sameSumBlock(a,n);
	}
}