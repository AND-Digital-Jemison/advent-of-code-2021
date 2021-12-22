function day05getVentsCrossingPoints(size, diagram) {
  let diagramRow = [];
  let numberOfPoints = 0;
  for (let i = 0; i < size; i++) {
    diagramRow = [...diagram[i]];
    for (let x = 0; x < diagramRow.length; x++) {
      numberOfPoints += diagramRow[x] > 1 ? 1 : 0;
    }
  }
  return numberOfPoints;
}

module.exports = day05getVentsCrossingPoints;
