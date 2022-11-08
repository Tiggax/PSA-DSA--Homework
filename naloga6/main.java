// Dodatni file za zestiranje naloge. Ni potreben za oddajo, imel sem ga le za testiranje grafa.

package psa.naloga5;

public class main {
    public static void main(String[] args) {
        Prim graph5 = new Prim(5);
        graph5.addEdge(1, 3, 2);
        graph5.addEdge(1, 2, 5);
        graph5.addEdge(3, 4, 3);
        drawGraph(graph5);
    }
    public static void drawGraph(Prim graph){
       for (int i = 0; i < graph.data.length; i++) {
           for (int j = 0; j < graph.data.length; j++) {
               System.out.print(graph.data[i][j]+ " ");
           }
           System.out.println();
       } 
    }
}
