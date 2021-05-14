#include <iostream>
#include <map>

using namespace std;

map<int, int> cache;
int memoize(int N) {
  if (cache.find(N) != cache.end()) {
    return cache[N];
  }
  
  int result;
  if (N < 2) {
    result = N;
  } else {
    result = memoize(N-1) + memoize(N-2);
  }
  // put result in cache for later reference.
  cache[N] = result;
  return result;
}

int fib(int n) {
  if (n <= 1) {
    return n;
  }
  return memoize(n);
}

int main() {
  cout << "Memoization Fibonacci Number \n";
  cout << fib(1) << endl;
  cout << fib(2) << endl;
  cout << fib(3) << endl;
  cout << fib(4) << endl;
  cout << fib(5) << endl;
}
