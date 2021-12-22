function day05getHorVerLinesDiagram(lines, linesRefs, diagram) {
  let diagramRow = [];
  let count = 0;
  let lineXY;
  let lineEnd;
  for (let position = 0; position < lines.length; position++) {
    lineXY = lines[position];
    switch (linesRefs[position]) {
      case 1:
        if (lineXY[3] - lineXY[1] < 0) {
          lineEnd = lineXY[1];
          count = lineXY[3];
        } else {
          lineEnd = lineXY[3];
          count = lineXY[1];
        }
        while (count < lineEnd + 1) {
          diagramRow = [...diagram[count]];
          diagramRow[lineXY[0]] += 1;
          diagram[count] = diagramRow;
          count += 1;
        }
        break;
      case 2:
        if (lineXY[2] - lineXY[0] < 0) {
          lineEnd = lineXY[0];
          count = lineXY[2];
        } else {
          lineEnd = lineXY[2];
          count = lineXY[0];
        }
        diagramRow = [...diagram[lineXY[1]]];
        while (count < lineEnd + 1) {
          diagramRow[count] += 1;
          count += 1;
        }
        diagram[lineXY[1]] = diagramRow;
        break;
      default:
        continue;
    }
  }
  return diagram;
}

module.exports = day05getHorVerLinesDiagram;
