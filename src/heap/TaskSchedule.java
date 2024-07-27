package heap;

public class TaskSchedule {

  public static void main(String[] args) {
    // char[] tasks = new char[] { 'A', 'A', 'B', 'B', 'B', 'B','C','C','C','C'};
    // B, A, Idle, B, A, Idle, B, Idle, Idle, B
    char[] tasks = new char[] { 'A', 'A', 'B', 'B'};
    System.out.println(leastInterval(tasks, 2));
  }

  public static int leastInterval(char[] tasks, int n) {
    int max = 0;
    int maxLetterCount = 0;
    int[] letters = new int[26];
    for (int i = 0; i < tasks.length; i++) {
      letters[tasks[i] - 'A']++;
    }
    for (int i = 0; i < 26; i++) {
      if (letters[i] > max) {
        max = letters[i];
        maxLetterCount = 1;
      } else if (letters[i] == max) {
        maxLetterCount++;
      }
    }
    // max-1 is the interval
    // 1+n is how many tasks will be executed in each interval
    // maxLetterCount is the maximum letter will be executed 
    return Math.max((max - 1) * (1 + n) + maxLetterCount, tasks.length);
  }
}
