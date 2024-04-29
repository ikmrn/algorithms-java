public class Main {
  public static void main(String[] args) {
    var trie = new Trie();
    trie.insertWord("can");
    trie.insertWord("cannot");
    trie.insertWord("click");
    trie.insertWord("clicks");
    trie.insertWord("copper");
    trie.insertWord("cold");
    trie.insertWord("quack");
    System.out.println(trie.autocomplete("co"));
    System.out.println(trie.autocomplete("c"));

  }
}