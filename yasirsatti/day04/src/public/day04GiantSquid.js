const readDataFile = require("./readDataFile");
const filePath = process.argv.slice(2)[0];
const data = readDataFile(filePath);
const extractBoardsNumbers = require('./day04extractBoardsNumbers');
const [randomNumbersAll, boards, boardsCheckedNumbers] = extractBoardsNumbers(data);
const findWinnigBoard = require("./day04findWinnigBoard");
const [
  winningBoard, finalScore,
] = findWinnigBoard(randomNumbersAll.slice(0, 10), boards, boardsCheckedNumbers);
console.log("The winning board number 1 and final score is", winningBoard, ' ', finalScore);
