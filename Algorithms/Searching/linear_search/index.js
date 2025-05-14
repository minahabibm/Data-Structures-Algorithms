function linearSearch(arr, key) {
  for(let i = 0; i < arr.length; i++) {
    if(arr[i] === key){
      return i
    }
  }
  return -1
}

let arr = [ 2, 3, 4, 10, 40 ]
let x = 10
let result = linearSearch(arr, x)
result === -1 ? console.log("Element is not present in array" ) : console.log("Element is present at index " + result)