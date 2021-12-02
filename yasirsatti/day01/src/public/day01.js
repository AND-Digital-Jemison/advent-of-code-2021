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
  const text = fs.readFileSync(file[0]).toString('utf-8');
  const reportReadingValues = text.split('\n');
  return reportReadingValues;
}

const filePath = process.argv.slice(2);
const data = readDataFile(filePath);
console.log('Number of measurements larger than previous one is ', numberOfmeasurementsLargerThanPrevious(data));

module.exports = numberOfmeasurementsLargerThanPrevious;
