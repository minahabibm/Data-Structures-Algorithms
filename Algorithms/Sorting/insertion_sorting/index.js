let insertionSorting = (inputArray) => {
  let length = inputArray.length;
  for (let i = 1; i < length; i++) {
    let key = inputArray[i];
    let j = i - 1;
    while (j >= 0 && inputArray[j] > key) {
      inputArray[j + 1] = inputArray[j];
      j = j - 1;
    }
    inputArray[j + 1] = key;
  }
  return inputArray;
};
const arr = [64, 34, 25, 12, 22, 11, 90];
let SortedArray = insertionSorting(arr);
console.log("sorted Array:", SortedArray);