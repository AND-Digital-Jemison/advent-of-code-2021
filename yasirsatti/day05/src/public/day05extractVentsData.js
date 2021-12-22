function day05extractVentsData(data) {
  const ventsCoordinates = [];
  let dataRow;
  let lineStart;
  let lineEnd;
  let xSize = 0;
  let ySize = 0;
  let diagramSize = 0;
  for (let i = 0; i < data.length; i++) {
    dataRow = data[i].split(" ");
    lineStart = dataRow[0].split(",");
    lineStart = lineStart.map((x) => {
      return parseInt(x);
    });
    lineEnd = dataRow[2].split(",");
    lineEnd = lineEnd.map((y) => {
      return parseInt(y);
    });
    ventsCoordinates.push(lineStart.concat(lineEnd));
    xSize = xSize > lineStart[0] ? xSize : lineStart[0];
    xSize = xSize > lineEnd[0] ? xSize : lineEnd[0];
    ySize = ySize > lineStart[1] ? ySize : lineStart[1];
    ySize = ySize > lineEnd[1] ? ySize : lineEnd[1];
  }
  diagramSize = xSize > ySize ? xSize + 1 : ySize + 1;
  return [ventsCoordinates, diagramSize];
}

module.exports = day05extractVentsData;
