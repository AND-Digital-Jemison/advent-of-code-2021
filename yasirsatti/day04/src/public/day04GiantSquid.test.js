const randomNumbersAll = [
  7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18,
  20, 8, 19, 3, 26, 1,
];
const randomNumbersGrp1 = [7, 4, 9, 5, 11];
const randomNumbersGrp2 = [17, 23, 2, 0, 14];
const randomNumbersGrp3 = [24];
const randomNumbersCol4Winner = [
  33, 4, 99, 5, 11, 55, 23, 2, 0, 14, 21, 88, 10, 16, 13, 6, 7, 25, 12, 222, 24,
  18, 20, 8, 19, 3, 26, 1,
];
const board1Row0 = [22, 13, 17, 11, 0];
const board1Row1 = [8, 2, 23, 4, 24];
const board1Row2 = [21, 9, 14, 16, 7];
const board1Row3 = [6, 10, 3, 18, 5];
const board1Row4 = [1, 12, 20, 15, 19];
const board1 = [board1Row0, board1Row1, board1Row2, board1Row3, board1Row4];
const board1CheckedNumbersRow0 = [false, false, false, false, false];
const board1CheckedNumbersRow1 = [false, false, false, false, false];
const board1CheckedNumbersRow2 = [false, false, false, false, false];
const board1CheckedNumbersRow3 = [false, false, false, false, false];
const board1CheckedNumbersRow4 = [false, false, false, false, false];
let board1CheckedNumbers = [
  board1CheckedNumbersRow0,
  board1CheckedNumbersRow1,
  board1CheckedNumbersRow2,
  board1CheckedNumbersRow3,
  board1CheckedNumbersRow4,
];
const board2Row0 = [3, 15, 0, 2, 22];
const board2Row1 = [9, 18, 13, 17, 5];
const board2Row2 = [19, 8, 7, 25, 23];
const board2Row3 = [20, 11, 10, 24, 4];
const board2Row4 = [14, 21, 16, 12, 6];
const board2 = [board2Row0, board2Row1, board2Row2, board2Row3, board2Row4];
const board2CheckedNumbersRow0 = [false, false, false, false, false];
const board2CheckedNumbersRow1 = [false, false, false, false, false];
const board2CheckedNumbersRow2 = [false, false, false, false, false];
const board2CheckedNumbersRow3 = [false, false, false, false, false];
const board2CheckedNumbersRow4 = [false, false, false, false, false];
let board2CheckedNumbers = [
  board2CheckedNumbersRow0,
  board2CheckedNumbersRow1,
  board2CheckedNumbersRow2,
  board2CheckedNumbersRow3,
  board2CheckedNumbersRow4,
];
const board3Row0 = [14, 21, 17, 24, 4];
const board3Row1 = [10, 16, 15, 9, 19];
const board3Row2 = [18, 8, 23, 26, 20];
const board3Row3 = [22, 11, 13, 6, 5];
const board3Row4 = [2, 0, 12, 3, 7];
const board3 = [board3Row0, board3Row1, board3Row2, board3Row3, board3Row4];
const board3CheckedNumbersRow0 = [false, false, false, false, false];
const board3CheckedNumbersRow1 = [false, false, false, false, false];
const board3CheckedNumbersRow2 = [false, false, false, false, false];
const board3CheckedNumbersRow3 = [false, false, false, false, false];
const board3CheckedNumbersRow4 = [false, false, false, false, false];
let board3CheckedNumbers = [
  board3CheckedNumbersRow0,
  board3CheckedNumbersRow1,
  board3CheckedNumbersRow2,
  board3CheckedNumbersRow3,
  board3CheckedNumbersRow4,
];
const boards = [board1, board2, board3];
const boardsCheckedNumbers = [board1CheckedNumbers, board2CheckedNumbers, board3CheckedNumbers];

let checkedNumbers = [];

const number = (board, drawnNumber) => {
  let count = 0;
  checkedNumbers = Array(board.length).fill(false);
  for (let i = 0; i < drawnNumber.length; i++) {
    for (let x = 0; x < board.length; x++) {
      if (board[x] === drawnNumber[i]) {
        count += 1;
        checkedNumbers[x] = true;
      }
    }
  }
  return count;
};

const checkNumbersAreMarked = (number) =>
  checkedNumbers[randomNumbersAll.indexOf(number)];

const readBoardValue = (board, row, column) => {
  return board[row][column];
};

const readDataFile = require('./readDataFile');
const extractBoardsNumbers = require('./day04extractBoardsNumbers');
const findWinningBoard = require('./day04findWinnigBoard');
const markDrawnNumbers = require('./day04markDrawnNumbers');
const calculateSumUnmarkedNumbers = require('./day04calculateSumUnmarkedNumbers');
const checkWinnerBoard = require('./day04checkWinnerBoard');

describe("Giant squid tests (local)", () => {
  it("1. draw one number", () => {
    expect(number(randomNumbersAll, [1])).toBe(1);
  });

  it("2. draw two numbers", () => {
    expect(number(randomNumbersAll, [1, 2])).toBe(2);
  });

  it("3. draw numbers but one does not exist", () => {
    expect(number(randomNumbersAll, [1, 2, 65])).toBe(2);
  });

  it("4. Check drawn numbers are marked on the board", () => {
    number(randomNumbersAll, [1, 2, 22]);
    expect(checkNumbersAreMarked(22)).toBe(true);
  });

  it("5. Check number 3 is not checked on the board", () => {
    number(randomNumbersAll, [1, 2, 9]);
    expect(checkNumbersAreMarked(3)).toBe(false);
  });

  it("6. Check board 1 values", () => {
    expect(readBoardValue(board1, 1, 1)).toBe(2);
  });

  it("7. Mark drawn numbers on board 1", () => {
    expect(markDrawnNumbers(board1, randomNumbersAll, board1CheckedNumbers)[0]).toBe(25);
  });

  it("8. verifies the winner board", () => {
    let count;
    [
      count, board1CheckedNumbers,
    ] = markDrawnNumbers(board1, randomNumbersAll, board1CheckedNumbers);
    expect(checkWinnerBoard(board1CheckedNumbers)).toBe(true);
  });

  it("9. verifies the winner board with group 1 numbers drawn", () => {
    let count;
    [
      count, board1CheckedNumbers,
    ] = markDrawnNumbers(board1, randomNumbersGrp1, board1CheckedNumbers);
    expect(checkWinnerBoard(board1CheckedNumbers)).toBe(true);
  });

  it("10. verifies the winner board with group 1 & 2 numbers drawn", () => {
    let count;
    [
      count, board1CheckedNumbers,
    ] = markDrawnNumbers(board1, randomNumbersGrp1, board1CheckedNumbers);
    [
      count, board1CheckedNumbers,
    ] = markDrawnNumbers(board1, randomNumbersGrp2, board1CheckedNumbers);
    expect(checkWinnerBoard(board1CheckedNumbers)).toBe(true);
  });

  it("11. verifies the winner board with group 1 & 2 & 3 numbers drawn", () => {
    let count;
    [
      count, board1CheckedNumbers,
    ] = markDrawnNumbers(board1, randomNumbersGrp1, board1CheckedNumbers);
    [
      count, board1CheckedNumbers,
    ] = markDrawnNumbers(board1, randomNumbersGrp2, board1CheckedNumbers);
    [
      count, board1CheckedNumbers,
    ] = markDrawnNumbers(board1, randomNumbersGrp3, board1CheckedNumbers);
    expect(checkWinnerBoard(board1CheckedNumbers)).toBe(true);
  });

  it("12. verifies sum of unchecked numbers of winner board", () => {
    let count;
    [
      count, board1CheckedNumbers,
    ] = markDrawnNumbers(board1, randomNumbersGrp1, board1CheckedNumbers);
    [
      count, board1CheckedNumbers,
    ] = markDrawnNumbers(board1, randomNumbersGrp2, board1CheckedNumbers);
    const sum = calculateSumUnmarkedNumbers(board1, board1CheckedNumbers);
    expect(sum).toBe(300);
  });
});

describe('Example boards tests', () => {
  it("1. Make 1st draw on example board 1", () => {
    const drawnNumbers = [7, 4, 9, 5, 11];
    let count;
    [
      count, board1CheckedNumbers,
    ] = markDrawnNumbers(boards[0], drawnNumbers, board1CheckedNumbers);
    expect(checkWinnerBoard(board1CheckedNumbers)).toBe(false);
  });

  it("2. Make 1st draw on example board 2", () => {
    const drawnNumbers = [7, 4, 9, 5, 11];
    let count;
    [
      count, board2CheckedNumbers,
    ] = markDrawnNumbers(boards[1], drawnNumbers, board2CheckedNumbers);
    expect(checkWinnerBoard(board2CheckedNumbers)).toBe(false);
  });

  it("3. Make 1st draw on example board 3", () => {
    const drawnNumbers = [7, 4, 9, 5, 11];
    let count;
    [
      count, board3CheckedNumbers,
    ] = markDrawnNumbers(boards[2], drawnNumbers, board3CheckedNumbers);
    expect(checkWinnerBoard(board3CheckedNumbers)).toBe(false);
  });

  it("4. Make 2nd draw on example board 1", () => {
    const drawnNumbers = [17, 23, 2, 0, 14, 21];
    let count;
    [
      count, board1CheckedNumbers,
    ] = markDrawnNumbers(boards[0], drawnNumbers, board1CheckedNumbers);
    expect(checkWinnerBoard(board1CheckedNumbers)).toBe(false);
  });

  it("5. Make 2nd draw on example board 2", () => {
    const drawnNumbers = [17, 23, 2, 0, 14, 21];
    let count;
    [
      count, board2CheckedNumbers,
    ] = markDrawnNumbers(boards[1], drawnNumbers, board2CheckedNumbers);
    expect(checkWinnerBoard(board2CheckedNumbers)).toBe(false);
  });

  it("6. Make 2nd draw on example board 3", () => {
    const drawnNumbers = [17, 23, 2, 0, 14, 21];
    let count;
    [
      count, board3CheckedNumbers,
    ] = markDrawnNumbers(boards[2], drawnNumbers, board3CheckedNumbers);
    expect(checkWinnerBoard(board3CheckedNumbers)).toBe(false);
  });

  it("7. Make 3rd draw on example board 1", () => {
    const drawnNumbers = [24];
    let count;
    [
      count, board1CheckedNumbers,
    ] = markDrawnNumbers(boards[0], drawnNumbers, board1CheckedNumbers);
    expect(checkWinnerBoard(board1CheckedNumbers)).toBe(false);
  });

  it("8. Make 3rd draw on example board 2", () => {
    const drawnNumbers = [24];
    let count;
    [
      count, board2CheckedNumbers,
    ] = markDrawnNumbers(boards[1], drawnNumbers, board2CheckedNumbers);
    expect(checkWinnerBoard(board2CheckedNumbers)).toBe(false);
  });

  it("9. Make 3rd draw on example board 3", () => {
    const drawnNumbers = [24];
    let count;
    [
      count, board3CheckedNumbers,
    ] = markDrawnNumbers(boards[2], drawnNumbers, board3CheckedNumbers);
    expect(checkWinnerBoard(board3CheckedNumbers)).toBe(true);
  });

  it("10. Calculate sum of unmarked numbers for winner board 3", () => {
    const sum = calculateSumUnmarkedNumbers(board3, board3CheckedNumbers);
    expect(sum).toBe(188);
  });

  it("11. Calculate finale score for winner board 3", () => {
    const sum = calculateSumUnmarkedNumbers(board3, board3CheckedNumbers);
    expect(sum * 24).toBe(4512);
  });
});

describe('Example boards tests using all random numbers', () => {
  it("1. Make 1st draw on example board 1", () => {
    const drawnNumbers = [7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24];
    let count;
    [
      count, board1CheckedNumbers,
    ] = markDrawnNumbers(boards[0], drawnNumbers, board1CheckedNumbers);
    expect(checkWinnerBoard(board1CheckedNumbers)).toBe(false);
  });

  it("2. Make 1st draw on example board 2", () => {
    const drawnNumbers = [7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24];
    let count;
    [
      count, board2CheckedNumbers,
    ] = markDrawnNumbers(boards[1], drawnNumbers, board2CheckedNumbers);
    expect(checkWinnerBoard(board2CheckedNumbers)).toBe(false);
  });

  it("3. Make 1st draw on example board 3", () => {
    const drawnNumbers = [7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24];
    let count;
    [
      count, board3CheckedNumbers,
    ] = markDrawnNumbers(boards[2], drawnNumbers, board3CheckedNumbers);
    expect(checkWinnerBoard(board3CheckedNumbers)).toBe(true);
  });

  it("4. Calculate sum of unmarked numbers for winner board 3", () => {
    const sum = calculateSumUnmarkedNumbers(board3, board3CheckedNumbers);
    expect(sum).toBe(188);
  });
});

describe("Giant squid tests (live code)", () => {
  it("1. Find final score for example data", () => {
    const data = readDataFile('src/public/day04exampleDataNumbers.txt');
    console.log(data);
    const [randomNumbers, exampleBoards, exampleBoardsCheckedNumbers] = extractBoardsNumbers(data);
    const [
      isWinnerBoard, finalScore,
    ] = findWinningBoard(randomNumbers, exampleBoards, exampleBoardsCheckedNumbers);
    expect(finalScore).toBe(300);
  });

  it("2. Find final score for puzzle", () => {
    const data = readDataFile('src/public/day04GiantSquidData.txt');
    const [randomNumbers, puzzleBoards, puzzleBoardsCheckedNumbers] = extractBoardsNumbers(data);
    const [
      isWinnerBoard, finalScore,
    ] = findWinningBoard(randomNumbers, puzzleBoards, puzzleBoardsCheckedNumbers);
    console.log('winner board ', isWinnerBoard);
    console.log('final score ', finalScore);
    expect(isWinnerBoard).toBe(true);
    expect(finalScore).toBe(0);
  });
});
