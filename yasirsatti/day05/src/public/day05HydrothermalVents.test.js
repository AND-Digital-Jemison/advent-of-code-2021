const exampleLineVents = [
  [0, 9, 5, 9],
  [8, 0, 0, 8],
  [9, 4, 3, 4],
  [2, 2, 2, 1],
  [7, 0, 7, 4],
  [6, 4, 2, 0],
  [0, 9, 2, 9],
  [3, 4, 1, 4],
  [0, 0, 8, 8],
  [5, 5, 8, 2],
];

const exampleLineVentsRequiredRefData = [
  2, 0, 2, 1, 1,
  0, 2, 2, 0, 0,
];

const exampleLineVentsRequired = [
  [0, 9, 5, 9],
  [9, 4, 3, 4],
  [2, 2, 2, 1],
  [7, 0, 7, 4],
  [0, 9, 2, 9],
  [3, 4, 1, 4],
];

const exampleVentsLinesCrossingStringDiagram = [
  ".......1..",
  "..1....1..",
  "..1....1..",
  ".......1..",
  ".112111211",
  "..........",
  "..........",
  "..........",
  "..........",
  "222111....",
];

const readDataFile = require('./readDataFile');
const extractVentsData = require("./day05extractVentsData");
const getHorVerLinesRef = require("./day05getHorVerLinesRef");
const getEmptyDiagram = require("./day05getEmptyDiagram");
const getHorVerLinesDiagram = require("./day05getHorVerLinesDiagram");
const getVentsWithLinesCrossingDiagram = require("./day05getVentsWithLinesCrossingDiagram");
const getVentsCrossingPoints = require("./day05getVentsCrossingPoints");

describe("Calculate crossing points for Example ", () => {
  const data = readDataFile('src/public/day05exampHydrothermalVentsData.txt');
  const [ventsCoordinates, diagramSize] = extractVentsData(data);
  const linesRefs = getHorVerLinesRef(ventsCoordinates);
  const diagram = getEmptyDiagram(diagramSize);
  const linesDiagram = getHorVerLinesDiagram(
    ventsCoordinates,
    linesRefs,
    diagram,
  );
  it("1. Calculate reference for which coordinates for horizontal and vertical lines vents", () => {
    const calaculatedRefHorVerVents = getHorVerLinesRef(ventsCoordinates);
    expect(calaculatedRefHorVerVents).toEqual(exampleLineVentsRequiredRefData);
  });

  it("2. Verifies the diagram for horizntal and vertical lines crossings", () => {
    const linesDiagramString = getVentsWithLinesCrossingDiagram(linesDiagram);
    expect(linesDiagramString).toEqual(exampleVentsLinesCrossingStringDiagram);
  });

  it("3. Verifies the number of points with 2 or more lines crossing", () => {
    const numberOfPoints = getVentsCrossingPoints(linesDiagram.length, linesDiagram);
    expect(numberOfPoints).toEqual(5);
  });
});

describe("Calculate crossing points for puzzle ", () => {
  const data = readDataFile('src/public/day05HydrothermalVentsData.txt');
  const [ventsCoordinates, diagramSize] = extractVentsData(data);
  const linesRefs = getHorVerLinesRef(ventsCoordinates);
  const diagram = getEmptyDiagram(diagramSize);
  const linesDiagram = getHorVerLinesDiagram(
    ventsCoordinates,
    linesRefs,
    diagram,
  );

  it("1. Verifies the number of points with 2 or more lines crossing", () => {
    const numberOfPoints = getVentsCrossingPoints(linesDiagram.length, linesDiagram);
    expect(numberOfPoints).toEqual(6856);
  });
});
