function calculatePosition(data) {
  const numOfpositions = data.length;
  let forwardPosition = 0;
  let depthPosition = 0;
  for (let i = 0; i < numOfpositions; i += 1) {
    const navigate = data[i].split(' ');
    // eslint-disable-next-line default-case
    switch (navigate[0]) {
      case 'forward':
        forwardPosition += parseInt(navigate[1], 10);
        break;
      case 'up':
        depthPosition -= parseInt(navigate[1], 10);
        break;
      case 'down':
        depthPosition += parseInt(navigate[1], 10);
        break;
    }
  }
  const navigateResult = [forwardPosition, depthPosition, forwardPosition * depthPosition];
  return navigateResult;
}

module.exports = calculatePosition;
