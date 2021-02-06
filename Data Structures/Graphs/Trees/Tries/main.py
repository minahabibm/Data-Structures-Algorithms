
class TrieNode:
  def __init__(self, char):
    self.char = char
    self.isEndOfWord = False
    self.triNode = {}

class Trie(object):
  def __init__(self):
    self.root = TrieNode("")
    
  def insert(self, word):
    node = self.root
    for char in word:
      if char in node.triNode:
        node = node.triNode[char]
      else:
        new_node = TrieNode(char)
        node.triNode[char] = new_node
        node = new_node
    node.isEndOfWord = True
        
  def search(self, word):
    current = self.root
    for l in word:
      if l not in current.triNode:
        return False
      current = current.triNode[l]
    return current.isEndOfWord

  def delete(self, word):
    self._delete(self.root, word, 0)
  def _delete(self, current, word, index):
    if(index == len(word)):
      if not current.isEndOfWord:
        return False
      current.isEndOfWord = False
      return len(current.triNode.keys()) == 0

    ch = word[index]
    if ch not in current.triNode:
      return False

    node = current.triNode[ch]
    should_delete_current_node = self._delete(node, word, index + 1)

    if should_delete_current_node:
      current.triNode.pop(ch)
      return len(current.triNode) == 0

    return False

  '''Extras'''
  def print(self):
    return self._print(self.root)
  def _print(self, node):
    if node == None:
      return
    for i in node.triNode :
      print("->", end =" ")
      print(i, end =" ")
      self._print(node.triNode[i])
    return
	
  def dfs(self, node, prefix):
    if node.isEndOfWord:
      self.output.append((prefix + node.char)) 
    for child in node.triNode.values():
      self.dfs(child, prefix + node.char)
  def prefix(self, x):
    self.output = []
    node = self.root        
    for char in x:
      if char in node.triNode:
        node = node.triNode[char]
      else:
        return []

    # Traverse the trie to get all candidates
    self.dfs(node, x[:-1])

    # Sort the results in reverse order and return
    return sorted(self.output, key=lambda x: x[1], reverse=True)
  

if __name__=='__main__': 
  print("Hello World")
  trie = Trie()
  arr = ["hello", "hi", "teabag", "teacan"]
  
  for i in arr:
    trie.insert(i)

  trie.print()
  print()
  print(trie.search('hello'))
  print(trie.search('helo'))
  print(trie.prefix('tea'))
  print(trie.search('teabag'))
  trie.delete('teabag')
  print(trie.search('teabag'))
  trie.print()
  print()
  print(trie.prefix('tea'))
