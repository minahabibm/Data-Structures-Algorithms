const getMax = (arr) => {
  let max = 0;
  for (let num of arr) {
    if (max < num.toString().length) {
      max = num.toString().length
    }
  }
  return max
}
const getPosition = (num, place) => {
 return  Math.floor(Math.abs(num)/Math.pow(10,place))% 10
}

const radixSort = (arr) => {
  const max = getMax(arr); // length of the max digit in the array
  for (let i = 0; i < max; i++) {
    let buckets = Array.from({ length: 10 }, () => [ ])
    for (let j = 0; j < arr.length; j++) {
      buckets[getPosition(arr[ j ], i)].push(arr[ j ]); // pushing into buckets
    }
    arr = [ ].concat(...buckets);
  }
  return arr
}

const unsortedArr = [31, 27, 28, 42, 13, 8, 11, 30, 17, 41, 15, 43, 1, 36, 9, 16, 20, 35, 48, 37, 7, 26, 34, 21, 22, 6, 29, 32, 49, 10, 12, 19, 24, 38, 5, 14, 44, 40, 3, 50, 46, 25, 18, 33, 47, 4, 45, 39, 23, 2];
console.log(radixSort(unsortedArr));