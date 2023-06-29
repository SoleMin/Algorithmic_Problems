import java.io.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class ViewAngle{
		        	private static int V,level[][],count=-1,lev_dfs[],degree=0,no_vert_conn_comp=0;
		        	private static Stack <Integer>st=new Stack();
		        	private static LinkedList<Integer > adj[];
		        	private static boolean[][] Visite;
		        	private static boolean [] Visited;
		        	private static TreeSet<Integer> ts=new TreeSet();
		        //	private static HashMap
		        	private static Queue<Pair> queue = new LinkedList<Pair>();
		        	ViewAngle(int V){
		    V++;
		    this.V=(V);
		    adj=new LinkedList[V];
		    Visite=new boolean[100][100];
	
	 	   Visited=new boolean[V];
		   
		   lev_dfs=new int[V]; 
		   for(int i=0;i<V;i++)
			   adj[i]=new LinkedList<Integer>();
		    }
		        	static File inFile,outFile;
		        	static FileWriter fWriter;
		        	static PrintWriter pWriter;
		        	public static void main(String[] args) throws IOException {
		    	
		    	 inFile=new File("input.txt");
		    	 outFile = new File ("output.txt");
			     fWriter = new FileWriter (outFile);
			    pWriter = new PrintWriter (fWriter);
			  Scanner sc = new Scanner (inFile);
			  int n=sc.nextInt();
			  int m=sc.nextInt();
			  char c[][]=new char[n][m];
			  for(int i=0;i<n;i++){
				  for(int j=0;j<m;j++){
					  c[i][j]='.';
				  }
			  }
			  setup(n, m);
			  int k=sc.nextInt();
			  for(int i=0;i<k;i++){
				  int x=sc.nextInt();
				  int y=sc.nextInt();
				  queue.add(new Pair(x-1, y-1));
				  c[x-1][y-1]='X';
			 level[x-1][y-1]=-1;
			 Visite[x-1][y-1]=true;
			  }
			BFS(c, n, m);
		    	pWriter.close();
		    	sc.close();
		    }
		   static  void addEdge(int v,int w){
		    	
		    	if(adj[v]==null){
		    		adj[v]=new LinkedList();
		    	}
		    	adj[v].add(w);
		     
		    	
		    }
		 
		    public static int BFS2(int startVert,int dest){
		    	Visited=new boolean[V];
		    	for(int i=1;i<V;i++){
		    		lev_dfs[i]=-1;
		    	}
		    	Queue<Integer> q=new LinkedList<Integer>();
		    	q.add(startVert);
		    	
		    	lev_dfs[startVert]=0;
		    	while(!q.isEmpty()){
		    		int top=q.poll();
		    		
		    		Iterator<Integer> i= adj[top].listIterator();
		    		while(i.hasNext()){
		    			int n=i.next();
		    			if(!Visited[n]){
		    				q.add(n);
		    				Visited[n]=true;
		    				lev_dfs[n]=lev_dfs[top]+1;
		    			if(n==dest){
		    				q.clear();
		    				return lev_dfs[n];
		    			
		    			}
		    			}
		    		}
		    	}
		    	q.clear();
		    	return -1;
		    }
		    public int getEd(){
		    	return degree/2;
		    }
		    public void get(int from,int to){
		    	int h=lev_dfs[from]-lev_dfs[to];
		    	if(h<=0){
		    		System.out.println(-1);
		    	}else{
		    		System.out.println(h-1);
		    	}
		    }
		    public static void setup(int n,int m){

		    	 level=new int[n][m];
		    	Visite=new boolean[n][m];	
		    }
		    private static boolean check(int x,int y,char c[][]){
			
				if((x>=0 && y>=0) && (x<c.length && y<c[0].length) && c[x][y]=='.'){
					
					return true;
				}
				return false;
			}
		    public static int BFS(char[][] c,int n,int m)
		    {
		        //Visited[s]=true;
		   //     queue.add(new Pair(x,y));
		       int count=0;
		 //  level[x][y]=-1;
		        while (!queue.isEmpty())
		        {
		        	
		            Pair temp = queue.poll();
		           int  x=temp.w;
		            int y=temp.h;
		            Visite[x][y]=true;
		            if(check(x+1,y,c) && !Visite[x+1][y]){
		            	level[x+1][y]=level[x][y]+1;
		            	queue.add(new Pair(x+1, y));
		            Visite[x+1][y]=true;
		            }
		            if(check(x-1,y,c) && !Visite[x-1][y]){
		            	level[x-1][y]=level[x][y]+1;
		            	queue.add(new Pair(x-1, y));
		            	Visite[x-1][y]=true;
		            }
		            if(check(x,y+1,c) && !Visite[x][y+1]){
		            	level[x][y+1]=level[x][y]+1;
		            	queue.add(new Pair(x, y+1));
		            	Visite[x][y+1]=true;
		            }
		            if(check(x,y-1,c) && !Visite[x][y-1]){
		            	level[x][y-1]=level[x][y]+1;
		            	queue.add(new Pair(x, y-1));
		            	Visite[x][y-1]=true;
		            }
		          
		            
		        }
		        int prev_lev=-1,x=-1,y=-1;
		        for(int i=0;i<n;i++){
		        	for(int j=0;j<m;j++){
		        		if(level[i][j]>=prev_lev){
		        			prev_lev=level[i][j];
		        			x=i;y=j;
		        		}
		        		//System.out.println(level[i][j]+" ");
		        	}
		        	//System.out.println();
		        }
		        
		        pWriter.println((x+1)+" "+(y+1));
		        return V;
		    }
		    
		    private void getAns(int startVertex){
		    	for(int i=0;i<adj[startVertex].size();i++){
		    		int ch=adj[startVertex].get(i);
		    		for(int j=0;j<adj[ch].size();j++){
		    			int ch2=adj[ch].get(j);
		    			if(adj[ch2].contains(startVertex)){
		    				System.out.println(startVertex+" "+ch+" "+ch2);
		    				System.exit(0);
		    			}
		    		}
		    	}
		    }
		    
		     public long dfs(int startVertex){
		    //	 getAns(startVertex);
		    	 
		    	 if(!Visited[startVertex])  {
		    
		   return dfsUtil(startVertex,Visited);
		    	//return getAns();
		    	}
		    	 
		    
		     
		    return 0;
		    	}
		 private long dfsUtil(int startVertex, boolean[] Visited) {//0-Blue 1-Pink
		//System.out.println(startVertex);
			 int c=1;
			 long cout=0;
		      degree=0;
		    	Visited[startVertex]=true;
		    //	lev_dfs[startVertex]=1;
		      st.push(startVertex);
		    while(!st.isEmpty()){
		    	
		    	int top=st.pop();
		    
		   	Iterator<Integer> i=adj[top].listIterator();
		     degree+=adj[top].size();
		    
		    while(i.hasNext()){
		// System.out.println(top+" "+adj[top].size());
		    	int n=i.next();
		  //  	System.out.print(n+" ");
		     if( !Visited[n]){
		    				Visited[n]=true;
		    					st.push(n);
		    				//	System.out.print(n+" ");
		    					lev_dfs[n]=top;
		    			
		    		 }
		         }
		//    System.out.println("--------------------------------");
		 }
		    	
		    for(int i=1;i<V;i++){
		    	if(lev_dfs[i]!=0){
		    		System.out.print(lev_dfs[i]+" ");
		    	}
		    }
		    return cout;
			    
		  //  System.out.println("NO");
		   // return c;
		    	
		    
		    
		    
		    }
		        
		        }     
class Pair implements Comparable<Pair>{
	   
	int w;
	int h;
	Pair(int w,int h){
		this.w=w;
		this.h=h;
	}
	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
	//	Sort in increasing order
		if(w>o.w){
			return 1;
		}else if(w<o.w){
			return -1;
		}else{
			if(h>o.h)
				return 1;
			else if(h<o.h)
				return -1;
			else
			return 0;
		}
		
		
	}

}
		        	