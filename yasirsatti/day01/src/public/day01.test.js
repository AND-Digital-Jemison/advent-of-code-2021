// eslint-disable-next-line no-undef
it('counts number of times a depth measurement increases from previous measurement', () => {
  // eslint-disable-next-line global-require
  const readDataFile = require('./readDataFile');
  const filePath = 'src/public/sonardata.rtf';
  const testData = readDataFile(filePath);
  // eslint-disable-next-line global-require
  const numberOfmeasurements = require('./numberOfmeasurements');
  // eslint-disable-next-line no-undef
  expect(numberOfmeasurements(testData)).toBe(2784);
});
