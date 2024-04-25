public class Main {
  public static void main(String[] args) {
    Trie trie = new Trie();

    trie.insert("can");
    trie.insert("cannot");
    trie.insert("cans");
    System.out.println(trie.contains("cannot"));
    System.out.println(trie.contains("can"));
    System.out.println(trie.contains("cans"));
    trie.insert("canton");
    trie.insert("rabbit");
    trie.insert("rabbits");
    trie.remove("rabbit");
    trie.insert("cartoon");
    trie.traverse();
    // trie.traverse();
    System.out.println();
    System.out.println(trie.autocomplete("ca"));
  }
}