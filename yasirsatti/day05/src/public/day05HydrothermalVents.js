const readDataFile = require("./readDataFile");
const extractVentsData = require("./day05extractVentsData");
const getHorVerLinesRef = require("./day05getHorVerLinesRef");
const getEmptyDiagram = require("./day05getEmptyDiagram");
const getHorVerLinesDiagram = require("./day05getHorVerLinesDiagram");
const getVentsWithLinesCrossingDiagram = require("./day05getVentsWithLinesCrossingDiagram");
const getVentsCrossingPoints = require("./day05getVentsCrossingPoints");

const filePath = process.argv.slice(2)[0];
const data = readDataFile(filePath);
const [ventsCoordinates, diagramSize] = extractVentsData(data);
const linesRefs = getHorVerLinesRef(ventsCoordinates);
const diagram = getEmptyDiagram(diagramSize);
const linesDiagram = getHorVerLinesDiagram(
  ventsCoordinates,
  linesRefs,
  diagram,
);
const numberOfPoints = getVentsCrossingPoints(
  linesDiagram.length,
  linesDiagram,
);
console.log(
  "The number of points where at least two lines overlap is ",
  numberOfPoints,
);
