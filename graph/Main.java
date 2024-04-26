public class Main {
  public static void main(String[] args) {
    Graph graph = new Graph();
    graph.addNode("A");
    graph.addNode("B");
    graph.addNode("C");
    graph.addNode("D");
    graph.addEdge("A", "B");
    graph.addEdge("B", "D");
    graph.addEdge("D", "C");
    graph.addEdge("A", "C");
    graph.print();
    graph.traverseDepthFirst("A");
    System.out.println();
    graph.traverseBreadthFirst("A");

    var g = new Graph();
    g.addNode("A");
    g.addNode("X");
    g.addNode("B");
    g.addNode("C");
    g.addEdge("A", "C");
    g.addEdge("B", "C");
    g.addEdge("X", "A");
    g.addEdge("X", "B");
    System.out.println();

    System.out.println(g.topologicalSort());
    var g1 = new Graph();
    g1.addNode("A");
    g1.addNode("B");
    g1.addNode("C");
    g1.addEdge("A", "B");
    g1.addEdge("B", "C");
    g1.addEdge("C", "A");
    System.out.println(g1.hasCycle());
  }
}