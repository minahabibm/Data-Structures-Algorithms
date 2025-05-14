const pivot = (arr, start = 0, end = arr.length + 1) => {
  const swap = (list, a, b) => [list[a], list[b]] = [list[b], list[a]];
  let pivot = arr[start], pointer = start;
  for (let i = start; i < arr.length; i++) {
    if (arr[i] < pivot  ) {
      pointer++;
      swap(arr, pointer, i);
    }
  };
  swap(arr, start, pointer);
  return pointer;
}

const quickSort = (arr, start = 0, end = arr.length) => {
  let pivotIndex = pivot(arr, start, end);

  if (start >= end) return arr;
  quickSort(arr, start, pivotIndex);
  quickSort(arr, pivotIndex + 1, end);

  return arr;
};

const unsortedArr = [31, 27, 28, 42, 13, 8, 11, 30, 17, 41, 15, 43, 1, 36, 9, 16, 20, 35, 48, 37, 7, 26, 34, 21, 22, 6, 29, 32, 49, 10, 12, 19, 24, 38, 5, 14, 44, 40, 3, 50, 46, 25, 18, 33, 47, 4, 45, 39, 23, 2];
let SortedArray = quickSort(unsortedArr);
console.log("sorted Array:", SortedArray);
