#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int jumpSearch(int arr[], int x, int n){
  int step = sqrt(n);
  int prev = 0;
  while (arr[min(step, n)-1] < x) {
    prev = step;
    step += sqrt(n);
    if (prev >= n)
      return -1;
  }

  while (arr[prev] < x){
    prev++;
    if (prev == min(step, n))
      return -1;
  }

  if (arr[prev] == x) {
    return prev;
  }

  return -1;
}

// Driver program to test function
int main() {
  int arr[] = { 0, 1, 1, 2, 3, 4, 5, 8, 12, 20, 40, 55, 89, 144, 233, 377, 610 };
  int x = 55;
  int n = sizeof(arr) / sizeof(arr[0]);

  int index = jumpSearch(arr, x, n);

  (index == -1) ? cout << "Element is not present in array \n" : cout << "Element is present at index " << index << endl;

  return 0;
}
