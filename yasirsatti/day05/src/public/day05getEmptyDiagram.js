function day05getEmptyDiagram(lines) {
  const diagram = [];
  let xSize = 0;
  let ySize = 0;
  for (let i = 0; i < lines.length; i++) {
    if (lines[i][0] > lines[2]) {
      xSize = xSize > lines[i][0] ? xSize : lines[i][0];
    } else {
      xSize = xSize > lines[i][2] ? xSize : lines[i][2];
    }
    if (lines[i][1] > lines[3]) {
      ySize = ySize > lines[i][1] ? ySize : lines[i][1];
    } else {
      ySize = ySize > lines[i][3] ? ySize : lines[i][3];
    }
  }
  const diagramSize = xSize > ySize ? xSize + 1 : ySize + 1;
  const diagramRow = Array.apply(0, Array(diagramSize)).map(function (el, i) {
    return 0;
  });
  for (let i = 0; i < diagramSize; i++) {
    diagram.push(diagramRow);
  }
  return diagram;
}

module.exports = day05getEmptyDiagram;
