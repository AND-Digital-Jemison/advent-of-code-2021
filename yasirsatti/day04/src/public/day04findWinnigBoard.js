function day04findWinnigBoard(randomNumbers, boards, boardsCheckedNumbers) {
  const markDrawnNumbers = require("./day04markDrawnNumbers");
  const checkWinnerBoard = require("./day04checkWinnerBoard");
  const calculateSumUnmarkedNumbers = require("./day04calculateSumUnmarkedNumbers");
  let isWinnerBoard = false;
  let winnerBoardNumber;
  let finalScore = 0;
  let sumUncheckedNumbers = 0;
  let count;
  let boardCheckedNumbers;
  let lastCalledNumber;
  let drawnNumbers;
  let endIndx;
  while (randomNumbers.length !== 0) {
    endIndx = Math.random() * randomNumbers.length + 1;
    drawnNumbers = randomNumbers.slice(0, endIndx);
    randomNumbers = randomNumbers.slice(endIndx, randomNumbers.length);
    if (boards[0][0].length === undefined) {
      // eslint-disable-next-line no-param-reassign
      [count, boardsCheckedNumbers, lastCalledNumber] = markDrawnNumbers(
        boards,
        drawnNumbers,
        boardsCheckedNumbers,
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
        // eslint-disable-next-line no-param-reassign
        [count, boardsCheckedNumbers[boardNumber], lastCalledNumber] = markDrawnNumbers(
          boards[boardNumber],
          drawnNumbers,
          boardsCheckedNumbers[boardNumber],
        );
        isWinnerBoard = checkWinnerBoard(boardsCheckedNumbers[boardNumber]);
        if (isWinnerBoard) {
          sumUncheckedNumbers = calculateSumUnmarkedNumbers(
            boards[boardNumber],
            boardsCheckedNumbers[boardNumber],
          );
          winnerBoardNumber = boardNumber;
          finalScore = lastCalledNumber * sumUncheckedNumbers;
          break;
        }
      }
    }
  }
  return [winnerBoardNumber, finalScore];
}

module.exports = day04findWinnigBoard;
