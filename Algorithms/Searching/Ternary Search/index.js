let ternarySearch = (left, right, target, arr) => {
	if (right >= left) {
		let mid1 = Math.floor(left + (right - left) /3);
		let mid2 = Math.floor(right - (right - left) /3);

		if (arr[mid1] == target) {
			return mid1;
		}
		else if (arr[mid2] == target) {
			return mid2;
		}

		if (target < arr[mid1]) {
			return ternarySearch(left, mid1 - 1, target, arr);
		}
		else if (target > arr[mid2]) {
			return ternarySearch(mid2 + 1, right, target, arr);
		}
		else {
			return ternarySearch(mid1 + 1, mid2 - 1, target, arr);
		}
	}
	return false;
}

const arr = [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ]
var l = 0
var r = 9
var key = 5
let result = ternarySearch(l, r, key, arr);
result == true ? console.log("Element is not present in array" ) : console.log("Element is present at index " , result);

var key = 110
result = ternarySearch(l, r, key, arr);
result == false ? console.log("Element is not present in array" ) : console.log("Element is present at index " , result);