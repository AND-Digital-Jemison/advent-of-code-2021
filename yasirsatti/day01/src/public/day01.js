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

const readDataFile = require('./readDataFile');
const filePath = process.argv.slice(2)[0];
const data = readDataFile(filePath);
console.log('Number of measurements larger than previous one is ', numberOfmeasurementsLargerThanPrevious(data));

module.exports = numberOfmeasurementsLargerThanPrevious;
