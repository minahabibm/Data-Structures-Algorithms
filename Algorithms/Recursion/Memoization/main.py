class CoinChange(object):
  def __init__(self):
    self.memo = {0: 0}
  
  def coinChange(self, coins, amount):
    coins.sort()
    minCoins = self.getMinCoins(coins, amount)
    
    if minCoins == float('inf'):
      return -1
    
    return minCoins
      
  def getMinCoins(self, coins, amount):
    if amount in self.memo:
      return self.memo[amount]
    
    minCoins = float('inf')
    
    for c in coins:
      if amount - c <  0: 
        break
          
      numCoins = self.getMinCoins(coins, amount - c) + 1
      minCoins = min(numCoins, minCoins)

    self.memo[amount] = minCoins
    
    return minCoins

coinChange = CoinChange()
print(coinChange.getMinCoins([1,2,5], 11))
