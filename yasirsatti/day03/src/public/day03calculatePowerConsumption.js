function day03calculatePowerConsumption(data) {
  const numOfData = data.length;
  let binary0count = 0;
  let binary1count = 0;
  let gammaRate = "";
  let epsilonRate = "";
  const binaryElements = [];

  for (let i = 0; i < numOfData; i += 1) {
    const dataelement = data[i].split("");
    binaryElements.push(dataelement);
  }

  const numberOfBits = data[0].length;

  for (let column = 0; column < numberOfBits; column += 1) {
    for (let row = 0; row < numOfData; row += 1) {
      if (binaryElements[row][column] === "0") {
        binary0count += 1;
      } else {
        binary1count += 1;
      }
    }
    if (binary0count > binary1count) {
      gammaRate += "0";
      epsilonRate += "1";
    } else {
      gammaRate += "1";
      epsilonRate += "0";
    }
    binary0count = 0;
    binary1count = 0;
  }
  let gammaValue = 0;
  let epsilonValue = 0;
  const hexPower = [2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1];
  for (let i = 0; i < 12; i += 1) {
    gammaValue += hexPower[i] * parseInt(gammaRate[i], 10);
    epsilonValue += hexPower[i] * parseInt(epsilonRate[i], 10);
  }
  return gammaValue * epsilonValue;
}

module.exports = day03calculatePowerConsumption;
