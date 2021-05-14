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
  
  static List<List<Integer>> result = new ArrayList<>();

  public static List<List<Integer>> combine(int n, int k) {
    if (k <= 0 || n <= 0) return result;
    List<Integer> track = new ArrayList<>();
    backtrack(n, k, 1, track);
    return result;
  }

  private static void backtrack(int n, int k, int start, List<Integer> track) {
    if (k == track.size()) {
      List<Integer> subList = new ArrayList<>();
      for (int a : track) subList.add(a);
      result.add(subList);
    } 
    
    for (int i = start; i <= n; i++) {
      track.add(i);
      backtrack(n, k, i + 1, track);
      track.remove(track.size() - 1);
    }
    
  }
  
  public static void main(String[] args) {
    System.out.println("Backtracking");

    List<List<Integer>> result = combine(4, 2);
    System.out.println(result);
  }
}