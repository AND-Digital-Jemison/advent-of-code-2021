function day04markDrawnNumbers(board, drawnNumbers, boardCheckedNumbers) {
  let count = 0;
  let lastCalledNumber;
  const checkedNumbers = boardCheckedNumbers.map((y) => y);
  for (let i = 0; i < drawnNumbers.length; i++) {
    for (let x = 0; x < 5; x++) {
      for (let y = 0; y < 5; y++) {
        if (board[x][y] === drawnNumbers[i]) {
          count += 1;
          checkedNumbers[x][y] = true;
          lastCalledNumber = drawnNumbers[i];
        }
      }
    }
  }
  return [count, checkedNumbers, lastCalledNumber];
}

module.exports = day04markDrawnNumbers;
