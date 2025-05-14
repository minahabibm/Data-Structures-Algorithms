let merge = (left, right) => {
  let arr = []
  while (left.length && right.length) {
    if (left[0] < right[0]) {
      arr.push(left.shift())  
    } else {
      arr.push(right.shift()) 
    }
  }
  return [ ...arr, ...left, ...right ]
}

let mergeSorting = (array) =>  {
  if (array.length <= 1) return array;
  let 
    mid = Math.floor(array.length / 2), 
    left = mergeSorting(array.slice(0, mid)), 
    right = mergeSorting(array.slice(mid));

  return merge(left, right);
}

const arr = [64, 34, 25, 12, 22, 11, 90];
let SortedArray = mergeSorting(arr);
console.log("sorted Array:", SortedArray);