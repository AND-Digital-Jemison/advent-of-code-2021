// eslint-disable-next-line no-undef
it("Calculate the submarine power consumption ", () => {
    // eslint-disable-next-line global-require
    const readDataFile = require("./readDataFile");
    const filePath = "src/public/day03BinaryDiagnosticData.txt";
    const testData = readDataFile(filePath);
    // eslint-disable-next-line global-require
    const calculatePowerConsumption = require("./day03calculatePowerConsumption");
    // eslint-disable-next-line no-undef
    expect(calculatePowerConsumption(testData)).toBe(3895776);
  });
  