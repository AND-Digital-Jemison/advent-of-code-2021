function day022calculatePositionWithAim(data) {
  const numOfpositions = data.length;
  let forwardPosition = 0;
  let depthPosition = 0;
  let aim = 0;
  for (let i = 0; i < numOfpositions; i += 1) {
    const navigate = data[i].split(" ");
    const newPosition = parseInt(navigate[1], 10);
    // eslint-disable-next-line default-case
    switch (navigate[0]) {
      case "forward":
        forwardPosition += newPosition;
        depthPosition += aim * newPosition;
        break;
      case "up":
        aim -= newPosition;
        break;
      case "down":
        aim += newPosition;
        break;
    }
  }
  const navigateResult = [
    forwardPosition,
    depthPosition,
    forwardPosition * depthPosition,
  ];
  return navigateResult;
}

module.exports = day022calculatePositionWithAim;
