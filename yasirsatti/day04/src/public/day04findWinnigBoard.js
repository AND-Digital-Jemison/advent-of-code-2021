function day04findWinnigBoard(randomNumbers, boards, boardsCheckedNumbersInit) {
  const markDrawnNumbers = require("./day04markDrawnNumbers");
  const checkWinnerBoard = require("./day04checkWinnerBoard");
  const calculateSumUnmarkedNumbers = require("./day04calculateSumUnmarkedNumbers");
  let isWinnerBoard = false;
  let finalScore = 0;
  let sumUncheckedNumbers = 0;
  let count;
  let boardCheckedNumbers;
  let lastCalledNumber;
  let drawnNumbers;
  const endIndx = Math.random() * 10 + 1;
  while (randomNumbers.length !== 0) {
    drawnNumbers = randomNumbers.slice(0, endIndx);
    randomNumbers = randomNumbers.slice(endIndx, randomNumbers.length);
    if (boards[0][0].length === undefined) {
      [count, boardCheckedNumbers, lastCalledNumber] = markDrawnNumbers(
        boards,
        drawnNumbers,
        boardsCheckedNumbersInit,
      );
      isWinnerBoard = checkWinnerBoard(boardCheckedNumbers);
      if (isWinnerBoard) {
        sumUncheckedNumbers = calculateSumUnmarkedNumbers(
          boards,
          boardCheckedNumbers,
        );
        finalScore = lastCalledNumber * sumUncheckedNumbers;
      }
    } else {
      for (let boardNumber = 0; boardNumber < boards.length; boardNumber++) {
        [count, boardCheckedNumbers, lastCalledNumber] = markDrawnNumbers(
          boards[boardNumber],
          drawnNumbers,
          boardsCheckedNumbersInit[boardNumber],
        );
        isWinnerBoard = checkWinnerBoard(boardCheckedNumbers);
        if (isWinnerBoard) {
          sumUncheckedNumbers = calculateSumUnmarkedNumbers(
            boards[boardNumber],
            boardCheckedNumbers,
          );
          finalScore = lastCalledNumber * sumUncheckedNumbers;
          break;
        }
      }
    }
  }
  return [isWinnerBoard, finalScore];
}

module.exports = day04findWinnigBoard;
