/**
 * result = []
 * def backtrack(Path, Seletion List):
 *  if meet the End Conditon:
 *    result.add(Path)  
 *    return
 *  for seletion in Seletion List:
 *    select  
 *    backtrack(Path, Seletion List)
 * deselect
**/
// 4. N Queens

var isValidQueen = function(row, col, n) {
  //check for spots above on this column
  for(let i = 0; i < row; i++) {
    if(chessBoard[i][col] === "Q") return false;
  }
  //check for up left
  for(let i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
    if(chessBoard[i][j] === "Q") return false;
  }
  //check for up right
  for(let i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
    if(chessBoard[i][j] === "Q") return false;
  }
  return true;
}

var backtrack = function(row, n) {
  if(row === n) {
    result.push([...chessBoard].map(row => row.join('')));
    return;
  }
  for(var col = 0; col < n; col++) {
    if(isValidQueen(row, col, n)) {
      chessBoard[row][col] = "Q";
      backtrack(row + 1, n);
      chessBoard[row][col] = ".";
    }
  }
}

var result = [];
var chessBoardSize = 4;
var chessBoard = new Array(chessBoardSize);
for(var i = 0; i < chessBoardSize; i++) {
  chessBoard[i] = new Array(chessBoardSize).fill(".");
}

backtrack(0, chessBoardSize);

console.log(result); 