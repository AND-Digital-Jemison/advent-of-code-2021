const readDataFile = require('./readDataFile');
const filePath = process.argv.slice(2)[0];
const data = readDataFile(filePath);
const numberOfmeasurements = require('./numberOfmeasurements');
console.log(
  'Number of measurements larger than previous one is ',
  numberOfmeasurements(data)
  );
