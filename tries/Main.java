public class Main {
  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("can");
    trie.insert("cannot");

    trie.remove("cannot");
    System.out.println(trie.contains("can"));
    System.out.println(trie.contains("cannot"));

  }
}