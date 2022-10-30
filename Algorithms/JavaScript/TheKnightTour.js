
const SIZE = 8;
const START = [1, 3];

let board = [];
const possibleMoves = [
  [2, 1],
  [2, -1],
  [1, 2],
  [1, -2],
  [-1, 2],
  [-1, -2],
  [-2, 1],
  [-2, -1],
];

/**
 * Reset the board.
 */
const resetBoard = () => {
  board = [];
  for (let x = 0; x < SIZE; x++) {
    board[x] = [];
    for (let y = 0; y < SIZE; y++) {
      board[x][y] = -1;
    }
  }
};

/**
 * Render the board in its current state.
 */
const renderBoard = () => {
  let rendered = "";
  for (const row of board) {
    rendered = `${rendered}\n`;
    for (const space of row) {
      rendered = `${rendered} ${String(space).padStart(3, " ")}`;
    }
  }
  console.log(rendered);
};

/**
 * Determine whether a given set of coordinates are a valid and available space
 * on the board.
 */
const isValid = ([x, y]) => board[x] && board[x][y] === -1;

const getValidMoves = ([x, y]) => {
  const moves = [];
  for (const [moveX, moveY] of possibleMoves) {
    const toX = x + moveX;
    const toY = y + moveY;
    if (isValid([toX, toY])) {
      moves.push([toX, toY]);
    }
  }
  return moves;
};

/**
 * Solve the Knight's Tour problem given starting coordinates.
 */
const solve = ([x, y], moveNumber = 0) => {
  if (!isValid([x, y])) {
    throw new Error(`The starting position x:${x} and y:${y} is invalid`);
  }

  board[x][y] = moveNumber;
  if (moveNumber + 1 === SIZE * SIZE) {
    return true;
  }
  const sortedMoves = getValidMoves([x, y]).sort(
    (a, b) => getValidMoves(a).length - getValidMoves(b).length
  );
  for (const [toX, toY] of sortedMoves) {
    if (solve([toX, toY], moveNumber + 1)) {
      return true;
    }
    board[toX][toY] = -1;
  }
  return false;
};

let successes = 0;
let failures = 0;
for (startX = 0; startX < 8; startX++) {
  for (startY = 0; startY < 8; startY++) {
    resetBoard();
    const success = solve([startX, startY]);
    if (success) {
      successes = successes + 1;
    } else {
      failures = failures + 1;
    }
    renderBoard(board);
  }
}

console.log("Successes", successes);
console.log("Failures", failures);
