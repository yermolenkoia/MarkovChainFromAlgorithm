package view;

import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import view.elements.Edge;
import view.elements.Vertex;


public class GraphParameters {
    private DirectedGraph<Vertex, Edge> graph = new DirectedSparseGraph<>();
    private int idVertexCount;
    private static final Double DOUBLE_ONE = 1.0;
    private static final Integer ONE = 1;
    private static final Double FIRST_T = 0.1;
    private static final Double SECOND_T = 0.2;
    private static final Double THIRD_T = 0.3;
    public Graph<Vertex, Edge> getGraph() {
        return graph;
    }
    private Double getProbabilityForLoop(Integer matrixSize){
        Double prob = new Double(matrixSize);
        return prob/(prob + 1.0);
    }
    public GraphParameters(Integer matrixSize){
        Integer msSqrt = matrixSize * matrixSize;
        Vertex [] arr = new Vertex[9];
        for (int i = 0; i < arr.length; i++){
            arr[i] = new Vertex(idVertexCount++);
        }
        graph.addEdge(new Edge(DOUBLE_ONE, arr[0].toString(), arr[1].toString(), ONE, FIRST_T), arr[0], arr[1]);
        graph.addEdge(new Edge(DOUBLE_ONE, arr[2].toString(), arr[3].toString(), ONE, SECOND_T), arr[2], arr[3]);
        graph.addEdge(new Edge(DOUBLE_ONE, arr[4].toString(), arr[5].toString(), matrixSize, THIRD_T), arr[4], arr[5]);
        graph.addEdge(new Edge(DOUBLE_ONE, arr[6].toString(), arr[7].toString(), msSqrt, FIRST_T), arr[6], arr[7]);
        graph.addEdge(new Edge(DOUBLE_ONE, arr[8].toString(), arr[1].toString(), matrixSize, SECOND_T), arr[8], arr[1]);
        graph.addEdge(new Edge(DOUBLE_ONE, arr[7].toString(), arr[5].toString(), msSqrt, THIRD_T), arr[7], arr[5]);
        graph.addEdge(new Edge(getProbabilityForLoop(matrixSize),
                arr[1].toString(), arr[4].toString(), matrixSize, FIRST_T), arr[1], arr[4]);
        graph.addEdge(new Edge(getProbabilityForLoop(matrixSize),
                arr[5].toString(), arr[6].toString(), msSqrt, SECOND_T), arr[5], arr[6]);
        graph.addEdge(new Edge(1.0 - getProbabilityForLoop(matrixSize),
                arr[1].toString(), arr[2].toString(), ONE, SECOND_T), arr[1], arr[2]);
        graph.addEdge(new Edge(1.0 - getProbabilityForLoop(matrixSize),
                arr[5].toString(), arr[8].toString(), matrixSize, FIRST_T), arr[5], arr[8]);
    }
}
