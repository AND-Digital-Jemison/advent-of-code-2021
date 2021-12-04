// eslint-disable-next-line no-undef
it("Take into consideration aim and re-calculates the multiplication of final horizontal and depth positions ", () => {
  // eslint-disable-next-line global-require
  const readDataFile = require("./readDataFile");
  const filePath = "src/public/day02NavigateData.txt";
  const testData = readDataFile(filePath);
  // eslint-disable-next-line global-require
  const calculatePosition = require("./day022calculatePositionWithAim");
  // eslint-disable-next-line no-undef
  expect(calculatePosition(testData)[2]).toBe(1813062561);
});
