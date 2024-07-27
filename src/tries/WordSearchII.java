package tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class WordSearchII {

  private static Trie currentTrie;

  public static void main(String[] args) {
    //   char[][] board = { { 'a', 'b' }, { 'c', 'd' } };
    char[][] board = {
      { 'o', 'a', 'a', 'n' },
      { 'e', 't', 'a', 'e' },
      { 'i', 'h', 'k', 'r' },
      { 'i', 'f', 'l', 'v' }
    };
    String[] words = new String[] { "oath", "pea", "eat", "rain", "o" };
    System.out.println(Arrays.asList(findWords(board, words)));
  }

  public static List<String> findWords(char[][] board, String[] words) {
    HashSet<String> result = new HashSet<>();
    HashSet<String> visit = new HashSet<>();

    Trie root = new Trie();
    // Set<Charater> colSet
    for (String word : words) {
      root.addWord(word);
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(i, j, root, "", result, visit, board, root);
      }
    }
    return new ArrayList<>(result);
  }

  private static void dfs(
    int row,
    int col,
    Trie node,
    String word,
    HashSet<String> result,
    HashSet<String> visit,
    char[][] board,
    Trie root
  ) {
    if (
      row < 0 ||
      row == board.length ||
      col < 0 ||
      col == board[0].length ||
      !node.children.containsKey(board[row][col]) || // cannot find the word in the board
      //   node.children.get(board[row][col]).refs < 1 // the node has no next word
      visit.contains(row + "-" + col)
    ) return;

    visit.add(row + "-" + col);

    node = node.children.get(board[row][col]); // set Next Node
    word += board[row][col]; // append the letters to create the word
    if (node.isWord) {
      node.isWord = false;
      result.add(word);
      root.remove(word);
    }

    dfs(row + 1, col, node, word, result, visit, board, root);
    dfs(row - 1, col, node, word, result, visit, board, root);
    dfs(row, col + 1, node, word, result, visit, board, root);
    dfs(row, col - 1, node, word, result, visit, board, root);

    visit.remove(row + "-" + col);
  }

  static class Trie {

    Map<Character, Trie> children;
    boolean isWord;
    int refs;

    Trie() {
      this.children = new HashMap<>();
      isWord = false;
      refs = 0;
    }

    public void addWord(String word) {
      currentTrie = this;
      this.refs++;
      for (int i = 0; i < word.length(); i++) {
        char currentCharacter = word.charAt(i);
        if (!currentTrie.children.containsKey(currentCharacter)) {
          currentTrie.children.put(currentCharacter, new Trie());
        }
        currentTrie = currentTrie.children.get(currentCharacter);
        currentTrie.refs++;
      }
      currentTrie.isWord = true;
    }

    public void remove(String word) {
      currentTrie = this;
      currentTrie.refs--;
      for (int i = 0; i < word.length(); i++) {
        char currentCharacter = word.charAt(i);
        if (currentTrie.children.containsKey(currentCharacter)) {
          currentTrie = currentTrie.children.get(currentCharacter);
          currentTrie.refs--;
        }
      }
    }
  }
}
