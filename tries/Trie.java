import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {

  private Node root = new Node(' ');

  public void insert(String word) {
    Node curr = this.root;
    for (var ch : word.toCharArray()) {
      if (!curr.hasChild(ch)) {
        curr.addChild(ch);
      }
      curr = curr.getChild(ch);
    }
    curr.isEndOfWord = true;
  }

  public boolean contains(String word) {
    Node curr = root;
    for (var ch : word.toCharArray()) {
      if (!curr.hasChild(ch))
        return false;
      curr = curr.getChild(ch);
    }
    return curr.isEndOfWord;
  }

  public void traverse() {
    walkTraverse(root);
  }

  private void walkTraverse(Node root) {
    // Pre-order
    System.out.println(root.value);
    for (Node child : root.getChildren()) {
      walkTraverse(child);
    }
  }

  public void remove(String word) {
    if (word == null) {
      return;
    }
    walkRemove(root, word, 0);
  }

  private void walkRemove(Node root, String word, int idx) {
    if (idx == word.length()) {
      root.isEndOfWord = false;
      return;
    }
    char ch = word.charAt(idx);
    Node child = root.getChild(ch);
    if (child == null) {
      return;
    }
    walkRemove(child, word, idx + 1);

    if (!child.hasChildren() && !child.isEndOfWord)
      root.removeChild(ch);
    ;
  }

  public List<String> autocomplete(String prefix) {
    List<String> words = new ArrayList<>();
    var lastNode = findLastNode(prefix);
    findWords(lastNode, prefix, words);

    return words;

  }

  private void findWords(Node root, String prefix, List<String> words) {

  }

  private Node findLastNode(String prefix) {
    var curr = root;
    for (char ch : prefix.toCharArray()) {
      var child = curr.getChild(ch);
      if (child == null) {
        return null;
      }
      curr = child;
    }
    return curr;

  }

  private class Node {
    char value;
    private HashMap<Character, Node> children = new HashMap<>();
    boolean isEndOfWord;

    public Node(char character) {
      this.value = character;
    }

    @Override
    public String toString() {
      return "value" + value;
    }

    public boolean hasChild(char ch) {
      return children.containsKey(ch);
    }

    public void addChild(char ch) {
      children.put(ch, new Node(ch));
    }

    public Node getChild(char ch) {
      return children.get(ch);
    }

    public Node[] getChildren() {
      return children.values().toArray(new Node[0]);
    }

    public boolean hasChildren() {
      return !children.isEmpty();
    }

    public void removeChild(char ch) {
      children.remove(ch);
    }

  }
}