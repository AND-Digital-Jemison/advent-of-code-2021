function day04checkWinnerBoard(boardCheckedNumbers) {
  let isWinnder = false;
  for (let row = 0; row < 5; row++) {
    if (boardCheckedNumbers[row].includes(false)) continue;
    isWinnder = true;
  }
  if (!isWinnder) {
    for (let column = 0; column < 5; column++) {
      let col1CheckedCount = 0;
      let col2CheckedCount = 0;
      let col3CheckedCount = 0;
      let col4CheckedCount = 0;
      let col5CheckedCount = 0;
      for (let row = 0; row < 5; row++) {
        if (boardCheckedNumbers[row][column] === false) break;
        // eslint-disable-next-line default-case
        switch (column) {
          case 0:
            col1CheckedCount += 1;
            if (col1CheckedCount === 5) {
              isWinnder = true;
              break;
            }
            break;
          case 1:
            col2CheckedCount += 1;
            if (col2CheckedCount === 5) {
              isWinnder = true;
              break;
            }
            break;
          case 2:
            col3CheckedCount += 1;
            if (col3CheckedCount === 5) {
              isWinnder = true;
              break;
            }
            break;
          case 3:
            col4CheckedCount += 1;
            if (col4CheckedCount === 5) {
              isWinnder = true;
              break;
            }
            break;
          case 4:
            col5CheckedCount += 1;
            if (col5CheckedCount === 5) {
              isWinnder = true;
              break;
            }
            break;
        }
      }
    }
  }
  return isWinnder;
}

module.exports = day04checkWinnerBoard;
