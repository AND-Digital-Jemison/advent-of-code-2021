function day05getHorVerLinesRef(lines) {
    const lineVentsRequiredRef = [];
  for (let i = 0; i < lines.length; i++) {
    if (lines[i][0] === lines[i][2]) {
        lineVentsRequiredRef.push(1);
      continue;
    }
    if (lines[i][1] === lines[i][3]) {
        lineVentsRequiredRef.push(2);
      continue;
    }
    lineVentsRequiredRef.push(0);
  }
  return lineVentsRequiredRef;
};

module.exports = day05getHorVerLinesRef;
