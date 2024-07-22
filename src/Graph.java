import java.util.LinkedList;
import java.util.Queue;

public class Graph{
    int vertices;
    LinkedList<Integer>[] adjArr;

    Graph(int vertices){
        this.vertices=vertices;
        adjArr=new LinkedList[vertices];

        for(int i=0;i<vertices;i++){
            adjArr[i]=new LinkedList<>();
        }
    }

    void addEdge(int u,int v){adjArr[u].add(v);}

    void bfs(int startNode){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(startNode);

        boolean[] visited=new boolean[vertices];
        visited[startNode]=true;

        while(!queue.isEmpty()){
            int currentNode=queue.poll();
            System.out.print(currentNode+" ");

            for(int node : adjArr[currentNode]){
                if(!visited[node]){
                    visited[node]=true;
                    queue.add(node);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices=11;

        Graph graph=new Graph(vertices);

        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,8);
        graph.addEdge(2,10);
        graph.addEdge(8,9);
        graph.addEdge(10,9);
        graph.addEdge(4,5);
        graph.addEdge(5,6);
        graph.addEdge(5,7);

        graph.bfs(0);
    }
}