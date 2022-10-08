function decimalToBinary(num) {
    const remStack = [];
    let number = num;
    let rem;
    let binaryString = '';
//insert in stack
    while (number > 0) {
        rem = Math.floor(number % 2);
        remStack.push(rem);
        number = Math.floor(number / 2);
    }
//pop from stack
    while (remStack.length !== 0) {
        binaryString += remStack.pop().toString();
    }

    return binaryString;
}