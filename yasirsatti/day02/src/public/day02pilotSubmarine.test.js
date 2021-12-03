// eslint-disable-next-line no-undef
it("Calculates the multiplication of final horizontal and depth positions ", () => {
  // eslint-disable-next-line global-require
  const readDataFile = require("./readDataFile");
  const filePath = "src/public/pilotData.txt";
  const testData = readDataFile(filePath);
  // eslint-disable-next-line global-require
  const calculatePosition = require("./calculatePosition");
  // eslint-disable-next-line no-undef
  expect(calculatePosition(testData)[2]).toBe(1947824);
});
