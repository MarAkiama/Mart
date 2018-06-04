package bellmanfordsp;
import java.awt.*;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.EdgeWeightedDirectedCycle;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.In;
public class BellmanFordSP {
public class Animation {
        private double[] distTo;               // distTo[v] = distance  of shortest s->v path
        private DirectedEdge[] edgeTo;         // edgeTo[v] = last edge on shortest s->v path
        private boolean[] onQueue;             // onQueue[v] = is v currently on the queue?
        private Queue<Integer> queue;          // queue of vertices to relax
        private int cost;                      // number of calls to relax()
        private Iterable<DirectedEdge> cycle;  // negative cycle (or null if no such cycle)
        private boolean[] relaxed;                        
        private double radiusOfCircle;
        private double width;
        private double length;

        public Animation(EdgeWeightedDigraph G, int s, double xScaleLow,
                                    double xScaleHigh, double yScaleLow, double yScaleHigh,
                                    double radiusOfCircle, double width, double length) {
            distTo  = new double[G.V()];
            edgeTo  = new DirectedEdge[G.V()];
            onQueue = new boolean[G.V()];

            relaxed = new boolean[G.V()];

            this.radiusOfCircle = radiusOfCircle;
            this.width = width;
            this.length = length;

            Coordinate[] randomCoordinates = getRandomCoordinates(G);
            initCanvas(xScaleLow, xScaleHigh, yScaleLow, yScaleHigh);

            drawGraphVertices(randomCoordinates);
            drawGraphEdges(G, randomCoordinates);

            for (int v = 0; v < G.V(); v++)
                distTo[v] = Double.POSITIVE_INFINITY;
            distTo[s] = 0.0;
                queue = new Queue<Integer>();
                queue.enqueue(s);
                onQueue[s] = true;

            while (!queue.isEmpty() && !hasNegativeCycle()) {
            int vertexToRelax = queue.dequeue();

                drawVerticesInShortestPath(randomCoordinates);

                if (edgeTo[vertexToRelax] != null) {
                    drawEdgeInShortestPath(edgeTo[vertexToRelax].from(), vertexToRelax, randomCoordinates);
                }

                relax(G, vertexToRelax, randomCoordinates);
                onQueue[vertexToRelax] = false;
            relax(G, vertexToRelax, randomCoordinates);
        }

            drawVerticesInShortestPath(randomCoordinates);
            drawAllEdgesInShortestPath(randomCoordinates);
        }

        private void relax(EdgeWeightedDigraph G, int v, Coordinate[] randomCoordinates) {
            relaxed[v] = true;
            for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (!onQueue[w]) {
                    queue.enqueue(w);
                    onQueue[w] = true;
                }
            }
            else {
                    drawIneligibleEdge(v, w, randomCoordinates);
                }
            if (cost++ % G.V() == 0) {
                findNegativeCycle();
                if (hasNegativeCycle()) return;  // found a negative cycle
            }
        }
            drawCandidateEdgesToShortestPath(randomCoordinates);
        }
    public boolean hasNegativeCycle() {
        return cycle != null;
    }
    public Iterable<DirectedEdge> negativeCycle() {
        return cycle;
    }
    private void findNegativeCycle() {
        int V = edgeTo.length;
        EdgeWeightedDigraph spt = new EdgeWeightedDigraph(V);
        for (int v = 0; v < V; v++)
            if (edgeTo[v] != null)
                spt.addEdge(edgeTo[v]);

        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(spt);
        cycle = finder.cycle();
    }
    public double distTo(int v) {
        if (hasNegativeCycle())
            throw new UnsupportedOperationException("Negative cost cycle exists");
        return distTo[v];
    }
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }
    public Iterable<DirectedEdge> pathTo(int v) {
        if (hasNegativeCycle())
            throw new UnsupportedOperationException("Negative cost cycle exists");
        if (!hasPathTo(v)) return null;
        java.util.Stack<DirectedEdge> path = new java.util.Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }

        private void initCanvas(double xScaleLow, double xScaleHigh, double yScaleLow, double yScaleHigh) { //Scene
            StdDraw.setCanvasSize(700, 700);
            StdDraw.setXscale(xScaleLow, xScaleHigh);
            StdDraw.setYscale(yScaleLow, yScaleHigh);
        }

        private Coordinate[] getRandomCoordinates(EdgeWeightedDigraph G) {
            Coordinate[] vertexCoordinates = new Coordinate[G.V()];
            DrawUtilities drawUtilities = new DrawUtilities();

            int valueToExpand = 5;

            for(int v = 0; v < G.V(); v++) {
                double randomX = StdRandom.uniform() * valueToExpand;
                double randomY = StdRandom.uniform() * valueToExpand;
                if (randomX!=randomY)
                vertexCoordinates[v] = new Coordinate(randomX, randomY);
            }            
            return vertexCoordinates;
        }

        private void drawGraphVertices(Coordinate[] coordinates) {
            for(int vertex = 0; vertex < coordinates.length; vertex++) {

                StdDraw.setPenColor(Color.LIGHT_GRAY);
                StdDraw.filledCircle(coordinates[vertex].getXCoordinate(), coordinates[vertex].getYCoordinate(),
                        radiusOfCircle);

                StdDraw.setPenColor(Color.BLACK);
                StdDraw.circle(coordinates[vertex].getXCoordinate(), coordinates[vertex].getYCoordinate(),
                        radiusOfCircle);

                StdDraw.text(coordinates[vertex].getXCoordinate(), coordinates[vertex].getYCoordinate(),
                        String.valueOf(vertex));
            }
        }

        private void drawGraphEdges(EdgeWeightedDigraph G, Coordinate[] coordinates) {
            StdDraw.setPenRadius(0.003);
            StdDraw.setPenColor(Color.BLACK);

            for(int v = 0; v < G.V(); v++) {
                for(DirectedEdge edge : G.adj(v)) {
                    int w = edge.to();
                    DrawUtilities.drawArrow(coordinates[v], coordinates[w], length, width);
                }
            }
        }

        private void drawVerticesInShortestPath(Coordinate[] coordinates) {
            StdDraw.setPenRadius(0.002D);

            for(int v = 0; v < coordinates.length; v++) {
                if (relaxed[v]) {
                    StdDraw.setPenColor(Color.YELLOW);
                    StdDraw.filledCircle(coordinates[v].getXCoordinate(), coordinates[v].getYCoordinate(),
                            radiusOfCircle);

                    StdDraw.setPenColor(Color.BLACK);
                    StdDraw.circle(coordinates[v].getXCoordinate(), coordinates[v].getYCoordinate(),
                            radiusOfCircle);

                    StdDraw.setPenColor(Color.BLACK);
                    StdDraw.text(coordinates[v].getXCoordinate(), coordinates[v].getYCoordinate(),
                            String.valueOf(v));
                }
            }
        }

        private void drawCandidateEdgesToShortestPath(Coordinate[] coordinates) {
            int nextVertexInShortestPath = -1;

            if (!queue.isEmpty()) {
                nextVertexInShortestPath = queue.peek(); //select the first item
            }

            for(DirectedEdge edge : edgeTo) {
                if (edge == null) {
                    continue;
                }

                int vertex1 = edge.from();
                int vertex2 = edge.to();
                
                // If both vertices are already relaxed, the edge is already in the shortest path
                if (relaxed[vertex2]) {
                    continue;
                }

                if (nextVertexInShortestPath != -1 && edge == edgeTo[nextVertexInShortestPath]) {
                    // Favorite candidate
                    StdDraw.setPenRadius(0.007D);
                } else {
                    StdDraw.setPenRadius(0.002D);
                }
                StdDraw.setPenColor(Color.RED);
                DrawUtilities.drawArrow(coordinates[vertex1], coordinates[vertex2], length, width);
            }

            sleep();
        }

        private void drawEdgeInShortestPath(int vertex1, int vertex2, Coordinate[] coordinates) {
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.setPenRadius(0.007D);

            DrawUtilities.drawArrow(coordinates[vertex1], coordinates[vertex2], length, width);
            sleep();
        }

        private void drawAllEdgesInShortestPath(Coordinate[] coordinates) {
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.setPenRadius(0.007D);

            for(int vertex = 0; vertex < coordinates.length; vertex++) {
                if (edgeTo[vertex] != null) {
                    DrawUtilities.drawArrow(coordinates[edgeTo[vertex].from()], coordinates[vertex], length, width);
                }
            }
        }

        private void drawIneligibleEdge(int vertex1, int vertex2, Coordinate[] coordinates) {
            StdDraw.setPenRadius(0.005D);
            StdDraw.setPenColor(Color.LIGHT_GRAY);

            DrawUtilities.drawArrow(coordinates[vertex1], coordinates[vertex2], length, width);
        }

        private void sleep() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
    public static void main(String[] args) {
        String filePath = "/Users/marzan/NetBeansProjects/bellmanfordsp/src/bellmanfordsp/tinyEWD.txt";
        EdgeWeightedDigraph edgeWeightedDigraph = new EdgeWeightedDigraph(new In(filePath));

        new BellmanFordSP().new Animation(edgeWeightedDigraph, 0, -0.5, 5.2,
                        -0.2, 5.2, 0.25, 0.06, 0.03);
    }

}