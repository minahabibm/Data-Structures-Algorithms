def selectionSorting(arr):
  for i in range(len(arr)):
    min_idx = i
    for j in range(i+1, len(arr)):
      if arr[min_idx] > arr[j]:
        min_idx = j    
    arr[i], arr[min_idx] = arr[min_idx], arr[i]

# Driver code to test above
A = [64, 25, 12, 22, 11]
selectionSorting(A)
print ("Sorted array")
for i in range(len(A)):
  print ("%d" %A[i],end=" ")
print('')