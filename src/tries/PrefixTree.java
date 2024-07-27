package tries;

public class PrefixTree {

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    System.out.println(trie.search("apple")); // return True
    System.out.println(trie.search("app")); // return False
    System.out.println(trie.startsWith("app")); // return True
    trie.insert("app");
    trie.search("app");
  }
}

class Trie {

  Node root;

  public Trie() {
    root = new Node('\0');
  }

  public void insert(String word) {
    Node current = root;
    for (char letter : word.toCharArray()) {
      if (current.children[letter - 'a'] == null) {
        current.children[letter - 'a'] = new Node(letter);
      }
      current = current.children[letter - 'a'];
    }
    current.isWord = true;
  }

  public boolean search(String word) {
    Node result = getLast(word);
    return result != null && result.isWord;
  }

  private Node getLast(String word) {
    Node current = root;
    for (char letter : word.toCharArray()) {
      if (current.children[letter - 'a'] == null) return null;
      current = current.children[letter - 'a'];
    }
    return current;
  }

  public boolean startsWith(String prefix) {
    Node result = getLast(prefix);
    return null != result;
  }

  class Node {
    private char value;
    private boolean isWord;
    private Node[] children;

    public Node(char val) {
      this.value = val;
      this.isWord = false;
      this.children = new Node[26];
    }
  }
}
