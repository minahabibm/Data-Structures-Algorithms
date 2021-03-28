let jumpSearch = (arr, x, n) => {
  let step = Math.sqrt(n); 
  let prev = 0;
  while (arr[Math.min(step, n)-1] < x) {
    prev = step;
    step += Math.sqrt(n);
    if (prev >= n)
      return -1;
  }
  while (arr[prev] < x) {
    prev++;
    if (prev == Math.min(step, n))
      return -1;
  }
  if (arr[prev] == x)
    return prev;
  
  return -1;
}
 
let arr = [0, 1, 1, 2, 3, 5, 8, 34, 55, 80, 89, 90, 144, 233, 377, 610];
let x = 55;
let n = arr.length;    

let index = jumpSearch(arr, x, n);  
index === -1 ? console.log("Element is not present in array" ) : console.log("Element is present at index " + index)   