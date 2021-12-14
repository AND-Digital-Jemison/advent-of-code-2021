function day04calculateSumUnmarkedNumbers(board, boardCheckedNumbers) {
  let sum = 0;
  for (let column = 0; column < 5; column++) {
    for (let row = 0; row < 5; row++) {
      if (boardCheckedNumbers[row][column] === true) continue;
      sum += board[row][column];
    }
  }
  return sum;
}

module.exports = day04calculateSumUnmarkedNumbers;
