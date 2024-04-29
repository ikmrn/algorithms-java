import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
  TrieNode root = new TrieNode(' ');

  public void insertWord(String word) {
    var curr = this.root;
    for (var ch : word.toCharArray()) {
      ch = Character.toLowerCase(ch);
      if (!curr.hasChild(ch)) {
        curr.addChild(ch);
      }
      curr = curr.getChild(ch);
    }
    curr.isEnd = true;
  }

  public List<String> autocomplete(String prefix) {
    List<String> result = new ArrayList<>();
    var lastNode = findLastNode(prefix);
    if (lastNode == null) {
      System.out.println("No words starting with " + prefix + " in our database.");
      return result;
    }
    autocompleteWalk(lastNode, result, prefix);
    return result;

  }

  public void autocompleteWalk(TrieNode curr, List<String> arr, String prefix) {

    if (curr.isEnd == true) {
      arr.add(prefix);
    }
    for (var child : curr.getChildren()) {
      var word = prefix + child.value;
      autocompleteWalk(child, arr, word);
    }

  }

  private TrieNode findLastNode(String word) {
    var curr = this.root;
    for (char ch : word.toCharArray()) {
      var child = curr.getChild(ch);
      if (child == null)
        return null;
      curr = child;
    }
    return curr;
  }

  public boolean contains(String word) {
    var curr = this.root;
    for (var ch : word.toCharArray()) {
      ch = Character.toLowerCase(ch);
      if (!curr.hasChild(ch)) {
        return false;
      }
      curr = curr.getChild(ch);
    }
    return curr.isEnd;
  }

  public void removeWord(String word) {
    removeWalk(root, word, 0);
  }

  private void removeWalk(TrieNode curr, String word, int idx) {
    if (idx == word.length()) {
      curr.isEnd = false;
      return;
    }
    char ch = word.charAt(idx);
    idx++;
    if (!curr.hasChild(ch)) {
      System.out.println("No such word.");
      return;
    }
    var child = curr.getChild(ch);
    removeWalk(child, word, idx);

    if (!child.hasChildren() && !child.isEnd) {
      curr.removeChild(ch);
    }
  }

  private class TrieNode {
    char value;
    boolean isEnd;
    HashMap<Character, TrieNode> children;

    public TrieNode(char ch) {
      this.value = ch;
      children = new HashMap<>();
    }

    public boolean hasChild(char ch) {
      return children.containsKey(ch);
    }

    public void addChild(char ch) {
      children.put(ch, new TrieNode(ch));
    }

    public TrieNode getChild(char ch) {
      return children.get(ch);
    }

    public boolean hasChildren() {
      return !children.isEmpty();
    }

    public TrieNode[] getChildren() {
      return children.values().toArray(new TrieNode[0]);
    }

    public void removeChild(char ch) {
      children.remove(ch);
    }

  }
}