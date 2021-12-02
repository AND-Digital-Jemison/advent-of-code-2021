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

function readDataFile(file) {
  // eslint-disable-next-line global-require
  const fs = require('fs');
  const text = fs.readFileSync(file).toString('utf-8');
  const reportReadingValues = text.split('\n');
  return reportReadingValues;
}

// eslint-disable-next-line no-undef
it('counts number of times a depth measurement increases from previous measurement', () => {
  const filePath = 'src/public/sonardata.rtf';
  const testData = readDataFile(filePath);
  // eslint-disable-next-line no-undef
  expect(numberOfmeasurementsLargerThanPrevious(testData)).toBe(2784);
});
