import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

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

  public void traverseDepthFirstRec(String root) {
    var node = nodes.get(root);
    if (node == null) {
      return;
    }
    Stack<Node> stack = new Stack<>();
    Set<Node> seen = new HashSet<>();

    stack.push(node);

    while (!stack.isEmpty()) {
      var stackNode = stack.pop();
      System.out.println(stackNode.label);
      seen.add(stackNode);
      for (var ajdNode : adjList.get(stackNode)) {
        if (!seen.contains(ajdNode))
          stack.push(ajdNode);
      }
    }
  }

  public void traverseBreadthFirst(String root) {
    var node = nodes.get(root);
    if (node == null) {
      return;
    }
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(node);
    Set<Node> seen = new HashSet<>();

    while (!queue.isEmpty()) {
      var qNode = queue.remove();
      System.out.println(qNode.label);
      seen.add(qNode);
      for (var adjNode : adjList.get(qNode)) {
        if (!seen.contains(adjNode)) {
          queue.add(adjNode);
        }
      }

    }
  }

  public List<String> topologicalSort() {

    Stack<Node> stack = new Stack<>();
    Set<Node> visited = new HashSet<>();
    for (var node : nodes.values()) {
      System.out.println(node.label);
      topologicalWalk(node, stack, visited);
    }
    List<String> sorted = new ArrayList<>();
    while (!stack.empty())
      sorted.add(stack.pop().label);
    return sorted;
  }

  private void topologicalWalk(Node curr, Stack<Node> stack, Set<Node> visited) {
    if (visited.contains(curr))
      return;

    visited.add(curr);
    for (var neighbor : adjList.get(curr)) {
      topologicalWalk(neighbor, stack, visited);
    }
    System.out.println("Value added " + curr.label);
    stack.push(curr);

  }

  public boolean hasCycle() {
    Set<Node> all = new HashSet<>();
    all.addAll(nodes.values());
    Set<Node> visiting = new HashSet<>();
    Set<Node> visited = new HashSet<>();
    while (!all.isEmpty()) {
      var curr = all.iterator().next();
      if (hasCycleWalk(curr, all, visiting, visited))
        return true;
    }
    return false;
  }

  private boolean hasCycleWalk(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
    all.remove(node);
    visiting.add(node);
    for (var neighbor : adjList.get(node)) {
      if (visited.contains(neighbor))
        continue;

      if (visiting.contains(neighbor))
        return true;

      if (hasCycleWalk(neighbor, all, visiting, visited))
        return true;

    }
    visiting.remove(node);
    visited.add(node);
    return false;
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