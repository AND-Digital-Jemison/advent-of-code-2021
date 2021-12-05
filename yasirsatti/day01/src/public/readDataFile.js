function readDataFile(filename) {
  // eslint-disable-next-line global-require
  const fs = require('fs');
  const text = fs.readFileSync(filename).toString('utf-8');
  const data = text.split('\n');
  return data;
}

module.exports = readDataFile;
