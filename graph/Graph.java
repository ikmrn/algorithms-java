import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
  private HashMap<String, Node> nodes = new HashMap<>();
  private HashMap<Node, List<Node>> adjList = new HashMap<>();

  public void addNode(String label) {
    Node node = new Node(label);
    nodes.putIfAbsent(label, node);
    adjList.putIfAbsent(node, new ArrayList<>());
  }

  public void addEdge(String from, String to) {
    Node fromNode = nodes.get(from);
    if (fromNode == null) {
      throw new IllegalArgumentException("From is not valid");
    }
    Node toNode = nodes.get(to);
    if (toNode == null) {
      throw new IllegalArgumentException("To is not valid");
    }

    adjList.get(fromNode).add(toNode);
  }

  public void remove(String label) {
    var node = nodes.get(label);
    if (nodes == null) {
      return;
    }
    for (var key : adjList.keySet())
      adjList.get(key).remove(node);

    adjList.remove(node);
    nodes.remove(node);
  }

  public void removeEdge(String from, String to) {
    var fromNode = nodes.get(from);
    var toNode = nodes.get(to);
    if (fromNode == null || toNode == null) {
      return;
    }

    adjList.get(fromNode).remove(toNode);

  }

  public void print() {
    for (Node source : adjList.keySet()) {
      var targets = adjList.get(source);
      if (!targets.isEmpty()) {
        System.out.println(source + " is connected to " + targets);
      }
    }
  }

  public void traverseDepthFirst(String start) {
    var node = nodes.get(start);
    if (node == null) {
      return;
    }
    traverseDepthWalk(node, new HashSet<>());

  }

  private void traverseDepthWalk(Node root, HashSet<Node> seen) {
    if (seen.contains(root)) {
      return;
    }
    System.out.println(root.label);
    seen.add(root);
    for (var node : adjList.get(root)) {
      if (!seen.contains(node)) {
        traverseDepthWalk(node, seen);
      }
    }
  }

  private class Node {
    String label;

    public Node(String label) {
      this.label = label;
    }

    @Override
    public String toString() {
      return this.label;
    }

  }

}