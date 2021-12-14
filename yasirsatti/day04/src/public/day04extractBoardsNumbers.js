function day04extractBoardsNumbers(data) {
  const board1CheckedNumbersRow0 = [false, false, false, false, false];
  const board1CheckedNumbersRow1 = [false, false, false, false, false];
  const board1CheckedNumbersRow2 = [false, false, false, false, false];
  const board1CheckedNumbersRow3 = [false, false, false, false, false];
  const board1CheckedNumbersRow4 = [false, false, false, false, false];
  const boardCheckedNumbersInit = [
    board1CheckedNumbersRow0,
    board1CheckedNumbersRow1,
    board1CheckedNumbersRow2,
    board1CheckedNumbersRow3,
    board1CheckedNumbersRow4,
  ];
  let dataRow;
  let dataRowInt = [];
  let randomNumbersAll = [];
  let board = [];
  const boards = [];
  const boardsCheckedNumbers = [];
  let isNewBoard = false;
  let boardRowsCount = 0;
  const getRandomNumbers = (row) => {
    const randomNumbers = [];
    dataRow = row.split(",");
    for (let x = 0; x < dataRow.length; x++) {
      randomNumbers.push(parseInt(dataRow[x], 10));
    }
    return randomNumbers;
  };
  const removeEmptyElements = (row) => {
    const newRow = [];
    for (let i = 0; i < row.length; i++) {
      if (row[i] != "") newRow.push(row[i]);
    }
    return newRow;
  };
  for (let i = 0; i < data.length; i++) {
    if (i === 0) {
      randomNumbersAll = getRandomNumbers(data[i]);
      continue;
    }
    if (data[i] === "") {
      isNewBoard = true;
      boardRowsCount = 0;
      continue;
    }
    dataRow = data[i].split(" ");
    if (dataRow.indexOf("") > -1) {
      dataRow = removeEmptyElements(dataRow);
    }
    for (let x = 0; x < dataRow.length; x++) {
      dataRowInt.push(parseInt(dataRow[x], 10));
    }
    board.push(dataRowInt);
    boardRowsCount += 1;
    dataRowInt = [];
    if (boardRowsCount === 5) {
      boards.push(board);
      boardsCheckedNumbers.push(boardCheckedNumbersInit);
      board = [];
    }
  }
  return [randomNumbersAll, boards, boardsCheckedNumbers];
}

module.exports = day04extractBoardsNumbers;
