const countingSortStr = (str) => {
    let arr = str.split("");
    let n = str.length;
    const output = new Array(n);

    // Create a count array to store count of inidividul
    // characters and initialize count array as 0
    const count = new Array(256).fill(0);

    // store count of each character
    for (let i = 0; i < n; i++) {
        count[arr[i].charCodeAt()]++;
    }

    // Change count[i] so that count[i] now contains actual
    // position of this character in output array
    for (let i = 1; i <= 255; i++) {
        count[i] += count[i - 1];
    }

    // Build the output character array
    // To make it stable we are operating in reverse order.
    for (let i = n - 1; i >= 0; i--) {
        output[count[arr[i].charCodeAt()] - 1] = arr[i].charCodeAt();
        --count[arr[i].charCodeAt()];
    }

    //Convert the ASCII Value to characters again
    return output.map((e) => String.fromCharCode(e));
};
