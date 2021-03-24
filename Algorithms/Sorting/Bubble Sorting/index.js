let bubbleSorting = (inputArray) => {
  let len = inputArray.length;
  let swapped;
  do {
    swapped = false;
    for (let i = 0; i < len; i ++){
      if (inputArray[i] > inputArray[i + 1]){
        let tmp = inputArray[i];
        inputArray[i] = inputArray[i + 1];
        inputArray[i + 1] = tmp;
        swapped = true;
      }
    }
  }while(swapped);
  return inputArray;
};

const arr = [64, 34, 25, 12, 22, 11, 90];
let SortedArray = bubbleSorting(arr);
console.log("sorted Array:", SortedArray);