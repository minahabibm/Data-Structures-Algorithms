// 2D-Memoization

class Main {
  public static boolean isinter(String s1, int i, String s2, int j, String s3, int k, int[][] memo) {
    if (i == s1.length()) {
      return s2.substring(j).equals(s3.substring(k));
    }
    if (j == s2.length()) {
      return s1.substring(i).equals(s3.substring(k));
    }
    if (memo[i][j] > -1) {
      return memo[i][j] == 1 ? true : false;
    }
    boolean ans = false;
    if (s3.charAt(k) == s1.charAt(i) && isinter(s1, i + 1, s2, j, s3, k + 1, memo)
            || s3.charAt(k) == s2.charAt(j) && isinter(s1, i, s2, j + 1, s3, k + 1, memo)) {
      ans = true;
    }
    memo[i][j] = ans ? 1 : 0;
    return ans;
  }
  public static boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }
    int memo[][] = new int[s1.length()][s2.length()];
    for (int i = 0; i < s1.length(); i++) {
      for (int j = 0; j < s2.length(); j++) {
        memo[i][j] = -1;
      }
    }
    return isinter(s1, 0, s2, 0, s3, 0, memo);
  }
  
  public static void main(String[] args) {
    System.out.println("Interleaving String");
    System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
  }

}