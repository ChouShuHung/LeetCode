package dynamic;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

    // Stack<Character> stack = new Stack<>();
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, "", n, 0, 0);
        return result;
    }

    private static void dfs(List<String> result, String s, int n, int open, int close) {
        if (open == close && open == n) {
            result.add(s);
            return;
        }

        if (open < n) {
            dfs(result, s + "(", n, open + 1, close);
        }

        if (close < open) {
            dfs(result, s + ")", n, open, close + 1);
        }
    }
}
