/**
 * memo = {}
 * def memoization(i, memo):
 *  if meet the End Conditon:
 *    return
 *  if i in memo:
 *    return memo[i]
 *  memo[i] = recur memoization(i , memo)
**/

const memoizationCS = ( i, n, memo) =>  {
  if (i > n ) return 0
  if (i === n) return 1
  if (memo[i]) return memo[i]
  memo[i] = memoizationCS(i + 1, n, memo) + memoizationCS(i + 2, n, memo)
  return memo[i]
}
const climbStairs = (n) => {
  memo = {}
  return memoizationCS(0,n, memo)
}
console.log(climbStairs(45))