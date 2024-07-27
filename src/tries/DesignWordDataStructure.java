package tries;

public class DesignWordDataStructure {

  public static void main(String[] args) {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    wordDictionary.search("pad"); // return False
    wordDictionary.search("bad"); // return True
    wordDictionary.search(".ad"); // return True
    wordDictionary.search("b.."); // return True
  }
}

class WordDictionary {

  Node root;

  public WordDictionary() {
    root = new Node('\0');
  }

  public void addWord(String word) {
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
    boolean result = searchHelper(word, root, 0);
    System.out.println(result);
    return result;
  }

  private boolean searchHelper(String word, Node current, int index) {
    if (index == word.length()) return current.isWord;

    char letter = word.charAt(index);
    if (letter == '.') {
      for (Node temp : current.children) {
        if (temp != null && searchHelper(word, temp, index + 1)) return true;
      }
      return false;
    }
    
    if (current.children[letter - 'a'] == null) return false;
    current = current.children[letter - 'a'];

    return searchHelper(word, current.children[letter - 'a'], index + 1);
  }

  class Node {

    private boolean isWord;
    private char value;
    private Node[] children;

    Node(char value) {
      this.value = value;
      this.isWord = false;
      children = new Node[26];
    }
  }
}
