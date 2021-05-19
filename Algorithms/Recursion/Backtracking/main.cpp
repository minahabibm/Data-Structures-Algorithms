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
//1. Subset

#include <iostream>
#include <vector>
  
using namespace std;

vector<vector<int>> res;

void backtrack(vector<int>& nums, int start, vector<int>& track) {
  res.push_back(track);
  for (int i = start; i < nums.size(); i++) {
    // select
    track.push_back(nums[i]);
    // backtrack
    backtrack(nums, i + 1, track);
    // deselect
    track.pop_back();
  }
}

vector<vector<int>> subsets(vector<int>& nums) {
  // record the path
  vector<int> track;
  backtrack(nums, 0, track);
  return res;
}

int main() {
  std::cout << "Backtracking\n";
  vector<int> nums;
  nums = {1,2,3};
  cout << "\nSize : " << res.size() << endl;
  subsets(nums);
  for(int i=0; i < res.size(); i++){
    cout << "[ ";
    for(int j=0; j < res.at(i).size(); j++){
      cout << res.at(i).at(j) << " ";
    }
    cout << ']'<< endl;
  }

}