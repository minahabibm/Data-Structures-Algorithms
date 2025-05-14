function binarySearch(arr, l, r, key) {
  if (r >= l) {
    mid = Math.floor((r + l) / 2);
    if (arr[mid] == key) {
      return mid
    }
    if (arr[mid] > key) {
      return binarySearch(arr, l, mid - 1, key); 
    }
    return binarySearch(arr, mid + 1, r, key); 
  } 
  return -1; 
}

let arr = [ 2, 3, 4, 10, 40 ]
let x = 10
let result = binarySearch(arr, 0, arr.length - 1, x)
result === -1 ? console.log("Element is not present in array" ) : console.log("Element is present at index " + result)