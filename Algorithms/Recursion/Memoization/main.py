'''
  memo = {}
  def memoization(i, memo):
   if meet the End Conditon:
     return
   if i in memo:
     return memo[i]
   memo[i] = recur memoization(i , memo)
'''

def fib(N):
  cache = {}
  def recur_fib(N):
    if N in cache:
      return cache[N]

    if N < 2:
      result = N
    else:
      result = recur_fib(N-1) + recur_fib(N-2)

    # put result in cache for later reference.
    cache[N] = result
    return result

  return recur_fib(N)

print(fib(5))
