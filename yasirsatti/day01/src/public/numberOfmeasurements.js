function numberOfmeasurements(sonardata) {
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

module.exports = numberOfmeasurements;
