let selectionSorting = (inputArray) => {
  let n = inputArray.length;      
  for(let i = 0; i < n; i++) {
    let min = i;
    for(let j = i+1; j < n; j++) {
      if(inputArray[j] < inputArray[min]) {
        min=j; 
      }
    }
    if (min != i) {
      let tmp = inputArray[i]; 
      inputArray[i] = inputArray[min];
      inputArray[min] = tmp;      
    }
  }
  return inputArray;
};
const arr = [64, 34, 25, 12, 22, 11, 90];
let SortedArray = selectionSorting(arr);
console.log("sorted Array:", SortedArray);