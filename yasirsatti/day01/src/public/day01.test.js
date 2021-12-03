function numberOfmeasurementsLargerThanPrevious(sonardata) {
  let countNumberOfmeasurements = 0;

  for (let i = 0; i < sonardata.length; i += 1) {
    if (i !== 0) {
      if (sonardata[i] > sonardata[i - 1]) {
        countNumberOfmeasurements += 1;
      }
    }
  }
  return countNumberOfmeasurements;
}

// eslint-disable-next-line no-undef
it('counts number of times a depth measurement increases from previous measurement', () => {
  // eslint-disable-next-line global-require
  const readDataFile = require('./readDataFile');
  const filePath = 'src/public/sonardata.rtf';
  const testData = readDataFile(filePath);
  // eslint-disable-next-line no-undef
  expect(numberOfmeasurementsLargerThanPrevious(testData)).toBe(2784);
});
