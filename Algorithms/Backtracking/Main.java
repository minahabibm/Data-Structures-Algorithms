/**
  result = []
  def backtrack(Path, Seletion List):
    if meet the End Conditon:
        result.add(Path)
        return

    for seletion in Seletion List:
        select
        backtrack(Path, Seletion List)
        deselect
**/
// 1. Combination
import java.util.*;

class Main {

  public static List<List<Integer>> combine(int n, int k) {
    int[] subArr = new int[k];
    List<List<Integer>> result = new ArrayList<>();
    backtracking(0, 0, n, k, subArr, result);
    return result;
  }

  private static void backtracking(int i, int count, int n, int k, int[] subArr, List<List<Integer>> result) {
    if (k == 0) {
      List<Integer> subList = new ArrayList<>();
      for (int a : subArr) subList.add(a);
      result.add(subList);
    } else {
      for (int j = i + 1; j <= n; j++) {
        subArr[count] = j;
        backtracking(j, count + 1, n, k - 1, subArr, result);
      }
    }
  }
  
  public static void main(String[] args) {
    System.out.println("Backtracking");

    List<List<Integer>> result = combine(4, 2);
    System.out.println(result);
  }
}

