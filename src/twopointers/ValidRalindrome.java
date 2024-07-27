package twopointers;

public class ValidRalindrome {

  public static void main(String[] args) {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(isPalindrome("race a car"));
    System.out.println(isPalindromeA("Madam, in Eden, I'm Adam"));
    System.out.println();
    // System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    // System.out.println(isPalindromeOther("race a car"));
  }

  public static boolean isPalindrome(String s) {
    char[] str = s.toLowerCase().toCharArray();
    int left = 0;
    int right = str.length - 1;
    // System.out.println(Arrays.toString(str));
    while (left < right) {
      if (isNotLetterOrDigit(str[left])) {
        left++;
      } else if (isNotLetterOrDigit(str[right])) {
        right--;
      } else if (left != right && str[left] != str[right]) {
        return false;
      } else {
        left++;
        right--;
      }
    }
    return true;
  }

  private static boolean isNotLetterOrDigit(char c) {
    return !((c >= 'a' && c <= 'z') || (c >= '0' & c <= '9'));
  }

  public static boolean isPalindromeA(String s) {
    int left = 0;
    int right = s.length() - 1;
    while(left<right){
        while(left < right && !isAlpha(s.charAt(left))){
            left++;
        }
        while(left < right && !isAlpha(s.charAt(right))){
            right--;
        }
        if(Character.toLowerCase(s.charAt(left)) 
         != Character.toLowerCase(s.charAt(right))) return false;
        left++;
        right--;
    }
    return true;
}

private static boolean isAlpha(char c){
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
}
}
