const readDataFile = require('./readDataFile');
const filePath = process.argv.slice(2)[0];
const data = readDataFile(filePath);
const calculatePosition = require('./day022calculatePositionWithAim');
const navigateResult = calculatePosition(data);
console.log('Forward position is           ', navigateResult[0]);
console.log('depth position is             ', navigateResult[1]);
console.log('Their multiplication value is ', navigateResult[2]);