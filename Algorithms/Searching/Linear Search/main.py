def linearSearch(arr, x): 
  for i in range(len(arr)):
    if arr[i] == x:
      return i 
  return -1

if __name__=='__main__': 
  arr = [ 2, 3, 4, 10, 40 ]
  x = 100
  result = linearSearch(arr, x)
  print("Element is not present in array" ) if result == -1 else print("Element is present at index " + str(result))
