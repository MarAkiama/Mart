
package undirectedgraph;
import com.javamex.classmexer.MemoryUtil;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import undirectedgraph.MultipleLinearRegression;

public class UndirectedGraph {
    final static int Ve = 56;
    final static int Ev = 40;

 public static void main(String[] args) {
        Edge e = new Edge(123456, 654321, 1.0);
        StdOut.println("size of Edge = " + MemoryUtil.memoryUsageOf(e) + " bytes");


        int n = 40;
        int[] V = new int[n];
        int[] E = new int[n];

        // build random graphs and compute memory usage\
        
        long[] memory = new long[n];
        for (int i = 0; i < n; i++) {
            V[i] = 2*StdRandom.uniform(500);       // vertices
            E[i] = V[i] * StdRandom.uniform(10);   // edges
            EdgeWeightedGraph G = new EdgeWeightedGraph(V[i]);
            for (int j = 0; j < E[i]; j++) {
                int v = StdRandom.uniform(V[i]);
                int w = StdRandom.uniform(V[i]);
                double weight = StdRandom.uniform(0.0, 1.0);
                G.addEdge(new Edge(v, w, weight));
            }
            memory[i] = MemoryUtil.deepMemoryUsageOf(G);
        }

        // build multiple linear regression coefficients
        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            y[i] = memory[i];
        }

        double[][] x = new double[n][3];
        for (int i = 0; i < n; i++) {
            x[i][0] = 1.0;
            x[i][1] = V[i];
            x[i][2] = E[i];
        }


        MultipleLinearRegression regression = new MultipleLinearRegression(x, y);
        StdOut.println("memory of an EdgeWeightedGraph with V vertices and E edges:");
        StdOut.println(Ve + " V, " + Ev + " E." );
        StdOut.printf("%.2f + %.2f V + %.2f E bytes\n",
                      regression.beta(0), regression.beta(1), regression.beta(2));
    }
}
