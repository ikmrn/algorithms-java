public class WeightedGraph {

  private class Node {
    String label;

    public Node(String label) {
      this.label = label;
    }

    @Override
    public String toString() {
      return label;
    }
  }

  private class Edge {
    Node from;
    Node to;
    int weight;

    public Edge(String from, String to, int weight) {
      this.from = new Node(from);
      this.to = new Node(to);
      this.weight = weight;
    }

    @Override
    public String toString() {
      return from + "->" + to;
    }
  }
}
