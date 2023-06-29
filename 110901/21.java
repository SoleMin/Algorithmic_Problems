import java.util.*;

class Graph1 {
   public static int[] color;
   public static boolean isOk = true;
   static class Node {
      int data;
      LinkedList<Node> adjacent;
      boolean visited;

      public Node(int data) {
         this.data = data;
         this.visited = false;
         adjacent = new LinkedList<>();
      }
   }

   Node[] nodes;

   public Graph1(int size) {
      color = new int[size];
      nodes = new Node[size];
      for (int i = 0; i < size; i++) {
         nodes[i] = new Node(i);
         color[nodes[i].data] = 0;
      }
   }

   public void addEdge(int l1, int l2) {
      Node n1 = nodes[l1];
      Node n2 = nodes[l2];
      if (!n1.adjacent.contains(n2))
         n1.adjacent.add(n2);
      if (!n2.adjacent.contains(n1))
         n2.adjacent.add(n1);
   }

   public void print(Node node) {
      System.out.print(node.data + " ");
   }

   public void BFS(int index) {
      Node root = nodes[index];
      Queue<Node> que = new LinkedList<>();
      que.add(root);
      root.visited = true;
      while (!que.isEmpty()) {
         Node node = que.poll();
         for (Node n : node.adjacent) {
            if (!n.visited) {
               n.visited = true;
               que.add(n);
            }
         }
         print(node);
      }
   }
   
   public void DFS(int index) {
      Node root = nodes[index];
      Stack<Node> stack = new Stack<>();
      stack.push(root);
      root.visited = true;
      color[root.data] = 1;
      while (!stack.isEmpty()) {
         Node node = stack.pop();
         
         for (Node n : node.adjacent) {
            if(color[node.data] == 1 && color[n.data] == 0) {
               color[n.data] = 2;
            }
            
            if(color[node.data]== 2 && color[n.data]== 0  )
               color[n.data]= 1;
            
            if(color[node.data] !=0 & color[node.data] == color[n.data]) 
               isOk = false;
               
            
            if (!n.visited) {
               n.visited = true;
               stack.add(n);
            }
         }
      }
      if(isOk) {
            System.out.println("BICOLORABLE.");
         }
         else{
					  System.out.println("NOT BICOLORABLE.");
					 isOk = true;
				 }
           
		
   }

}

public class Main {
   public static void main(String[] args) {
      
      Scanner input = new Scanner(System.in);
      
      while(input.hasNext()) {
    	  
    	  int nnodes = input.nextInt();
    	  if(nnodes == 0) {
    		  break;
    	  }
          int nedges = input.nextInt();
          Graph1 g = new Graph1(nnodes);
          
          for(int i=0; i<nedges; i++) {
             int a = input.nextInt();
             int b = input.nextInt();
             g.addEdge(a, b);
          }
          
          g.DFS(0);
      }
      
   }
}