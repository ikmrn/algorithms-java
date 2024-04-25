import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
  Node root = new Node(' ');

  public void insert(String word) {
    Node curr = this.root;
    for (char ch : word.toCharArray()) {
      if (!curr.hasChild(ch)) {
        curr.addChild(ch);
      }
      curr = curr.getChild(ch);
    }
    curr.isEnd = true;
  }

  public void remove(String word) {
    if (word == null) {
      System.out.println("No word provided");
      return;
    }
    walkRemove(root, word, 0);
  }

  private void walkRemove(Node root, String word, int idx) {
    if (idx == word.length()) {
      root.isEnd = false;
      return;
    }
    char ch = word.charAt(idx);
    idx++;
    if (!root.hasChild(ch)) {
      System.out.println("No Such Word.");
      return;
    }
    Node child = root.getChild(ch);
    walkRemove(child, word, idx);
    if (!child.hasChildren() && !child.isEnd) {
      root.removeChild(ch);
    }
  }

  public boolean contains(String word) {
    Node curr = this.root;
    for (char ch : word.toCharArray()) {
      if (!curr.hasChild(ch)) {
        return false;
      }
      curr = curr.getChild(ch);
    }
    return curr.isEnd;
  }

  public List<String> autocomplete(String prefix) {
    List<String> result = new ArrayList<>();
    Node lastNode = findLastNode(prefix);
    if (lastNode == null) {
      System.out.println("No word that begins " + "'" + prefix + "'" + " in our database");
      return result;
    }
    autocompleteWalk(lastNode, result, prefix);
    return result;
  }

  private Node findLastNode(String prefix) {
    Node curr = root;
    for (char ch : prefix.toCharArray()) {
      Node child = curr.getChild(ch);
      if (child == null) {
        return null;
      }
      curr = child;
    }
    return curr;
  }

  private void autocompleteWalk(Node currNode, List<String> arrList, String prefix) {
    if (!currNode.hasChildren() || currNode.isEnd == true) {
      // prefix = prefix + currNode.value;
      arrList.add(prefix);
    }

    for (Node child : currNode.getChildren()) {
      String word = prefix + child.value;
      autocompleteWalk(child, arrList, word);
    }
  }

  public void traverse() {
    walkTraverse(root);
  }

  public void walkTraverse(Node root) {
    if (!root.hasChildren()) {
      return;
    }
    for (Node child : root.getChildren()) {
      System.out.println(child.value);
      walkTraverse(child);
    }
  }

  private class Node {
    char value;
    HashMap<Character, Node> children = new HashMap<>();
    boolean isEnd;

    public Node(char ch) {
      this.value = ch;
    }

    public Node getChild(char ch) {
      return children.get(ch);
    }

    public boolean hasChild(char ch) {
      return children.containsKey(ch);
    }

    public void addChild(char ch) {
      children.put(ch, new Node(ch));
    }

    public boolean hasChildren() {
      return !children.isEmpty();
    }

    public Node[] getChildren() {
      return children.values().toArray(new Node[0]);
    }

    public void removeChild(char ch) {
      children.remove(ch);
    }

  }
}