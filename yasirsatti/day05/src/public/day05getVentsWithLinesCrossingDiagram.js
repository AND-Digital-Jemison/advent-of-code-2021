function getVentsWithLinesCrossingDiagram(diagram) {
  let diagramRow = [];
  let diagramRowString = [];
  for (let i = 0; i < diagram.length; i++) {
    diagramRow = [...diagram[i]];
    diagramRowString = diagramRow.map(function (y) {
      return y === 0 ? "." : y.toString();
    });
    diagram[i] = diagramRowString.join("");
  }
  return diagram;
}

module.exports = getVentsWithLinesCrossingDiagram;
