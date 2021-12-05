const readDataFile = require('../../../day02/src/public/readDataFile');
const filePath = process.argv.slice(2)[0];
const data = readDataFile(filePath);
const calculaGammaEpsilonRates = require('./day03calculatePowerConsumption');
const powerConsumption = calculaGammaEpsilonRates(data);
console.log('Submarine power consumption is ', powerConsumption);